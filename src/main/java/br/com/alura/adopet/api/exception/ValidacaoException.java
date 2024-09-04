package br.com.alura.adopet.api.exception;

/**
 * @author Mateus Dantas
 */
public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String message) {
        super(message);
    }
}
