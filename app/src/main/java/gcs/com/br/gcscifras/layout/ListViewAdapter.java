package gcs.com.br.gcscifras.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.io.InputStream;
import java.util.List;

import gcs.com.br.gcscifras.R;
import gcs.com.br.gcscifras.classes.domain.BaseClass;
import gcs.com.br.gcscifras.classes.domain.Cifra;
import gcs.com.br.gcscifras.classes.utils.CifrasUtils;
import gcs.com.br.gcscifras.classes.utils.GCSCifrasConstants;
import gcs.com.br.gcscifras.classes.utils.GCSCifrasUtils;
import gcs.com.br.gcscifras.interfaces.OnCallBaseListener;

/**
 * Created by welisson on 17/04/17.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.CustomViewHolder> {
    private List<Cifra> _cifrasItemList;
    private Context _context;

    public ListViewAdapter(Context context, List<Cifra> cifrasItemList) {
        this._cifrasItemList = cifrasItemList;
        this._context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listviewrow, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int i) {
        final Cifra cifra = _cifrasItemList.get(i);

        //Setting text view title
        //customViewHolder.tvLineOne.setText(Html.fromHtml(cifra.getNome()));
        customViewHolder.tvLineOne.setText(cifra.getNome() + " - " + cifra.getArtista());
        customViewHolder.tvLineTwoo.setText(cifra.getAlbum() + " - " + cifra.getGenero() + " - " + cifra.getAnoLancamento());
        customViewHolder.tvQtdAcessos.setText(String.valueOf(cifra.getQtdAcessos()) + " Acessos");
        customViewHolder.id = cifra.getId();
        customViewHolder.rbPontuacao.setRating(cifra.getPontuacao());

        setImage(customViewHolder.ivCardBgd,
                cifra.getUrlCapa());

        customViewHolder.btLinkCifra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("id", customViewHolder.id);
                GCSCifrasUtils.openActivity(_context, ViewCifraActivity.class, b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != _cifrasItemList ? _cifrasItemList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvLineOne, tvLineTwoo, tvQtdAcessos;
        protected Button btLinkCifra;
        protected ImageView ivCardBgd;
        protected RatingBar rbPontuacao;
        protected int id;

        public CustomViewHolder(View view) {
            super(view);
            this.tvLineOne = (TextView) view.findViewById(R.id.tvLineOne);
            this.tvLineTwoo = (TextView) view.findViewById(R.id.tvLineTwoo);
            this.btLinkCifra = (Button) view.findViewById(R.id.btLinkCifra);
            this.tvQtdAcessos = (TextView) view.findViewById(R.id.tvQtdAcessos);
            this.ivCardBgd = (ImageView) view.findViewById(R.id.ivCardBgd);
            this.rbPontuacao = (RatingBar) view.findViewById(R.id.rbPontuacao);
        }
    }

    private void setImage(ImageView iv, String url)
    {
        ImageLoader imageLoader = ImageLoader.getInstance(); // Get singleton instance

        // Load image, decode it to Bitmap and display Bitmap in ImageView (or any other view
        //  which implements ImageAware interface)
        imageLoader.displayImage(url,
                iv
                        /*, defaultOptions*/);
    }


}
