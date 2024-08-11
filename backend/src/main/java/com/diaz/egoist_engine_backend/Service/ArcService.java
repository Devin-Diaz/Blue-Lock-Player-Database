package com.diaz.egoist_engine_backend.Service;

import com.diaz.egoist_engine_backend.Model.Arc;
import com.diaz.egoist_engine_backend.Repository.ArcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArcService {
    private final ArcRepository arcRepository;

    public ArcService(ArcRepository arcRepository) {
        this.arcRepository = arcRepository;
    }

    public List<Arc> getAllArcs() {
        return arcRepository.findAll();
    }

    public Optional<Arc> getArcById(Integer arcId) {
        return arcRepository.findById(arcId);
    }
}
