package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.*;
import uniandes.dpoo.aerolinea.modelo.cliente.*;

public abstract class CalculadoraTarifas {
	
	public static final double IMPUESTO = 0.28;
	
    public int calcularTarifa(Vuelo vuelo, Cliente cliente)
    {
        
        int costoBase = calcularCostoBase(vuelo, cliente);
        
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        int costoConDescuento = (int)Math.round(costoBase * (1 - porcentajeDescuento));
        
        int impuestos = calcularValorImpuestos(costoConDescuento);
        
        return costoConDescuento + impuestos;
    }

    
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    
    protected int calcularDistanciaVuelo(Ruta ruta)
    {
        return ruta.getDistancia(); 
    }

    protected int calcularValorImpuestos(int costoBase)
    {
        return (int)Math.round(costoBase * IMPUESTO);
    }

}
