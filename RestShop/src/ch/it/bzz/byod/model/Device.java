/**
 * Bildungszentrum Zürichsee BZZ
 * Fachgruppe IT
 * 
 * MP-CH-133-1316-2: Webapplikationen realisieren
 * BYODManager
 */

package ch.it.bzz.byod.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;




/**
 * @author Markus Meier, Marcel Suter
 * @date 2015-01-07
 * @version 1.0
 * 
 */
public class Device
{

    // Bezeichnung
    @Size(min = 4, max = 255, message = "Bezeichnung zu kurz oder zu lang (4 - 255 Zeichen).")
    private String bezeichnung;

    // Hostname
    @Size(min = 4, max = 64, message = "Hostname zu kurz oder zu lang (4 - 64 Zeichen).")
    @Pattern(regexp = "(?i)[0-9a-z]{1,64}", message = "Hostname ungültig.")
    private String hostname;

    // MAC-Adresse
    @NotEmpty(message = "MAC-Adresse fehlt.")
    @Pattern(regexp = "(?i)([0-9a-f]{2}:){5}[0-9a-f]{2}", message = "MAC-Adresse ungültig.")
    private String macAdresse;

    /**
     * Constructor Neues, leeres Gerät anlegen.
     */
    public Device()
    {
        setBezeichnung("");
        setHostname("");
        setMacAdresse("");
    }

    /**
     * Constructor Gerät mit Bezeichnung, Hostname und MAC-Adresse anlegen.
     * 
     * @param bezeichnung  Bezeichnung
     * @param hostname     Hostname
     * @param macAdresse   MAC-Adresse
     */
    public Device(String bezeichnung, String hostname, String macAdresse)
    {
        setBezeichnung(bezeichnung);
        setHostname(hostname);
        setMacAdresse(macAdresse);
    }

    /**
     * @return bezeichnung
     */
    public String getBezeichnung()
    {
        return bezeichnung;
    }

    /**
     * @param bezeichnung  Bezeichnung
     */
    public void setBezeichnung(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
    }

    /**
     * @return hostname
     */
    public String getHostname()
    {
        return hostname;
    }

    /**
     * @param hostname Hostname
     */
    public void setHostname(String hostname)
    {
        this.hostname = hostname.toLowerCase();
    }

    /**
     * @return MAC-Adresse
     */
    public String getMacAdresse()
    {
        return macAdresse;
    }

    /**
     * @param macAdresse MAC-Adresse
     */
    public void setMacAdresse(String macAdresse)
    {
        this.macAdresse = macAdresse.toLowerCase();
    }
}
