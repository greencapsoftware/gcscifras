package gcs.com.br.gcscifras.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

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

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(false)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP

        Bundle b = getIntent().getExtras();
        int modo = b.getInt("modo");

        //Busca de Cifras
        if (modo == -1)
        {
            String query = b.getString("query");
            CifrasUtils.buscaCifras(modo, query, ListViewActivity.this,
                    onCallBaseListenerListaCifras);
        }
        else {
            CifrasUtils.listaCifras(modo, ListViewActivity.this, onCallBaseListenerListaCifras);
        }
    }

    private OnCallBaseListListener onCallBaseListenerListaCifras = new OnCallBaseListListener() {

        @Override
        public void onCallBaseListResult(List<Cifra> c) {
            if (c != null) {
                _adapter = new ListViewAdapter(ListViewActivity.this, c);
                _rvCifras.setAdapter(_adapter);
            }
        }
    };
}