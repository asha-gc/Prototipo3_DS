/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asha2
 */
public class MisAlumnos {
    private static List<Alumno> alumnoslista = new ArrayList<Alumno>();
    private static List<Alumno_Calif> calif_finales = new ArrayList<Alumno_Calif>();
    
    public static void GuardarAlumno(Alumno alumno){
        alumnoslista.add(alumno);
        //System.out.println(contacto);
    }
    /*public boolean CompararMatricula(String matricula){
        for (int i=0;i<alumnoslista.size();i++) {
            if(alumnoslista.get(i).getMatricula()==)
        }
    }*/
    public static void GuardarCalifs(){
        String matric1;
        List lista = LeerArrayList();
        for(int j=0;j<lista.size();j++){
            matric1=lista.get(j).toString();
            Alumno_Calif alum=new Alumno_Calif(matric1,"Diseño de Software",0);
            calif_finales.add(alum);
        }
    }
    
    public static void CalificacionesFinales(){
        String archCSV = "calificaciones.csv";
        try{
                List califs = new ArrayList();
                for(int k=0;k<MisAlumnos.calif_finales.size();k++){
                    int califfinal= MisAlumnos.calif_finales.get(k).getCalificacion();
                    String calif_final=Integer.toString(califfinal);
                    String datos[]={MisAlumnos.calif_finales.get(k).getMatricula(),MisAlumnos.calif_finales.get(k).getAsignatura(),calif_final};
                    califs.add(datos);
                }
                CSVWriter writer = new CSVWriter(new FileWriter(archCSV));
                writer.writeAll(califs);
                writer.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        
    }
    
    public static List LeerArrayList(){
       List lista = new ArrayList();
       for (int i=0;i<alumnoslista.size();i++) {
            lista.add(alumnoslista.get(i).getMatricula());
        }
       return lista;
    }
    public static boolean ComprobarArray(String matric,int calificacion){
        boolean matriculaencon=false;
        for(int i=0;i<calif_finales.size();i++){
            if(matric.equals(calif_finales.get(i).getMatricula())){
                matriculaencon=true;
                calif_finales.get(i).setCalificacion(calificacion);     
            }
        }
        return matriculaencon;
    }
    
    public void inicializaTabla(JTable tabla){
        Vector<String> titulos=new Vector<String>();
        Vector<Vector <Object>>data= new Vector<Vector <Object>>();
        titulos.add("Apellido Paterno");
        titulos.add("Apellido Materno");
        titulos.add("Nombre");
        titulos.add("Apellido");
        
        for(int i=0;i<alumnoslista.size();i++){
            Vector<Object> row=new Vector<Object>();
            row.add(alumnoslista.get(i).getPrimerApellido());
            row.add(alumnoslista.get(i).getSegundoApellido());
            row.add(alumnoslista.get(i).getNombre());
            row.add(alumnoslista.get(i).getMatricula());
            data.add(row);
        }
        
        DefaultTableModel modelo=new DefaultTableModel(data,titulos);
        tabla.setModel(modelo);
    }
   
}
