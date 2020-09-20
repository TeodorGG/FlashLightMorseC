package com.example.flashlightmorsec;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class decoder extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);

        listview= findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.itemsss,initlist());

        listview.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigetionBar();
    }

    private List<String> initlist(){

        List<String> list = new ArrayList<String>();

        list.add("A    .-     ");
        list.add("B    -...   ");
        list.add("C    -.-.   ");
        list.add("D    -..    ");
        list.add("E    .      ");
        list.add("F    ..-.   ");
        list.add("G    --.    ");
        list.add("H    ....   ");
        list.add("I    ..     ");
        list.add("J    .---   ");
        list.add("K    -.-    ");
        list.add("L    .-..   ");
        list.add("M    --     ");
        list.add("N    -.     ");
        list.add("O    ---    ");
        list.add("P    .--.   ");
        list.add("Q    --.-   ");
        list.add("R    .-.    ");
        list.add("S    ...    ");
        list.add("T    -      ");
        list.add("U    ..-    ");
        list.add("V    ...-   ");
        list.add("W    .--    ");
        list.add("X    -..-   ");
        list.add("Y    -.--   ");
        list.add("Z    --..   ");
        list.add("0    -----  ");
        list.add("1    .----  ");
        list.add("2    ..---  ");
        list.add("3    ...--  ");
        list.add("4    ....-  ");
        list.add("5    .....  ");
        list.add("6    -....  ");
        list.add("7    --...  ");
        list.add("8    ---..  ");
        list.add("9    ----.  ");
        list.add("'    .----. ");
        list.add(":    ---... ");
        list.add(",    --..-- ");
        list.add("-    -....- ");
        list.add("(    -.--.- ");
        list.add(".    .-.-.- ");
        list.add("?    ..--.. ");
        list.add(";    -.-.-. ");
        list.add("/    -..-.  ");
        list.add("-    ..--.- ");
        list.add(")    ---..  ");
        list.add("=    -...-  ");
        list.add("@    .--.-. ");
        list.add("+    .-.-.  ");
        return list;

    }

    private void hideNavigetionBar(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }
}
