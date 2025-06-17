
package com.a3.verificador.controller;

import com.a3.verificador.repository.UsuarioRepository;
import com.a3.verificador.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{chave}")
    public int getScore(@PathVariable String chave) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByChavePix(chave);
        return usuarioOptional.map(Usuario::getScore).orElse(0);
    }
}
