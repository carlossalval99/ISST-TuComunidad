/*package es.upm.dit.isst.tfgapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.tfgapi.model.VECINO;
import es.upm.dit.isst.tfgapi.repository.COMUNIDADRepository;
import es.upm.dit.isst.tfgapi.repository.VECINORepository;

@RestController
public class VECINOController {

  @Autowired
  private COMUNIDADRepository comunidadRepository;
  
    private final VECINORepository vecinoRepository;

    public static final Logger log = LoggerFactory.getLogger(VECINOController.class);

    public VECINOController(VECINORepository i) {

        this.vecinoRepository = i;

    }
/*
    @GetMapping("/comunidads/{comunidadId}/vecinos")

    public ResponseEntity<List<VECINO>> getAllVecinosByComunidadId(@PathVariable(value = "comunidadId") String comunidadId) {
      if (!comunidadRepository.existsById(comunidadId)) {
        throw new ResourceNotFoundException("Not found Comunidad with id = " + comunidadId);
      }
      List<VECINO> vecinos = vecinoRepository.findByComunidadId(comunidadId);
      return new ResponseEntity<>(vecinos, HttpStatus.OK);
    }

    @GetMapping("/vecinos/{id}")
    public ResponseEntity<VECINO> getVecinosByComunidadId(@PathVariable(value = "id") String id) {
      VECINO vecino = vecinoRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Not found Vecino with id = " + id));
      return new ResponseEntity<>(vecino, HttpStatus.OK);
    }

    @PostMapping("/comunidads/{comunidadlId}/vecinos")
    public ResponseEntity<VECINO> createComment(@PathVariable(value = "tutorialId") String comunidadId,
        @RequestBody VECINO vecinoRequest) {
      VECINO vecino = comunidadRepository.findById(comunidadId).map(comunidad -> {
        vecinoRequest.setComunidad(comunidad);
        return vecinoRepository.save(vecinoRequest);
      }).orElseThrow(() -> new ResourceNotFoundException("Not found Comunidad with id = " + comunidadId));
      return new ResponseEntity<>(vecino, HttpStatus.CREATED);
    }
*//*
  @GetMapping("/vecinos")
    List<VECINO> readAll() {

      return (List<VECINO>) vecinoRepository.findAll();

    }

 
/*
    @PostMapping("/vecinos")

    ResponseEntity<VECINO> create(@RequestBody VECINO newVECINO) throws URISyntaxException {

      VECINO result = vecinoRepository.save(newVECINO);

      return ResponseEntity.created(new URI("/vecinos/" + result.getId())).body(result);

    }

 */
/*
    @GetMapping("/vecinos/{piso}")

    ResponseEntity<VECINO> read(@PathVariable String piso) {

      return vecinoRepository.findByPiso(piso).map(vecino ->

         ResponseEntity.ok().body(vecino)

      ).orElse(new ResponseEntity<VECINO>(HttpStatus.NOT_FOUND));

    }*/

/*
    @PutMapping("/infos/{id}")

    ResponseEntity<INFO> update(@RequestBody INFO newINFO, @PathVariable String id) {

      return infoRepository.findById(id).map(info -> {

        info.setTema(newINFO.getTema());

        info.setContenido(newINFO.getContenido());

        info.setVecino(newINFO.getVecino());

        infoRepository.save(info);

        return ResponseEntity.ok().body(info);

      }).orElse(new ResponseEntity<INFO>(HttpStatus.NOT_FOUND));

    }


    @DeleteMapping("comunidad/{id}")

    ResponseEntity<COMUNIDAD> delete(@PathVariable String id) {

      comunidadRepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }

/*
    @GetMapping("/tfgs/profesor/{id}")

    List<TFG> readTutor(@PathVariable String id) {

      return (List<TFG>) tfgRepository.findByTutor(id);

    }*/


    /*@PostMapping("/tfgs/{id}/incrementa")

    ResponseEntity<TFG> incrementa(@PathVariable String id) {

      return tfgRepository.findById(id).map(tfg -> {

       tfg.setStatus(tfg.getStatus() + 1);

        tfgRepository.save(tfg);

        return ResponseEntity.ok().body(tfg);

      }).orElse(new ResponseEntity<TFG>(HttpStatus.NOT_FOUND));  

    }*/
/*
}*/