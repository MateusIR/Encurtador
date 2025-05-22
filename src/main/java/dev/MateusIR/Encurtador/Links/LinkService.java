package dev.MateusIR.Encurtador.Links;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LinkService {
    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String geraUrlAleatoria(){
    return RandomStringUtils.randomAlphanumeric(8,10);
    }

    public Link encurtaUrl(String url, String customUrl){
        Link link = new Link();
        link.setUrl(url);

        if (customUrl != null && customUrl.length() >= 6 && customUrl.length() <= 32 && !customUrl.contains(" ")) {
            link.setUrlShort(customUrl);
        } else {
            link.setUrlShort(geraUrlAleatoria());
        }

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

    @Scheduled(fixedRate = 86400000)
    public void deletarLinksExpirados() {
        LocalDateTime limite = LocalDateTime.now().minusWeeks(1);
        List<Link> expirados = linkRepository.findAllByUrlCriadaEmBefore(limite);
        linkRepository.deleteAll(expirados);
    }

}
