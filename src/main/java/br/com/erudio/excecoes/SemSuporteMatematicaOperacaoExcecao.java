package br.com.erudio.excecoes;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SemSuporteMatematicaOperacaoExcecao {
    @Serial
    private static final long serialVersionUID = 1L;

}
