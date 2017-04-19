package gcs.com.br.gcscifras.classes.utils;

import android.content.Context;
import android.view.View;

import java.util.List;

import gcs.com.br.gcscifras.classes.api.CifrasAPI;
import gcs.com.br.gcscifras.classes.api.ServiceGenerator;
import gcs.com.br.gcscifras.classes.domain.BaseClass;
import gcs.com.br.gcscifras.classes.domain.Cifra;
import gcs.com.br.gcscifras.interfaces.OnCallBaseListListener;
import gcs.com.br.gcscifras.interfaces.OnCallBaseListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by welisson on 15/04/17.
 */

public class CifrasUtils {

    public static void chamaCifra(int id, final Context context, final OnCallBaseListener listener)
    {
        CifrasAPI api = ServiceGenerator.createService(CifrasAPI.class);

        try {
            Call<Cifra> call = api.cifra(0, id);
            call.enqueue(new Callback<Cifra>() {

                @Override
                public void onResponse(Call<Cifra> call, Response<Cifra> response) {

                    if (response.isSuccessful()) {
                        Cifra c = response.body();

                        if (listener != null)
                            listener.onCallBaseResult(c);
                    }
                }

                @Override
                public void onFailure(Call<Cifra> call, Throwable t) {
                    GCSCifrasUtils.showError(context, t.getMessage());
                }
            });

        } catch (Exception ex) {
            GCSCifrasUtils.showError(context, ex.getMessage());
        }
    }

    public static void listaCifras(int modo, final Context context, final OnCallBaseListListener listener)
    {
        CifrasAPI api = ServiceGenerator.createService(CifrasAPI.class);

        try {
            Call<List<Cifra>> call = api.listaCifras(modo);
            call.enqueue(new Callback<List<Cifra>>() {

                @Override
                public void onResponse(Call<List<Cifra>> call, Response<List<Cifra>> response) {

                    if (response.isSuccessful()) {
                        List<Cifra> c = response.body();

                        if (listener != null)
                            listener.onCallBaseListResult(c);
                    }
                }

                @Override
                public void onFailure(Call<List<Cifra>> call, Throwable t) {
                    GCSCifrasUtils.showError(context, t.getMessage());
                }
            });

        } catch (Exception ex) {
            GCSCifrasUtils.showError(context, ex.getMessage());
        }
    }

    public static void buscaCifras(int modo, String query, final Context context, final OnCallBaseListListener listener)
    {
        CifrasAPI api = ServiceGenerator.createService(CifrasAPI.class);

        try {
            Call<List<Cifra>> call = api.buscaCifras(modo, query);
            call.enqueue(new Callback<List<Cifra>>() {

                @Override
                public void onResponse(Call<List<Cifra>> call, Response<List<Cifra>> response) {

                    if (response.isSuccessful()) {
                        List<Cifra> c = response.body();

                        if (listener != null)
                            listener.onCallBaseListResult(c);
                    }
                }

                @Override
                public void onFailure(Call<List<Cifra>> call, Throwable t) {
                    GCSCifrasUtils.showError(context, t.getMessage());
                }
            });

        } catch (Exception ex) {
            GCSCifrasUtils.showError(context, ex.getMessage());
        }
    }

    public static void totalCifras(final Context context, final OnCallBaseListener listener)
    {
        CifrasAPI api = ServiceGenerator.createService(CifrasAPI.class);

        try {
            Call<Cifra> call = api.totalCifras();
            call.enqueue(new Callback<Cifra>() {

                @Override
                public void onResponse(Call<Cifra> call, Response<Cifra> response) {

                    if (response.isSuccessful()) {
                        Cifra c = response.body();

                        if (listener != null)
                            listener.onCallBaseResult(c);
                    }
                }

                @Override
                public void onFailure(Call<Cifra> call, Throwable t) {
                    GCSCifrasUtils.showError(context, t.getMessage());
                }
            });

        } catch (Exception ex) {
            GCSCifrasUtils.showError(context, ex.getMessage());
        }
    }
}
