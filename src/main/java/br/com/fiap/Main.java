package br.com.fiap;

import br.com.fiap.funcionario.model.Funcionario;
import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fiap");
        EntityManager manager = factory.createEntityManager();

        PF bene = new PF();
        bene.setNome("Benefrancis");
        bene.setNascimento(LocalDate.of(1977, 3, 8));
        bene.setCPF("2416465468");
        bene.setRG("1231546");

        Funcionario func = new Funcionario();
        func.setPessoa(bene);
        func.setMatricula("12315");
        func.setAdmissao(LocalDate.now());
        func.setEmail("benefrancis@mlbenezinho.com.br");

        manager.getTransaction().begin();
        manager.persist(func);
        manager.getTransaction().commit();
    }
}