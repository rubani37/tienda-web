/**
 * 
 */
package com.tienda.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.tienda.model.Producto;

/**
 * @author 
 *
 */
@ManagedBean
@ViewScoped
public class ProductoController implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ProductoController.class);
	
	private Producto productoInsertar;
	private boolean estActualizar = false;

	@ManagedProperty(value = "#{productoDataManager}")
	private ProductoDataManager productoDataManager;
	
	public void abrirIngresarNuevoProducto(){
		try {
			estActualizar = false;
			productoInsertar= new Producto();
			RequestContext.getCurrentInstance().execute("PF('dlgIngresoProducto').show()");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void guardarProducto(){
		try {
			productoInsertar.setIdProducto(obtenerIdProducto());
			productoDataManager.getListaProducto().add(productoInsertar);
			RequestContext.getCurrentInstance().execute("PF('dlgIngresoProducto').hide()");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	private Integer obtenerIdProducto(){
		try {
			if(productoDataManager.getListaProducto() == null 
					|| productoDataManager.getListaProducto().isEmpty()){
				return 1;
			}else{
				int id = productoDataManager.getListaProducto().size();
				return id +1;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return 0;
		}
	}
	
	public void abrirActualizarProducto(Producto producto){
		try {
			estActualizar = true;
			productoInsertar = producto;
			RequestContext.getCurrentInstance().execute("PF('dlgIngresoProducto').show()");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void actualizarProducto(){
		try {
			productoDataManager.getListaProducto().stream()
	         .filter(pro -> pro.getIdProducto().equals(productoInsertar.getIdProducto()))
	         .forEach (f -> {
	              f.setNumStock(productoInsertar.getNumStock());
	            });
			RequestContext.getCurrentInstance().execute("PF('dlgIngresoProducto').hide()");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * @return the productoInsertar
	 */
	public Producto getProductoInsertar() {
		return productoInsertar;
	}

	/**
	 * @param productoInsertar the productoInsertar to set
	 */
	public void setProductoInsertar(Producto productoInsertar) {
		this.productoInsertar = productoInsertar;
	}

	/**
	 * @return the productoDataManager
	 */
	public ProductoDataManager getProductoDataManager() {
		return productoDataManager;
	}

	/**
	 * @param productoDataManager the productoDataManager to set
	 */
	public void setProductoDataManager(ProductoDataManager productoDataManager) {
		this.productoDataManager = productoDataManager;
	}

	/**
	 * @return the estActualizar
	 */
	public boolean isEstActualizar() {
		return estActualizar;
	}

	/**
	 * @param estActualizar the estActualizar to set
	 */
	public void setEstActualizar(boolean estActualizar) {
		this.estActualizar = estActualizar;
	}
	
}
