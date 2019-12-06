package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.LIST";
    private ArrayList<String> values = new ArrayList<>();
    private int buttonHitCount = 0;
    private int numValuesNeeded = 26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((EditText)findViewById(R.id.editText)).setHint("Enter an adjective");
        values = new ArrayList<>();
        buttonHitCount = 0;
    }

    /** Called when the user taps the Continue button*/
    public void buttonHit(View view){
        EditText editText = findViewById(R.id.editText);
        values.add(buttonHitCount, editText.getText().toString().toLowerCase().trim());


        buttonHitCount += 1;
        if(buttonHitCount >= numValuesNeeded){
            sendMessage(view);
            return;
        }

        editText.getText().clear();
        /* Adj, adj, bodyPart, noun, animal, verb - 6
         * adverb, noun, adj, noun - 4
         * verb, noun, bodyPart, noun - 4
         * adverb, verb, verb, exclamation, past tense verb, past tense verb - 6
         * number, number, verb, verb, verb - 5
         * adverb - 1
         */
        switch(buttonHitCount) {
            case 1:
            case 8: editText.setHint("Enter an adjective"); break;
            case 6:
            case 14:
            case 25: editText.setHint("Enter an adverb"); break;
            case 4: editText.setHint("Enter an animal"); break;
            case 2:
            case 12: editText.setHint("Enter a body part"); break;
            case 17: editText.setHint("Enter an exclamation"); break;
            case 3:
            case 7:
            case 9:
            case 11:
            case 13: editText.setHint("Enter a noun"); break;
            case 20:
            case 21: editText.setHint("Enter a number"); break;
            case 18:
            case 19: editText.setHint("Enter a past tense verb"); break;
            case 5:
            case 10:
            case 15:
            case 16:
            case 22:
            case 23:
            case 24: editText.setHint("Enter a verb"); break;
        }
    }

    /** Called when the user taps the Continue button and there are no more requests */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putStringArrayListExtra(EXTRA_MESSAGE, values);
        startActivity(intent);
    }
}
