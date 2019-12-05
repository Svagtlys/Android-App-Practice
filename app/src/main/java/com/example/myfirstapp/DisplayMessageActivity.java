package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Get the Intent that started this activity and extract the String
        Intent intent = getIntent();
        ArrayList<String> values = intent.getStringArrayListExtra(MainActivity.EXTRA_MESSAGE);

        String[] valuesArray = values.toArray(new String[values.size()]);

        //Capture the layout's text view and set the string as its text
        TextView textView = findViewById(R.id.textView);

        /* 0 Adj, 1 adj, 2 bodyPart, 3 noun, 4 animal, 5 verb - 6
         * 6 adverb, 7 noun, 8 adj, 9 noun - 4
         * 10 verb, 11 noun, 12 bodyPart, 13 noun - 4
         * 14 adverb, 15 verb, 16 verb, 17 exclamation, 18 past tense verb, 19 past tense verb - 6
         * 20 number, 21 number, 22 verb, 23 verb, 24 verb - 5
         * 25 adverb - 1
         */
        String madLib = String.format(
                "When we first met, you looked %1$s and %2$s. I couldn't believe my %3$s! You smelled like %4$s and walked as graceful as a %5$s. I couldn't wait to %6$s to you.\n"
                +"I %7$s asked you if I could have your %8$s. I could see a look of %9$s in your eyes. You hesitated for a moment, then gave me a %10$s.\n"
                +"I finally got to take you on our first date. I loved spending time with you. You could make me %11$s so easily, like no one had before. When you touched me, "
                +"I felt %12$s up my %13$s. When you looked at me, I could see %14$s. I knew we were meant to be together.\n"
                +"After a %15$s night, I was so %16$s to bring you home. I longed to %17$s you again. You looked at me and said '%18$s' and I just knew. You %19$s me and I %20$s you.\n"
                +"Here we are after all this time. It feels like it's been %21$s years! I look forward to %22$s more. You make me want to %23$s and I will %24$s you forever. "
                +"Nobody else could %25$s me like you do.\n"
                +"%26$s yours,\nMe <3", (Object[])valuesArray);

        textView.setText(madLib);
    }
}
