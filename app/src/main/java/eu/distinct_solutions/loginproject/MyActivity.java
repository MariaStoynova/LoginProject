package eu.distinct_solutions.loginproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MyActivity extends AppCompatActivity {


    private TextView m_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        this.m_textView = findViewById(R.id.textView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Boolean isFirst=getIntent().getBooleanExtra("isFirst",true );
        if(!isFirst){
            m_textView.setText("Welcome Back!");
        }
    }

    public static int Sum(int ... arr)
    {
        int sum = arr[0];
        for (int i=1; i<arr.length; i++) {
            sum += arr[i++];
        }
        return sum;
    }
}
