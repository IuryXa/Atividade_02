package br.fecap.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbCalabresa, cbMarguerita, cbPortuguesa;
    private Button btnEscolherSabor;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbMarguerita = findViewById(R.id.cbMarguerita);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        btnEscolherSabor = findViewById(R.id.btnEscolherSabor);

        btnEscolherSabor.setOnClickListener(view ->{
            intent = new Intent(this, TamanhoEPagamento.class);
            CheckBoxEscolher();
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void CheckBoxEscolher(){
        String sabor1 = "", sabor2 = "", sabor3 = "";
        double precoSabor1=0.0, precoSabor2=0.0, precoSabor3=0.0;
        if(cbCalabresa.isChecked()){
            sabor1 = "Calabresa";
            precoSabor1 = 40.00;
        }
        if (cbPortuguesa.isChecked()){
            sabor2 = "Portuguesa";
            precoSabor2 = 42.00;
        }
        if (cbMarguerita.isChecked()){
            sabor3 = "Marguerita";
            precoSabor3 = 45.00;
        }
        intent.putExtra("precosabor1", precoSabor1);
        intent.putExtra("precosabor2", precoSabor2);
        intent.putExtra("precosabor3", precoSabor3);
        intent.putExtra("sabor1", sabor1);
        intent.putExtra("sabor2", sabor2);
        intent.putExtra("sabor3", sabor3);
    }
}