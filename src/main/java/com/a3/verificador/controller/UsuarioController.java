package com.a3.verificador.controller;

import com.a3.verificador.model.Usuario;
import com.a3.verificador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getScore() == null) {
            usuario.setScore(100);
        }
        Usuario novo = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // Endpoint para buscar usuário pela chave Pix
    @GetMapping("/chave/{chavePix}")
    public ResponseEntity<Usuario> buscarPorChavePix(@PathVariable String chavePix) {
        Optional<Usuario> usuario = usuarioRepository.findByChavePix(chavePix);
        return usuario.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Endpoint para consultar o score do usuário pela chave Pix
    @GetMapping("/score/{chavePix}")
    public ResponseEntity<Integer> consultarScore(@PathVariable String chavePix) {
        return usuarioRepository.findByChavePix(chavePix)
                .map(usuario -> ResponseEntity.ok(usuario.getScore()))
                .orElse(ResponseEntity.notFound().build());
    }
}
