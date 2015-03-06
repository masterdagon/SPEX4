/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entity.Project;
import Entity.ProjectUser;
import Entity.Task;
import Facade.Facade;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Muggi
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPEX4PU");
        EntityManager em = emf.createEntityManager();
        
        Date date = new Date();
        Project project = new Project("Project1","Demo project",date,date);
        ProjectUser projectUser = new ProjectUser("John Doe","abc@hotmail.com",date);
        Task task = new Task("Task 1","Demo task", 10,2);
        
        project.tasksAdd(task);
        project.contributorsAdd(projectUser);
        projectUser.projectsAdd(project);
        
        em.getTransaction().begin();
        em.persist(project);

        em.persist(projectUser);

        em.persist(task);
        
        em.getTransaction().commit();
        
        Facade facade = new Facade();
        facade.createUser("Hanne", "abracadabra@gmail.com");
        System.out.println("USER FROM DATABASE: " + facade.findUser(4).getUserName());
        
        facade.createTaskAndAssignToProject("TASKTEST", "This is a test task", 10, (long)1);
        System.out.println("TASK FROM DATABASE: " + facade.findProject((long)1).getTasks().get(1).getDescription());
    }

}
