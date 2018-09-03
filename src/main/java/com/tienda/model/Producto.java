/**
 * 
 */
package com.tienda.model;

import java.math.BigDecimal;

/**
 * @author 
 *
 */
public class Producto {

	private Integer idProducto;
	private String nomProducto;
	private String nomCodigo;
	private String txtDescripcion;
	private Integer numStock;
	private Integer numCantidad;
	private BigDecimal numValor;
	private BigDecimal numTotal;
	private BigDecimal numTotalPagar;
	
	/**
	 * @return the idProducto
	 */
	public Integer getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return the nomProducto
	 */
	public String getNomProducto() {
		return nomProducto;
	}
	/**
	 * @param nomProducto the nomProducto to set
	 */
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	/**
	 * @return the nomCodigo
	 */
	public String getNomCodigo() {
		return nomCodigo;
	}
	/**
	 * @param nomCodigo the nomCodigo to set
	 */
	public void setNomCodigo(String nomCodigo) {
		this.nomCodigo = nomCodigo;
	}
	/**
	 * @return the txtDescripcion
	 */
	public String getTxtDescripcion() {
		return txtDescripcion;
	}
	/**
	 * @param txtDescripcion the txtDescripcion to set
	 */
	public void setTxtDescripcion(String txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}
	/**
	 * @return the numStock
	 */
	public Integer getNumStock() {
		return numStock;
	}
	/**
	 * @param numStock the numStock to set
	 */
	public void setNumStock(Integer numStock) {
		this.numStock = numStock;
	}
	/**
	 * @return the numValor
	 */
	public BigDecimal getNumValor() {
		return numValor;
	}
	/**
	 * @param numValor the numValor to set
	 */
	public void setNumValor(BigDecimal numValor) {
		this.numValor = numValor;
	}
	/**
	 * @return the numCantidad
	 */
	public Integer getNumCantidad() {
		return numCantidad;
	}
	/**
	 * @param numCantidad the numCantidad to set
	 */
	public void setNumCantidad(Integer numCantidad) {
		this.numCantidad = numCantidad;
	}
	/**
	 * @return the numTotal
	 */
	public BigDecimal getNumTotal() {
		return numTotal;
	}
	/**
	 * @param numTotal the numTotal to set
	 */
	public void setNumTotal(BigDecimal numTotal) {
		this.numTotal = numTotal;
	}
	/**
	 * @return the numTotalPagar
	 */
	public BigDecimal getNumTotalPagar() {
		return numTotalPagar;
	}
	/**
	 * @param numTotalPagar the numTotalPagar to set
	 */
	public void setNumTotalPagar(BigDecimal numTotalPagar) {
		this.numTotalPagar = numTotalPagar;
	}
	
}
