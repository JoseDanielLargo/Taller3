package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
	private String origen;
    private String destino;
    private String horaSalida;
    private String horaLlegada;
    private double precioBase;

    public Ruta(String origen, String destino, String horaSalida, String horaLlegada, double precioBase)
    {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.precioBase = precioBase;
    }

    public String getOrigen() { return origen; }

    public String getDestino() { return destino; }

    public String getHoraSalida() { return horaSalida; }

    public String getHoraLlegada() { return horaLlegada; }

    public double getPrecioBase() { return precioBase; }

    
    public static int getMinutos(String horaCompleta) {
        return Integer.parseInt(horaCompleta) % 100;
    }

    public static int getHoras(String horaCompleta) {
        return Integer.parseInt(horaCompleta) / 100;
    }

    
    public int getDuracionEnMinutos() {
        int salidaMin = getHoras(horaSalida) * 60 + getMinutos(horaSalida);
        int llegadaMin = getHoras(horaLlegada) * 60 + getMinutos(horaLlegada);
        int duracion = llegadaMin - salidaMin;
        if (duracion < 0) duracion += 24 * 60; 
        return duracion;
    }
    
    

    
}
