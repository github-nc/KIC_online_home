/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.models.Room;
import admin.models.Semester;
import admin.models.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/*Need manually add up with typing*/
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author andx
 */
public class dbController {

    private static Connection dbConn;

    public dbController(String pathToDbFile) throws ClassNotFoundException, SQLException {
        if (dbConn == null) {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig cfg = new SQLiteConfig();
            cfg.enforceForeignKeys(true);
            dbConn = DriverManager.getConnection("jdbc:sqlite:" + pathToDbFile);
        }
    }

   
    
    public void insertRoomIntoDb(Room newRoom) throws SQLException {
        dbConn.createStatement().executeUpdate("INSERT INTO room VALUES('" + newRoom.getId() + "', " + newRoom.getCapacity() + ");");
    }

    public ResultSet fetchRoomsFromDb() throws SQLException {
        return dbConn.createStatement().executeQuery("SELECT * FROM room;");
    }

    public void removeRoomFromDb(String rmID) throws SQLException {
        dbConn.createStatement().executeUpdate("DELETE FROM room WHERE rm_id='" + rmID + "'");
    }

    public void updateRoomIntoDb(Room updatedRM) throws SQLException {
        dbConn.createStatement().executeUpdate("UPDATE room SET rm_id='" + updatedRM.getId() + "', rm_capacity=" + updatedRM.getCapacity() + " WHERE rm_id ='" + updatedRM.getId() + "'");
    }

    
    
    
    
    public void insertSemesterIntoDb(Semester newSemester) throws SQLException {
        dbConn.createStatement().executeUpdate("INSERT INTO semester VALUES('" + newSemester.getId() + "',  '" + newSemester.getDateStart() + "' , '" + newSemester.getDateEnd() + "');");
    } //Date型数据须转换为Timestamp型数据后才能正确存入SQL数据库??? 否则存入SQL的时候不报错，但后续从SQL里读取DATE或DATETIME型数据时，会报出date parsing error(日期解析错误)的问题。

    public ResultSet fetchSemestersFromDb() throws SQLException {
        return dbConn.createStatement().executeQuery("SELECT * FROM semester;");
    }

    public void removeSemesterFromDb(String semsId) throws SQLException {
        dbConn.createStatement().executeUpdate("DELETE FROM semester WHERE sems_id='" + semsId + "'");
    }  //column name不适合直接从SQLiteStudio_v3.2.1数据库里拷贝，否则后续可能会爆出column name读取错误的问题。

    public void updateSemesterIntoDb(Semester updatedSems) throws SQLException {
        dbConn.createStatement().executeUpdate("UPDATE semester SET sems_id='" + updatedSems.getId() + "', sems_start='" + updatedSems.getDateStart() + "', sems_end='" + updatedSems.getDateEnd() + "' WHERE sems_id='" + updatedSems.getId() + "'");
    }

    
    
    
    
    public void insertStudentIntoDb(Student newStudent) throws SQLException {
        dbConn.createStatement().executeUpdate("INSERT INTO student VALUES(" + newStudent.getId() + ", '" + newStudent.getName() + "', '" + newStudent.getLang() + "');");
    }

    public ResultSet fetchStudentsFromDb() throws SQLException {
        return dbConn.createStatement().executeQuery("SELECT * FROM student;");
    }

    public void removeStudentFromDb(int sid) throws SQLException {
        dbConn.createStatement().executeUpdate("DELETE FROM student WHERE std_id=" + sid + "");
    }

    public void updateStudentIntoDb(Student updatedSt) throws SQLException {
        dbConn.createStatement().executeUpdate("UPDATE student SET std_id=" + updatedSt.getId() + ", std_name='" + updatedSt.getName() + "', std_lang='" + updatedSt.getLang() + "' WHERE std_id ='" + updatedSt.getId() + "'");
    }

}
