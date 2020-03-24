package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivBakso, ivNasi, ivSate;
    TextView tvBakso, tvNasi, tvSate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBakso = findViewById(R.id.iv_bakso);
        ivNasi = findViewById(R.id.iv_nasi);
        ivSate = findViewById(R.id.iv_sate);
        tvBakso = findViewById(R.id.tv_desk_bakso);
        tvNasi = findViewById(R.id.tv_desk_nasi);
        tvSate = findViewById(R.id.tv_desk_sate);

        ivSate.setOnClickListener(this);
        ivBakso.setOnClickListener(this);
        ivNasi.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iv_bakso:
                Intent intentbakso = new Intent(getApplicationContext(), OrderActivity.class);
                intentbakso.putExtra("orderan", tvBakso.getText().toString());
                startActivity(intentbakso);
                break;
            case R.id.iv_sate:
                Intent intentsate = new Intent(getApplicationContext(), OrderActivity.class);
                intentsate.putExtra("orderan", tvSate.getText().toString());
                startActivity(intentsate);
                break;
            case R.id.iv_nasi:
                Intent intentnasi = new Intent(getApplicationContext(), OrderActivity.class);
                intentnasi.putExtra("orderan", tvNasi.getText().toString());
                startActivity(intentnasi);
                break;

        }

    }
}
