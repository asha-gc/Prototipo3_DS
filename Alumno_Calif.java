/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author asha2
 */
public class Alumno_Calif {
    private String matricula;
    private String asignatura;
    private int calificacion;

    public Alumno_Calif(String matricula, String asignatura, int calificacion) {
        this.matricula = matricula;
        this.asignatura = asignatura;
        this.calificacion = calificacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    
}
