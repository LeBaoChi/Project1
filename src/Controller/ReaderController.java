/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ReaderModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PhuDX
 */
public class ReaderController {
    private Connection conn = null;

    public List<ReaderModel> GetListReader(ReaderModel model) {
        List<ReaderModel> listReader = new ArrayList();
        ConnectionData data = new ConnectionData();
        try {
            conn = data.getConnect();
            CallableStatement stmt = conn.prepareCall("{ CALL sp_Reader_GetAll(?,?,?,?,?,?,?,?,?)}");
            stmt.setString(1, model.getReaderCoode());
            stmt.setString(2, model.getFullName());
            stmt.setString(3, model.getAddress());
            stmt.setString(4, model.getPhone());
            stmt.setString(5, model.getEmail());
            stmt.setString(6, model.getAllowDateFrom());
            stmt.setString(7, model.getAllowDateTo());
            stmt.setString(8, model.getDeadLineFrom());
            stmt.setString(9, model.getDeadLineTo());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model = new ReaderModel(
                        rs.getString("ReaderCode"),
                        rs.getString("FullName"),
                        rs.getString("Address"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        rs.getString("AllowDate"),
                        rs.getString("DeadLine"));
                listReader.add(model);
            }
        } catch (SQLException ex) {
            System.out.println("GetListReader-SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("GetListReader-Exception: " + ex.getMessage());
        } finally {
            data.getClose();
        }
        return listReader;
    }

    public int ReaderDelete(String ReaderCode) {
        int result = 0;
        ConnectionData data = new ConnectionData();
        try {
            conn = data.getConnect();
            CallableStatement stmt = conn.prepareCall("{ CALL sp_Reader_Delete(?)}");
            stmt.setString(1, ReaderCode);
            result = stmt.executeUpdate();
         } catch (SQLException ex) {
            System.out.println("ReaderDelete-SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ReaderDelete-Exception: " + ex.getMessage());
        } finally {
            data.getClose();
        }
        return result;
    }
    
    public int ReaderInsertOrUpdate(int status,ReaderModel model) {
        int result = 0;
        ConnectionData data = new ConnectionData();
        try {
            conn = data.getConnect();
            CallableStatement stmt = conn.prepareCall("{ CALL sp_Reader_InsertOrUpdate(?,?,?,?,?,?,?,?)}");
            stmt.setInt(1, status);
            stmt.setString(2, model.getReaderCoode());
            stmt.setString(3, model.getFullName());
            stmt.setString(4, model.getAddress());
            stmt.setString(5, model.getPhone());
            stmt.setString(6, model.getEmail());
            stmt.setString(7, model.getAllowDate());
            stmt.setString(8, model.getDeadLine());
            result = stmt.executeUpdate();
         } catch (SQLException ex) {
            System.out.println("ReaderInsertOrUpdate-SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ReaderInsertOrUpdate-Exception: " + ex.getMessage());
        } finally {
            data.getClose();
        }
        return result;
    }
}
