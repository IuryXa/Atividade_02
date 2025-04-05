package br.fecap.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoDoPedido extends AppCompatActivity {

    private TextView resumoPedido;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_do_pedido);

        Bundle bundle = getIntent().getExtras();
        resumoPedido = findViewById(R.id.textPedido);
        String nome = bundle.getString("nome");
        String pedido = bundle.getString("pedido");
        String mensagem = nome + ", aqui está o seu pedido:\n" + pedido;
        resumoPedido.setText(mensagem);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}