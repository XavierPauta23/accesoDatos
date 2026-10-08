package org.example.ui;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.dto.PacienteDTO;
import org.example.domain.error.AppError;
import org.example.domain.error.DatabaseError;
import org.example.domain.services.PacienteService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;

@Slf4j
public class PacienteUI {
    private final PacienteService pacienteService;

    @Inject
    public PacienteUI (PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public void getAll() {
        try {
            IO.println(pacienteService.getAll());
        } catch (DatabaseError e) {
            log.error("Error de BD {}", e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado");
            throw new AppError("Error crítico");
        }
    }

    public void save() {
        try {
            PacienteDTO pacienteDTO = PacienteDTO.builder()
                    .nombre("María")
                    .fechaNacimiento(LocalDate.of(2003, 10, 23))
                    .telefono("690 555 777")
                    .build();
            IO.println(pacienteService.add(pacienteDTO));
        } catch (DatabaseError e) {
            log.error("Error de base de datos en PatientService.addPatient()", e);
        } catch (Exception e) {
            log.error("Error inesperado", e);
            throw new AppError("Error crítico en addPatient()");
        }
    }
}