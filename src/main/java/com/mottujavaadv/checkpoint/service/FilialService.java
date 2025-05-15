package com.mottujavaadv.checkpoint.service;

import com.mottujavaadv.checkpoint.model.Filial;
import com.mottujavaadv.checkpoint.repository.FilialRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class FilialService {

    private final FilialRepository filialRepository;

    public FilialService(FilialRepository filialRepository) {
        this.filialRepository = filialRepository;
    }


    public Page<Filial> listarPaginado(Pageable pageable) {
        return filialRepository.findAll(pageable);
    }

    public List<Filial> listarTodas() {
        return filialRepository.findAll();
    }

    public Optional<Filial> buscarPorId(Long id) {
        return filialRepository.findById(id);
    }

    public Filial salvar(Filial filial) {
        return filialRepository.save(filial);
    }

    public void deletar(Long id) {
        filialRepository.deleteById(id);
    }
}
