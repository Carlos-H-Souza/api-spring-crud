package br.com.treinaweb.apispringcrud.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.apispringcrud.Entidades.Vendas;

public interface RepositorioVendas extends JpaRepository<Vendas, Long> {

}
