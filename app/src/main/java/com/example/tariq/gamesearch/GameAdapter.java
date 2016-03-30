package com.example.tariq.gamesearch;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    private static final int SIZE = 100;
    private final List<String> items;
    public final static String EXTRA_MESSAGE = "com.example.tariq.gamesearch.MESSAGE";
    public  List<GameModel> gameList;

    public static GameAdapter newInstance(Context context) {
        List<String> items = new ArrayList<>();
        ArrayList<GameModel> gameList = new ArrayList<GameModel>();
      //  GameModel model;
        String [] gameOBJName={"poker", "texas holdem", "speed", "sharades", "namegame", "marbles", "twotruths", "21?"};
       int size = gameOBJName.length;
        for (int i = 0; i < size ; i++) {
            items.add(gameOBJName[i]);
        }
        return new GameAdapter(items);
    }

    private GameAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return ViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = items.get(position);
        holder.setText(text);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
      //  public static GlobalList gl=new GlobalList(); // cant create another globalList object because it needs to be created only once.
       // ArrayList<GameModel> l=gl.getList();

        public static ViewHolder newInstance(View itemView) {
            TextView textView = (TextView) itemView.findViewById(android.R.id.text1);
            return new ViewHolder(itemView, textView);
        }

        private ViewHolder(View itemView, TextView textView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.textView = textView;
        }

        @Override
        public void onClick(View view) {

            ArrayList<GameModel> gameList1 = new ArrayList<GameModel>();
            GameModel model1, model2;
            String [] gameOBJName1={"poker", "texas holdem", "speed", "charades", "namegame", "marbles", "twotruths", "21?"};
            int[] gamePosition={1,2,3,4,5,6,7,8};
            int[] numPlayerArr={3,3,2,2,2,2,2,2};
            String [] material={"52 Card Deck", "52 Card Deck", "52 Card Deck", "No Material Required", "No Material Required", "Marbles", "No Material Required","No Material Required"  };
            int[] icons={R.drawable.poker_image, R.drawable.texas_holdem_image, R.drawable.speed_image, R.drawable.charades_image, R.drawable.name_game_image,R.drawable.marbles_image, R.drawable.two_truths_and_a_lie_image,R.drawable.two_1_questions_image};
            int numObjects=gameOBJName1.length;
            String[] summary= new String[numObjects];
            summary[1]="Texas Holdem Poker is a community card game generally played from anywhere between 2 to 10 people. To win in Texas Holdem Poker, you will have to make the best 5 card combination possible";


            for(int i=0; i < gameOBJName1.length; i++) {
                model1 = new GameModel(gamePosition[i], gameOBJName1[i], numPlayerArr[i], material[i],icons[i], summary[i]);
                gameList1.add(model1);
            }

            Context c = view.getContext();
            Toast.makeText(view.getContext(), "position = " + getPosition(), Toast.LENGTH_SHORT).show();
            int position = getPosition();  //position of the game onClick
            model2 = gameList1.get(position);

           // MainController.getInstance().addModel(model2.getPosition(), model2.getTitle(),
           //                                 model2.getPlayers(), model2.getTitle2());

            Intent intent = new Intent(c, GameClassActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable(EXTRA_MESSAGE, model2);
            intent.putExtras(bundle);

          //  GameModel model3= MainController.getInstance().getModel();
          //  intent.putExtra(EXTRA_MESSAGE, model3);
            c.startActivity(intent);
        }
        public void setText(CharSequence text) {
            textView.setText(text);
        }
    }
}


