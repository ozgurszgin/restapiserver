package btk.gov.restapitest.Controller;


import btk.gov.restapitest.Service.OgrenciService;
import btk.gov.restapitest.entities.Ogrenci;
import btk.gov.restapitest.entities.OgrenciQuery;
import btk.gov.restapitest.entities.OgrenciSonuc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciRest {

    private static final Logger LOGGER= LoggerFactory.getLogger(OgrenciRest.class);

    @Autowired
    private OgrenciService ogrenciService;

    @GetMapping("/ogrenciTest")
    public String test()   {
        return "sss";
    }

    @GetMapping("/ogrenciBy")
    public ResponseEntity<OgrenciSonuc> ogrenciSorgu(OgrenciQuery ogrenciQuery){

        LOGGER.info("Baz sorgu basladi...");
        StopWatch stopWatch= new StopWatch();
        stopWatch.start();
        OgrenciSonuc sorguSonuc=new OgrenciSonuc();




        try{
            sorguSonuc.setOgrenci(ogrenciService.retriveOgrenci(ogrenciQuery.getId()));

        }
        catch (Exception e)
        {
            sorguSonuc.setHata("ogrenciSorgu method ERROR"+ e.getMessage());
            LOGGER.error("ogrenciSorgu method ERROR OgrenciId:{}",ogrenciQuery.getId(),e);
            return new ResponseEntity<>(sorguSonuc, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        stopWatch.stop();
        LOGGER.info("ogrenciSorgu took {} seconds", stopWatch.getTotalTimeSeconds());
        return new ResponseEntity<>(sorguSonuc,HttpStatus.OK);
    }

}
