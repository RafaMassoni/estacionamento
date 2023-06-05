package br.com.rafael.controllers;


import br.com.rafael.daos.TiqueteDAO;
import br.com.rafael.factory.TiqueteAdapterFactory;
import br.com.rafael.requester.FinalizarTiqueteRequester;
import br.com.rafael.requester.VeiculoRequester;
import br.com.rafael.responses.TiqueteResponse;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/tiquete")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TiqueteController {

    private final TiqueteAdapter tiqueteAdapter;

    public TiqueteController(TiqueteDAO tiqueteDAO) {
        this.tiqueteAdapter = TiqueteAdapterFactory.factory.criar(tiqueteDAO);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
         List<TiqueteResponse> categoriaDTOS = tiqueteAdapter.buscarTodos();
        return ResponseEntity.ok(categoriaDTOS);
    }





    @GetMapping("/{idTiquete}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer idTiquete) {
        TiqueteResponse tiquete = tiqueteAdapter.buscarPorId(idTiquete);
        return ResponseEntity.ok(tiquete);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> criarNovoTiquete(@Valid @RequestBody VeiculoRequester veiculoRequester) {
        TiqueteResponse tiquete = tiqueteAdapter.criarNovoTiquete(veiculoRequester);
        return ResponseEntity
                .created( URI.create("/tiquete/" + tiquete.id().toString()))
                .body("Tiquete criado com sucesso!");
    }


    @PostMapping("/finalizar")
    public ResponseEntity<?> finalizarTiquete(@Valid @RequestBody FinalizarTiqueteRequester finalizarTiqueteRequester) {
        tiqueteAdapter.finalizarTiquete(finalizarTiqueteRequester);
        return ResponseEntity.ok("Tiquete finalizado com sucesso!");
    }

}
