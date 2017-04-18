package gcs.com.br.gcscifras.interfaces;

import gcs.com.br.gcscifras.classes.domain.BaseClass;

/**
 * Created by welisson on 16/04/17.
 */

public interface OnCallBaseListener {
    /**
     * Called when a view has been clicked.
     *
     * @param c The base class that resulted.
     */
    void onCallBaseResult(BaseClass c);
}