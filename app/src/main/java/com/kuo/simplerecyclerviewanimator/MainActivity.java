package com.kuo.simplerecyclerviewanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.kuo.animator.FadeInAnimator;
import com.kuo.animator.OvershootInLeftAnimator;
import com.kuo.animator.OvershootInRightAnimator;
import com.kuo.animator.ScaleInAnimator;
import com.kuo.animator.SlideInBottomAnimator;
import com.kuo.animator.SlideInLeftAnimator;
import com.kuo.animator.SlideInTopAnimator;
import com.kuo.animator.SlideInRightAnimator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final int SLIDE_TOP = 0;
    private static final int SLIDE_BOTTOM = 1;
    private static final int SLIDE_LEFT = 2;
    private static final int SLIDE_RIGHT = 3;
    private static final int SCALE = 4;
    private static final int FADE = 5;
    private static final int OVERSHOOT_LEFT = 6;
    private static final int OVERSHOOT_RIGHT = 7;

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ImageButton addButton, deleteButton;
    private Spinner spinner;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onInitView();

    }

    private void onInitView(){
        findViewTarget();
        onInitRecyclerViewAdapter();
        onInitSpinnerAdapter();
    }

    private void findViewTarget(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        addButton = (ImageButton) findViewById(R.id.addButton);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton);
        spinner = (Spinner) findViewById(R.id.spinner);

        toolbar.setTitle("SimpleRecyclerViewItemAnimator");
        setSupportActionBar(toolbar);

        addButton.setOnClickListener(onAddClickListener);
        deleteButton.setOnClickListener(onAddClickListener);

    }

    private void onInitRecyclerViewAdapter(){

        int[] colors = {R.color.Grey_700,
                R.color.LightGreen_500,
                R.color.Red_500,
                R.color.Pink_500,
                R.color.Purple_500,
                R.color.DeepPurple_500,
                R.color.Indigo_500,
                R.color.Blue_500};

        List<Integer> colorsList = new ArrayList<Integer>();

        for(int i = 0 ; i < colors.length ; i++){
            colorsList.add(colors[i]);
        }

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewAdapter = new RecyclerViewAdapter(this, colorsList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new OvershootInLeftAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void onInitSpinnerAdapter(){

        String[] names = {"SlideInTop", "SlideInBottom", "SlideInLeft", "SlideInRight", "ScaleIn", "FadeIn", "OvershootInLeft", "OvershootInRight"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, names);

        spinner.setOnItemSelectedListener(onItemSelectedListener);
        spinner.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Spinner.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i){
                case SLIDE_TOP:
                    recyclerView.setItemAnimator(new SlideInTopAnimator());
                    break;
                case SLIDE_BOTTOM:
                    recyclerView.setItemAnimator(new SlideInBottomAnimator());
                    break;
                case SLIDE_LEFT:
                    recyclerView.setItemAnimator(new SlideInLeftAnimator());
                    break;
                case SLIDE_RIGHT:
                    recyclerView.setItemAnimator(new SlideInRightAnimator());
                    break;
                case SCALE:
                    recyclerView.setItemAnimator(new ScaleInAnimator());
                    break;
                case FADE:
                    recyclerView.setItemAnimator(new FadeInAnimator());
                    break;
                case OVERSHOOT_LEFT:
                    recyclerView.setItemAnimator(new OvershootInLeftAnimator());
                    break;
                case OVERSHOOT_RIGHT:
                    recyclerView.setItemAnimator(new OvershootInRightAnimator());
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private ImageButton.OnClickListener onAddClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.addButton){
                recyclerViewAdapter.addColor(R.color.Cyan_500, 1);
            }else if(view.getId() == R.id.deleteButton){
                recyclerViewAdapter.deleteColor(1);
            }
        }
    };
}

