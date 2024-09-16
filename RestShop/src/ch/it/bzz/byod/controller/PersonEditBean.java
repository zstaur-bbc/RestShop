/**
 * Bildungszentrum Zürichsee BZZ
 * Fachgruppe IT
 * 
 * MP-CH-133-1316-2: Webapplikationen realisieren
 * BYODManager
 */
package ch.it.bzz.byod.controller;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;



import ch.it.bzz.byod.model.Person;

/**
 * @author Markus Meier, Marcel Suter
 * @date 2015-01-07
 * @version 2.0
 */
@SessionScoped
@ManagedBean(name = "personEditBean")
public class PersonEditBean {
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    public PersonEditBean() {

    }

    /**
     * Aktion "Speichern"
     * 
     * @return Nächste Maske
     */
    
    public String save() {
        return "personShow?faces-redirect=true";
    }
    
    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean
     *            the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    /**
     * Holt die angemeldete Person aus der LoginBean
     * 
     * @return the person
     */
    public Person getPerson() {
        return getLoginBean().getPerson();
    }

}
