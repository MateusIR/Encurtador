package dev.MateusIR.Encurtador.Links;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }


    @PostMapping("/encurtador")
    public ResponseEntity<LinkResponse> gerarUrlShort(@RequestBody Map<String,String> request){
        String url = request.get("url");
        Link link = linkService.encurtaUrl(url);

        String geraRedirecionamentoUrl = "http://localhost:8080/r/" + link.getUrlShort();

        LinkResponse response = new LinkResponse(link.getId(),link.getUrl(),geraRedirecionamentoUrl,link.getUrlCriadaEm());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
