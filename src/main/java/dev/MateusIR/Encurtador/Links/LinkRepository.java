package dev.MateusIR.Encurtador.Links;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
        Link findByUrlShort(String urlShort);

        List<Link> findAllByUrlCriadaEmBefore(LocalDateTime limite);

        void deleteAllByUrl(String url);
}
