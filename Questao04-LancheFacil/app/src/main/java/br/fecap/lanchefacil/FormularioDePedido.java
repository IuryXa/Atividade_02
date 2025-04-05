package br.fecap.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioDePedido extends AppCompatActivity {

    private EditText nomeText;
    private RadioButton rbPedido1, rbPedido2, rbPedido3;
    private Button btnFazerPedido;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_de_pedido);

        nomeText = findViewById(R.id.editTextNome);
        rbPedido1 = findViewById(R.id.rbPedido1);
        rbPedido2 = findViewById(R.id.rbPedido2);
        rbPedido3 = findViewById(R.id.rbPedido3);
        btnFazerPedido = findViewById(R.id.btnFazerPedido);

        btnFazerPedido.setOnClickListener(view ->{
            String nome = nomeText.getText().toString();
            intent = new Intent(this, ResumoDoPedido.class);
            intent.putExtra("nome",nome);
            CheckBoxPedido();
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void CheckBoxPedido(){
        if(rbPedido1.isChecked()){
            intent.putExtra("pedido", rbPedido1.getText().toString());
        } else if (rbPedido2.isChecked()) {
            intent.putExtra("pedido", rbPedido2.getText().toString());
        } else if (rbPedido3.isChecked()) {
            intent.putExtra("pedido", rbPedido3.getText().toString());
        }
    }
}