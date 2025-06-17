package com.a3.verificador.controller;

import com.a3.verificador.model.Transacao;
import com.a3.verificador.repository.TransacaoRepository;
import com.a3.verificador.repository.UsuarioRepository;
import com.a3.verificador.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/transacao")
    public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao) {
        Transacao nova = transacaoRepository.save(transacao);

        // Atualiza o score do usuário referente à chave Pix usada
        usuarioRepository.findByChavePix(transacao.getChavePix()).ifPresent(usuario -> {
            // Exemplo: reduz 1 ponto no score a cada Pix enviado
            int atual = usuario.getScore() != null ? usuario.getScore() : 0;
            int novoScore = Math.min(atual + 5, 100);
          usuario.setScore(novoScore);
          usuarioRepository.save(usuario);
        });

        return ResponseEntity.ok(nova);
    }
}
