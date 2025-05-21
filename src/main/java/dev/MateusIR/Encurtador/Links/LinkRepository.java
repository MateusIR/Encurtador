package dev.MateusIR.Encurtador.Links;


import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
        Link findByUrl_short(String url_short);

}
