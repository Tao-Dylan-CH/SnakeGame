package game;

import javax.swing.*;
import java.awt.*;

/**
 * @author 挚爱之夕
 * @date 2021/8/21 - 08 - 21 - 22:23
 * @Description: game
 * @Version: 1.0
 */
public class StartGame {
    //这是一个main方法，是程序的入口
    public static void main(String[] args) {
        //创建一个窗体
        JFrame jf = new JFrame();
        //给窗体设置一个标题
        jf.setTitle("贪吃蛇 大作战 by 挚爱之夕");
        //设置窗体弹出的坐标，对应窗体的宽高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height= Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((width-1018)/2,(height-845)/2,1018,845);
        //不可修改大小
        jf.setResizable(false);
        //窗口居中
//        jf.setLocationRelativeTo(null);
        //窗口关闭，程序退出
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建面板
        GamePanel gp = new GamePanel();
        //将面板放入窗体
        jf.add(gp);
        jf.setVisible(true);
    }
}
