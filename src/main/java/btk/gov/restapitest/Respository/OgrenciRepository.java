package btk.gov.restapitest.Respository;

import btk.gov.restapitest.entities.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci,Integer> {

}