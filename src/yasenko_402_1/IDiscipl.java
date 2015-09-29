/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasenko_402_1;

import java.util.List;

/**
 *
 * @author Natasha
 */
interface IDiscipl {
     boolean CreateDiscipl(Discipl message );
    Discipl ReadDiscipl(int id);
    List<Discipl> ReadDiscipl();
    List<Discipl> SearchDiscipl(Discipl message);
    boolean UpdateDiscipl(Discipl message );
    boolean DeleteDiscipl(Discipl message);
    
}
