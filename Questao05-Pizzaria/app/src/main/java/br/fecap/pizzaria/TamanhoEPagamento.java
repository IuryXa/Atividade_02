package br.fecap.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TamanhoEPagamento extends AppCompatActivity {

    private RadioButton rbTamanhoPequena, rbTamanhoMedia, rbTamanhoGrande, rbDinheiro, rbCredito, rbDebito, rbPix;
    private Button btnFinalizar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tamanho_epagamento);

        Bundle bundle = getIntent().getExtras();

        rbTamanhoPequena = findViewById(R.id.rbTamanhoPequena);
        rbTamanhoMedia = findViewById(R.id.rbTamanhoMedia);
        rbTamanhoGrande = findViewById(R.id.rbTamanhoGrande);
        rbDinheiro = findViewById(R.id.rbDinheiro);
        rbCredito = findViewById(R.id.rbCredito);
        rbDebito = findViewById(R.id.rbDebito);
        rbPix = findViewById(R.id.rbPix);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnFinalizar.setOnClickListener(view->{
            intent = new Intent(this, ResumoPedido.class);
            CheckBoxTamanho();
            MetodoPagamento();
            intent.putExtra("sabor1", bundle.getString("sabor1"));
            intent.putExtra("sabor2", bundle.getString("sabor2"));
            intent.putExtra("sabor3", bundle.getString("sabor3"));
            intent.putExtra("precosabor1", bundle.getDouble("precosabor1"));
            intent.putExtra("precosabor2", bundle.getDouble("precosabor2"));
            intent.putExtra("precosabor3", bundle.getDouble("precosabor3"));
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void CheckBoxTamanho(){
        if (rbTamanhoPequena.isChecked()){
            intent.putExtra("tamanho",rbTamanhoPequena.getText().toString());
            intent.putExtra("preco", 1.0);
        } else if (rbTamanhoMedia.isChecked()) {
            intent.putExtra("tamanho", rbTamanhoMedia.getText().toString());
            intent.putExtra("preco", 1.2);
        } else if (rbTamanhoGrande.isChecked()) {
            intent.putExtra("tamanho", rbTamanhoGrande.getText().toString());
            intent.putExtra("preco", 1.4);
        }
    }

    private void MetodoPagamento(){
        if (rbDinheiro.isChecked()){
            intent.putExtra("pagamento", "dinheiro");
        } else if (rbDebito.isChecked()) {
            intent.putExtra("pagamento","cartão de débito");
        } else if (rbCredito.isChecked()) {
            intent.putExtra("pagamento","cartão de crédito");
        } else if (rbPix.isChecked()) {
            intent.putExtra("pagamento", "pix");
        }
    }

}