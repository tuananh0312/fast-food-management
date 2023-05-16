/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.time.LocalDate;
import java.util.ArrayList;



public class HoaDonBUS {

    public static ArrayList<HoaDonDTO> HD;

    public HoaDonBUS() {

    }

    public void docHD() throws Exception 
    {
        HoaDonDAO hd = new HoaDonDAO();
        if (HD == null) {
            HD = new ArrayList<>();
        }
        HD = hd.docHD(); 

    }

    public void them(HoaDonDTO HDDTO) 
    {
        HoaDonDAO hd = new HoaDonDAO();
        hd.them(HDDTO);//ghi vÃ o database
        if (HD != null)
        HD.add(HDDTO);
        KhachHangBUS.TongChiTieu(HDDTO.getIDKhachHang(), HDDTO.getTongTien());
    }

    public void sua(HoaDonDTO HDDTO, int i) 
    {
        HoaDonDAO hd = new HoaDonDAO();
        hd.sua(HDDTO);
        if (HD != null)
        HD.set(i, HDDTO);
    }

    public void xoa(HoaDonDTO HDDTO, int index) 
    {
        HoaDonDAO hd = new HoaDonDAO();
        hd.xoa(HDDTO); 
        if (HD != null)
        HD.set(index, HDDTO); 
    }

    public void xoa(String ID, int index) 
    {
        HoaDonDAO data = new HoaDonDAO();
        data.xoa(ID);
        HoaDonDTO DTO=HD.get(index); 
        DTO.setTrangThai("áº¨n");
        if (HD != null)
        HD.set(index, DTO);
    }
    

    public static int timViTri( String ID) 
    {
        for (int i = 0; i < HD.size(); i++) {
            if (HD.get(i).getIDHoaDon().equals(ID)) {
                return i;
            }
        }
        return 0;
    }
    
 
    public static String getMaHoaDonCuoi()
    {
        if(HD == null)
        {
            HD = new ArrayList<>();
        }
        if(HD.size() > 0)
        {
            String ma;
         ma = HD.get(HD.size()-1).getIDHoaDon();
         return ma;
        }
         return null;
    }
    //Get lÃ m Excel PDF
    public ArrayList<HoaDonDTO> getHoaDonDTO() {
        return HD;
    }
    public HoaDonDTO getHoaDonDTO(String idhoadon) {
        for (HoaDonDTO hdDTO : HD) {
            if (hdDTO.getIDHoaDon().equals(idhoadon)) {
                return hdDTO;
            }
        }
        return null;
    }
    
    public ArrayList<HoaDonDTO> search(String type, String value, LocalDate _ngay1, LocalDate _ngay2, int _tong1, int _tong2) {
        ArrayList<HoaDonDTO> result = new ArrayList<>();
        HD.forEach((HoaDonDTO) -> {
            switch (type) {
                case "Táº¥t cáº£":
                    if (HoaDonDTO.getIDHoaDon().toLowerCase().contains(value.toLowerCase())
                            || HoaDonDTO.getIDNhanVien().toLowerCase().contains(value.toLowerCase())
                            || HoaDonDTO.getIDKhachHang().toLowerCase().contains(value.toLowerCase())
                            || HoaDonDTO.getIDKhachHang().toLowerCase().contains(value.toLowerCase())
                            || HoaDonDTO.getNgayLap().toString().toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(HoaDonDTO.getTienGiamGia()).toLowerCase().contains(value.toLowerCase())
                            || String.valueOf(HoaDonDTO.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }

                    break;

                case "MÃ£ hÃ³a Ä‘Æ¡n":
                    if (HoaDonDTO.getIDHoaDon().toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
                    break;

                case "MÃ£ nhÃ¢n viÃªn":
                    if (HoaDonDTO.getIDNhanVien().toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
                    break;

                case "MÃ£ khÃ¡ch hÃ ng":
                    if (HoaDonDTO.getIDKhachHang().toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
                    break;

                case "Ngày lập":
                    if (HoaDonDTO.getNgayLap().toString().toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
                    break;
                case "Giáº£m giÃ¡":
                    if (String.valueOf(HoaDonDTO.getTienGiamGia()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
                    break;

                case "Tá»•ng tiá»�n":
                    if (String.valueOf(HoaDonDTO.getTongTien()).toLowerCase().contains(value.toLowerCase())) {
                        result.add(HoaDonDTO);
                    }
            }
        });

        //Ngay lap, tong tien
        for (int i = result.size() - 1; i >= 0; i--) {
            HoaDonDTO hd = result.get(i);
            LocalDate ngaylap = hd.getNgayLap();
            float tongtien = (float) hd.getTongTien();

            Boolean ngayKhongThoa = (_ngay1 != null && ngaylap.isBefore(_ngay1)) || (_ngay2 != null && ngaylap.isAfter(_ngay2));
            Boolean tienKhongThoa = (_tong1 != -1 && tongtien < _tong1) || (_tong2 != -1 && tongtien > _tong2);

            if (ngayKhongThoa || tienKhongThoa) {
                result.remove(hd);
            }
        }
        
        return result;
    }
}



