/**
 * Bildungszentrum Zuerichsee BZZ
 * Fachgruppe IT
 * 
 * MP-CH-133-1316-2: Webapplikationen realisieren
 * BYODManager
 */
package ch.it.bzz.byod.model;

import ch.it.bzz.byod.data.DataHandler;
import java.util.ArrayList;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;


/**
 * @author Raphael Stauffacher
 * @date 2017-04-13
 * @version 1.0
 */
public class Person
{
    private DataHandler dataHandler;
    private ArrayList<Device> deviceList = new ArrayList<Device>();

    // Email
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email ist invalid!")
    private String email;
    
    // Name
    @NotEmpty(message = "Name fehlt.")
    @Size(max = 255, message = "Name zu lang (max. 255 Zeichen).")
    private String            name;

    // Benutzername
    @Size(min = 2, max = 32, message = "Benutzername zu kurz oder zu lang (2 - 32).")
    @Pattern(regexp = "(?i)[a-z0-9]{2,32}", message = "Benutzername ungültig.")
    private String            benutzername;

    // Passwort
    @Size(min = 8, max = 32, message = "Passwort zu kurz oder zu lang (8 - 32).")
    private String            passwort;


    /**
     * Constructor Neue, leere Person anlegen. 
     */
    public Person()
    {
       setDataHandler(new DataHandler());
    }

    /**
     * Gerät hinzufügen
     * 
     * @param device
     *            Neues Gerät
     * @return true: erfolgreich, false: fehlgeschlagen
     */
    public boolean addGeraet(Device device)
    {
        if (!deviceList.add(device))
            return false;

        return true;
    }

    /**
     * Gerät entfernen
     * 
     * @param device  Zu entfernendes Gerät
     * @return true: erfolgreich, false: fehlgeschlagen
     */
    public boolean removeGeraet(Device device)
    {

        return deviceList.remove(device);
    }

    /**
     * Login überprüfen
     * 
     * @param benutzername  Eingegebener Benutzername
     * @param passwort      Eingegebenes Passwort
     * @return true:        Korrektes Login 
     *         false:       Fehler
     */
    public boolean checkLogin(String benutzername, String passwort)
    {
        if (getDataHandler().loadData(this, benutzername)) {   // Person existiert
            if (passwort.equals(getPasswort())) {
                return true;
            }
        } 
        setBenutzername(null);
        return false;
    }

    /**
     * @return the dataHandler
     */
    public DataHandler getDataHandler() {
        return dataHandler;
    }

    /**
     * @param dataHandler the dataHandler to set
     */
    public void setDataHandler(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    /**
     * @return the deviceList
     */
    public ArrayList<Device> getDeviceList() {
        return deviceList;
    }

    /**
     * @param deviceList Geräte-Liste
     */
    public void setDeviceList(ArrayList<Device> deviceList) {
        this.deviceList = deviceList;
    }

    /**
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name Name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return benutzername
     */
    public String getBenutzername()
    {
        return benutzername;
    }

    /**
     * Benutzername setzen
     * 
     * @param benutzername Benutzername
     */
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    /**
     * @return the passwort
     */
    public String getPasswort() {
        return passwort;
    }

    /**
     * Passwort setzen
     * 
     * @param passwort Neues Passwort
     */
    public void setPasswort(String passwort)
    {
        // Neuen Passwort-Hash ablegen
        this.passwort = passwort;

    }
    
    /**
     * 
     * @return the email
     */
    public String getEmail()  {
    	return this.email;
    }
    
    /**
     * Email setzten
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

}
