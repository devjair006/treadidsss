/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package a.labaeddef.EjeDesordenados.Eje1Desorden;

import javax.swing.JOptionPane;

public class logicE1 {

    // Método para dar de alta un alumno
    public static int alta(String[] nombre, int[] semestres, float[] promedio,
            int n, int tam,
            String nuevoNombre, int nuevoSemestre, float nuevoPromedio) {

        // Si el arreglo está vacío, se agrega directamente
        if (n == -1) {
            n++;
            nombre[n] = nuevoNombre;
            semestres[n] = nuevoSemestre;
            promedio[n] = nuevoPromedio;
            JOptionPane.showMessageDialog(null, "Alumno agregado correctamente.");
        }
        // Si aún hay espacio para más alumnos
        else if (n < tam - 1) {
            // Verificamos si el alumno ya existe
            int pos = buscar(nombre, nuevoNombre, n);

            if ((pos >= 0) && ((pos == 0) && (nuevoNombre.equalsIgnoreCase(nombre[0])))) {
                // Si ya existe, no se agrega
                JOptionPane.showMessageDialog(null, "El alumno ya existe.");
                return n;
            } else {
                n++;
                pos = pos * (-1); // Obtenemos la posición donde insertar

                // Recorremos hacia la derecha para insertar el nuevo alumno en orden alfabético
                for (int i = n; i >= pos + 1; i--) {
                    nombre[i] = nombre[i - 1];
                    semestres[i] = semestres[i - 1];
                    promedio[i] = promedio[i - 1];
                }

                // Insertamos el nuevo alumno en su posición ordenada
                nombre[pos] = nuevoNombre;
                semestres[pos] = nuevoSemestre;
                promedio[pos] = nuevoPromedio;

                JOptionPane.showMessageDialog(null, "Alumno agregado correctamente.");
            }
        }
        // Si el arreglo está lleno
        else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más alumnos.");
        }
        return n;
    }

    // Método para dar de baja un alumno
    public static int baja(String[] nombre, int[] semestres, float[] promedio,
            int n, String nomB) {

        if (n > -1) {
            int pos = buscar(nombre, nomB, n);

            // Si no se encontró el alumno
            if ((pos <= 0) && (!nomB.equalsIgnoreCase(nombre[0]))) {
                JOptionPane.showMessageDialog(null, "El alumno no existe.");
                return n;
            } else {
                // Recorremos el arreglo para eliminar al alumno
                for (int i = pos; i < n; i++) {
                    nombre[i] = nombre[i + 1];
                    semestres[i] = semestres[i + 1];
                    promedio[i] = promedio[i + 1];
                }
                n--;
                JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente.");
            }
        }
        return n;
    }

    // Método para modificar datos de un alumno
    public static boolean modificar(String[] nombre, int[] semestres, float[] promedio,
            int n, String nomB, int nuevoSemestre, float nuevoPromedio) {

        if (n > -1) {
            int pos = buscar(nombre, nomB, n);

            if ((pos <= 0) && (!nomB.equalsIgnoreCase(nombre[0]))) {
                return false; // No existe el alumno
            } else {
                // Actualizamos los datos
                semestres[pos] = nuevoSemestre;
                promedio[pos] = nuevoPromedio;
                return true;
            }
        }
        return false;
    }

    // Método para buscar un alumno en orden alfabético
    public static int buscar(String[] nombre, String nomB, int n) {
        int i = 0;

        // Búsqueda binaria en orden alfabético
        while ((i <= n) && (nombre[i].compareToIgnoreCase(nomB) < 0)) {
            i++;
        }

        // Si el nombre no existe
        if ((i > n) || (nombre[i].compareToIgnoreCase(nomB) > 0)) {
            return -i; // Retorna la posición negativa donde debería estar
        } else {
            return i; // Retorna la posición donde se encontró
        }
    }
}
