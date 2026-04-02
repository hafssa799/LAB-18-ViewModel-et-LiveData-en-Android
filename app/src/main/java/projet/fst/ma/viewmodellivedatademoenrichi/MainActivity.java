package projet.fst.ma.viewmodellivedatademoenrichi;

import android.os.Bundle;import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private CounterViewModel viewModel;
    private TextView tvCount;
    private Button btnIncrement, btnDecrement, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison avec le XML (IDs vérifiés dans votre activity_main.xml)
        tvCount = findViewById(R.id.tvCount);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnDecrement = findViewById(R.id.btnDecrement);
        btnReset = findViewById(R.id.btnReset);

        // 1. Initialisation du ViewModel
        viewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        // 2. Observation du LiveData (Magie de la mise à jour automatique)
        viewModel.getCount().observe(this, newCount -> {
            tvCount.setText(String.valueOf(newCount));
        });

        // 3. Actions sur les boutons
        btnIncrement.setOnClickListener(v -> viewModel.increment());
        btnDecrement.setOnClickListener(v -> viewModel.decrement());
        btnReset.setOnClickListener(v -> viewModel.reset());
    }
}