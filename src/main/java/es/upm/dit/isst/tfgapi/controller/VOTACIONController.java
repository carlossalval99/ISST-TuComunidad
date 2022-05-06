package es.upm.dit.isst.tfgapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.tfgapi.model.VOTACION;
import es.upm.dit.isst.tfgapi.repository.VOTACIONRepository;

@RestController
public class VOTACIONController {

    private final VOTACIONRepository votacionRepository;

    public static final Logger log = LoggerFactory.getLogger(VOTACIONController.class);

    public VOTACIONController(VOTACIONRepository v) {

        this.votacionRepository = v;

    }

    @GetMapping("/votacions")

    List<VOTACION> readAll() {

      return (List<VOTACION>) votacionRepository.findAll();

    }

 

    @PostMapping("/votacions")

    ResponseEntity<VOTACION> create(@RequestBody VOTACION newVOTACION) throws URISyntaxException {

      VOTACION result = votacionRepository.save(newVOTACION);

      return ResponseEntity.created(new URI("/votacions/" + result.getIdvotacion())).body(result);

    }

 

    @GetMapping("/votacions/{id}")

    ResponseEntity<VOTACION> read(@PathVariable String id) {

      return votacionRepository.findById(id).map(votacion ->

         ResponseEntity.ok().body(votacion)

      ).orElse(new ResponseEntity<VOTACION>(HttpStatus.NOT_FOUND));

    }


    @PutMapping("/votacions/{id}")

    ResponseEntity<VOTACION> update(@RequestBody VOTACION newVOTACION, @PathVariable String id) {

      return votacionRepository.findById(id).map(votacion -> {

        votacion.setTema(newVOTACION.getTema());

        votacion.setFechayhoralimite(newVOTACION.getFechayhoralimite());

        votacionRepository.save(votacion);

        return ResponseEntity.ok().body(votacion);

      }).orElse(new ResponseEntity<VOTACION>(HttpStatus.NOT_FOUND));

    }


    @DeleteMapping("votacions/{id}")

    ResponseEntity<VOTACION> delete(@PathVariable String id) {

      votacionRepository.deleteById(id);

      return ResponseEntity.ok().body(null);

    }


    /*@GetMapping("/tfgs/profesor/{id}")

    List<TFG> readTutor(@PathVariable String id) {

      return (List<TFG>) tfgRepository.findByTutor(id);

    }*/


    @PostMapping("/votacions/{id}/incrementa")

    ResponseEntity<VOTACION> incrementa(@PathVariable String id) {

      return votacionRepository.findById(id).map(votacion -> {

       votacion.setVotos(votacion.getVotos() + 1);

        votacionRepository.save(votacion);

        return ResponseEntity.ok().body(votacion);

      }).orElse(new ResponseEntity<VOTACION>(HttpStatus.NOT_FOUND));  

    }

    @PostMapping("/votacions/{id}/resta")

    ResponseEntity<VOTACION> resta(@PathVariable String id) {

      return votacionRepository.findById(id).map(votacion -> {

       votacion.setVotos(votacion.getVotos() - 1);

        votacionRepository.save(votacion);

        return ResponseEntity.ok().body(votacion);

      }).orElse(new ResponseEntity<VOTACION>(HttpStatus.NOT_FOUND));  

    }

}