package gcs.com.br.gcscifras.layout;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import gcs.com.br.gcscifras.R;
import gcs.com.br.gcscifras.classes.domain.BaseClass;
import gcs.com.br.gcscifras.classes.domain.Cifra;
import gcs.com.br.gcscifras.classes.utils.CifrasUtils;
import gcs.com.br.gcscifras.classes.utils.GCSCifrasUtils;
import gcs.com.br.gcscifras.interfaces.OnCallBaseListener;

public class ViewCifraActivity extends AppCompatActivity {

    Handler handler = new Handler();
    TextView _tvLineOne, _tvLineTwoo, _tvCifra;
    private int _cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cifra);

        setControls();
        initialize();
    }

    private void setControls() {
        _tvLineOne = (TextView)findViewById(R.id.tvLineOne);
        _tvLineTwoo = (TextView)findViewById(R.id.tvLineTwoo);
        _tvCifra = (TextView)findViewById(R.id.tvCifra);
        _tvCifra.setMovementMethod(new ScrollingMovementMethod());
    }

    private void initialize() {

        Bundle b = getIntent().getExtras();
        int id = b.getInt("id");

        CifrasUtils.chamaCifra(id, ViewCifraActivity.this, new OnCallBaseListener() {
            @Override
            public void onCallBaseResult(BaseClass c) {
                if (c != null)
                {
                    Cifra o = (Cifra) c;
                    _tvLineOne.setText(o.getArtista() + " - " + o.getNome());
                    _tvLineTwoo.setText(o.getAlbum() + " - " + o.getGenero() + " - " + o.getAnoLancamento());
                    _tvCifra.setText(o.getCifra());
                }
            }
        });

        autoScroll();
    }

    private void autoScroll() {
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    public void run() {
                        _cont++;

                        if (_cont < 30)
                            return;

                        int scrollPos = (int) (_tvCifra.getScrollY() + 50.0);
                        //_tvCifra.smoothScrollTo(0, scrollPos);
                        _tvCifra.scrollTo(0, scrollPos);
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 1000);
    }
}
