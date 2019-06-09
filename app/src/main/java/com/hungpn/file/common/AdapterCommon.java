package com.hungpn.file.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AdapterCommon<
        HD extends RecyclerView.ViewHolder,
        T,
        In extends InterAdapter<T>>
        extends RecyclerView.Adapter<HD> {
    protected In inter;

    public AdapterCommon(In inter) {
        this.inter = inter;
    }

    protected abstract int getLayoutMain();

    protected abstract HD getHD(View itemView);

    @NonNull
    @Override
    public HD onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        return getHD(LayoutInflater.from(viewGroup.getContext()).inflate(
                getLayoutMain(), viewGroup, false
        ));
    }

    @Override
    public int getItemCount() {
        return inter.getCount();
    }
}
