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
interface ITeacher {
    boolean CreateTeacher(Teacher user);
    Teacher ReadTeacher(int id);
    List<Teacher> ReadTeachers();
    boolean UpdateTeacher(Teacher user);
    boolean DeleteTeacher(Teacher user);
}
