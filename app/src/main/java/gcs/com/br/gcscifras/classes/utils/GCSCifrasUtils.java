package gcs.com.br.gcscifras.classes.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import gcs.com.br.gcscifras.R;

/**
 * Created by welisson on 15/04/17.
 */

public class GCSCifrasUtils {

    public static void showToast(Context context, CharSequence text)
    {
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public static void showError(Context context, String message) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static String dateToString(Date date)
    {
        //SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        return out.format(date);
    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static void openActivity(Context context, Class activityClass)
    {
        openActivity(context, activityClass, null);
    }

    public static void openActivity(Context context, Class activityClass, Bundle params)
    {
        Intent i = new Intent(context, activityClass);

        if (params != null)
            i.putExtras(params);

        context.startActivity(i);
    }

    public static void abreMensagemSimNao(Context context, String msg,
                                          DialogInterface.OnClickListener clSim,
                                          DialogInterface.OnClickListener clNao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("SBeauty")
                .setMessage(msg)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(R.string.sim, clSim)
                .setNegativeButton(R.string.nao, clNao)						//Do nothing on no
                .show();
    }

}
