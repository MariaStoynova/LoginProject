package eu.distinct_solutions.loginproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText m_etName;
    private EditText m_etPassword;
    private Button mbtt;
    private boolean isFirst = true;
    private String name = "";
    private String password = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.m_etName = findViewById(R.id.etName);
        this.m_etPassword = findViewById(R.id.etPassword);
        this.mbtt = (Button) findViewById(R.id.button);

        mbtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        name = sp.getString("name", "");
        password = sp.getString("password", "");
        if (!name.equals("") && !password.equals("")) {
            isFirst = false;
            mbtt.setText("Login");
        }
    }

    void buttonClick() {
        if (isFirst) {
            //TODO добавете проверки за валидност на името и паролата
            SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("name", m_etName.getText().toString());
            editor.putString("password", m_etPassword.getText().toString());
            editor.apply();

        } else {
            if (!name.equals(m_etName.getText().toString()) || !password.equals(m_etPassword.getText().toString())) {
                Toast.makeText(MainActivity.this, "Wrong Name or Password!", Toast.LENGTH_LONG).show();
                return;
            }
        }
        Intent secondPage = new Intent(MainActivity.this, MyActivity.class);

        //Може да предатете флага isFirst като екстра или да вземете преференсите на втората страница
        secondPage.putExtra("isFirst", isFirst);
        startActivity(secondPage);

    }
}
