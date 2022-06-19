package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestaoCursosMain {
    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Professor professor = new Professor();
        Telefone telefone = new Telefone();
        Curso curso = new Curso();
        Aluno aluno = new Aluno();
        Endereco endereco = new Endereco();
        MaterialCurso materialCurso = new MaterialCurso();
        List<Telefone>listaTelefone = new ArrayList<>();
        List<Endereco>listaEndereco = new ArrayList<>();
        List<Aluno> listaAluno = new ArrayList<>();

        telefone.setDdd("31");
        telefone.setTelefone("99716-0487");

        endereco.setEndereco("Rua Conceição Rosa Lima");
        endereco.setLogadouro("Apto");
        endereco.setNumero("778");
        endereco.setBairro("Ingá");
        endereco.setCep(3217640);
        endereco.setCidade("Betim");
        endereco.setEstado("Minas Gerais");

        aluno.setEmail("juniorshait@gmail.com");
        aluno.setMatricula("709372");
        aluno.setNomecompleto("Shait Junior Moreira dos Santos");
        listaTelefone.add(telefone);
        aluno.setTelefone(listaTelefone);
        listaEndereco.add(endereco);
        aluno.setEndereco(listaEndereco);
        aluno.setDataDeNascimento(LocalDate.of(1999, 05, 14));
        listaAluno.add(aluno);
        alunoModel.create(aluno);

        professor.setEmail("renan@gmail.com");
        professor.setMatricula("te03417");
        professor.setNomecompleto("Renan de Lima Gomes");

        curso.setMaterialCurso(materialCurso);
        curso.setAluno(listaAluno);
        curso.setNome("Analise de Algoritmo");
        curso.setSigla("AA");
        curso.setProfessor(professor);

        materialCurso.setCurso(curso);
        materialCurso.setUrl("https://pt.wikipedia.org/wiki/An%C3%A1lise_de_algoritmos#:~:text=Em%20ci%C3%AAncia%20da%20computa%C3%A7%C3%A3o%2C%20a,(inputs)%20de%20tamanho%20arbitr%C3%A1rio.");

        cursoModel.create(curso);

        //2) Buscando todos os alunos na base de dados
        List<Aluno> alunos = alunoModel.findAll();
        for (Aluno aluno1:alunos) {
            System.out.println(aluno1.getId()+" "+aluno1.getNomecompleto()+" "+aluno1.getDataDeNascimento()+" "
                    +aluno1.getEmail()+" "+aluno1.getMatricula()+" "+aluno1.getTelefone()+" "+
                    aluno1.getEndereco());
        }

        //3) Buscar um Aluno por Id
        Aluno aluno1 = alunoModel.findById(aluno.getId());
        System.out.println(aluno1.getId()+" "+aluno1.getNomecompleto()+" "+aluno1.getDataDeNascimento()+" "
                +aluno1.getEmail()+" "+aluno1.getMatricula()+" "+aluno1.getTelefone()+" "+
                aluno1.getEndereco());

        //4) Deletar um aluno
        alunoModel.delete(aluno1);
        List<Aluno> pessoaList = alunoModel.findAll();
        System.out.println(pessoaList.stream().map(Aluno::getMatricula).collect(Collectors.toList()));

        //5) Atualizar Aluno
        aluno.setEmail("juniorshait@gmail.com");
        aluno.setMatricula("5436");
        aluno.setNomecompleto("Joao Junior Moreira dos Santos");
        listaTelefone.add(telefone);
        aluno.setTelefone(listaTelefone);
        listaEndereco.add(endereco);
        aluno.setEndereco(listaEndereco);
        aluno.setDataDeNascimento(LocalDate.of(1999, 05, 14));
        listaAluno.add(aluno);

        Aluno alunoModelById = alunoModel.findById(aluno.getId());
        System.out.println("Aluno atualizado: ");
        System.out.println(aluno1.getId()+" "+aluno1.getNomecompleto()+" "+aluno1.getDataDeNascimento()+" "
                +aluno1.getEmail()+" "+aluno1.getMatricula()+" "+aluno1.getTelefone()+" "+
                aluno1.getEndereco());

        //2) Buscando todos os cursos na base de dados
        List<Curso> cursos = cursoModel.findAll();
        for (Curso curso1: cursos) {
            System.out.println(curso1.getId()+" "+curso1.getNome()+" "+curso1.getMaterialCurso()+" "
                    +curso1.getAluno()+" "+curso1.getProfessor()+" "+curso1.getSigla());
        }

        //3) Buscar um Curso por Id
        Curso curso1 = cursoModel.findById(curso.getId());
        System.out.println(curso1.getId()+" "+curso1.getNome()+" "+curso1.getMaterialCurso()+" "
                +curso1.getAluno()+" "+curso1.getProfessor()+" "+curso1.getSigla());

        //4) Deletar um curso
        cursoModel.delete(curso1);

        List<Curso> cursoList = cursoModel.findAll();
        System.out.println(cursoList.stream().map(Curso::getNome).collect(Collectors.toList()));

        //5) Atualizar Curso
        curso.setMaterialCurso(materialCurso);
        curso.setAluno(listaAluno);
        curso.setNome("Analise de POO");
        curso.setSigla("POO");
        curso.setProfessor(professor);
        materialCurso.setCurso(curso);
        materialCurso.setUrl("https://pt.wikipedia.org/wiki/An%C3%A1lise_de_algoritmos#:~:text=Em%20ci%C3%AAncia%20da%20computa%C3%A7%C3%A3o%2C%20a,(inputs)%20de%20tamanho%20arbitr%C3%A1rio.");


        Curso cursoModelById = cursoModel.findById(curso.getId());
        System.out.println("Curso atualizado: ");
        System.out.println(curso1.getId()+" "+curso1.getNome()+" "+curso1.getMaterialCurso()+" "
                +curso1.getAluno()+" "+curso1.getProfessor()+" "+curso1.getSigla());

    }
}
