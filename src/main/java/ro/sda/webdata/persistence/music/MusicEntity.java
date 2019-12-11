package ro.sda.webdata.persistence.music;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name ="music")
public class MusicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "singer")
    private String singer;

    @Column(name = "songName")
    private String songName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
