/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.labaeddef.EjeOrdenados.Ejercicio6Orden;

import javax.swing.JOptionPane;

/**
 *
 * @author Francisco Ruiz
 */
public class LogicaVendedores {

    public static int InsertaO(String nombre[], float totalVentas[], int n, int tam, String txtNombre, float txtTotalVentas) {
        if (n == -1) {
            n++;
            nombre[n] = txtNombre;
            totalVentas[n] = txtTotalVentas;
            // Inserción realizada
            JOptionPane.showMessageDialog(null, "Insercion Realizada con exito");
        } else if (n < (tam - 1)) {
            String nomB = txtNombre;
            int pos = Busca(nombre, nomB, n);
            if ((pos >= 0) && ((pos == 0) && (nomB.equalsIgnoreCase(nombre[0])))) {
                // El vendedor ya existe
                JOptionPane.showMessageDialog(null,"El vendedor ya existe");
            } else {
                n = n + 1;
                pos = pos * (-1);
                for (int i = n; i >= (pos + 1); i--) {
                    nombre[i] = nombre[i - 1];
                    totalVentas[i] = totalVentas[i - 1];
                }
                nombre[pos] = nomB;
                totalVentas[pos] = txtTotalVentas;
                // Inserción realizada
                JOptionPane.showMessageDialog(null, "Insercion Realizada con exito");
            }
        } else {
            JOptionPane.showMessageDialog(null,"No hay espacio en el arreglo");
        }
        return n;
    }

   public static boolean ModificaO(String nombre[], float totalVentas[], int n, String txtNombre, float txtTotalVentas) {
    if (n > -1) {
        String nomB = txtNombre;
        int pos = Busca(nombre, nomB, n);
        if ((pos <= 0) && (!(nomB.equalsIgnoreCase(nombre[0])))) {
            
            return false;
        } else {
            totalVentas[pos] = txtTotalVentas;
            JOptionPane.showMessageDialog(null, "Modificacion realizada");
            return true;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Array vacio");
        return false;
    }
}


    public static int Busca(String nombre[], String nomB, int n) {
        int i = 0;
        
        while ((i <= n) && (nombre[i].compareTo(nomB) < 0)) 
            i++;
        // i>n es decir ya recorrio el arreglo
        if ((i > n) || (nombre[i].compareTo(nomB) > 0)) // es decir va despues alfabeticamente
            return (-i); 
        else
            return (i); // son iguales
    }
}
