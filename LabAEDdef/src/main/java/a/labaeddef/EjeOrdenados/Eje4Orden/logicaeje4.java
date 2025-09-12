/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.labaeddef.EjeOrdenados.Eje4Orden;

import javax.swing.JOptionPane;



public class logicaeje4 {
    
    
public static int alta(String[] nombre, String[] direccion, int[] edad, String[] sexo, int[] antiguedad,
                           int n, int tam,
                           String nuevoNombre, String nuevaDireccion, int nuevaEdad, String nuevoSexo, int nuevaAntiguedad) {
        if (n == -1) {
            n++;
            nombre[n] = nuevoNombre;
            direccion[n] = nuevaDireccion;
            edad[n] = nuevaEdad;
            sexo[n] = nuevoSexo;
            antiguedad[n] = nuevaAntiguedad;
        } else if (n < tam - 1) {
            int pos = buscar(nombre, nuevoNombre, n);
            if ((pos >= 0) && ((pos == 0) && (nuevoNombre.equalsIgnoreCase(nombre[0])))) {
                return n; // ya existe
            } else {
                n++;
                pos = pos * (-1);
                for (int i = n; i >= pos + 1; i--) {
                    nombre[i] = nombre[i - 1];
                    direccion[i] = direccion[i - 1];
                    edad[i] = edad[i - 1];
                    sexo[i] = sexo[i - 1];
                    antiguedad[i] = antiguedad[i - 1];
                }
                nombre[pos] = nuevoNombre;
                direccion[pos] = nuevaDireccion;
                edad[pos] = nuevaEdad;
                sexo[pos] = nuevoSexo;
                antiguedad[pos] = nuevaAntiguedad;
                
                JOptionPane.showMessageDialog(null, "Empleado agregado correctamente .");
            }
        }else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arregloo.");
        }
        return n;
    }

    public static int baja(String[] nombre, String[] direccion, int[] edad, String[] sexo, int[] antiguedad, int n,
                           String nomB) {
        if (n > -1) {
            int pos = buscar(nombre, nomB, n);
            if ((pos <= 0) && (!nomB.equalsIgnoreCase(nombre[0]))) {
                return n; // no existe
            } else {
                for (int i = pos; i < n; i++) {
                    nombre[i] = nombre[i + 1];
                    direccion[i] = direccion[i + 1];
                    edad[i] = edad[i + 1];
                    sexo[i] = sexo[i + 1];
                    antiguedad[i] = antiguedad[i + 1];
                }
                n--;
            }
        }
        return n;
    }

    public static boolean modificarAntiguedad(String[] nombre, int[] antiguedad, int n,
                                              String nomB, int nuevaAntiguedad) {
        if (n > -1) {
            int pos = buscar(nombre, nomB, n);
            if ((pos <= 0) && (!nomB.equalsIgnoreCase(nombre[0]))) {
                return false; // no existe
            } else {
                antiguedad[pos] = nuevaAntiguedad;
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

