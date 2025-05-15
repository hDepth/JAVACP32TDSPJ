package com.mottujavaadv.checkpoint.controller;

import com.mottujavaadv.checkpoint.model.Filial;
import com.mottujavaadv.checkpoint.model.Moto;
import com.mottujavaadv.checkpoint.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motos")
public class MotoController {

    private final MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @GetMapping
    public ResponseEntity<Page<Moto>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return ResponseEntity.ok(motoService.listarPaginado(pageable));
    }



    @GetMapping("/{id}")
    public ResponseEntity<Moto> buscarPorId(@PathVariable Long id) {
        return motoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<Moto> buscarPorPlaca(@RequestParam String placa) {
        return motoService.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Moto> criar(@Valid @RequestBody Moto moto) {
        return ResponseEntity.status(201).body(motoService.salvar(moto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moto> atualizar(@PathVariable Long id, @Valid @RequestBody Moto novaMoto) {
        return motoService.buscarPorId(id)
                .map(moto -> {
                    moto.setPlaca(novaMoto.getPlaca());
                    moto.setModelo(novaMoto.getModelo());
                    moto.setCor(novaMoto.getCor());
                    moto.setAnoFabricacao(novaMoto.getAnoFabricacao());
                    moto.setStatus(novaMoto.getStatus());
                    moto.setPosicaoNoPatio(novaMoto.getPosicaoNoPatio());
                    moto.setFilial(novaMoto.getFilial());
                    return ResponseEntity.ok(motoService.salvar(moto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (motoService.buscarPorId(id).isPresent()) {
            motoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

