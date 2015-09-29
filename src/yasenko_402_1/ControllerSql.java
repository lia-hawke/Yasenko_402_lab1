/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasenko_402_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasha
 */
public class ControllerSql implements ITeacher,IDiscipl{
    private Connection con=null;
    private Statement stmt=null;
    
    public  ControllerSql(Connection con) throws SQLException {
        this.con = con;
        this.stmt=this.con.createStatement();
    }

    public ResultSet  searchKlientSql(String query) throws SQLException{
        return stmt.executeQuery(query);
    }

    @Override
    public boolean CreateTeacher(Teacher user) {
            String query="INSERT INTO \"main\".\"Teachers\" (\"id\",\"Name\") VALUES  "
                + " (\""+ user.id+"\",\""+user.name+"\") ";

        try {
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return false;
        }
    }

    @Override
    public Teacher ReadTeacher(int id) {
                String query="SELECT * FROM \"main\".\"Teachers\" where id = "+id;
        try {
            ResultSet q =this.stmt.executeQuery(query);
            q.next();
            Teacher rez = new Teacher(q.getInt(1),q.getString(2));
            System.out.println(rez.toString());
            return (rez);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public List<Teacher> ReadTeachers() {
        String query="SELECT * FROM \"main\".\"Teachers\"";
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<Teacher> user = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                Teacher tmp =new Teacher(q.getInt(1),q.getString(2));
                user.add(tmp);
                rezString+=tmp.toString();
            }
            System.out.println(rezString);
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public boolean UpdateTeacher(Teacher user) {
                try {
            String query = "UPDATE \"main\".\"Teachers\" "
                    + "SET "
                    + "   \"id\" = \""+ user.id+"\", "
                    + "   \"Name\" = \""+user.name+"\" "
                    + "WHERE  \"id\"= "+user.id ;
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean DeleteTeacher(Teacher user) {
                String query="DELETE FROM \"main\".\"Teachers\" where id = "+user.id;
        try {
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return false;
        }
    }

    @Override
    public boolean CreateDiscipl(Discipl message) {
       String query="INSERT INTO \"main\".\"Discipl\" (\"Id\",\"Id_teacher\",\"discipl\") VALUES "
                + " ( "+message.id+" , "+message.Id_teacher+" , \""+message.discipl+"\") ";
        try {
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return false;
        }
    }

    @Override
    public Discipl ReadDiscipl(int id) {
                String query="SELECT * FROM \"main\".\"Discipl\" where Id = "+id+"";
        try {
            ResultSet q =this.stmt.executeQuery(query);
            q.next();
            Discipl rez = new Discipl(q.getInt(1),q.getInt(2),q.getString(3));
            System.out.println(rez.toString());
            return (rez);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public List<Discipl> ReadDiscipl() {
                String query="SELECT * FROM \"main\".\"Discipl\"";
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<Discipl> messages = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                Discipl tmp =new Discipl(q.getInt(1),q.getInt(2),q.getString(3));
                messages.add(tmp);
                rezString+=tmp.toString();
            }
            System.out.println(rezString);
            return messages;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public List<Discipl> SearchDiscipl(Discipl message) {
        boolean first = true;
        String query="SELECT * FROM \"main\".\"Discipl\" where ";
        if(message.id>0)
        {
            if(first)
            {
                first=false;
                query+="Id = "+message.id+" ";
            }
        }
        if(message.Id_teacher>0)
        {
            if(first)
            {
                first=false;
                query+="Id_teacher = "+message.Id_teacher+" ";
            }
            else
            {
                query+="or Id_teacher = "+message.Id_teacher+" ";
            }
            
        }
        if(message.discipl!=null||!"".equals(message.discipl))
        {
            if(first){
                first=false;
                query+="discipl = \""+message.discipl+"\" ";
            }
            else{
                query+="or discipl = \""+message.discipl+"\" ";
            }
            
        }
        if(first)
        {
           return ReadDiscipl();     
        }
        
        try {
            ResultSet q =this.stmt.executeQuery(query);
            List<Discipl> messages = new LinkedList(); 
            String rezString = new String();
            while(q.next())
            {
                Discipl tmp =new Discipl(q.getInt(1),q.getInt(2),q.getString(3));
                messages.add(tmp);
                rezString+=tmp.toString();
            }
            System.out.println(rezString);
            return messages;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public boolean UpdateDiscipl(Discipl message) {
              try {
            String query = "UPDATE \"main\".\"Discipl\" "
                    + "SET "
                    + "\"Id\" = "+message.id+","
                    + " \"Id_teacher\" = "+message.Id_teacher+", "
                    + "\"discipl\" = \""+message.discipl+"\" "
                    + "WHERE  Id = "+message.id+"";
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean DeleteDiscipl(Discipl message) {
          String query="DELETE FROM \"main\".\"Discipl\" where Id = "+message.id+"";
        try {
            return this.stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return false;
        }
    }

}
