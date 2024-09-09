package br.com.alura.adopet.api.impl;

public interface EmailService {

    void enviarEmail(String to, String subject, String message);

}
