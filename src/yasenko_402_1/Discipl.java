/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasenko_402_1;

/**
 *
 * @author Natasha
 */
public class Discipl {
    public String discipl;
    public int id, Id_teacher;
    
    @Override
    public String toString()
    {
        return id+" " +Id_teacher+" " +discipl;
    }

    public Discipl(int id, int Id_teacher, String discipl) {
        this.id = id;
        this.Id_teacher = Id_teacher;
        this.discipl = discipl;
    }
    
}