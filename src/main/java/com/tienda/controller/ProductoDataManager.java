/**
 * 
 */
package com.tienda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tienda.model.Producto;

/**
 * @author 
 *
 */
@ManagedBean
@SessionScoped
public class ProductoDataManager {
	
	private List<Producto> listaProducto;
	private List<Producto> listaProductoSeleccionado;

	@PostConstruct
	public void init(){
		listaProducto = new ArrayList<Producto>();
		listaProductoSeleccionado = new ArrayList<Producto>();
	}
	
	/**
	 * @return the listaProducto
	 */
	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	/**
	 * @param listaProducto the listaProducto to set
	 */
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	/**
	 * @return the listaProductoSeleccionado
	 */
	public List<Producto> getListaProductoSeleccionado() {
		return listaProductoSeleccionado;
	}

	/**
	 * @param listaProductoSeleccionado the listaProductoSeleccionado to set
	 */
	public void setListaProductoSeleccionado(
			List<Producto> listaProductoSeleccionado) {
		this.listaProductoSeleccionado = listaProductoSeleccionado;
	}
	
}
