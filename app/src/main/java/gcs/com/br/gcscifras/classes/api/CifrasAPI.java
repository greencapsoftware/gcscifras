package gcs.com.br.gcscifras.classes.api;

import java.util.List;

import gcs.com.br.gcscifras.classes.domain.Cifra;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by welisson on 15/04/17.
 */

public interface CifrasAPI {
    @FormUrlEncoded
    @POST("ctrlcifrasandroid.php")
    Call<Cifra> cifra(@Field("modo") int modo, @Field("id") int id);

    @FormUrlEncoded
    @POST("ctrlcifrasandroid.php")
    Call<List<Cifra>> listaCifras(@Field("modo") int modo);

    @FormUrlEncoded
    @POST("ctrlcifrasandroid.php")
    Call<List<Cifra>> buscaCifras(@Field("modo") int modo, @Field("q") String query);
}
