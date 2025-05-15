package com.mottujavaadv.checkpoint.controller;

import com.mottujavaadv.checkpoint.model.Filial;
import com.mottujavaadv.checkpoint.service.FilialService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filiais")
public class FilialController {

    private final FilialService filialService;

    public FilialController(FilialService filialService) {
        this.filialService = filialService;
    }

    @GetMapping
    public ResponseEntity<Page<Filial>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return ResponseEntity.ok(filialService.listarPaginado(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filial> buscarPorId(@PathVariable Long id) {
        return filialService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Filial> criar(@Valid @RequestBody Filial filial) {
        return ResponseEntity.status(201).body(filialService.salvar(filial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filial> atualizar(@PathVariable Long id, @Valid @RequestBody Filial novaFilial) {
        return filialService.buscarPorId(id)
                .map(filial -> {
                    filial.setNome(novaFilial.getNome());
                    filial.setCidade(novaFilial.getCidade());
                    filial.setEstado(novaFilial.getEstado());
                    filial.setPais(novaFilial.getPais());
                    filial.setTamanhoPatio(novaFilial.getTamanhoPatio());
                    return ResponseEntity.ok(filialService.salvar(filial));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (filialService.buscarPorId(id).isPresent()) {
            filialService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
