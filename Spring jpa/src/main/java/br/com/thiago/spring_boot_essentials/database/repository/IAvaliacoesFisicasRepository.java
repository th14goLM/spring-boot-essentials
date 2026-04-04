package br.com.thiago.spring_boot_essentials.database.repository;

import br.com.thiago.spring_boot_essentials.database.model.AvaliacaoesFisicasEntity;
import br.com.thiago.spring_boot_essentials.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacaoesFisicasEntity, Integer> {
}
