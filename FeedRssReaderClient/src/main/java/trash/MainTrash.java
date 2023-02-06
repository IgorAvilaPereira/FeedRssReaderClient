/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trash;

import persistencia.MyConnection;

/**
 *
 * @author iapereira
 */
public class MainTrash {
    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        myConnection.createFeedsTable();
    }
    
}
