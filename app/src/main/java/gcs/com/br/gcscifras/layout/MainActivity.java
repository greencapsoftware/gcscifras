package gcs.com.br.gcscifras.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import gcs.com.br.gcscifras.R;
import gcs.com.br.gcscifras.classes.utils.GCSCifrasUtils;

public class MainActivity extends AppCompatActivity {

    Button _btnPorOrdem, _btnPorArtista, _btnPorGenero, _btnPorAlbum, _btnPorLancamento,
        _btnSearch;
    TextView _tvTotal;
    EditText _etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
        initialize();
    }

    private void initialize() {
        _tvTotal.setText(_tvTotal.getText().toString().replace("{0}", "1"));
    }

    private void setEvents() {
        if (_btnPorOrdem != null)
            _btnPorOrdem.setOnClickListener(onClickListenerOrdem);

        if (_btnPorArtista != null)
            _btnPorArtista.setOnClickListener(onClickListenerOrdem);

        if (_btnPorGenero != null)
            _btnPorGenero.setOnClickListener(onClickListenerOrdem);

        if (_btnPorAlbum != null)
            _btnPorAlbum.setOnClickListener(onClickListenerOrdem);

        if (_btnPorLancamento != null)
            _btnPorLancamento.setOnClickListener(onClickListenerOrdem);

        if (_btnSearch != null)
            _btnSearch.setOnClickListener(onClickListenerOrdem);
    }

    private View.OnClickListener onClickListenerOrdem = new View.OnClickListener() {

        public void onClick(View v) {
            Bundle b = new Bundle();

            switch(v.getId()) {
                case R.id.btnPorOrdem:
                    b.putInt("modo", 1);
                    break;
                case R.id.btnPorArtista:
                    b.putInt("modo", 2);
                    break;
                case R.id.btnPorGenero:
                    b.putInt("modo", 3);
                    break;
                case R.id.btnPorAlbum:
                    b.putInt("modo", 4);
                    break;
                case R.id.btnPorLancamento:
                    b.putInt("modo", 5);
                    break;
                case R.id.btnSearch:
                    b.putInt("modo", -1);
                    b.putString("query", _etSearch.getText().toString());
                    break;
            }

            GCSCifrasUtils.openActivity(MainActivity.this, ListViewActivity.class, b);
        }
    };

    private void setControls() {
        _btnPorOrdem = (Button)findViewById(R.id.btnPorOrdem);
        _btnPorArtista = (Button)findViewById(R.id.btnPorArtista);
        _btnPorGenero = (Button)findViewById(R.id.btnPorGenero);
        _btnPorAlbum = (Button)findViewById(R.id.btnPorAlbum);
        _btnPorLancamento = (Button)findViewById(R.id.btnPorLancamento);
        _btnSearch = (Button)findViewById(R.id.btnSearch);
        _etSearch = (EditText) findViewById(R.id.etSearch);

        _tvTotal = (TextView)findViewById(R.id.tvTotal);
    }
}
