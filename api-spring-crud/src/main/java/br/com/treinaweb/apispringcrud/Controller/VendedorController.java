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

import br.com.treinaweb.apispringcrud.Entidades.Vendedor;
import br.com.treinaweb.apispringcrud.Repositorio.RepositorioVendedor;

@RestController
@RequestMapping("/api/v1/vendedor")
public class VendedorController {

    @Autowired
    private RepositorioVendedor repositorioVendedor;

    // Rota responsável por realizar o cadastro de novos vendedores no banco de
    // dados
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vendedor cadastrar(@RequestBody Vendedor vendedor) {
        return RepositorioVendedor.save(vendedor);
    }

    // Rota que responsável por listar todos os vendedores cadastradas no banco
    // de dados.
    @GetMapping
    public List<Vendedor> listar() {
        return repositorioVendedor.findAll();
    }

    // Rota responsável por realizar a busca de vendedores pelo id.
    @GetMapping("/{idVendedor}")
    public Vendedor buscarPorId(@PathVariable Long idVendedor) {
        var vendedorOptional = repositorioVendedor.findById(idVendedor);
        if (vendedorOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return vendedorOptional.get();
    }

    // Rota de exclusão de Vendedores por id, semelhante com a rota
    // de busca de vendedores por id.
    @DeleteMapping("/{idVendedor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long idVendedor) {
        var vendedorOptional = repositorioVendedor.findById(idVendedor);
        if (vendedorOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repositorioVendedor.delete(vendedorOptional.get());
    }

    @PutMapping("/{id}")
    public Vendedor atualizarPorId(@PathVariable Long idVendedor, @RequestBody Vendedor vendedor) {
        var vendedorOptional = repositorioVendedor.findById(idVendedor);
        if (vendedorOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        vendedor.SetIdVendedor(idVendedor);
        return repositorioVendedor.save(vendedor);
    }

}
