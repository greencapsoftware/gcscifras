package gcs.com.br.gcscifras.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.Format;

import gcs.com.br.gcscifras.R;
import gcs.com.br.gcscifras.classes.domain.BaseClass;
import gcs.com.br.gcscifras.classes.domain.Cifra;
import gcs.com.br.gcscifras.classes.utils.CifrasUtils;
import gcs.com.br.gcscifras.classes.utils.GCSCifrasUtils;
import gcs.com.br.gcscifras.interfaces.OnCallBaseListener;

public class MainActivity extends AppCompatActivity {

    Button _btnPorOrdem;
    TextView _tvTotal;

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
            _btnPorOrdem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GCSCifrasUtils.openActivity(MainActivity.this, ListViewActivity.class);
                //GCSCifrasUtils.openActivity(MainActivity.this, ViewCifraActivity.class);
                }
            });
    }

    private void setControls() {
        _btnPorOrdem = (Button)findViewById(R.id.btnPorOrdem);

        _tvTotal = (TextView)findViewById(R.id.tvTotal);
    }
}
