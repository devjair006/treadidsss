/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.labaeddef.EjeOrdenados.Eje5Orden;

/**
 *
 * @author Francisco Ruiz
 */
import javax.swing.*;
public class LogicaInmoviliaria {
    
   
    
    public static int InsertaO(float superficieDep[], float precio[], String ubicacion[], float txtSuperficie, float txtPrecio, String txtDir, int n, int tam) {
        if (n == -1) {
            n++;
           
            superficieDep[n] = txtSuperficie;
            ubicacion[n] = txtDir;
            precio[n] = txtPrecio;
            JOptionPane.showMessageDialog(null, "Insercion realizada");
        } else if (n < (tam - 1)) {

            float superficieDep2 = txtSuperficie;

            int pos = Busca(superficieDep, superficieDep2, n);

            
            if ((pos >= 0) && ((pos == 0) && (superficieDep2 == superficieDep[0]))) {
                JOptionPane.showMessageDialog(null, "La superficie ya esta registrada");
            } else {
                n = n + 1;
                pos = pos * (-1);
                for (int i = n; i >= (pos + 1); i--) {
                    superficieDep[i] = superficieDep[i - 1];
                    ubicacion[i] = ubicacion[i - 1];
                    precio[i]= precio[i-1];
                } // fin for

                superficieDep[pos] = superficieDep2;
                ubicacion[pos] = txtDir;
                precio[pos] = txtPrecio;
                
                JOptionPane.showMessageDialog(null, "Insercion realizada");
            } // fin if-else (existencia)
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo");
        } // fin if-else-if (estado del arreglo)

        return n;
    } // fin InsertaO

    public static int EliminaO(float superficieDep[], float precio[], String ubicacion[], float txtSuperficie, int n) {
        if (n > -1) {
            float superficieDep2 = txtSuperficie;

            int pos = Busca(superficieDep, superficieDep2, n);

            if ((pos <= 0) && (superficieDep2 != superficieDep[0])) {
                JOptionPane.showMessageDialog(null,"La superficie no existe");
            } else {
                n = n - 1;
                for (int i = pos; i <= n; i++) {
                    superficieDep[i] = superficieDep[i + 1];
                    ubicacion[i] = ubicacion[i + 1];
                    precio[i]= precio[i+1];
                } // fin for
                JOptionPane.showMessageDialog(null, "Eliminacion realizada");
            } // fin if-else (existencia)
        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        } // fin if-else (array vacío)

        return n;
    } // fin EliminaO

    public static void ModificaO(float superficieDep[], float precio[], float txtSuperficie, float txtPrecio,  int n) {
        if (n > -1) {
            float superficieDep2 = txtSuperficie;

            int pos = Busca(superficieDep, superficieDep2, n);
            
            if ((pos <= 0) && (superficieDep2 != superficieDep[0])) {
                JOptionPane.showMessageDialog(null,"La superficie no existe");
            } else {
                precio[pos] = txtPrecio;
                JOptionPane.showMessageDialog(null, "Modificacion realizada");
            } // fin if-else (existencia)
        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        } // fin if-else (array vacío)
    } // fin ModificaO

    public static int ImprimirUno(float superficieDep[], float precio[], String ubicacion[], int n, float superficieM) {
        if (n > -1) {
            float superficieDep2 = superficieM;
            int pos = Busca(superficieDep, superficieDep2, n);

            if ((pos <= 0) && (superficieDep2 != superficieDep[0])) {
                JOptionPane.showMessageDialog(null,"La superficie no existe");
                return -1 ;
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Direccion del departamento:  " + ubicacion[pos] + "\n superficie:  " + superficieDep[pos] + "\n precio del departamento: "+precio[pos]+"\n");
            } // fin if-else (existencia)
        } else {
            JOptionPane.showMessageDialog(null, "Array vacio");
        }
        return 0;
        // fin if-else (array vacío)
    } // fin ImprimirUno

    /*public static void Imprimirtodo(float[] superficie, float[] precio, String[] ubicacion, int n) {
        if (n < 0) {
            JOptionPane.showMessageDialog(null, "Arreglo vacío");
            return;
        }

        String sal = "Dirección\t\tSuperficie\t\tPrecio\n";
        for (int i = 0; i <= n; i++) {
            sal += ubicacion[i] + "\t\t" + superficie[i] + "\t\t" + precio[i] + "\n";
        }

        JTextArea imp = new JTextArea();
        imp.setText(sal);
        imp.setEditable(false);
        JOptionPane.showMessageDialog(null, imp);
    }*/
    
    
   


    public static int Busca(float[] superficie, float objetivo, int n) {
        int i = 0;

        // Avanza mientras el valor actual sea estrictamente menor al objetivo
        while (i <= n && superficie[i] < objetivo) {
            i++;
        }

        // Si nos pasamos del último índice válido, va al final
        if (i > n) {
            return -i; // no existe; insertar en i (al final)
             
        }

        // Si el valor en i es igual, lo encontramos
        if (superficie[i] == objetivo) {
            return i; // existe en i
            
        }

        // Si llegamos aquí, superficie[i] > objetivo → insertar antes de i
        return -1; // no existe; insertar en i
    }
}
