/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Muggi
 */
@Entity
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @SequenceGenerator(name = "s1", sequenceName = "My_SEQ", initialValue = 1, allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s1")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Project[ id=" + id + " ]";
    }

    public Project() {
        this.tasks = new ArrayList();
        this.contributors = new ArrayList();

    }

    private String name;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModified;

    @ManyToMany
    private List<ProjectUser> contributors;
    @OneToMany
    private List<Task> tasks;
    
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void contributorsAdd(ProjectUser projectUser) {
        contributors.add(projectUser);
    }

    public void contributorsRemove(ProjectUser projectUser) {
        contributors.remove(projectUser);
    }

    public void tasksAdd(Task task) {
        tasks.add(task);
    }

    public void tasksRemove(Task task) {
        tasks.remove(tasks);
    }

    public List<ProjectUser> getContributors() {
        return contributors;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setContributors(List<ProjectUser> contributors) {
        this.contributors = contributors;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    

    public Project(String name, String description, Date created, Date lastModified) {
        this.tasks = new ArrayList();
        this.contributors = new ArrayList();
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
    }

}
