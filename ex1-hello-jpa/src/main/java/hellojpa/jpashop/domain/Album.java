package hellojpa.jpashop.domain;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item{

    private String artist;
    private String etc;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getArtist() {
        return artist;
    }

    public String getEtc() {
        return etc;
    }
}
