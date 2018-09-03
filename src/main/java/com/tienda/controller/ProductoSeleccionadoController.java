/**
 * 
 */
package com.tienda.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

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
public class ProductoSeleccionadoController implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ProductoSeleccionadoController.class);
	
	private Producto productoSeleccionado;
	private BigDecimal totalPagar = new BigDecimal(0);
	
	@ManagedProperty(value = "#{productoDataManager}")
	private ProductoDataManager productoDataManager;
	
	public void abrirSeleccionarProducto(Producto producto){
		try {
			productoSeleccionado = producto;
			productoSeleccionado.setNumCantidad(1);
			RequestContext.getCurrentInstance().execute("PF('dlgSeleccionarProducto').show()");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void seleccionarProducto(){
		try {
			actualizarStock();
			productoSeleccionado.setNumTotal(productoSeleccionado.getNumValor()
					.multiply(new BigDecimal(productoSeleccionado.getNumCantidad())));
			verificarExisteProducto();
			RequestContext.getCurrentInstance().execute("PF('dlgSeleccionarProducto').hide()");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	private void verificarExisteProducto(){
		try {
			Producto pro_ = productoDataManager.getListaProductoSeleccionado().stream()
			.filter(pro -> pro.getIdProducto().equals(productoSeleccionado.getIdProducto()))
			.findFirst().orElse(null);
			if(pro_ == null){
				productoDataManager.getListaProductoSeleccionado().add(productoSeleccionado);
			}else{
				productoDataManager.getListaProductoSeleccionado().stream()
				.filter(pro -> pro.getIdProducto().equals(productoSeleccionado.getIdProducto()))
				.forEach (f -> {
					f.setNumCantidad(f.getNumCantidad()+productoSeleccionado.getNumCantidad());
					f.setNumTotal(f.getNumValor().multiply(new BigDecimal(f.getNumCantidad())));
				});
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void abrirVerProductoSeleccionado(){
		try {
			calcularTotal();
			if(totalPagar.compareTo(new BigDecimal(0)) > 0){
				RequestContext.getCurrentInstance().execute("PF('dlgProductoSeleccionado').show()");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	private void calcularTotal(){
		try {
			totalPagar = new BigDecimal(0);
			if(productoDataManager.getListaProductoSeleccionado() == null
					|| productoDataManager.getListaProductoSeleccionado().isEmpty()){
				totalPagar = new BigDecimal(0);
			}else{
				for(Producto pro : productoDataManager.getListaProductoSeleccionado()){
					totalPagar = totalPagar.add(pro.getNumTotal());
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	private void actualizarStock(){
		try {
			productoDataManager.getListaProducto().stream()
			.filter(pro -> pro.getIdProducto().equals(productoSeleccionado.getIdProducto()))
			.forEach (f -> {
				f.setNumStock(productoSeleccionado.getNumStock()-productoSeleccionado.getNumCantidad());
			});
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void cancelarCompra(){
		try {
			for(Producto pro_ : productoDataManager.getListaProductoSeleccionado()){
				productoDataManager.getListaProducto().stream()
				.filter(pro -> pro.getIdProducto().equals(pro_.getIdProducto()))
				.forEach (f -> {
					f.setNumStock(pro_.getNumStock()+pro_.getNumCantidad());
				});
			}
			productoDataManager.setListaProductoSeleccionado(new ArrayList<Producto>());
			RequestContext.getCurrentInstance().execute("PF('dlgProductoSeleccionado').hide()");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
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
	 * @return the productoSeleccionado
	 */
	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	/**
	 * @param productoSeleccionado the productoSeleccionado to set
	 */
	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	/**
	 * @return the totalPagar
	 */
	public BigDecimal getTotalPagar() {
		return totalPagar;
	}

	/**
	 * @param totalPagar the totalPagar to set
	 */
	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}

}
