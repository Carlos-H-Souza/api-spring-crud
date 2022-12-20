package br.com.treinaweb.apispringcrud.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.apispringcrud.Entidades.Vendedor;

public interface RepositorioVendedor extends JpaRepository<Vendedor, Long> {

}
