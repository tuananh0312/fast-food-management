/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Tool;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nguyen
 */
public class GUIFormContent extends JPanel {
    protected JPanel CongCu,TimKiem,Table;
    
    public GUIFormContent(){
        initcomponent();
    }
    public void initcomponent(){
        setLayout(new BorderLayout());
        
//        setBackground(Color.decode("#FFCDD2"));
        CongCu=CongCu();
        CongCu.setPreferredSize(new Dimension(0,70));
        add(CongCu,BorderLayout.NORTH);
        
        TimKiem=TimKiem();
        
        add(TimKiem,BorderLayout.CENTER);
        
        Table=Table();
        Table.setPreferredSize(new Dimension(0,600));
        add(Table,BorderLayout.SOUTH);
        
        setVisible(true);
        setSize(GUImenu.width_content, 770);
    }
    protected JPanel CongCu(){
        JPanel CongCu=new JPanel();
        
        JButton Them=new JButton("Thêm");
//         Them.setIcon(Tool.showIcon(30, 30,"/Images/Icon/them-30px.png"));
            Them.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/them1-30.png")));
//        Them.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/icons8_add_30px.png")));
        Them.setFont(new Font("Segoe UI", 0, 14));
        Them.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));        
        Them.setBackground(Color.decode("#90CAF9"));
       
        Them.setBounds(350, 0, 70, 40);
        Them.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                Them_click(evt);
            }
        });
        CongCu.add(Them);
        
        JButton Sua=new JButton("Sửa");
//        Sua.setIcon(Tool.showIcon(30,30,"/Images/Icon/sua-30px.png"));
            Sua.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/sua3-30.png")));
//        Sua.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/icons8_support_30px.png")));
        Sua.setFont(new Font("Segoe UI", 0, 14));
        Sua.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
        Sua.setBackground(Color.decode("#90CAF9"));
        Sua.setBounds(430, 0, 70, 30);
        Sua.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                Sua_click(evt);
            }
        });
        CongCu.add(Sua);
        
        JButton Xoa=new JButton("Xóa");
//        1Xoa.setIcon(Tool.showIcon(30, 30, "src/Images/Icon/xoa-30px_1.png"));
Xoa.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/delete1-30.png")));
//        Xoa.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/icons8_cancel_30px_1.png")));
        Xoa.setFont(new Font("Segoe UI", 0, 14));
        Xoa.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
        Xoa.setBackground(Color.decode("#90CAF9"));
        Xoa.setBounds(510, 0, 70, 30);
        Xoa.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                Xoa_click(evt);
            }
        });
        CongCu.add(Xoa);
        
        JButton NhapExcel=new JButton("Nhập Excel");
        NhapExcel.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/xls-30.png")));
        NhapExcel.setFont(new Font("Segoe UI", 0, 14));
        NhapExcel.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
        NhapExcel.setBackground(Color.decode("#90CAF9"));
        NhapExcel.setBounds(590, 0, 100, 30);
        NhapExcel.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                NhapExcel_click(evt);
            }
        });
        CongCu.add(NhapExcel);
        
        JButton XuatExcel=new JButton("Xuất Excel");
        XuatExcel.setIcon(new ImageIcon(this.getClass().getResource("/Images/Icon/xls-30.png")));
        XuatExcel.setFont(new Font("Segoe UI", 0, 14));
        XuatExcel.setBorder(BorderFactory.createLineBorder(Color.decode("#90CAF9"), 1));
        XuatExcel.setBackground(Color.decode("#90CAF9"));
        XuatExcel.setBounds(670, 0, 100, 30);
        XuatExcel.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt){
                XuatExcel_click(evt);
            }
        });
        CongCu.add(XuatExcel);
        return CongCu;
        
    }
    protected JPanel TimKiem(){
        JPanel TimKiem=new JPanel();                
        return TimKiem;
    }
    protected JPanel Table(){
        JPanel Table=new JPanel();       
        return Table;
    }
    protected void Them_click(MouseEvent evt){
        
    }
    protected void Sua_click(MouseEvent evt){
        
    }
    protected void Xoa_click(MouseEvent evt){
        
    }
    protected void NhapExcel_click(MouseEvent evt){
        
    }
    protected void XuatExcel_click(MouseEvent evt){
        
    }
    
}















