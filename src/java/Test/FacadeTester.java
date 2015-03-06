/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Facade.Facade;
import javax.persistence.Persistence;

/**
 *
 * @author Muggi
 */
public class FacadeTester {
    
    static Facade facade = new Facade();
    
    public static void main(String[] args) {
//        facade.createUser("Muggi", "blabla@email.com");
//        facade.createUser("Lonni", "kapla@gmail.com");
//        facade.createUser("Kurt", "kapla@gmail.com");
//        facade.createProject("Project Ultimo", "Test project 1");
//        facade.createProject("Project Maximum", "Test project 2");
//        facade.assignUserToProject(1, 3);
//        facade.assignUserToProject(2, 3);
//        System.out.println(facade.findProject(3).getContributors().toString());
//        facade.createTaskAndAssignToProject("Test task", "Hopefully will be deleted", 5, 151);
//        facade.removeTask(201);
//        facade.getAllUsers();
        facade.getAllProjects();
    }
    
}
