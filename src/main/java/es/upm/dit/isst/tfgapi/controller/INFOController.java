package es.upm.dit.isst.tfgapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.tfgapi.model.INFO;
import es.upm.dit.isst.tfgapi.repository.INFORepository;

@RestController
public class INFOController {

    private final INFORepository infoRepository;

    public static final Logger log = LoggerFactory.getLogger(INFOController.class);

    public INFOController(INFORepository i) {

        this.infoRepository = i;

    }

    @Secured("ROLE_VECINO")

    @GetMapping("/infos")

    List<INFO> readAll() {

      return (List<INFO>) infoRepository.findAll();

    }

 
    @Secured("ROLE_VECINO")
    @PostMapping("/infos")

    ResponseEntity<INFO> create(@RequestBody INFO newINFO) throws URISyntaxException {

      INFO result = infoRepository.save(newINFO);

      return ResponseEntity.created(new URI("/infos/" + result.getIdinfo())).body(result);

    }

 
    @Secured("ROLE_VECINO")

    @GetMapping("/infos/{id}")

    ResponseEntity<INFO> read(@PathVariable String id) {

      return infoRepository.findById(id).map(info ->

         ResponseEntity.ok().body(info)

      ).orElse(new ResponseEntity<INFO>(HttpStatus.NOT_FOUND));

    }

    @Secured("ROLE_VECINO")

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

    @Secured("ROLE_VECINO")

    @DeleteMapping("infos/{id}")

    ResponseEntity<INFO> delete(@PathVariable String id) {

      infoRepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }


    /*@GetMapping("/tfgs/profesor/{id}")

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

}