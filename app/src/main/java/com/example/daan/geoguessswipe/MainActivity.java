package com.example.daan.geoguessswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<StreetviewObject> mStreetviewObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStreetviewObjects =  new ArrayList<>();

        for (int i = 0; i < StreetviewObject.PRE_DEFINED_STREETVIEW_OBJECT_NAMES.length; i++) {
            mStreetviewObjects.add(new StreetviewObject(
                    StreetviewObject.PRE_DEFINED_STREETVIEW_OBJECT_NAMES[i],
                    StreetviewObject.PRE_DEFINED_STREETVIEW_OBJECT_IMAGE_IDS[i],
                    StreetviewObject.PRE_DEFINED_IF_IN_EUROPE[i])
            );
        }

        final RecyclerView mStreetviewRecyclerView = findViewById(R.id.recyclerView);
        mStreetviewRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        final StreetviewObjectAdapter mAdapter = new StreetviewObjectAdapter(this, mStreetviewObjects);
        mStreetviewRecyclerView.setAdapter(mAdapter);


        ItemTouchHelper.SimpleCallback simpleItemCallback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                boolean isInEurope = mStreetviewObjects.get(position).mIsInEurope();

                switch (swipeDir) {
                    case ItemTouchHelper.LEFT:
                        checkCorrect(true, isInEurope, position);
                        break;
                    case ItemTouchHelper.RIGHT:
                        checkCorrect(false, isInEurope, position);
                        break;
                }

                mStreetviewRecyclerView.scrollToPosition(position + 1);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemCallback);
        itemTouchHelper.attachToRecyclerView(mStreetviewRecyclerView);
    }

    private void checkCorrect(boolean givenAnswer, boolean correctAnswer, int position) {
        if (givenAnswer == correctAnswer) {
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Answer!", Toast.LENGTH_SHORT).show();
        }
    }
}
