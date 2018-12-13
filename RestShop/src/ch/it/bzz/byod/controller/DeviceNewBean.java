/**
 * Bildungszentrum Zürichsee BZZ
 * Fachgruppe IT
 * 
 * MP-CH-133-1316-2: Webapplikationen realisieren
 * BYODManager
 */
package ch.it.bzz.byod.controller;

import javax.faces.bean.SessionScoped;
import ch.it.bzz.byod.model.Device;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


/**
 * @author Raphael Stauffacher
 * @date 2017-04-13
 * @version 2.0
 */
@SessionScoped
@ManagedBean(name = "deviceNewBean")
public class DeviceNewBean {
	
	private Device device;
	
	@ManagedProperty(value = "deviceListBean")
	private DeviceListBean deviceListBean;
	
	/**
	 * default constructor
	 */
    public DeviceNewBean() {
    	setDevice(new Device());
    }
    
    /**
     * adds a new device to the list
     */
    public void insert() {
    	getDeviceListBean().getDeviceList().add(getDevice());
    }

    /**
     * gets the device
     * @return
     * 		device to return
     */
	public Device getDevice() {
		return device;
	}

	/**
	 * sets the device
	 * @param device
	 * 			device to set
	 */
	public void setDevice(Device device) {
		this.device = device;
	}

	/**
	 * gets the deviceListBean
	 * @return
	 * 		deviceListBean to return
	 */
	public DeviceListBean getDeviceListBean() {
		return deviceListBean;
	}

	/**
	 * sets the deviceListBean
	 * @param deviceListBean
	 * 			deviceListBean to set
	 */
	public void setDeviceListBean(DeviceListBean deviceListBean) {
		this.deviceListBean = deviceListBean;
	}
}
