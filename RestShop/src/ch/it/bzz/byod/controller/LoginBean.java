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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import ch.it.bzz.byod.model.Person;

/**
 * @author Markus Meier, Marcel Suter
 * @date 2015-01-07
 * @version 2.0
 */
@SessionScoped
@ManagedBean(name = "loginBean")
public class LoginBean {

	private Person person;
	@NotNull(message = "Benutzername fehlt.")
	private String email;
	private String benutzername;
	private String passwort;

	public LoginBean() {
		setPerson(new Person());
	}

	/**
	 * Gibt an ob die Person authentifiziert wurde
	 * 
	 * @return true=Authentifiziert
	 */
	public boolean isAuthenticated() {
		if (getPerson().getBenutzername() == null)
			return false;
		return true;
	}

	/**
	 * Aktion "Login"
	 * 
	 * @return Nächste Maske
	 */
	public String login() {
		if (getPerson().checkLogin(getBenutzername(), getPasswort())) {
			return "personShow?faces-redirect=true";
		} else {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Benutzername und/oder Passwort falsch", null));
			return "login";
		}
	}

	/**
	 * Aktion "Logout"
	 * 
	 * @return Nächste Maske
	 */
	public String logout() {
		setPerson(new Person());
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Benutzer abgemeldet", null));

		context.getExternalContext().getFlash().setKeepMessages(true);
		return "login?faces-redirect=true";
	}
	
	public void setLogin(String login) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(login);
		
		if(matcher.matches()) {
			setEmail(login);
		} else {
			setBenutzername(login);
		}
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person
	 *            the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the benutzername
	 */
	public String getBenutzername() {
		return benutzername;
	}

	/**
	 * @param login
	 *            the benutzername to set
	 */
	public void setBenutzername(String login) {
		this.benutzername = login;
	}

	/**
	 * @return the passwort
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * @param passwort
	 *            the passwort to set
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	/**
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * sets the email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
