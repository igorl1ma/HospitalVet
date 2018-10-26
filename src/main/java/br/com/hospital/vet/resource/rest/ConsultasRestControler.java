package br.com.hospital.vet.resource.rest;

import br.com.hospital.vet.domain.Consultas;
import br.com.hospital.vet.domain.Medicos;
import br.com.hospital.vet.service.ConsultasService;
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
        value = "/consultas",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class ConsultasRestControler {

    @Autowired
    private ConsultasService service;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Consultas editar(@PathVariable ("id") Long id, @RequestBody Consultas consultas) {
        service.update(id,consultas);
        return consultas;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Consultas getConsultas (@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> salvar (@RequestBody Consultas consultas) {
        service.save(consultas);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consultas.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Consultas> listar() {
        return service.findAll();
    }

}
