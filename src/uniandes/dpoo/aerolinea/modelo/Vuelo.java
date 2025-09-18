package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.tiquetes.*;
import uniandes.dpoo.aerolinea.modelo.cliente.*;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Vuelo {
	
    private Ruta ruta;
    private String fecha;
    private Avion avion;
    private List<Tiquete> tiquetes;
    
    public Vuelo( Ruta ruta, String fecha, Avion avion )
    {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new ArrayList<>( );
    }
    
    public Ruta getRuta( )
    {
        return ruta;
    }

    public String getFecha( )
    {
        return fecha;
    }

    public Avion getAvion( )
    {
        return avion;
    }

    public Collection<Tiquete> getTiquetes( )
    {
        return tiquetes;
    }


    public int venderTiquetes( Cliente cliente, CalculadoraTarifas calculadora, int cantidad ) throws Exception
    {
        int capacidadDisponible = avion.getCapacidad( ) - tiquetes.size( );
        if( cantidad > capacidadDisponible )
            throw new Exception( "No hay cupos suficientes en el vuelo." );

        int total = 0;
        for( int i = 0; i < cantidad; i++ )
        {
            int tarifa = calculadora.calcularTarifa( this, cliente );
            Tiquete t = new Tiquete( this, cliente, tarifa );
            tiquetes.add( t );
            cliente.agregarTiquete( t );
            total += tarifa;
        }
        return total;
    }

   
    public int getCuposDisponibles( )
    {
        return avion.getCapacidad( ) - tiquetes.size( );
    }

    @Override
    public boolean equals( Object obj )
    {
        if( this == obj ) return true;
        if( obj == null || getClass( ) != obj.getClass( ) ) return false;

        Vuelo other = (Vuelo) obj;
        return fecha.equals( other.fecha ) && ruta.equals( other.ruta ) && avion.equals( other.avion );
    }

    @Override
    public int hashCode( )
    {
        return (ruta.getCodigoRuta( ) + fecha + avion.getNombre( )).hashCode( );
    }

}
