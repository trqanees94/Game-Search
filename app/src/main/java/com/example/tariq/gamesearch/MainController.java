package com.example.tariq.gamesearch;

/**
 * Created by ifti on 3/23/2016.
 */
public class MainController {

    private static MainController instance;
    private GameModel model;
    int position;
    String name;
    int numPlayers;
    int iconID;
    String summary;

    private MainController(){
        //this.model= new GameModel( position,  name,  numPlayers,  secondName);
    }

    public static MainController getInstance()
    {
        if(instance==null) {
            {
                instance=new MainController();
            }
        }
        return instance;
    }

    public void addModel( int position, String name, int numPlayers, String secondName, int icon, String summary)
    {
         model = new GameModel(position, name, numPlayers, secondName, icon, summary);

    }

    public GameModel getModel()
    {return model;}

}
