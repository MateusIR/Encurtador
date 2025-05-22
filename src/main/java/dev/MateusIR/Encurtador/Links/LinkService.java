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
        link.setUrlShort(geraUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());
        return linkRepository.save(link);
    }
    public Link getOriginal(String urlShort){
        try {
            return linkRepository.findByUrlShort(urlShort);
        }catch (Exception e){
            throw new RuntimeException("URL não encontrada", e);
        }
    }
}
