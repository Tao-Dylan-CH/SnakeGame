package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * @author 挚爱之夕
 * @date 2021/8/21 - 08 - 21 - 22:41
 * @Description: game
 * @Version: 1.0
 */

/**
 * GamePanel 继承 JPanel 是一个面板
 */
public class GamePanel extends JPanel {

     //定义两个数组
    //蛇的长度
    int length;
     //一个数组，专门存储蛇的x轴坐标
    int[] snakeX = new int[200];
    //一个数组，专门存储蛇的y轴坐标
    int[] snakeY = new int[200];
    //游戏只有两个状态，开始、暂停
    boolean isStart = false;
    //加入定时器
    Timer timer;
    //定义蛇的行走方向
    String direction ;
    //定义食物的x,y坐标
    int foodX;
    int foodY;
    //定义一个记分
    int score;
    //死亡状态
    boolean isDie = false; //默认小蛇没有死亡
    public void init(){
        //初始化蛇长
        length = 3;
        //初始化蛇头坐标
        snakeX[0] = 484;
        snakeY[0] = 409;
        //初始化第一节身体坐标
        snakeX[1] = 452;
        snakeY[1] = 409;
        //初始化第二节身子坐标
        snakeX[2] = 420;
        snakeY[2] = 409;
        direction = "R"; //U D L R
        //初始化实物的坐标
        foodX = 612;
        foodY = 249;
//        foodX = 4;
//        foodY = 761;
        score=0;
    }
    public GamePanel(){
        init();
        //将焦点定位在当前操作的面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {//监听键盘按键的按下操作
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
//                System.out.println(keyCode);
                if(keyCode==KeyEvent.VK_SPACE){//监听空格
                    if(isDie){
                        //全部恢复到初始状态
                        init();
                        isDie = false;
                    }else{//小蛇没有死亡
                        isStart = !isStart;
                        repaint();//重绘动作
                    }

                }
                //监听向上
                if(keyCode==KeyEvent.VK_UP){
                    direction = "U";
                }
                //监听向下
                if(keyCode==KeyEvent.VK_DOWN){
                    direction = "D";
                }
                //监听向左
                if(keyCode==KeyEvent.VK_LEFT){
                    direction = "L";
                }
                //监听向右
                if(keyCode==KeyEvent.VK_RIGHT){
                    direction = "R";
                }
            }
        });
        //对定时器初始化
        timer = new Timer(100, new ActionListener() {
            /*
            ActionListener 是 事件监听
            相当于每100ms监听一下是否有新动作
            具体动作放入actionPerFormed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isStart&&!isDie){//游戏是开始状态，蛇存活，蛇才动
                    //后一节身子走到前一节身子的位置上
                    for(int i = length - 1;i>0;i--){
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }
                    //动头
                    if(direction.equals("R")){
                        snakeX[0]+=32;
                    }
                    if(direction.equals("L")){
                        snakeX[0]-=32;
                    }
                    if(direction.equals("U")){
                        snakeY[0]-=32;
                    }
                    if(direction.equals("D")){
                        snakeY[0]+=32;
                    }
                    //防止蛇超出边界
                    if(snakeX[0]>996){
                        snakeX[0]=4;
                    }
                    if(snakeX[0]<4){
                        snakeX[0]=996;
                    }
                    if(snakeY[0]<-32){
                        snakeY[0] = 793;
                    }
                    if(snakeY[0]>793){
                        snakeY[0] = -32;
                    }
                    //检测吃食物动作
                    if(snakeX[0]==foodX&&snakeY[0]==foodY){
                        //蛇的长度加1
                        length++;
//                        System.out.println(length);
                        //实物坐标改变，随机生成,必须是32的倍数
//                        foodX = ; //[0,30]*32+4
//                        foodY = ; //[0,23]*32+25
                        foodX = new Random().nextInt(31)*32+4;
                        foodY = new Random().nextInt(24)*32+25;
                        //吃到实物，积分加10
                        score+=10;

                    }
                    //死亡判定
                    for (int i = 1; i < length; i++) {
                        if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
                            isDie = true;
                            break;
                        }
                    }
                    repaint();//重绘
                }
            }
        });
        //启动定时器
        timer.start();
    }

    /*
    paintComponent方法比较特殊,这个方法属于图形版的main方法
    自动调用
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //填充背景颜色
        this.setBackground(new Color(50, 116, 114, 107));
        /**
         * 画头部图片
         * paintIcon四个参数：this：当前面板
         * g：当前使用的画笔 x,y：对应坐标
         */
        Images.headerImage.paintIcon(this,g,4,7);
        g.setColor(new Color(255, 255,255 ));
        g.fillRect(4,57,992,736);
        //画小蛇
        //画蛇头
        if(direction.equals("R")){
            Images.rightImage.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if(direction.equals("L")){
            Images.leftImage.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if(direction.equals("U")){
            Images.upImage.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if(direction.equals("D")){
            Images.downImage.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
//        //画第一节身子
//        Images.bodyImage.paintIcon(this,g,snakeX[1],snakeY[1]);
//        //画第二节身子
//        Images.bodyImage.paintIcon(this,g,snakeX[2],snakeY[2]);
        //优化为循环，画蛇身
        for(int i =1;i<length;i++){
            Images.bodyImage.paintIcon(this,g,snakeX[i],snakeY[i]);
        }


        //如果游戏暂停，界面中间应有一句提示语
        if(!isStart){
            //画一段文字
            g.setColor(new Color(114,98,255));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //画文字
            g.drawString("点击空格开始游戏",330,330);
        }

        //画食物
        Images.foodImage.paintIcon(this,g,foodX,foodY);
        //画积分
        g.setColor(new Color(114,98,255));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("积分："+score,900,50);

        //画入死亡状态
        if(isDie){
            g.setColor(new Color(114,98,255));
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            g.drawString("小蛇死亡，游戏停止，按下空格重新开始游戏",300,330);
        }
    }
}
