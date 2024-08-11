package com.diaz.egoist_engine_backend.Repository;

import com.diaz.egoist_engine_backend.Model.Arc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArcRepository extends JpaRepository<Arc, Integer> {
}
