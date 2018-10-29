package br.com.hospital.vet.resource.rest;

import br.com.hospital.vet.domain.Consultas;
import br.com.hospital.vet.domain.Medicos;
import br.com.hospital.vet.service.ConsultasService;
import br.com.hospital.vet.service.MedicosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(
            value="Deletar uma consulta",
            response=ConsultasRestControler.class,
            notes="Essa operação deleta uma consulta.")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Retorna um Response com uma mensagem de sucesso",
                    response=ConsultasRestControler.class
            ),
            @ApiResponse(
                    code=401,
                    message="Usuário sem permissão para deleção de consulta"
            ),
            @ApiResponse(
                    code=500,
                    message="Caso tenhamos algum erro vamos retornar um Response com a Exception",
                    response=ConsultasRestControler.class
            )

    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Long id){
        service.delete(id);
    }

    @ApiOperation(
            value="Editar uma consulta",
            response=ConsultasRestControler.class,
            notes="Essa operação etida uma consulta.")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Retorna um Response com uma mensagem de sucesso",
                    response=ConsultasRestControler.class
            ),
            @ApiResponse(
                    code=401,
                    message="Usuário sem permissão para edição de consulta"
            ),
            @ApiResponse(
                    code=500,
                    message="Caso tenhamos algum erro vamos retornar um Response com a Exception",
                    response=ConsultasRestControler.class
            )

    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Consultas editar(@PathVariable ("id") Long id, @RequestBody Consultas consultas) {
        service.update(id,consultas);
        return consultas;
    }

    @ApiOperation(
            value="Pesquisar uma consulta",
            response=ConsultasRestControler.class,
            notes="Essa operação pesquisa uma consulta por id.")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Retorna um Response com uma mensagem de sucesso",
                    response=ConsultasRestControler.class
            ),
            @ApiResponse(
                    code=401,
                    message="Usuário sem permissão para pesquisar a consulta"
            ),
            @ApiResponse(
                    code=500,
                    message="Caso tenhamos algum erro vamos retornar um Response com a Exception",
                    response=ConsultasRestControler.class
            )

    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Consultas getConsultas (@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @ApiOperation(
            value="Criar uma consulta",
            response=ConsultasRestControler.class,
            notes="Essa operação cria uma consulta.")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Retorna um Response com uma mensagem de sucesso",
                    response=ConsultasRestControler.class
            ),
            @ApiResponse(
                    code=401,
                    message="Usuário sem permissão para criacao de consulta"
            ),
            @ApiResponse(
                    code=500,
                    message="Caso tenhamos algum erro vamos retornar um Response com a Exception",
                    response=ConsultasRestControler.class
            )

    })
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

    @ApiOperation(
            value="Pesquisar todas as consultas",
            response=ConsultasRestControler.class,
            notes="Essa operação pesquisa todas as consultas cadastradas.")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Retorna um Response com uma mensagem de sucesso",
                    response=ConsultasRestControler.class
            ),
            @ApiResponse(
                    code=401,
                    message="Usuário sem permissão para pesuisar as consultas"
            ),
            @ApiResponse(
                    code=500,
                    message="Caso tenhamos algum erro vamos retornar um Response com a Exception",
                    response=ConsultasRestControler.class
            )

    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Consultas> listar() {
        return service.findAll();
    }

}
