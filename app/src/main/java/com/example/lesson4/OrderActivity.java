package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    String  nama, address, phone, note;
    TextView tvTerima, tvSubNama, tvSubAddress, tvSubPhone, tvSubNote, tvSubChoose;
    EditText etNama, etAddress, etPhone, etNote;
    Button btnSubmit;
    RadioGroup rgDeliv;
    RadioButton r;

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

        rgDeliv = findViewById(R.id.radioGroup);

        btnSubmit = findViewById(R.id.btn_submit);

        tvSubNama = findViewById(R.id.tv_submit_nama);
        tvSubPhone = findViewById(R.id.tv_submit_phone);
        tvSubAddress = findViewById(R.id.tv_submit_address);
        tvSubNote = findViewById(R.id.tv_submit_note);
        tvSubChoose = findViewById(R.id.tv_submit_deliv);

        tvTerima.setText(getIntent().getStringExtra("orderan"));

        btnSubmit.setOnClickListener(this);
        rbSame.setOnClickListener(this);
        rbPickup.setOnClickListener(this);
        rbNext.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_next:
                Toast.makeText(getApplicationContext(), "Next day ground delivery", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb_same:
                Toast.makeText(getApplicationContext(), "Same day messenger service", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb_pickup:
                Toast.makeText(getApplicationContext(), "Pickup", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_submit:
                nama = etNama.getText().toString();
                address = etAddress.getText().toString();
                phone = etPhone.getText().toString();
                note = etNote.getText().toString();

                int radioButtonID = rgDeliv.getCheckedRadioButtonId();
                View radioButton = rgDeliv.findViewById(radioButtonID);
                int idButton = rgDeliv.indexOfChild(radioButton);
                r = (RadioButton) rgDeliv.getChildAt(idButton);

                if (nama.isEmpty() && address.isEmpty() && phone.isEmpty() && note.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Tolong isi semua pertanyaan", Toast.LENGTH_LONG).show();
                }else {
                    if (rgDeliv.getCheckedRadioButtonId() == -1){
                        Toast.makeText(getApplicationContext(), "Tolong isi metode pengiriman", Toast.LENGTH_LONG).show();
                    }else {
                        tvSubNama.setText(etNama.getText().toString());
                        tvSubAddress.setText(etAddress.getText().toString());
                        tvSubPhone.setText(etPhone.getText().toString());
                        tvSubNote.setText(etNote.getText().toString());
                        tvSubChoose.setText(r.getText().toString());
                    }
                }




        }
    }
}
