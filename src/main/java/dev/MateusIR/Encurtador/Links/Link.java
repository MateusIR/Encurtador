package dev.MateusIR.Encurtador.Links;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String url_short;
    private LocalDateTime url_criadaEm;

    public Link(Long id, String url, String url_short, LocalDateTime url_criadaEm) {
        this.id = id;
        this.url = url;
        this.url_short = url_short;
        this.url_criadaEm = url_criadaEm;
    }
    public Link(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_short() {
        return url_short;
    }

    public void setUrl_short(String url_short) {
        this.url_short = url_short;
    }

    public LocalDateTime getUrl_criadaEm() {
        return url_criadaEm;
    }

    public void setUrl_criadaEm(LocalDateTime url_criadaEm) {
        this.url_criadaEm = url_criadaEm;
    }
}

