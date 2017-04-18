package gcs.com.br.gcscifras.classes.domain;

/**
 * Created by welisson on 15/04/17.
 */

public class Cifra extends BaseClass {
    private int id;
    private String nome;
    private String artista;
    private String genero;
    private String album;
    private int anoLancamento;
    private String cifra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCifra() {
        return cifra;
    }

    public void setCifra(String cifra) {
        this.cifra = cifra;
    }

    public Cifra preenche(Cifra c)
    {
        this.setId(c.id);
        this.setNome(c.nome);
        this.setArtista(c.artista);
        this.setGenero(c.genero);
        this.setAlbum(c.album);
        this.setAnoLancamento(c.anoLancamento);
        this.setCifra(c.cifra);

        return this;
    }
}

/*

{
	"id": 0,
	"nome": "Cifra Nome",
	"artista": "Artista Nome",
	"genero": "Gênero Nome",
	"album": "Álbum Nome",
	"anoLancamento": 2017,
	"cifra": "ASDFGÇLKJH"
}

 */