package dev.MateusIR.Encurtador.Links;



import java.time.LocalDateTime;

public class LinkResponse {

    private Long id;
    private String url;
    private String url_short;
    private LocalDateTime url_criadaEm;
    private String qrCodeBase64;


    public LinkResponse(Long id, String url, String url_short, LocalDateTime url_criadaEm, String qrCodeBase64) {
        this.id = id;
        this.url = url;
        this.url_short = url_short;
        this.url_criadaEm = url_criadaEm;
        this.qrCodeBase64 = qrCodeBase64;
    }
    public LinkResponse(){}

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

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }
    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }
}
