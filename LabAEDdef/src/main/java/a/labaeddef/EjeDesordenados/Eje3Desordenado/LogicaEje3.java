/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.labaeddef.EjeDesordenados.Eje3Desordenado;


import javax.swing.JOptionPane;



public class LogicaEje3 {

    // Alta de empleado
    public static int alta(String[] nombres, String[] sexos, int[] edades,
                           int n, int tam, String nuevoNombre, String nuevoSexo, int nuevaEdad) {

        if (n == -1) { // Primer registro
            n++;
            nombres[n] = nuevoNombre;
            sexos[n] = nuevoSexo;
            edades[n] = nuevaEdad;
            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
        }
        else if (n < tam - 1) { // Aún hay espacio
            int pos = buscar(nombres, nuevoNombre, n);

            if ((pos >= 0) && ((pos == 0) && (nuevoNombre.equalsIgnoreCase(nombres[0])))) {
                JOptionPane.showMessageDialog(null, "El empleado ya existe.");
                return n;
            } else {
                n++;
                pos = pos * (-1); // Posición donde debería ir

                // Desplazar a la derecha
                for (int i = n; i >= pos + 1; i--) {
                    nombres[i] = nombres[i - 1];
                    sexos[i] = sexos[i - 1];
                    edades[i] = edades[i - 1];
                }

                nombres[pos] = nuevoNombre;
                sexos[pos] = nuevoSexo;
                edades[pos] = nuevaEdad;

                JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más empleados.");
        }
        return n;
    }

    // Baja de empleado
    public static int baja(String[] nombres, String[] sexos, int[] edades,
                           int n, String nombreBorrar) {

        if (n > -1) {
            int pos = buscar(nombres, nombreBorrar, n);

            if ((pos <= 0) && (!nombreBorrar.equalsIgnoreCase(nombres[0]))) {
                JOptionPane.showMessageDialog(null, "El empleado no existe.");
                return n;
            } else {
                for (int i = pos; i < n; i++) {
                    nombres[i] = nombres[i + 1];
                    sexos[i] = sexos[i + 1];
                    edades[i] = edades[i + 1];
                }
                n--;
                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
            }
        }
        return n;
    }

    // Modificar edad de un empleado
    public static boolean modificarEdad(String[] nombres, int[] edades,
                                        int n, String nombreModificar, int nuevaEdad) {
        if (n > -1) {
            int pos = buscar(nombres, nombreModificar, n);

            if ((pos <= 0) && (!nombreModificar.equalsIgnoreCase(nombres[0]))) {
                return false; // No existe
            } else {
                edades[pos] = nuevaEdad;
                return true;
            }
        }
        return false;
    }

    // Buscar empleado (orden alfabético)
    public static int buscar(String[] nombres, String nombreB, int n) {
        int i = 0;

        while ((i <= n) && (nombres[i].compareToIgnoreCase(nombreB) < 0)) {
            i++;
        }

        if ((i > n) || (nombres[i].compareToIgnoreCase(nombreB) > 0)) {
            return -i; // No existe, devuelve la posición donde debería ir
        } else {
            return i; // Encontrado
        }
    }

    // Imprimir solo varones
}