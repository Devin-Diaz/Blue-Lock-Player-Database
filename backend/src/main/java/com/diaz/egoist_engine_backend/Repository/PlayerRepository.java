package com.diaz.egoist_engine_backend.Repository;

import com.diaz.egoist_engine_backend.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByPlayerId(Integer id);
    Optional<Player> findByFullName(String fullName);
    List<Player> findAllByNationality(String nationality);
}
