package ro.sda.webdata.persistence.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {


    //spring daca are @Repository si extinde o interfata de tip Repository, daca ii dau numele unei metode sugestiv cu conventiile lui de nume,
    //stie sa-mi faca query-uri singur, daca nu pot pune adnotarea @Query(...si pot face query-uri ale mele)
    
    List<CarEntity> findByModel(String model);
}
