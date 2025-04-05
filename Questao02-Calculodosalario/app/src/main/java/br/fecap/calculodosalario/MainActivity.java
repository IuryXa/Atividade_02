package br.fecap.calculodosalario;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnEnviar;
    private EditText salario;
    private TextView resultado;
    private RadioButton rb40, rb45, rb50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        salario = findViewById(R.id.editTextSalario);
        resultado = findViewById(R.id.textResultado);
        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);

        btnEnviar = findViewById(R.id.btnCalculo);
        btnEnviar.setOnClickListener(view ->{
            CalcularSalario();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void CalcularSalario(){
        double salarioAtual = Double.parseDouble(salario.getText().toString());
        if(rb40.isChecked()){
            salarioAtual *= 1.40;
        } else if (rb45.isChecked()) {
            salarioAtual *= 1.45;
        } else if (rb50.isChecked()) {
            salarioAtual *= 1.50;
        }
        String resultadoText = "O seu salário foi reajustado para " + salarioAtual;
        resultado.setText(resultadoText);
    }
}