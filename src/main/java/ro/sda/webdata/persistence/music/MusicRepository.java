package ro.sda.webdata.persistence.music;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicEntity,Long>{
}
