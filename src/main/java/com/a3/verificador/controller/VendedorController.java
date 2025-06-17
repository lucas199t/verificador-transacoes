package com.a3.verificador.controller;

import com.a3.verificador.model.Vendedor;
import com.a3.verificador.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    // Cadastro de novo vendedor
    @PostMapping
    public ResponseEntity<Vendedor> criarVendedor(@RequestBody Vendedor vendedor) {
        vendedor.setVerificado(false); // Sempre não verificado ao criar
        Vendedor novoVendedor = vendedorRepository.save(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVendedor);
    }

    // Listar todos os vendedores
    @GetMapping
    public List<Vendedor> listarVendedores() {
        return vendedorRepository.findAll();
    }

    // Buscar vendedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> buscarVendedor(@PathVariable Long id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        return vendedor.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar vendedor
    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> atualizarVendedor(@PathVariable Long id, @RequestBody Vendedor vendedorAtualizado) {
        return vendedorRepository.findById(id)
                .map(vendedor -> {
                    vendedor.setNome(vendedorAtualizado.getNome());
                    vendedor.setDocumento(vendedorAtualizado.getDocumento());
                    vendedor.setEmail(vendedorAtualizado.getEmail());
                    vendedor.setSenha(vendedorAtualizado.getSenha());
                    vendedor.setVerificado(vendedorAtualizado.isVerificado());
                    vendedorRepository.save(vendedor);
                    return ResponseEntity.ok(vendedor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar vendedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVendedor(@PathVariable Long id) {
        if (vendedorRepository.existsById(id)) {
            vendedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar vendedor por email (útil para login)
    @GetMapping("/email/{email}")
    public ResponseEntity<Vendedor> buscarPorEmail(@PathVariable String email) {
        Optional<Vendedor> vendedor = vendedorRepository.findByEmail(email);
        return vendedor.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint de LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String senha = credentials.get("senha");

        Optional<Vendedor> vendedorOpt = vendedorRepository.findByEmail(email);

        if (vendedorOpt.isPresent()) {
            Vendedor vendedor = vendedorOpt.get();
            if (vendedor.getSenha().equals(senha)) {
                // Login OK - não retorne a senha!
                Map<String, Object> userData = new HashMap<>();
                userData.put("id", vendedor.getId());
                userData.put("nome", vendedor.getNome());
                userData.put("email", vendedor.getEmail());
                userData.put("verificado", vendedor.isVerificado());
                return ResponseEntity.ok(userData);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
    }
}
