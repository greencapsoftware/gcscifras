package gcs.com.br.gcscifras.interfaces;

import java.util.List;

import gcs.com.br.gcscifras.classes.domain.BaseClass;
import gcs.com.br.gcscifras.classes.domain.Cifra;

/**
 * Created by welisson on 16/04/17.
 */

public interface OnCallBaseListListener {
    /**
     * Called when a view has been clicked.
     *
     * @param c The base class that resulted.
     */
    void onCallBaseListResult(List<Cifra> c);
}