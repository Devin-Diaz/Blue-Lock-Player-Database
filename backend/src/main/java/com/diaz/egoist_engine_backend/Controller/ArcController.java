package com.diaz.egoist_engine_backend.Controller;

import com.diaz.egoist_engine_backend.Model.Arc;
import com.diaz.egoist_engine_backend.Service.ArcService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/arcs")
public class ArcController {
    private final ArcService arcService;

    public ArcController(ArcService arcService) {
        this.arcService = arcService;
    }

    @GetMapping
    public List<Arc> getAllArcs() {
        return arcService.getAllArcs();
    }

    @GetMapping("/{arcId}")
    public ResponseEntity<Arc> getArcById(@PathVariable Integer arcId) {
        Optional<Arc> arcOptional = arcService.getArcById(arcId);
        return arcOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
