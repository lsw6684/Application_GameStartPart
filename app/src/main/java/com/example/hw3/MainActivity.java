package com.example.hw3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox start;
    TextView intro, select;
    ImageView ImgPet, doctor;
    RadioGroup rg;
    RadioButton bt1, bt2, bt3;
    Button end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (CheckBox) findViewById(R.id.start);
        intro = (TextView) findViewById(R.id.intro);
        select = (TextView) findViewById(R.id.select);
        doctor = (ImageView) findViewById(R.id.doctor);

        ImgPet = (ImageView) findViewById(R.id.ImgPet);

        rg = (RadioGroup) findViewById(R.id.rg);

        end = (Button) findViewById(R.id.end);
        bt1 = (RadioButton) findViewById(R.id.bt1);
        bt2 = (RadioButton) findViewById(R.id.bt2);
        bt3 = (RadioButton) findViewById(R.id.bt3);
        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonBiew, boolean isChecked) {
                if (start.isChecked() == true) {
                    intro.setVisibility(android.view.View.GONE);
                    doctor.setVisibility(android.view.View.GONE);
                    start.setVisibility(android.view.View.VISIBLE);
                    select.setVisibility(android.view.View.VISIBLE);
                    rg.setVisibility(android.view.View.VISIBLE);
                    ImgPet.setVisibility(android.view.View.VISIBLE);
                    end.setVisibility(android.view.View.VISIBLE);

                } else {
                    intro.setVisibility(android.view.View.VISIBLE);
                    doctor.setVisibility(android.view.View.VISIBLE);
                    select.setVisibility(android.view.View.INVISIBLE);
                    rg.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bt1:
                        ImgPet.setImageResource(R.drawable.chikorita);
                        break;
                    case R.id.bt2:
                        ImgPet.setImageResource(R.drawable.cyndaquil);
                        break;
                    case R.id.bt3:
                        ImgPet.setImageResource(R.drawable.totodile);
                        break;
                }

            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                ImgPet.setImageResource(R.drawable.ash_ketchum);

                RadioButton bt = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                if(bt != null){
                String str = bt.getText().toString();
                Toast.makeText(getApplicationContext(), str + " 너로 정했다!",
                        Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}

