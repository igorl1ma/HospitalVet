package br.com.hospital.vet.resource.rest;

import br.com.hospital.vet.domain.Medicos;
import br.com.hospital.vet.service.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(
        value = "/medicos",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class MedicosRestControler {

    @Autowired
    private MedicosService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Medicos editar(@PathVariable ("id") Long id, @RequestBody Medicos medicos) {
        service.update(id,medicos);
        return medicos;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Medicos getMedicos (@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> salvar (@RequestBody Medicos medicos) {
        service.save(medicos);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicos.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Medicos> listar() {
        return service.findAll();
    }

}
