package btk.gov.restapitest.Service;

import btk.gov.restapitest.Respository.OgrenciRepository;
import btk.gov.restapitest.entities.Ogrenci;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OgrenciService {
    private OgrenciRepository ogrenciRepository;

    public OgrenciService(OgrenciRepository ogrenciRepository) {
        this.ogrenciRepository = ogrenciRepository;
    }

    @Transactional
    public Ogrenci saveOgrenci(Ogrenci ogrenci)
    {
        return ogrenciRepository.save(ogrenci);
    }
    public Ogrenci retriveOgrenci(Integer id)
    {
        return ogrenciRepository.findById(id).orElse(null);
    }
    public void updateOgrenci(int id, Ogrenci ogrenci)
    {
        Ogrenci updateOgrenci=ogrenciRepository.findById(id).get();
        updateOgrenci.setName(ogrenci.getName());
        updateOgrenci.setSurname(ogrenci.getSurname());

    }
    public  void deleteOgrenci(Integer id)
    {
        ogrenciRepository.deleteById(id);

    }



}
