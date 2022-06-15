package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AdministrativoApp {

    public static void main(String[] args)  {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        Produto p2 = new Produto();
        p2.setNome("Telefone");
        p2.setPreco(450.0);
        p2.setQuantidade(300);
        p2.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);
        produtoModel.create(p2);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        for (Produto produto:produtos) {
            System.out.println(produto.getId()+" "+produto.getNome()+" "+produto.getPreco()+" "+produto.getQuantidade()+" "+produto.getStatus());
        }
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) Buscar um produto por Id
        Produto produto = produtoModel.findById(p2);
        System.out.println(produto.getId()+" "+produto.getNome()+" "+produto.getPreco()+" "+produto.getQuantidade()+" "+produto.getStatus());

        //4) Deletar um produto
        produtoModel.delete(p1);
        List<Produto> produtoList = produtoModel.findAll();
        System.out.println(produtoList.stream().map(Produto::getId).collect(Collectors.toList()));

        //5) Atualizar produto
        p1.setId(2L);
        p1.setNome("TV - Tela Plana");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(false);
        produtoModel.update(p1);
        Produto produtoModelById = produtoModel.findById(p1);
        System.out.println("Produto atualizado: ");
        System.out.println(produtoModelById.getId()+" "+produtoModelById.getNome()+" "+produtoModelById.getPreco()+" "+produtoModelById.getQuantidade()+" "+produtoModelById.getStatus());


        System.out.println("\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Pessoa(s): ");

        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Renan");
        pessoa1.setCpf("12345678905");
        pessoa1.setEmail("renan@gmail.com");
        pessoa1.setDataDeNascimento(LocalDate.of(1990, 07, 9));
        Integer idade =  Period.between(pessoa1.getDataDeNascimento(), LocalDate.now()).getYears();;
        pessoa1.setIdade(idade);

        // 1) Criando uma pessoa
        pessoaModel.create(pessoa1);

        //2) Buscando todos as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        for (Pessoa pessoa:pessoas) {
            System.out.println(pessoa.getId()+" "+pessoa.getNome()+" "+pessoa.getIdade()+" "+pessoa.getCpf()+" "+pessoa.getDataDeNascimento()+" "+pessoa.getEmail());
        }
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        //3) Buscar uma pessoa por Id
        Pessoa pessoa = pessoaModel.findById(pessoa1);
        System.out.println(pessoa.getId()+" "+pessoa.getNome()+" "+pessoa.getIdade()+" "+pessoa.getCpf()+" "+pessoa.getDataDeNascimento()+" "+pessoa.getEmail());

        //4) Deletar uma pessoa
        pessoaModel.delete(pessoa1);
        List<Pessoa> pessoaList = pessoaModel.findAll();
        System.out.println(pessoaList.stream().map(Pessoa::getCpf).collect(Collectors.toList()));

        //5) Atualizar produto
        pessoa1.setId(31L);
        pessoa1.setNome("Shait");
        pessoa1.setCpf("14603875622");
        pessoa1.setEmail("shait@gmail.com");
        pessoa1.setDataDeNascimento(LocalDate.of(1999, 05, 14));
        Integer idade2 =  Period.between(pessoa1.getDataDeNascimento(), LocalDate.now()).getYears();;
        pessoa1.setIdade(idade2);
        pessoaModel.update(pessoa1);

        Pessoa pessoaModelById = pessoaModel.findById(pessoa1);
        System.out.println("Pessoa atualizado: ");
        System.out.println(pessoa.getId()+" "+pessoa.getNome()+" "+pessoa.getIdade()+" "+pessoa.getCpf()+" "+pessoa.getDataDeNascimento()+" "+pessoa.getEmail());


    }

}
