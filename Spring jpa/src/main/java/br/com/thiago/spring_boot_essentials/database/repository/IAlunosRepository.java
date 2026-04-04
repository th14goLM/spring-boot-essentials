package br.com.thiago.spring_boot_essentials.database.repository;

import br.com.thiago.spring_boot_essentials.database.model.AlunosEntity;
import br.com.thiago.spring_boot_essentials.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {
}
