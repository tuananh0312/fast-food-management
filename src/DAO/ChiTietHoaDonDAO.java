//main
package DAO;

import DTO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChiTietHoaDonDAO {

    ConnectDB connection = new ConnectDB();

    public ChiTietHoaDonDAO() {

    }

    public ArrayList docCTHD() throws SQLException, Exception { 
        connection = new ConnectDB();
        ArrayList<ChiTietHoaDonDTO> chitiethd = new ArrayList<>();
        try {
            String qry = "SELECT * FROM chitiethoadon";
            ResultSet result = connection.excuteQuery(qry);
            if (result != null) {
                while (result.next()) {
                    ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                    cthd.setIDHoaDon(result.getString("IDHoaDon"));
                    cthd.setIDMonAn(result.getString("IDMonAn"));
                    cthd.setSoLuong(result.getInt("SoLuong"));
                    cthd.setDonGia(result.getFloat("DonGia"));
                    cthd.setThanhTien(result.getFloat("ThanhTien"));
                    chitiethd.add(cthd);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "KhÃ´ng Ä‘á»�c Ä‘Æ°á»£c dá»¯ liá»‡u báº£ng chi tiáº¿t hoÃ¡ Ä‘Æ¡n");
        }
        return chitiethd;
    }

    public void them(ChiTietHoaDonDTO chitiethd) { //cáº§n ghi láº¡i khi qua class khÃ¡c
        try {
            String qry = "INSERT INTO chitiethoadon values (";
            qry = qry + "'" + chitiethd.getIDHoaDon()+ "'";
            qry = qry + "," + "'" + chitiethd.getIDMonAn()+ "'";
            qry = qry + "," + "'" + chitiethd.getSoLuong()+ "'";
            qry = qry + "," + "'" + chitiethd.getDonGia() + "'";
            qry = qry + "," + "'" + chitiethd.getThanhTien()+ "'";
            qry = qry + ")";
            connection.getStatement();
            connection.ExecuteUpdate(qry);
            System.out.println(qry);
            connection.closeConnect();
        } catch (Exception ex) {
        }
    }

//    public void xoa(String IDHoaDon) { //cáº§n ghi láº¡i khi qua class khÃ¡c
//        IDHoaDon = " ";
//        try {
//            String qry = "DELETE FROM chitiethoadon WHERE IDHoaDon='" + IDHoaDon + "'";
//            connection.getStatement();
//            connection.ExecuteUpdate(qry);
//            System.out.println(qry);
//            connection.closeConnect();
//        } catch (Exception ex) {
//
//        }
//    }
//
////    public void xoa(ChiTietHoaDonDTO chitiethd) {
////        try {
////            String qry = "Update chitiethoadon Set ";
////            qry = qry + "TrangThai=" + "'" + chitiethd.getTrangThai() + "'";
////            qry = qry + " " + "where IDMonAn='" + chitiethd.getIDHoaDon()+ "'";
////            connection.getStatement();
////            connection.ExecuteUpdate(qry);
//////            System.out.println(qry);
////            connection.closeConnect();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    public void sua(ChiTietHoaDonDTO chitiethd) { //cáº§n ghi láº¡i khi qua class khÃ¡c
//        try {
//            String qry = "Update chitiethoadon Set ";
//            qry = qry + "IDHoaDon=" + "'" + chitiethd.getIDHoaDon()+ "',";
//            qry = qry + ",IDMonAn=" + "'" + chitiethd.getIDMonAn()+ "'";
//            qry = qry + ",SoLuong=" + "'" + chitiethd.getSoLuong()+ "'";
//            qry = qry + ",DonGia=" + "'" + chitiethd.getDonGia() + "'";
//            qry = qry + ",ThanhTien=" + "'" + chitiethd.getThanhTien()+ "'";
//            qry = qry+" "+" WHERE IDHoaDon=' "+chitiethd.getIDHoaDon()+"'";
//            connection.getStatement();
//            connection.ExecuteUpdate(qry);
//            //System.out.println(qry);
//            connection.closeConnect();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

}




