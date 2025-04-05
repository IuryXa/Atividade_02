package br.fecap.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class ResumoPedido extends AppCompatActivity {

    private TextView resumoPedido;
    private Button btnFechar;
    private String resumo;
    private double total;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);

        bundle = getIntent().getExtras();

        resumoPedido = findViewById(R.id.textResumo);
        btnFechar = findViewById(R.id.btnFechar);
        ResumoMensagem();

        btnFechar.setOnClickListener(view->{
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

    private void ResumoMensagem(){
        resumo = "Aqui está o resumo do seu pedido:\n";
        String sabor1 = bundle.getString("sabor1");
        String sabor2 = bundle.getString("sabor2");
        String sabor3 = bundle.getString("sabor3");
        String tamanho = bundle.getString("tamanho");
        double preco1 = bundle.getDouble("precosabor1");
        double preco2 = bundle.getDouble("precosabor2");
        double preco3 = bundle.getDouble("precosabor3");
        double precoTamanho = bundle.getDouble("preco");
        String pagamento = bundle.getString("pagamento");
        DecimalFormat numeroFormatado = new DecimalFormat("#.00");
        total = 0.0;
        if(sabor1.isEmpty()){
        }else{
            preco1 *= precoTamanho;
            resumo += "Uma pizza de " + sabor1 +"\n Tamanho: " + tamanho + "(R$" + numeroFormatado.format(preco1) + ")\n";
            total +=preco1;
        }
        if (sabor2.isEmpty()){
        }else{
            preco2 *= precoTamanho;
            resumo += "Uma pizza de " + sabor2 +"\n Tamanho: " + tamanho + "(R$" + numeroFormatado.format(preco2) + ")\n";
            total +=preco2;
        }
        if (sabor3.isEmpty()){
        }else{
            preco3 *= precoTamanho;
            resumo += "Uma pizza de " + sabor3 +"\n Tamanho: " + tamanho + "(R$" + numeroFormatado.format(preco3) + ")\n";
            total +=preco3;
        }
        resumo +="O valor total é de R$" + numeroFormatado.format(total) + "\nO método de pagamento escolhido foi "+ pagamento;
        resumoPedido.setText(resumo);
    }

}