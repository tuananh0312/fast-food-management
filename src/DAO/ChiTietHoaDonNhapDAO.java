/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietHoaDonNhapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Phat
 */
public class ChiTietHoaDonNhapDAO {
 
    ConnectDB connection = new ConnectDB();
    public ArrayList docCTHDN() throws Exception {
        ArrayList<ChiTietHoaDonNhapDTO> CTHDN = new ArrayList<>() ;
        try {
            String qry = "SELECT * FROM chitiethoadonnhap";
            ResultSet rs = connection.excuteQuery(qry);  
            while (rs.next()) {
                    ChiTietHoaDonNhapDTO  cthdn = new ChiTietHoaDonNhapDTO();
                    cthdn.setIDHoaDonNhap(rs.getString("IDHoaDonNhap"));
                    cthdn.setIDNguyenLieu(rs.getString("IDNguyenLieu"));
                    cthdn.setSoLuong(rs.getInt("SoLuong"));
                    cthdn.setGiaNhap(rs.getFloat("GiaNhap"));
                    cthdn.setThanhTien(rs.getFloat("ThanhTien"));
                    CTHDN.add(cthdn);
                }
            }
         catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu bảng chi tiết hóa đơn nhập");
        } 
        return CTHDN;   
    }
    public void them(ChiTietHoaDonNhapDTO  cthdn ) {
        try{
            String qry ="INSERT INTO chitiethoadonnhap values (";
            qry = qry + "'" + cthdn.getIDHoaDonNhap()+ "'";
            qry = qry + "," + "'" + cthdn.getIDNguyenLieu()+ "'";
            qry = qry + "," + "'" + cthdn.getSoLuong()+ "'";
            qry = qry + "," + "'" + cthdn.getGiaNhap()+ "'";
            qry = qry + "," + "'" + cthdn.getThanhTien()+ "'";
            qry = qry + ")";
            connection.getStatement();
            connection.ExecuteUpdate(qry);           
            connection.closeConnect();

       } catch (Exception ex) {
       }
    }    
    
//    public void sua(ChiTietHoaDonNhapDTO  cthdn){
//        try{
//             String qry="Update chitiethoadonnhap Set ";
//                    qry = qry + "IDHoaDonNhap=" + "'" + cthdn.getIDHoaDonNhap()+ "'";
//                    qry = qry + ",IDNguyenLieu= ' "+cthdn.getIDNguyenLieu()+"'";// sua ten giong dt
//                    qry = qry + ",SoLuong= '"+cthdn.getSoLuong()+"'";
//                    qry = qry + ",GiaNhap= '"+cthdn.getGiaNhap()+"'";
//                    qry = qry + " "+" WHERE IDHoaDonNhap=' "+cthdn.getIDHoaDonNhap()+"'";
//                    connection.getStatement();
//                    connection.ExecuteUpdate(qry);
//                    System.out.println(qry);
//                    connection.closeConnect();     
//        }catch (Exception ex){
//            
//        }
//    }
//    
//    public void xoa(String  IDHoaDonNhap){
//       IDHoaDonNhap =" ";
//        try{
//           String qry="DELETE FROM `chitiethoadonnhap` WHERE `IDHoaDonNhap` = '" + IDHoaDonNhap + "'";
//           connection.getStatement();
//           connection.ExecuteUpdate(qry);
//           System.out.println(qry);
//           connection.closeConnect();
//        }catch(Exception ex){
//            
//        }
//    }
//    
//    public void xoa(ChiTietHoaDonNhapDTO cthdn) {
//    try {
//            String qry = "Update chitiethoadonnhap Set ";
//            qry = qry + "where IDHoaDonNhap='" + cthdn.getIDHoaDonNhap()+ "'";
//            connection.getStatement();
//            connection.ExecuteUpdate(qry);
////            System.out.println(qry);
//            connection.closeConnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}






