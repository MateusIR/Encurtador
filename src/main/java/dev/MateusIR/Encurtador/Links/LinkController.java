package dev.MateusIR.Encurtador.Links;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }


    @PostMapping("/encurtador")
    public ResponseEntity<LinkResponse> gerarUrlShort(@RequestBody Map<String,String> request){
        String url = request.get("url");
        String customUrl = request.get("urlCustom");

        Link link = linkService.encurtaUrl(url,customUrl);

        String geraRedirecionamentoUrl = "http://localhost:8080/r/" + link.getUrlShort();

        String qrBase64 = QRCodeGenerator.generateBase64QrCode(geraRedirecionamentoUrl, 200, 200);

        LinkResponse response = new LinkResponse(link.getId(),link.getUrl(),geraRedirecionamentoUrl,link.getUrlCriadaEm(),qrBase64);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/r/{urlShort}")
    public void RedirecionarLink(@PathVariable String urlShort, HttpServletResponse response) throws IOException {
        Link link = linkService.getOriginal(urlShort);

        if (link != null){
            response.sendRedirect(link.getUrl());
        }else{
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }

}
