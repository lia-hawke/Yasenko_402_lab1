/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasenko_402_1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasha
 */
public class Yasenko_402_1 {
     private static ControllerSql controller=null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          myConnection con = new myConnection("org.sqlite.JDBC", "jdbc:sqlite:Lab1.sqlite");
        try {
            controller = new ControllerSql(con.getCon());
           
            Teacher userTest = new Teacher(2,"Кравец");
            ((ITeacher)controller).CreateTeacher(userTest);
            ((ITeacher)controller).ReadTeacher(userTest.id);
            userTest.name = "Кравець";
            ((ITeacher)controller).UpdateTeacher(userTest);
            ((ITeacher)controller).ReadTeachers();
            
            
            Discipl testMessage = new Discipl(2, 2, "Статистика");
            ((IDiscipl)controller).CreateDiscipl(testMessage);
            ((IDiscipl)controller).ReadDiscipl(testMessage.id);
            ((IDiscipl)controller).SearchDiscipl(new Discipl(0, 2, ""));
            testMessage.discipl="Прикладна статистика";
            ((IDiscipl)controller).UpdateDiscipl(testMessage);
            ((IDiscipl)controller).ReadDiscipl();
            
            ((ITeacher)controller).DeleteTeacher(userTest);
            ((IDiscipl)controller).DeleteDiscipl(testMessage);
        } catch (SQLException ex) {
            Logger.getLogger(Yasenko_402_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        // TODO code application logic here
    }
    
}
