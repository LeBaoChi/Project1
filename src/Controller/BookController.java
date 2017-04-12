/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BookModel;
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
public class BookController {
    private Connection conn = null;

    public List<BookModel> GetListBook(BookModel model) {
        List<BookModel> listBook = new ArrayList();
        ConnectionData data = new ConnectionData();
        try {
            conn = data.getConnect();
            CallableStatement stmt = conn.prepareCall("{ CALL sp_Book_GetAll(?,?,?,?,?,?)}");
            stmt.setString(1, model.getBookCode());
            stmt.setString(2, model.getBookName());
            stmt.setString(3, model.getAuthor());
            stmt.setString(4, model.getPublisher());
            stmt.setString(5, model.getPublishYear());
            stmt.setString(6, model.getType());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model = new BookModel(
                        rs.getString("BookCode"),
                        rs.getString("BookName"),
                        rs.getString("Author"),
                        rs.getString("Publisher"),
                        rs.getString("PublishYear"),
                        rs.getString("Type"),
                        rs.getFloat("Price"),
                        rs.getInt("Number"));
                listBook.add(model);
            }
        } catch (SQLException ex) {
            System.out.println("GetListBook-SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("GetListBook-Exception: " + ex.getMessage());
        } finally {
            data.getClose();
        }
        return listBook;
    }

    public int BookDelete(String BookCode) {
        int result = 0;
        ConnectionData data = new ConnectionData();
        try {
            conn = data.getConnect();
            CallableStatement stmt = conn.prepareCall("{ CALL sp_Book_Delete(?)}");
            stmt.setString(1, BookCode);
            result = stmt.executeUpdate();
         } catch (SQLException ex) {
            System.out.println("BookDelete-SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("BookDelete-Exception: " + ex.getMessage());
        } finally {
            data.getClose();
        }
        return result;
    }
    public int BookInsertOrUpdate(int status,BookModel model) {
        int result = 0;
        ConnectionData data = new ConnectionData();
        try {
            conn = data.getConnect();
            CallableStatement stmt = conn.prepareCall("{ CALL sp_Book_InsertOrUpdate(?,?,?,?,?,?,?,?,?)}");
            stmt.setInt(1, status);
            stmt.setString(2, model.getBookCode());
            stmt.setString(3, model.getBookName());
            stmt.setString(4, model.getAuthor());
            stmt.setString(5, model.getPublisher());
            stmt.setString(6, model.getPublishYear());
            stmt.setString(7, model.getType());
            stmt.setFloat (8, model.getPrice());
            stmt.setInt   (9, model.getNumber());
            result = stmt.executeUpdate();
         } catch (SQLException ex) {
            System.out.println("BookInsertOrUpdate-SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("BookInsertOrUpdate-Exception: " + ex.getMessage());
        } finally {
            data.getClose();
        }
        return result;
    }
}
