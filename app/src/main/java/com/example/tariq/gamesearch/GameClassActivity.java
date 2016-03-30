package com.example.tariq.gamesearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.tariq.gamesearch.GameAdapter;

import java.util.List;

public class GameClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle= this.getIntent().getExtras();
       GameModel newModel;
        newModel=bundle.getParcelable(GameAdapter.EXTRA_MESSAGE);

        String message= newModel.getTitle();
        int positionNum= newModel.getPosition();
        int playerNum = newModel.getPlayers();
        int iconID= newModel.getIconID();
        String gameSummary=newModel.getGameSummary();

        String message1 = Integer.toString(playerNum);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        ImageView imageView=(ImageView)findViewById(R.id.icon);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        Button readMoreButton= (Button) findViewById(R.id.readMoreButton);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.instructionLayout);
        final View topLine = (View) findViewById(R.id.topLine);

        textView1.setText(message); //displays name of game
        textView2.setText("Number of players:"+message1); // displays number of players
        imageView.setImageResource(iconID);
        textView3.setText(gameSummary);

        readMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                    linearLayout.setVisibility(View.VISIBLE);
                    topLine.setVisibility(View.INVISIBLE);

            }
        });

      //  LinearLayout layout = (LinearLayout) findViewById(R.id.content);
    }

}
