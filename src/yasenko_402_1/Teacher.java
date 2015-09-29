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
public class Teacher {
    public int id;
    public String name;
    
    @Override
    public String toString()
    {
        return id+" " +name;
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
}