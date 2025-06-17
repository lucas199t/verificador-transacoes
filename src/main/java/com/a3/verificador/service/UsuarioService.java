package com.a3.verificador.service;

import com.a3.verificador.model.Usuario;
import com.a3.verificador.repository.UsuarioRepository;
import com.a3.verificador.repository.TransacaoRepository;
import com.a3.verificador.repository.DenunciaRepository;
import com.a3.verificador.model.Transacao;
import com.a3.verificador.model.Denuncia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private DenunciaRepository denunciaRepository;

    public void atualizarOuCriarUsuario(String chavePix) {
        Usuario usuario = usuarioRepository.findByChavePix(chavePix)
            .orElseGet(() -> {
                Usuario novo = new Usuario();
                novo.setChavePix(chavePix);
                novo.setScore(100); // score inicial
                return novo;
            });

        // Calcular score com base nas transações confiáveis e denúncias
        List<Transacao> transacoes = transacaoRepository.findByChavePix(chavePix);
        List<Denuncia> denuncias = denunciaRepository.findByChavePix(chavePix);

        long confiaveis = transacoes.stream().filter(Transacao::isConfiavel).count();
        long denunciasCount = denuncias.size();

        int score = (int) (100 + (confiaveis * 5) - (denunciasCount * 15));
        if (score < 0) score = 0;
        if (score > 100) score = 100;

        usuario.setScore(score);
        usuarioRepository.save(usuario);
    }
}
