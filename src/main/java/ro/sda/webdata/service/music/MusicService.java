package ro.sda.webdata.service.music;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.webdata.persistence.music.MusicEntity;
import ro.sda.webdata.persistence.music.MusicRepository;

import java.util.List;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository){
        this.musicRepository=musicRepository;
    }

    @Transactional
    public void save(String singer){
        MusicEntity entity = new MusicEntity();
        entity.setSinger(singer);
       // entity.getSongName(songName);
        musicRepository.save(entity);

    }
    @Transactional
    public List<MusicEntity> findAll(){
        return musicRepository.findAll();
    }
}
