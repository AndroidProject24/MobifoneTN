package com.toan_itc.tn.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.toan_itc.tn.Lib.ripeffect.RippleViewLinear;
import com.toan_itc.tn.Model.DStincanhanKhuyenmaiRealm;
import com.toan_itc.tn.R;
import com.toan_itc.tn.Utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC-07 on 7/20/2015.
 */
public class CaNhanKmAdapter extends RecyclerView.Adapter<CaNhanKmAdapter.ViewHolder> {
    protected final Context context;
    private boolean twoPane;
    private int selectedItem = -1;

    public interface OnItemClickListener {
        void onItemClick(String link);
    }

    public static final String LOG_TAG = CaNhanKmAdapter.class.getSimpleName();

    protected OnItemClickListener onItemClickListener;

    private List<DStincanhanKhuyenmaiRealm> articles;

    public CaNhanKmAdapter(@NonNull Context context, List<DStincanhanKhuyenmaiRealm> articles, OnItemClickListener onItemClickListener) {
        if (articles == null) {
            throw new IllegalArgumentException("articles cannot be null");
        }
        this.context = context;
        this.articles = articles;
        this.onItemClickListener = onItemClickListener;
    }

    public void setTwoPane(boolean twoPane) {
        this.twoPane = twoPane;
        Log.d(LOG_TAG, String.format("setTwoPane : %b", this.twoPane));
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(context,view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final DStincanhanKhuyenmaiRealm data = this.articles.get(position);
        viewHolder.setArticleTitle(data.getTenTin());
        if (!data.getTomtat().equalsIgnoreCase("")) {
            viewHolder.setArticleDetails(data.getTomtat());
        }
        if (twoPane) {
            if (selectedItem == position) {
                viewHolder.setSelected(true);
            } else {
                viewHolder.setSelected(false);
            }
        }

        viewHolder.setOnClickListener(view -> {
            if (twoPane) {
                int oldPosition = selectedItem;
                viewHolder.setSelected(true);
                selectedItem = position;
                notifyItemChanged(oldPosition);
            }
            onItemClickListener.onItemClick(data.getLink());
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public DStincanhanKhuyenmaiRealm getLastArticle() {
        if (articles.size() > 0) {
            return articles.get(articles.size() - 1);
        }
        return null;
    }

    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
         @BindView(R.id.txt_name)
        TextView mTxtName;
         @BindView(R.id.txt_tomtat)
        TextView mTxtTomtat;
        @BindView(R.id.layout_click)
        RippleViewLinear mLayoutClick;
        private Context context;

        public ViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this,itemView);
        }

        public void setArticleTitle(String title) {
            mTxtName.setText(title);
        }

        public void setArticleDetails(String author) {
            mTxtTomtat.setText(author);
        }

        public void setOnClickListener(View.OnClickListener listener) {
            itemView.setOnClickListener(listener);
        }

        @SuppressWarnings("deprecation")
        public void setSelected(boolean isSelected) {
            int color;
            if (Utils.isAndroid6())
                color = ContextCompat.getColor(context, android.R.color.transparent);
            else
                color = context.getResources().getColor(android.R.color.transparent);
            if (isSelected) {
                if (Utils.isAndroid6())
                    color = ContextCompat.getColor(context, android.R.color.white);
                else
                    color = context.getResources().getColor(android.R.color.white);
            }
            itemView.setBackgroundColor(color);
        }
    }
}