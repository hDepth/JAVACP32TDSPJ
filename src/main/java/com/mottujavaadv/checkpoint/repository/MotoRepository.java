package com.mottujavaadv.checkpoint.repository;

import com.mottujavaadv.checkpoint.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    Optional<Moto> findByPlaca(String placa);

}
