package com.example.backend.model.repository;

import com.example.backend.model.dao.Account;
import com.example.backend.model.dao.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    Optional<Color> findById(Long id);
    @Query(value = "SELECT c FROM Color c JOIN c.owners a WHERE a.id = :accountId")
    List<Color> findColorsByAccountId(@Param("accountId") Integer accountId);
}
