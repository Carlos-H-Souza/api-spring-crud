package br.com.treinaweb.apispringcrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.treinaweb.apispringcrud.Entidades.Vendas;
import br.com.treinaweb.apispringcrud.Repositorio.RepositorioVendas;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendasController {

    @Autowired
    private RepositorioVendas repositorioVendas;

    // Rota responsável por realizar o cadastro de novas vendas no banco de
    // dados
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vendas cadastrar(@RequestBody Vendas vendas) {
        return repositorioVendas.save(vendas);
    }

    // Rota que responsável por listar todos as vendas cadastradas no banco
    // de dados.
    @GetMapping
    public List<Vendas> listar() {
        return repositorioVendas.findAll();
    }

    // Rota responsável por realizar a busca de uma venda por id.
    @GetMapping("/{id}")
    public Vendas buscarPorId(@PathVariable Long id) {
        var vendasOptional = repositorioVendas.findById(id);
        if (vendasOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return vendasOptional.get();
    }

    // Rota de exclusão de Vendas por id, semelhante com a rota
    // de busca de vendas por id.
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        var vendasOptional = repositorioVendas.findById(id);
        if (vendasOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repositorioVendas.delete(vendasOptional.get());
    }

    @PutMapping("/{id}")
    public Vendas atualizarPorId(@PathVariable Long id, @RequestBody Vendas vendas) {
        var vendasOptional = repositorioVendas.findById(id);
        if (vendasOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        vendas.setId(id);
        return repositorioVendas.save(vendas);
    }

}