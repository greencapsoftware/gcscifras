package gcs.com.br.gcscifras.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import gcs.com.br.gcscifras.R;
import gcs.com.br.gcscifras.classes.domain.BaseClass;
import gcs.com.br.gcscifras.classes.domain.Cifra;
import gcs.com.br.gcscifras.classes.utils.CifrasUtils;
import gcs.com.br.gcscifras.interfaces.OnCallBaseListListener;
import gcs.com.br.gcscifras.interfaces.OnCallBaseListener;

public class ListViewActivity extends AppCompatActivity {

    RecyclerView _rvCifras;
    private ListViewAdapter _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        setControls();
        initialize();
    }

    private void setControls() {
        _rvCifras = (RecyclerView)findViewById(R.id.rvCifras);
        _rvCifras.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initialize() {

        Bundle b = getIntent().getExtras();
        int modo = b.getInt("modo");

        CifrasUtils.listaCifras(modo, ListViewActivity.this, new OnCallBaseListListener() {
            @Override
            public void onCallBaseListResult(List<Cifra> c) {
                if (c != null) {
                    _adapter = new ListViewAdapter(ListViewActivity.this, c);
                    _rvCifras.setAdapter(_adapter);
                }
            }
        });


    }
}