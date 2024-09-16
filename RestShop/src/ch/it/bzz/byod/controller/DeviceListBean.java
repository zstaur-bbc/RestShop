/**
 * Bildungszentrum Zürichsee BZZ
 * Fachgruppe IT
 * 
 * MP-CH-133-1316-2: Webapplikationen realisieren
 * BYODManager
 */
package ch.it.bzz.byod.controller;

import javax.faces.bean.ViewScoped;
import ch.it.bzz.byod.model.Device;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 * @author Raphael Stauffacher
 * @date 2017-04-013
 * @version 1.0
 */
@ViewScoped
@ManagedBean(name = "deviceListBean")
public class DeviceListBean {
	
	private List<Device> deviceList;
	
	/**
     * default constructor
     */
	public DeviceListBean() {
		setDeviceList(new ArrayList<Device>());
		
		getDeviceList().add(new Device("Apple MacBookPro", "tonibook", "01:23:45:67:89:01"));
		getDeviceList().add(new Device("Apple iPhone 5s", "toniphone", "01:23:45:67:89:02"));
		getDeviceList().add(new Device("Apple iPad Air", "tonipad", "01:23:45:67:89:03"));
	}

	/**
	 * delete a device out of the deviceList
	 * @param device
	 * 			the device to delete
	 */
	public void delete(Device device) {
		getDeviceList().remove(device);
	}
	
	 /**
     * @return the deviceList
     */
	public List<Device> getDeviceList() {
		return this.deviceList;
	}
	
	 /**
     * @param deviceList
     *            the deviceList to set
     */
	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}
}
