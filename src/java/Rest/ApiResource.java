/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.Project;
import Entity.ProjectUser;
import Facade.Facade;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Muggi
 */
@Path("project")
public class ApiResource {

    @Context
    private UriInfo context;
    private Facade facade;

    /**
     * Creates a new instance of ApiResource
     */
    public ApiResource() {
        this.facade = new Facade();
    }

    @GET
    @Produces("application/json")
    public String getAllProjects() {
        Gson gson = new Gson();
//        List<Project> list = facade.getAllProjects();
//        String jsonList = gson.toJson(list);
////        JOptionPane.showMessageDialog(null, jsonList);
//        return jsonList;
//        String projectJson = gson.toJson((List<Project>)facade.getAllProjects());
        String projectJson = "Doesnt work yet";
        return projectJson;
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    public String getProject(@PathParam("id") int id) {
        Gson gson = new Gson();
        String project = gson.toJson(facade.findProject(id));
        return project;
    }

    @POST
    @Consumes("application/json")
    public void createProject(String content) {
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Project>() {
        }.getType();
        Project p = gson.fromJson(content, type);
        facade.createProject(p.getName(), p.getDescription());
    }

    @GET
    @Path("users")
    @Produces("application/json")
    public String getAllUsers() {
//        List<Project> list = facade.getAllProjects();
        Gson gson = new Gson();
//        String jsonList = gson.toJson(list);
////        JOptionPane.showMessageDialog(null, jsonList);
//        return jsonList;
//        String projectJson = gson.toJson(facade.getAllUsers());
        String projectJson = "Doesnt work yet";
        return projectJson;
    }

    @GET
    @Produces("application/json")
    @Path("/user/{id}")
    public String getUser(@PathParam("id") int id
    ) {
        Gson gson = new Gson();
        String user = gson.toJson(facade.findUser(id));
        return user;
    }

    @POST
    @Consumes("application/json")
    @Path("/user")
    public void createUser(String content
    ) {
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<ProjectUser>() {
        }.getType();
        ProjectUser pu = gson.fromJson(content, type);
        facade.createUser(pu.getUserName(), pu.getEmail());
    }

    @PUT
    @Consumes("application/json")
    @Path("/user")
    public void assignUserToProject(String content
    ) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Integer>>() {
        }.getType();
        List<Integer> iList = gson.fromJson(content, type);
        Integer[] intArray = iList.toArray(new Integer[0]);
//        JOptionPane.showMessageDialog(null, "Array 0: " + intArray[0]);
//        JOptionPane.showMessageDialog(null, "Array 0: " + intArray[1]);
        facade.assignUserToProject(intArray[0], intArray[1]);
    }

    @DELETE
    @Consumes("application/json")
    @Path("/task/delete")
    public void deleteTask(String content
    ) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Integer>>() {
        }.getType();
        List<Integer> iList = gson.fromJson(content, type);
        Integer[] intArray = iList.toArray(new Integer[0]);
//        JOptionPane.showMessageDialog(null, "Array 0: " + intArray[0]);
//        JOptionPane.showMessageDialog(null, "Array 0: " + intArray[1]);
        facade.removeTask(intArray[0]);
    }

}
