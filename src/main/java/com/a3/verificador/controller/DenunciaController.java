package com.a3.verificador.controller;

import com.a3.verificador.model.Denuncia;
import com.a3.verificador.repository.DenunciaRepository;
import com.a3.verificador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/denuncia")
public class DenunciaController {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String registrarDenuncia(@RequestBody Denuncia denuncia) {
        denunciaRepository.save(denuncia);
        usuarioService.atualizarOuCriarUsuario(denuncia.getChavePix());
        return "Denúncia registrada com sucesso!";
    }
}
