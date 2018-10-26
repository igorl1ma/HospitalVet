package br.com.hospital.vet.resource.rest;

import br.com.hospital.vet.domain.Pets;
import br.com.hospital.vet.service.PetsService;
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
        value = "/pets",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class PetsRestControler {

    @Autowired
    private PetsService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pets editar(@PathVariable ("id") Long id, @RequestBody Pets pets) {
        service.update(id,pets);
        return pets;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pets getPets (@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> salvar (@RequestBody Pets pets) {
        service.save(pets);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pets.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pets> listar() {
        return service.findAll();
    }

}
