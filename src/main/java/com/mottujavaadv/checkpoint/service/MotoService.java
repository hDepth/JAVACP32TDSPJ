package com.mottujavaadv.checkpoint.service;

import com.mottujavaadv.checkpoint.model.Moto;
import com.mottujavaadv.checkpoint.repository.MotoRepository;
import jakarta.persistence.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    private final MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public Page<Moto> listarPaginado(Pageable pageable) {
        return motoRepository.findAll(pageable);
    }

    //@Cacheable("motos")
    //public List<Moto> listarTodas() {
        //return motoRepository.findAll();
   // }


    public Optional<Moto> buscarPorId(Long id) {
        return motoRepository.findById(id);
    }

    public Moto salvar(Moto moto) {
        return motoRepository.save(moto);
    }

    public void deletar(Long id) {
        motoRepository.deleteById(id);
    }

    public Optional<Moto> buscarPorPlaca(String placa) {
        return motoRepository.findByPlaca(placa);
    }


}
