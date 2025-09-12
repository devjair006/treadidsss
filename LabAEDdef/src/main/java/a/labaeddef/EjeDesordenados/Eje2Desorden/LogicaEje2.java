/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.labaeddef.EjeDesordenados.Eje2Desorden;

import javax.swing.JOptionPane;

public class LogicaEje2 {

    public static int alta(String[] nombre, int[] saldo, boolean[] moroso,
            int n, int tam,
            String nuevoNombre, int nuevoSaldo, boolean nuevoMoroso) {

        if (n == -1) {
            n++;
            nombre[n] = nuevoNombre;
            saldo[n] = nuevoSaldo;
            moroso[n] = nuevoMoroso;
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
        }
        else if (n < tam - 1) {
            int pos = buscar(nombre, nuevoNombre, n);

            if ((pos >= 0) && ((pos == 0) && (nuevoNombre.equalsIgnoreCase(nombre[0])))) {
                JOptionPane.showMessageDialog(null, "Este cliente ya esta registrado");
                return n;
            } else {
                n++;
                pos = pos * (-1); 
                for (int i = n; i >= pos + 1; i--) {
                    nombre[i] = nombre[i - 1];
                    saldo[i] = saldo[i - 1];
                    moroso[i] = moroso[i - 1];
                }

                nombre[pos] = nuevoNombre;
                saldo[pos] = nuevoSaldo;
                moroso[pos] = nuevoMoroso;

                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más clientes");
        }
        return n;
    }

    public static int baja(String[] nombre, int[] saldo, boolean[] moroso,
            int n, String nomB) {

        if (n > -1) {
            int pos = buscar(nombre, nomB, n);

            if ((pos <= 0) && (!nomB.equalsIgnoreCase(nombre[0]))) {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                return n;
            } else {
                for (int i = pos; i < n; i++) {
                    nombre[i] = nombre[i + 1];
                    saldo[i] = saldo[i + 1];
                    moroso[i] = moroso[i + 1];
                }
                n--;
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            }
        }
        return n;
    }

    public static boolean modificar(String[] nombre, boolean[] moroso,int n, String nomB, boolean nuevoMoroso) {

        if (n > -1) {
            int pos = buscar(nombre, nomB, n);

            if ((pos <= 0) && (!nomB.equalsIgnoreCase(nombre[0]))) {
                return false; 
            } else {
                // Actualizamos los datos
                moroso[pos] = nuevoMoroso;
                return true;
            }
        }
        return false;
    }

    public static int buscar(String[] nombre, String nomB, int n) {
        int i = 0;

        while ((i <= n) && (nombre[i].compareToIgnoreCase(nomB) < 0)) {
            i++;
        }

        if ((i > n) || (nombre[i].compareToIgnoreCase(nomB) > 0)) {
            return -i; 
        } else {
            return i; 
        }
    }
}