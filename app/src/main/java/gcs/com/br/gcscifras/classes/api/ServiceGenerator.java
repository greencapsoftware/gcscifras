package gcs.com.br.gcscifras.classes.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gcs.com.br.gcscifras.classes.utils.GCSCifrasConstants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by welisson on 15/04/17.
 */

public class ServiceGenerator {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Gson gs = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            //.registerTypeAdapter(AgendaUsuario.class,
            //        new AgendaDeserializer())
            .create();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(GCSCifrasConstants.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create());
    //.addConverterFactory(GsonConverterFactory.create(gs));

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}