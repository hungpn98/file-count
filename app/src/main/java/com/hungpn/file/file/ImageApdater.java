package com.hungpn.file.file;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hungpn.file.GlideApp;
import com.hungpn.file.R;
import com.hungpn.file.common.AdapterCommon;
import com.hungpn.file.common.InterAdapter;

import java.io.File;

public class ImageApdater extends AdapterCommon<
        ImageApdater.ImageViewHolder,
        ItemFile,
        ImageApdater.IIImage> {

    public ImageApdater(IIImage inter) {
        super(inter);
    }

    @Override
    protected int getLayoutMain() {
        return R.layout.item_imageview;
    }

    @Override
    protected ImageViewHolder getHD(View itemView) {
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, final int position) {
        ItemFile item = inter.getData(position);
        GlideApp.with(imageViewHolder.itemView.getContext())
                .load(new File(item.getPath()))
                .placeholder(R.drawable.background_downloads)
                .error(R.drawable.background_downloads)
                .centerCrop()
                .into(imageViewHolder.ivImage);
        imageViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inter.onClickItem(position);
            }
        });
    }
    public interface IIImage extends InterAdapter<ItemFile>{
        void onClickItem(int position);
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivImage;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image_view);
        }
    }
}
