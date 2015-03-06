/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Project;
import Entity.ProjectUser;
import Entity.Task;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Muggi
 */
public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPEX4PU");
    EntityManager em = emf.createEntityManager();

    public void createUser(String userName, String email) {
        Date date = new Date();
        ProjectUser user = new ProjectUser(userName, email, date);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public ProjectUser findUser(long id) {
        return em.find(ProjectUser.class, id);
    }

    public List<ProjectUser> getAllUsers() {
        TypedQuery<ProjectUser> query = em.createQuery("select x from ProjectUser x", ProjectUser.class);
        List<ProjectUser> results = query.getResultList();
        System.out.println(results.get(0));
        System.out.println(results.get(1));
        return results;
//        em.getTransaction().begin();
//        Query query = em.createNativeQuery("select * from PROJECTUSER");
//        em.getTransaction().commit();
//        return query.getResultList();
    }

    public void createProject(String name, String description) {
        Date date = new Date();
        Project project = new Project(name, description, date, date);
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
    }

    public List<Project> getAllProjects() {
        TypedQuery<Project> query = em.createQuery("select x from Project x", Project.class);
        List<Project> results = query.getResultList();
        System.out.println(results.get(0).getDescription());
        return results;
//        em.getTransaction().begin();
//        Query query = em.createNativeQuery("select * from PROJECT");
//        em.getTransaction().commit();
//        return query.getResultList();
    }

    public void assignUserToProject(long userId, long projectId) {
        Date date = new Date();
        ProjectUser user = em.find(ProjectUser.class, userId);
        Project project = em.find(Project.class, projectId);

        em.getTransaction().begin();
        project.setLastModified(date);
        project.contributorsAdd(user);
        em.getTransaction().commit();
    }

    public Project findProject(long id) {
        return em.find(Project.class, id);
    }

    public void createTaskAndAssignToProject(String name, String description, int hoursAssigned, long id) {
        Date date = new Date();
        Task task = new Task(name, description, hoursAssigned, 0);
        Project project = em.find(Project.class, id);
        em.getTransaction().begin();
        project.tasksAdd(task);
        project.setLastModified(date);
        em.persist(task);
        em.persist(project);
        em.getTransaction().commit();
    }

    public void removeTask(long id) {
        Task task = em.find(Task.class, id);
        em.getTransaction().begin();
        Query query = em.createNativeQuery("delete from project_task where tasks_id = " + id);
        query.executeUpdate();
        em.remove(task);
        em.getTransaction().commit();

    }

}
