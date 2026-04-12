package br.com.thiago.spring_boot_essentials.database.repository;

import br.com.thiago.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {
}
