package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Main extends Application {

    public Random random=new Random();
    public int misileNo=4;
    int bulletThrow=0;
    public int bulletHit=0;
    public int enemy1Dead=0;
    public int enemy2Dead=0;
    public int enemy3Dead=0;
    public  int misile1Hit=0;
    public  int misile2Hit=0;
    public  int misile3Hit=0;

    public Integer score=0;
    public int life=3;
    public int start=0;
    public int bomb=0;


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Intro
        AnchorPane introLayout = new AnchorPane();
        BackgroundImage startBackground = new BackgroundImage(new Image("resource/StartBackground.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        introLayout.setBackground(new Background(startBackground));

        ImageView play = new ImageView(new Image("resource/plnw.png"));
        Button newGame = new Button("", play);
        newGame.setPadding(Insets.EMPTY);
        newGame.setLayoutX(900);
        newGame.setLayoutY(150);
        introLayout.getChildren().addAll(newGame);

//        ImageView highScore = new ImageView(new Image("resource/leaderboard.png"));
//        Button leaderBoard = new Button("", highScore);
//        leaderBoard.setPadding(Insets.EMPTY);
//        leaderBoard.setLayoutX(900);
//        leaderBoard.setLayoutY(250);
//        introLayout.getChildren().add(leaderBoard);

        ImageView help = new ImageView(new Image("resource/instructions.png"));
        Button instructions = new Button("", help);
        instructions.setPadding(Insets.EMPTY);
        instructions.setLayoutX(900);
        instructions.setLayoutY(300);
        introLayout.getChildren().add(instructions);

        ImageView quit = new ImageView(new Image("resource/exit.jpg"));
        Button exit = new Button("", quit);
        exit.setPadding(Insets.EMPTY);
        exit.setLayoutX(900);
        exit.setLayoutY(450);
        introLayout.getChildren().add(exit);

        Scene introScene = new Scene(introLayout, 1280, 720);
        primaryStage.setScene(introScene);


        //Scene 2 Gameplay
        Group game = new Group();
        ImageView background1 = new ImageView(new Image("resource/fix2.png"));
        ImageView background2 = new ImageView(new Image("resource/fix2.png"));
        ImageView enemy1=new ImageView(new Image("resource/Enemy-redYellow.png"));
        ImageView enemy2=new ImageView(new Image("resource/EnemyBlack.png"));
        ImageView enemy3=new ImageView(new Image("resource/WhiteShark.png"));
        ImageView Bomb1=new ImageView(new Image("resource/Bomb.png"));
        ImageView Bomb2=new ImageView(new Image("resource/Bomb.png"));
        ImageView Bomb3=new ImageView(new Image("resource/Bomb.png"));
        ImageView Score=new ImageView(new Image("resource/Score.png"));

        ImageView MisileRemaining=new ImageView(new Image("resource/MissileReamining.png"));
        MisileRemaining.setLayoutX(1030);
        ImageView misilesSet1=new ImageView(new Image("resource/misiles.png"));
        misilesSet1.setLayoutX(1190);
        ImageView misilesSet2=new ImageView(new Image("resource/misiles.png"));
        misilesSet2.setLayoutX(1220);
        ImageView misilesSet3=new ImageView(new Image("resource/misiles.png"));
        misilesSet3.setLayoutX(1250);

        Score.setLayoutX(550);

        Text ScoreCount=new Text(score.toString());
        ScoreCount.fontProperty().setValue(Font.font(80));
        ScoreCount.setFill(Color.GOLD);
        ScoreCount.setLayoutX(730);
        ScoreCount.setLayoutY(60);


        //life
        ImageView life1=new ImageView(new Image("resource/Life.png"));
        life1.setLayoutX(0);
        ImageView life2=new ImageView(new Image("resource/Life.png"));
        life2.setLayoutX(35);
        ImageView life3=new ImageView(new Image("resource/Life.png"));
        life3.setLayoutX(70);
        ImageView life4=new ImageView(new Image("resource/Life.png"));
        life4.setLayoutX(105);
        life4.setOpacity(0);
        ImageView life5=new ImageView(new Image("resource/Life.png"));
        life5.setLayoutX(140);
        life5.setOpacity(0);




        background1.setLayoutX(0);
        background2.setLayoutX(1280);
        enemy1.setLayoutX(1200);
        enemy1.setLayoutY(5);
        enemy2.setLayoutX(1600);
        enemy2.setLayoutY(270);
        enemy3.setLayoutX(1100);
        enemy3.setLayoutY(500);
        //Bombs
        Bomb1.setLayoutX(enemy1.getLayoutX()+10);
        Bomb1.setLayoutY(enemy1.getLayoutY()+60);

        Bomb2.setLayoutX(enemy2.getLayoutX()+2);
        Bomb2.setLayoutY(enemy2.getLayoutY()+68);

        Bomb3.setLayoutX(enemy3.getLayoutX()+16);
        Bomb3.setLayoutY(enemy3.getLayoutY()+64);

        ImageView plane=new ImageView(new Image("resource/US-AF.png"));
        plane.setLayoutX(30);
        plane.setLayoutY(300);

        final ImageView[] bullet = {new ImageView(new Image("resource/Bullet.png"))};
        bullet[0].setLayoutX(plane.getLayoutX()+159);
        bullet[0].setLayoutY(plane.getLayoutY()+46);

        ImageView misile1=new ImageView(new Image("resource/Missile.png"));
        misile1.setOpacity(0.5);
        misile1.setLayoutX(plane.getLayoutX()+70);
        misile1.setLayoutY(plane.getLayoutY()+40);

        ImageView misile2=new ImageView(new Image("resource/Missile.png"));
        misile2.setOpacity(0.5);
        misile2.setLayoutX(plane.getLayoutX()+40);
        misile2.setLayoutY(plane.getLayoutY()+60);

        ImageView misile3=new ImageView(new Image("resource/Missile.png"));
        misile3.setOpacity(0.5);
        misile3.setLayoutX(plane.getLayoutX()+45 );
        misile3.setLayoutY(plane.getLayoutY()-20);


        game.getChildren().addAll(background1,background2,plane,misile1,misile2,misile3,enemy1,enemy2,enemy3, bullet[0],Bomb1,Bomb2,Bomb3,Score,misilesSet1,misilesSet2,misilesSet3,MisileRemaining,ScoreCount,life1,life2,life3,life4,life5);
        Scene gameplay = new Scene(game, 1280, 720);

        KeyValue back1=new KeyValue(background1.layoutXProperty(),-1280);
        KeyValue back2=new KeyValue(background2.layoutXProperty(),0);

        KeyValue enm1=new KeyValue(enemy1.layoutXProperty(),-600);
        KeyValue enm2=new KeyValue(enemy2.layoutXProperty(),-600);
        KeyValue enm3=new KeyValue(enemy3.layoutXProperty(),-600);

        KeyFrame backFrame=new KeyFrame(Duration.seconds(8),back1,back2,enm1,enm2,enm3);
        Timeline gameTimeline=new Timeline();
        gameTimeline.setCycleCount(Timeline.INDEFINITE);
        gameTimeline.setAutoReverse(false);
        gameTimeline.getKeyFrames().addAll(backFrame);

        //Actions

        newGame.setOnAction(e ->
                {
                    //enter gameplay
                    primaryStage.setScene(gameplay);
                    gameTimeline.play();
                    start=1;

                });
        exit.setOnAction(e->System.exit(0));

        gameplay.setOnKeyPressed(e->
        {
            if(e.getCode()== KeyCode.RIGHT)
            {
                if(plane.getLayoutX()<900)
                {
                    plane.setLayoutX(plane.getLayoutX() + 10);
                    if(bulletThrow==0)
                    {
                        bullet[0].setLayoutX(bullet[0].getLayoutX()+10);
                    }
                    misile1.setLayoutX(misile1.getLayoutX()+10);
                    misile2.setLayoutX(misile2.getLayoutX()+10);
                    misile3.setLayoutX(misile3.getLayoutX()+10);
                }
            }
            if(e.getCode()==KeyCode.LEFT)
            {
                if(plane.getLayoutX()>0)
                {
                    plane.setLayoutX(plane.getLayoutX() - 10);
                    if(bulletThrow==0)
                    {
                        bullet[0].setLayoutX(bullet[0].getLayoutX()-10);
                    }
                    misile1.setLayoutX(misile1.getLayoutX()-10);
                    misile2.setLayoutX(misile2.getLayoutX()-10);
                    misile3.setLayoutX(misile3.getLayoutX()-10);
                }
            }
            if(e.getCode()==KeyCode.UP)
            {
                if(plane.getLayoutY()>0)
                {
                    plane.setLayoutY(plane.getLayoutY() -5);
                    if(bulletThrow==0)
                    {
                        bullet[0].setLayoutY(bullet[0].getLayoutY()-5);
                    }
                    misile1.setLayoutY(misile1.getLayoutY()-5);
                    misile2.setLayoutY(misile2.getLayoutY()-5);
                    misile3.setLayoutY(misile3.getLayoutY()-5);
                }
            }
            if(e.getCode()==KeyCode.DOWN)
            {
                if(plane.getLayoutY()<600)
                {
                    plane.setLayoutY(plane.getLayoutY() +5);
                    if(bulletThrow==0)
                    {
                        bullet[0].setLayoutY(bullet[0].getLayoutY()+5);
                    }
                    misile1.setLayoutY(misile1.getLayoutY()+5);
                    misile2.setLayoutY(misile2.getLayoutY()+5);
                    misile3.setLayoutY(misile3.getLayoutY()+5);
                }
            }
            if(e.getCode()==KeyCode.SPACE)
            {
                //misileThrow=1;
                misileNo=misileNo-1;
            }
            if(e.getCode()==KeyCode.ENTER)
            {
                bulletThrow=1;
            }

        });

        BackgroundImage go = new BackgroundImage(new Image("resource/gameover.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        ImageView con=new ImageView(new Image("resource/ContinueButton.png"));
        ImageView exi=new ImageView(new Image("resource/exitButton.png"));
        Button Contitnue=new Button("",con);
        Contitnue.setOnAction(e->primaryStage.setScene(gameplay));
        Button ex=new Button("",exi);
        ex.setOnAction(e->System.exit(0));
        AnchorPane Overpane=new AnchorPane();
        Overpane.setBackground(new Background(go));
        Overpane.getChildren().addAll(Contitnue,ex);
        Contitnue.setLayoutX(280);
        Contitnue.setLayoutY(400);
        Contitnue.setPadding(Insets.EMPTY);
        ex.setPadding(Insets.EMPTY);
        ex.setLayoutX(804);
        ex.setLayoutY(400);

        Scene GameOver=new Scene(Overpane,1280,720);

        new AnimationTimer()
        {
            int ran=random.nextInt(200);
            @Override
            public void handle(long now)
            {
                //random enemy comeup
                if(enemy1.getLayoutX()<-400)
                {
                    enemy1.setLayoutY(ran+10);
                }
                if(enemy2.getLayoutX()<-400)
                {
                    enemy2.setLayoutY(ran+300);
                }
                if(enemy3.getLayoutX()<-400)
                {
                    enemy3.setLayoutY(ran+340);
                }

                //misile throw
                if(misile1.getLayoutX()<1300 &&misileNo<=3)
                {
                    misile1.setOpacity(1);
                    misilesSet3.setOpacity(0);
                    misile1.setLayoutX(misile1.getLayoutX()+3);
                }
                else  if (misile2.getLayoutX()<1300&&misileNo<=2)
                {
                    misile2.setOpacity(1);
                    misilesSet2.setOpacity(0);
                    misile2.setLayoutX(misile2.getLayoutX()+3);

                }
                else if(misile3.getLayoutX()<1300&&misileNo<=1)
                {
                    misile3.setOpacity(1);
                    misilesSet1.setOpacity(0);
                    misile3.setLayoutX(misile3.getLayoutX()+3);
                    //misileThrow=0;
                }
//                if(misileThrow==1)
//                {
//                    if(misile1.getLayoutX()>1280||misile2.getLayoutX()>1280||misile3.getLayoutX()>1280)
//                    {
//                        misileThrow=0;
//                    }
//                }

                //bulletThrow
                if(bulletThrow==1)
                {
                    bullet[0].setOpacity(1);
                    bullet[0].setLayoutX(bullet[0].getLayoutX()+6);
                }
                if(bullet[0].getLayoutX()>1280||bullet[0].getOpacity()==0)
                {
                    bullet[0].setLayoutX(plane.getLayoutX()+159);
                    bullet[0].setLayoutY(plane.getLayoutY()+46);
                    bullet[0].setOpacity(0.5);
                    bulletThrow=0;
                    bulletHit=0;
                }
                if(bulletHit==1)
                {
                    bullet[0].setOpacity(0);
                    bullet[0].setLayoutX(bullet[0].getLayoutX()+6);
                    bulletThrow=0;
                }
                //enemy1 dead
                if(enemy1Dead==0&&bulletHit==0&&((bullet[0].getLayoutX()+41>=enemy1.getLayoutX()&&bullet[0].getLayoutX()<=enemy1.getLayoutX()+131)&&(bullet[0].getLayoutY()+3>=enemy1.getLayoutY()&&bullet[0].getLayoutY()<=enemy1.getLayoutY()+106)))
                {
                    enemy1Dead=1;
                    enemy1.setOpacity(0);
                    bulletHit=1;
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                if(enemy1Dead==0&&misile1Hit==0&&(misile1.getLayoutX()+70>=enemy1.getLayoutX()&&misile1.getLayoutX()<=enemy1.getLayoutX()+131)&&(misile1.getLayoutY()+19>=enemy1.getLayoutY()&&misile1.getLayoutY()<=enemy1.getLayoutY()+106))
                {
                    enemy1Dead=1;
                    enemy1.setOpacity(0);
                    misile1.setOpacity(0);
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                if(enemy1Dead==0&&misile2Hit==0&&(misile2.getLayoutX()+70>=enemy1.getLayoutX()&&misile2.getLayoutX()<=enemy1.getLayoutX()+131)&&(misile2.getLayoutY()+19>=enemy1.getLayoutY()&&misile2.getLayoutY()<=enemy1.getLayoutY()+106))
                {
                    enemy1Dead=1;
                    enemy1.setOpacity(0);
                    misile2.setOpacity(0);
                    bullet[0].setOpacity(0);
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                if(enemy1Dead==0&&misile3Hit==0&&(misile3.getLayoutX()+70>=enemy1.getLayoutX()&&misile3.getLayoutX()<=enemy1.getLayoutX()+131)&&(misile3.getLayoutY()+19>=enemy1.getLayoutY()&&misile3.getLayoutY()<=enemy1.getLayoutY()+106))
                {
                    enemy1Dead=1;
                    enemy1.setOpacity(0);
                    misile3.setOpacity(0);
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                //enemy2 dead
                if(enemy2Dead==0&&bulletHit==0&&((bullet[0].getLayoutX()+41>=enemy2.getLayoutX()+2&&bullet[0].getLayoutX()<=enemy2.getLayoutX()+146)&&(bullet[0].getLayoutY()+3>=enemy2.getLayoutY()+24&&bullet[0].getLayoutY()<=enemy2.getLayoutY()+83)))
                {
                    enemy2Dead=1;
                    enemy2.setOpacity(0);
                    bullet[0].setOpacity(0);
                    bulletHit=1;
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                if(enemy2Dead==0&&misile1Hit==0&&(misile1.getLayoutX()+70>=enemy2.getLayoutX()+2&&misile1.getLayoutX()<=enemy2.getLayoutX()+146)&&(misile1.getLayoutY()+19>=enemy2.getLayoutY()+24&&misile1.getLayoutY()<=enemy2.getLayoutY()+83))
                {
                    enemy2Dead=1;
                    enemy2.setOpacity(0);
                    misile1.setOpacity(0);
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                if(enemy2Dead==0&&misile2Hit==0&&(misile2.getLayoutX()+70>=enemy2.getLayoutX()+2&&misile2.getLayoutX()<=enemy2.getLayoutX()+146)&&(misile2.getLayoutY()+19>=enemy2.getLayoutY()+24&&misile2.getLayoutY()<=enemy2.getLayoutY()+83))
                {
                    enemy2Dead=1;
                    enemy2.setOpacity(0);
                    misile2.setOpacity(0);
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                if(enemy2Dead==0&&misile3Hit==0&&(misile3.getLayoutX()+70>=enemy2.getLayoutX()+2&&misile3.getLayoutX()<=enemy2.getLayoutX()+146)&&(misile3.getLayoutY()+19>=enemy2.getLayoutY()+24&&misile3.getLayoutY()<=enemy2.getLayoutY()+83))
                {
                    enemy2Dead=1;
                    enemy2.setOpacity(0);
                    misile3.setOpacity(0);
                    score+=10;
                    System.out.println(score);
                }
                //enemy3 dead
                if(enemy3Dead==0&&bulletHit==0&&((bullet[0].getLayoutX()+41>=enemy3.getLayoutX()+17&&bullet[0].getLayoutX()<=enemy3.getLayoutX()+106)&&(bullet[0].getLayoutY()+3>=enemy3.getLayoutY()+32&&bullet[0].getLayoutY()<=enemy3.getLayoutY()+108)))
                {
                    enemy3Dead=1;
                    enemy3.setOpacity(0);
                    bulletHit=1;
                    score+=10;
                    System.out.println(score);
                }
                if(enemy3Dead==0&&misile1Hit==0&&(misile1.getLayoutX()+70>=enemy3.getLayoutX()+17&&misile1.getLayoutX()<=enemy3.getLayoutX()+106)&&(misile1.getLayoutY()+19>=enemy3.getLayoutY()+32&&misile1.getLayoutY()<=enemy3.getLayoutY()+108))
                {
                    enemy3Dead=1;
                    enemy3.setOpacity(0);
                    misile1.setOpacity(0);
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                if(enemy3Dead==0&&misile2Hit==0&&(misile2.getLayoutX()+70>=enemy3.getLayoutX()+17&&misile2.getLayoutX()<=enemy3.getLayoutX()+106)&&(misile2.getLayoutY()+19>=enemy3.getLayoutY()+32&&misile2.getLayoutY()<=enemy3.getLayoutY()+108))
                {
                    enemy3Dead=1;
                    enemy3.setOpacity(0);
                    misile2.setOpacity(0);
                    score+=10;
                    ScoreCount.setText(score.toString());
                }
                if(enemy3Dead==0&&misile3Hit==0&&(misile3.getLayoutX()+70>=enemy3.getLayoutX()+17&&misile3.getLayoutX()<=enemy3.getLayoutX()+106)&&(misile3.getLayoutY()+19>=enemy3.getLayoutY()+32&&misile3.getLayoutY()<=enemy3.getLayoutY()+108))
                {
                    enemy3Dead=1;
                    enemy3.setOpacity(0);
                    misile3.setOpacity(0);
                    score+=10;
                    ScoreCount.setText(score.toString());
                }

                //dead enemy and scoring
                if(enemy1Dead==1)
                {
//                    score+=10;
//                    System.out.println(score);
                   if(enemy1.getLayoutX()<-400)
                   {
                       enemy1.setOpacity(1);
                       enemy1Dead=0;
                   }
                }
                if(enemy2Dead==1)
                {
                    //ScoreCount.textProperty().bind(score);
                    if(enemy2.getLayoutX()<-400)
                    {
                        enemy2.setOpacity(1);
                        enemy2Dead=0;
                    }
                }
                if(enemy3Dead==1)
                {
                    if(enemy3.getLayoutX()<-400)
                    {
                        enemy3.setOpacity(1);
                        enemy3Dead=0;
                    }
                }
                //enemyBomb1ing
                if(start==1)
                {
                    Bomb1.setLayoutX(Bomb1.getLayoutX()-10);
                    Bomb1.setLayoutY(Bomb1.getLayoutY());

                    Bomb2.setLayoutX(Bomb2.getLayoutX()-10);
                    Bomb2.setLayoutY(Bomb2.getLayoutY());

                    Bomb3.setLayoutX(Bomb3.getLayoutX()-10);
                    Bomb3.setLayoutY(Bomb3.getLayoutY());
                }
                if(Bomb1.getLayoutX()<-400)
                {
                    Bomb1.setLayoutX(enemy1.getLayoutX()+10);
                    Bomb1.setLayoutY(enemy1.getLayoutY()+40);
                }
                if(Bomb2.getLayoutX()<-400)
                {
                    Bomb2.setLayoutX(enemy2.getLayoutX()+2);
                    Bomb2.setLayoutY(enemy2.getLayoutY()+35);
                }
                if(Bomb3.getLayoutX()<-400)
                {
                    Bomb3.setLayoutX(enemy3.getLayoutX()-13);
                    Bomb3.setLayoutY(enemy3.getLayoutY()+30);
                }

                if((plane.getLayoutX()+197>=Bomb1.getLayoutX()+23&&plane.getLayoutX()+187<=Bomb1.getLayoutX()+23&&plane.getLayoutY()+91>=Bomb1.getLayoutY()+45&&plane.getLayoutY()<=Bomb1.getLayoutY()+31)||
                        (plane.getLayoutX()+197>=Bomb2.getLayoutX()+23&&plane.getLayoutX()+187<=Bomb2.getLayoutX()+23&&plane.getLayoutY()+91>=Bomb2.getLayoutY()+45&&plane.getLayoutY()<=Bomb2.getLayoutY()+31)||
                        (plane.getLayoutX()+197>=Bomb3.getLayoutX()+23&&plane.getLayoutX()+187<=Bomb3.getLayoutX()+23&&plane.getLayoutY()+91>=Bomb3.getLayoutY()+45&&plane.getLayoutY()<=Bomb3.getLayoutY()+31))
                {
                    if(life==3) {
                        life3.setOpacity(0);
                        life--;
                    }
                    else if(life==2) {
                        life2.setOpacity(0);
                        life--;
                    }
                    else if(life==1) {
                        life1.setOpacity(0);
                        life--;
                    }
                    else
                    {
                        primaryStage.setScene(GameOver);
                    }
                }

            }
        }.start();

        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

