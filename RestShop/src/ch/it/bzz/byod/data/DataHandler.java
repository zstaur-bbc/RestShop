/**
 * Bildungszentrum Zürichsee BZZ
 * Fachgruppe IT
 * 
 * MP-CH-133-1316-2: Webapplikationen realisieren
 * BYODManager
 */
package ch.it.bzz.byod.data;

import ch.it.bzz.byod.model.Device;
import ch.it.bzz.byod.model.Person;

/**
 * @author Markus Meier, Marcel Suter
 * @date 2015-01-07
 * @version 2.0
 */
public class DataHandler {

    public boolean loadData(Person person, String benutzername) {
        if (benutzername.equals("ammanna") | benutzername.equals("anton.ammann@it.bzz.ch")) {
            person.setPasswort("TonY");
            person.setName("Ammann, Anton");
            person.setEmail("anton.ammann@it.bzz.ch");
            person.setBenutzername("amanna");
            person.addGeraet(new Device("Apple MacBookPro", "tonibook",
                    "01:23:45:67:89:01"));
            person.addGeraet(new Device("Apple iPhone 5s", "toniphone",
                    "01:23:45:67:89:02"));
            person.addGeraet(new Device("Apple iPad Air", "tonipad",
                    "01:23:45:67:89:03"));
            return true;
        } else if (benutzername.equals("bergerb") | benutzername.equals("bebe@example.com")) {
            person.setPasswort("BeA");
            person.setName("Berger, Béatrice");
            person.setEmail("bebe@example.com");
            person.setBenutzername("bergerb");
            return true;
        } else if (benutzername.equals("chraemerc") | benutzername.equals("christian.chraemer@it.bzz.ch")) {
            person.setPasswort("ChriS");
            person.setName("Chrämer, Christian");
            person.setEmail("christian.chraemer@it.bzz.ch");
            person.setBenutzername("chraemerc");
            return true;
        } else if (benutzername.equals("doeblid")) {
            person.setPasswort("d0d0");
            person.setName("Döbeli, Dora");
            person.setEmail("");
            person.setBenutzername("doeblid");
            person.addGeraet(new Device("Dell Latitude", "dodo1",
                    "00:11:22:33:44:55"));
            person.addGeraet(new Device("Dell Venue", "dodo2",
                    "11:22:33:44:55:66"));
            return true;
        } else if (benutzername.equals("zurbriggenyx") | benutzername.equals("xyz@example.com")) {
            person.setPasswort("xYz");
            person.setName("Zurbriggen, Yvonne & Xaver");
            person.setEmail("xyz@example.com");
            person.setBenutzername("zurbriggenyx");
            return true;
        } 
        return false;
    }
}
