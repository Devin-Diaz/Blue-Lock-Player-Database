package com.diaz.egoist_engine_backend.Repository;

import com.diaz.egoist_engine_backend.Model.Arc;
import com.diaz.egoist_engine_backend.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArcRepository extends JpaRepository<Arc, Integer> {

    Arc findByArcId(Integer id);

}
