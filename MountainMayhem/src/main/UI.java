package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_BITCOIN;

public class UI {

    GamePanel gp;
    Font arial_40;
    Font arial_80B;
    BufferedImage coinImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0");



    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        OBJ_BITCOIN coin = new OBJ_BITCOIN();
        coinImage = coin.image;
    }
    public void showMessage(String text){

        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){

        if(gameFinished == true){

        g2.setFont(arial_40);
        g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found it!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x =gp.screenWidth/2 - textLength;
            y =gp.screenWidth/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);

            text = "Your Time is :" + dFormat.format(playTime) + "!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x =gp.screenWidth/2 - textLength;
            y =gp.screenWidth/2 + (gp.tileSize*4);
            g2.drawString(text, x, y);



            g2.setFont(arial_80B);
        g2.setColor(Color.blue);
        text = "You Win!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x =gp.screenWidth/2 - textLength;
            y =gp.screenWidth/2 + (gp.tileSize*2);
            g2.drawString(text, x, y);

            gp.gameThread = null;


        }
        else{
            
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawImage(coinImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x "+ gp.player.hasCoin, 74, 60);

            //Time
            playTime +=(double)1/60;
            g2.drawString("Time:"+dFormat.format (playTime), gp.tileSize*11, 65);


        //message
        if(messageOn == true){

            g2.setFont(g2.getFont().deriveFont(20F));
            g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

            messageCounter++;

            if(messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;
            }
        }

        }

    }


}
