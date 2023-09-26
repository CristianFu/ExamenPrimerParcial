package Examen;

import java.util.InputMismatchException; 


abstract class Empleado {
    private String RFC;
    private String Apellidos;
    private String Nombres;

    public Empleado(String RFC, String Apellidos, String Nombres) {
        this.RFC = RFC;
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
    }

    public abstract double calcularIngresos();

    public abstract double calcularBonificacion();

    public abstract double calcularDescuento();

    public double calcularSueldoNeto() {
        return calcularIngresos() + calcularBonificacion() - calcularDescuento();
    }

    public String getRFC() {
        return RFC;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }
}
 class EmpleadoVendedor extends Empleado {
    private double MontoVendido;
    private double TasaDeComision;

    public EmpleadoVendedor(String RFC, String Apellidos, String Nombres, double MontoVendido, double TasaDeComision) {
        super(RFC, Apellidos, Nombres);
        this.MontoVendido = MontoVendido;
        this.TasaDeComision = TasaDeComision;
    }

    @Override
    public double calcularIngresos() {
        return MontoVendido * TasaDeComision;
    }

    @Override
    public double calcularBonificacion() {
        if (MontoVendido < 1000) {
            return 0;
        } else if (MontoVendido >= 1000 && MontoVendido <= 5000) {
            return 0.05 * calcularIngresos();
        } else {
            return 0.10 * calcularIngresos();
        }
    }

    @Override
    public double calcularDescuento() {
        if (calcularIngresos() < 1000) {
            return 0.11 * calcularIngresos();
        } else {
            return 0.15 * calcularIngresos();
        }
    }
}
class EmpleadoPermanente extends Empleado {
    private double SueldoBase;
    private String NumeroSeguroSocial;

    public EmpleadoPermanente (String RFC, String Apellidos, String Nombres, double SueldoBase, String NumeroSeguroSocial) {
        super(RFC, Apellidos, Nombres);
        this.SueldoBase= SueldoBase;
        this.NumeroSeguroSocial= NumeroSeguroSocial;
    }
    @Override
    public double calcularIngresos() {
        return SueldoBase;
    }

    @Override
    public double calcularBonificacion() {
        return 0;
}
    @Override
    public double calcularDescuento() {
        return 0.11 * SueldoBase;
    }

    public double getSueldoBase() {
        return SueldoBase;
    }

    public String getNumeroSeguroSocial() {
        return NumeroSeguroSocial;
    }
}
public class Main {
    public static void main (String [] args) {
        try {
            Empleado empleadoV = new EmpleadoVendedor("MOSVA021545NDBKJD0", "Moreno", "Valentino", 2000, 0.08);
            Empleado empleadoP = new EmpleadoPermanente("GAJOB165105IDBUD0", "Garcia", "Jorge", 3000, "024578940584");
            System.out.println("Información del empleado 1:");
            System.out.println("----------------------------------------------------");
            System.out.println("RFC: " + empleadoV.getRFC());
            System.out.println("Apellidos: " + empleadoV.getApellidos());
            System.out.println("Nombres: " + empleadoV.getNombres());
            System.out.println("Ingresos: " + empleadoV.calcularIngresos());
            System.out.println("Bonificación: " + empleadoV.calcularBonificacion());
            System.out.println("Descuento: " + empleadoV.calcularDescuento());
            System.out.println("Sueldo Neto: " + empleadoV.calcularSueldoNeto());
   
            System.out.println("----------------------------------------------------");
            System.out.println("                                   ");
            System.out.println("Información del empleado 2:");
            System.out.println("----------------------------------------------------");
            System.out.println("RFC: " + empleadoP.getRFC());
            System.out.println("Apellidos: " + empleadoP.getApellidos());
            System.out.println("Nombres: " + empleadoP.getNombres());
            System.out.println("Ingresos: " + empleadoP.calcularIngresos());
            System.out.println("Bonificación: " + empleadoP.calcularBonificacion());
            System.out.println("Descuento: " + empleadoP.calcularDescuento());
            System.out.println("Sueldo Neto: " + empleadoP.calcularSueldoNeto());

        } catch (InputMismatchException e) {
            System.out.println("Error: Se ha ingresado un valor no válido.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    
    }
}