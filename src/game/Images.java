package game;

/**
 * @author 挚爱之夕
 * @date 2021/8/21 - 08 - 21 - 22:06
 * @Description: game
 * @Version: 1.0
 */

import javax.swing.*;
import java.net.URL;

/**
 * Images类用于获取游戏中设计的图片
 */
public class Images {
    /*
    将图片进行封装，封装为一个对象，
    这样在程序才可以通过操纵这个对象来获取图片
     */
    //将图片的路径封装为一个对象
    public static URL bodyURL = Images.class.getResource("/images/body.png");
    //将图片封装为程序中一个对象
    public static ImageIcon bodyImage = new ImageIcon(bodyURL);
    //将图片的路径封装为一个对象
    public static URL upURL = Images.class.getResource("/images/up.png");
    //将图片封装为程序中一个对象
    public static ImageIcon upImage = new ImageIcon(upURL);
    //将图片的路径封装为一个对象
    public static URL downURL = Images.class.getResource("/images/down.png");
    //将图片封装为程序中一个对象
    public static ImageIcon downImage = new ImageIcon(downURL);
    //将图片的路径封装为一个对象
    public static URL leftURL = Images.class.getResource("/images/left.png");
    //将图片封装为程序中一个对象
    public static ImageIcon leftImage = new ImageIcon(leftURL);
    //将图片的路径封装为一个对象
    public static URL rightURL = Images.class.getResource("/images/right.png");
    //将图片封装为程序中一个对象
    public static ImageIcon rightImage = new ImageIcon(rightURL);
    //将图片的路径封装为一个对象
    public static URL foodURL = Images.class.getResource("/images/food.png");
    //将图片封装为程序中一个对象
    public static ImageIcon foodImage = new ImageIcon(foodURL);
    //将图片的路径封装为一个对象
    public static URL headerURL = Images.class.getResource("/images/header.png");
    //将图片封装为程序中一个对象
    public static ImageIcon headerImage = new ImageIcon(headerURL);


}
