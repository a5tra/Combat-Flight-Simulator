package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Intro
        AnchorPane introLayout=new AnchorPane();
        BackgroundImage startBackground=new BackgroundImage(new Image("resource/StartBackground.jpg"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        introLayout.setBackground(new Background(startBackground));

        ImageView play=new ImageView(new Image("resource/plnw.png"));
        Button newGame=new Button("",play);
        newGame.setLayoutX(900);
        newGame.setLayoutY(150);
        introLayout.getChildren().addAll(newGame);

        ImageView highScore=new ImageView(new Image("resource/leaderboard.png"));
        Button leaderBoard=new Button("",highScore);
        leaderBoard.setLayoutX(900);
        leaderBoard.setLayoutY(250);
        //leaderBoard.setOnAction();
        introLayout.getChildren().add(leaderBoard);

        ImageView help=new ImageView(new Image("resource/instructions.png"));
        Button instructions=new Button("",help);
        instructions.setLayoutX(900);
        instructions.setLayoutY(350);
        introLayout.getChildren().add(instructions);

        ImageView quit=new ImageView(new Image("resource/exit.jpg"));
        Button exit=new Button("",quit);
        exit.setLayoutX(900);
        exit.setLayoutY(450);
        introLayout.getChildren().add(exit);

        Scene introScene=new Scene(introLayout,1280,720);
        primaryStage.setScene(introScene);



        //Scene 2 Gameplay
        Group game=new Group();
        ImageView background1=new ImageView(new Image("resource/Background1.jpg"));
        ImageView background2=new ImageView(new Image("resource/Background2.jpg"));
        ImageView background3=new ImageView(new Image("resource/Background3.jpg"));
        background1.setLayoutX(0);
        background1.setLayoutY(0);
        background2.setLayoutX(1280);
        background2.setLayoutY(0);
        background3.setLayoutX(2560);
        background3.setLayoutY(0);
        game.getChildren().addAll(background1,background2,background3);
        Scene gameplay=new Scene(game,1280,720);

















       /* AnchorPane root=new AnchorPane();
        ImageView background1=new ImageView(new Image("resource/Background1.jpg"));
        ImageView background2=new ImageView(new Image("resource/Background2.jpg"));
        ImageView background3=new ImageView(new Image("resource/Background3.jpg"));
        root.getChildren().addAll(background1,background2,background3);
        Scene gamePlayScene=new Scene(root,800,500);
        primaryStage.setScene(gamePlayScene);
        new AnimationTimer()
        {
            public void handle(long now)
            {
                double pos1x=background1.getX();
                double pos2x=background2.getX();
                double pos3x=background3.getX();
                pos1x=pos1x-2;
                pos2x=pos2x-2;
                pos3x=pos3x-2;
                if(pos1x==-700) pos1x=700;
                if(pos2x==-700) pos2x=700;
                if(pos3x==-500) pos3x=500;
                background1.setX(pos1x);
                background2.setX(pos2x);
                background3.setX(pos3x);

            }
        }.start();*/
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
