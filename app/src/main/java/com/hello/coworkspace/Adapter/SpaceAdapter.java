package com.hello.coworkspace.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hello.coworkspace.DetailsActivity;
import com.hello.coworkspace.Model.GetSpace;
import com.hello.coworkspace.Model.Space;
import com.hello.coworkspace.R;

import java.util.List;

public class SpaceAdapter extends RecyclerView.Adapter<SpaceAdapter.ViewHolder> {
    private List<Space> mSpaceList;
    private Context context;
    public SpaceAdapter(List <Space> KontakList) {
        mSpaceList = KontakList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        ViewHolder mViewHolder = new ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mTextViewNama.setText(mSpaceList.get(position).getSpace_name());
        Glide.with(holder.mTextViewNomor).load(Uri.parse(mSpaceList.get(position).getSpace_photo())).into(holder.mTextViewNomor);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("spacePhoto", mSpaceList.get(position).getSpace_photo());
                intent.putExtra("spaceName", mSpaceList.get(position).getSpace_name());
                intent.putExtra("spaceHours", mSpaceList.get(position).getSpace_hours());
                intent.putExtra("spaceAddress", mSpaceList.get(position).getSpace_address());
                intent.putExtra("spaceDescription", mSpaceList.get(position).getSpace_description());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSpaceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId;
        public TextView mTextViewNama;
        public ImageView mTextViewNomor;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewNama = (TextView) itemView.findViewById(R.id.spaceName);
            mTextViewNomor = (ImageView) itemView.findViewById(R.id.spacePhoto);
        }
    }
}
