package org.example.domain.error;

import org.example.common.Constantes;

public class PacienteDuplicadoError extends RuntimeException {
    public PacienteDuplicadoError() {
        super(Constantes.PACIENTE_DUPLICADO_ERROR);
    }
}
