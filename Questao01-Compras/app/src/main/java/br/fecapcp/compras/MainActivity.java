package br.fecapcp.compras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbRefrigerante;
    private Button btnTotal;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbRefrigerante = findViewById(R.id.cbRefrigerante);
        resultado = findViewById(R.id.textResultado);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void EscolhaCheckBox(View view){
        Double valorTotal = 0.0;
        if(cbArroz.isChecked()){
            valorTotal += 2.69;
        }
        if (cbLeite.isChecked()){
            valorTotal +=2.7;
        }
        if(cbCarne.isChecked()){
            valorTotal +=16.7;
        }
        if (cbFeijao.isChecked()){
            valorTotal +=3.38;
        }
        if(cbRefrigerante.isChecked()){
            valorTotal +=3.0;
        }
        resultado.setText("O resultado é R$" + valorTotal);
    }
}