package com.example.tariq.gamesearch;

import android.net.nsd.NsdManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Vector;

/**
 * Created by ifti on 3/1/2016.
 */
public class GameModel implements Parcelable{

    String title;
    int gameOrder;
    int players;
    String materials;
    int iconID;
    String gameSummary;


    public GameModel(int position, String name, int numPlayers, String neccesities, int image, String summary){ // this was String[] name
            gameOrder=position;
             title=name;
            players=numPlayers;
            materials=neccesities;
            iconID= image;
            gameSummary=summary;

    }

    public String getTitle(){return title;}
    public int getPosition(){return gameOrder;}
    public int getPlayers(){return players;}
    public String getMaterials(){return materials;}
    public int getIconID(){return iconID;}
    public String getGameSummary(){return gameSummary;}

    protected GameModel(Parcel in) {
        title = in.readString();
        gameOrder = in.readInt();
        players = in.readInt();
        materials=in.readString();
        iconID=in.readInt();
        gameSummary=in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(gameOrder);
        dest.writeInt(players);
        dest.writeString(materials);
        dest.writeInt(iconID);
        dest.writeString(gameSummary);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<GameModel> CREATOR = new Parcelable.Creator<GameModel>() {
        @Override
        public GameModel createFromParcel(Parcel in) {
            return new GameModel(in);
        }

        @Override
        public GameModel[] newArray(int size) {
            return new GameModel[size];
        }
    };

}
