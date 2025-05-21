package dev.MateusIR.Encurtador.Links;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkService {
    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String geraUrlAleatoria(){
    return RandomStringUtils.randomAlphanumeric(8,10);
    }

    public Link encurtaUrl(String url){
        Link link = new Link();
        link.setUrl(url);
        link.setUrl_short(geraUrlAleatoria());
        link.setUrl_criadaEm(LocalDateTime.now());
        return linkRepository.save(link);
    }
    public Link getLinkShort(String url_short){
        try {
            return linkRepository.findByUrl_short(url_short);
        }catch (Exception e){
            throw new RuntimeException("URL não encontrada", e);
        }
    }
}
