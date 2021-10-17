package com.example.synchronize.secondary.repository;


import com.example.synchronize.secondary.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsinaRepository extends JpaRepository<PersonEntity, Long> {
}
