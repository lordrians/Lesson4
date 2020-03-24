package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    String pOrderan;
    TextView tvTerima;
    EditText etNama, etAddress, etPhone, etNote;

    RadioButton rbSame, rbNext, rbPickup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_activity);

        tvTerima = findViewById(R.id.tv_terima);
        etNama = findViewById(R.id.et_nama);
        etAddress = findViewById(R.id.et_address);
        etPhone = findViewById(R.id.et_phone);
        etNote = findViewById(R.id.et_note);
        rbNext = findViewById(R.id.rb_next);
        rbPickup = findViewById(R.id.rb_pickup);
        rbSame = findViewById(R.id.rb_same);

        tvTerima.setText(getIntent().getStringExtra("orderan"));

        rbSame.setOnClickListener(this);
        rbPickup.setOnClickListener(this);
        rbNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_next:
                Toast.makeText(getApplicationContext(), "Next day ground delivery", Toast.LENGTH_LONG).show();
                break;

            case R.id.rb_same:
                Toast.makeText(getApplicationContext(), "Same day messenger service", Toast.LENGTH_LONG).show();
                break;

            case R.id.rb_pickup:
                Toast.makeText(getApplicationContext(), "Pickup", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
