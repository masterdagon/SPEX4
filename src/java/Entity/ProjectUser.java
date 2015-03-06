/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Muggi
 */
@Entity
public class ProjectUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @SequenceGenerator(name = "s1", sequenceName = "My_SEQ",initialValue = 1, allocationSize = 1)
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
        if (!(object instanceof ProjectUser)) {
            return false;
        }
        ProjectUser other = (ProjectUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProjectUser[ id=" + id + " name=" + getUserName() + " email=" + getEmail() + " ] ";
    }

    private String userName;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
 
    @ManyToMany(mappedBy = "contributors")
    private List<Project> projects;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public ProjectUser() {
        this.projects = new ArrayList();

    }

    public void projectsAdd(Project project) {
        projects.add(project);
    }

    public void projectsRemove(Project project) {
        projects.remove(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    
    

    public ProjectUser(String userName, String email, Date created) {
        this.projects = new ArrayList();
        this.userName = userName;
        this.email = email;
        this.created = created;
    }

}
