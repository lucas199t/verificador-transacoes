package com.a3.verificador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset='UTF-8'>
            <title>Verificador de Transações</title>
            <style>
                body {
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                    background: linear-gradient(135deg, #f0f4f7, #d9e2ec);
                    margin: 0;
                    padding: 40px;
                    color: #333;
                }
                .container {
                    max-width: 800px;
                    margin: auto;
                    background: white;
                    padding: 40px;
                    border-radius: 12px;
                    box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1);
                }
                h1 {
                    text-align: center;
                    color: #1f4e79;
                }
                p {
                    text-align: center;
                    font-size: 18px;
                    color: #555;
                }
                ul {
                    list-style: none;
                    padding: 0;
                    font-size: 16px;
                    margin-top: 30px;
                }
                ul li {
                    padding: 10px 0;
                    border-bottom: 1px solid #eee;
                }
                ul li strong {
                    color: #1f4e79;
                }
                .footer {
                    text-align: center;
                    font-size: 13px;
                    color: #888;
                    margin-top: 40px;
                }
            </style>
        </head>
        <body>
            <div class='container'>
                <h1>Verificador de Transações PIX</h1>
                <p>API para detectar transações suspeitas e prevenir golpes</p>
                <ul>
                    <li><strong>POST</strong> /vendedor – Cadastrar vendedor</li>
                    <li><strong>POST</strong> /transacao – Registrar transação</li>
                    <li><strong>POST</strong> /denuncia – Registrar denúncia</li>
                    <li><strong>GET</strong> /score/{chavePix} – Consultar score</li>
                </ul>
                <div class='footer'>
                    Desenvolvido por Lucas Henrique Pacheco Baiocco – A3 Engenharia de Software 2025
                </div>
            </div>
        </body>
        </html>
        """;
    }
}
