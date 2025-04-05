package br.fecap.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmacaoCadastro extends AppCompatActivity {

    private TextView textBoasVindas;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacao_cadastro);

        Bundle bundle = getIntent().getExtras();

        String nome = bundle.getString("nome");
        textBoasVindas = findViewById(R.id.textBoasVindas);
        String mensagem = "Parabéns! Você acabou de concluir o seu cadastro! Seja bem-vindo(a) " + nome;
        textBoasVindas.setText(mensagem);

        btnFechar = findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(view ->{
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