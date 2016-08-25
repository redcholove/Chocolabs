package com.example.redcholove.chocolabs;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by redcholove on 2016/8/25.
 */
public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder> {

    private Context context;
    private ArrayList<Channel> channels;

    public ChannelAdapter(Context context, ArrayList<Channel> channels){
        this.context = context;
        this.channels = channels;
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext())
                .inflate(R.layout.channel_cardview_layout, parent, false);

        ChannelViewHolder channelViewHolder = new ChannelViewHolder(view);
        return channelViewHolder;
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int position) {
        Channel channel = channels.get(position);
        holder.tvChannelTitle.setText(channel.ChannelTitle);
        holder.tvChannelIntro.setText(channel.ChannelIntro);
        Picasso.with(context).
                load(channel.ChannelIcon).
                placeholder(R.drawable.pp).
                error(android.R.drawable.stat_notify_error).
                into(holder.ivChannelIcon);
    }

    @Override
    public int getItemCount() {
        if(channels != null){
            return channels.size();
        }
        return 0;
    }


    //ViewHolder class
    public static class ChannelViewHolder extends RecyclerView.ViewHolder{

        public CardView cvChannel;
        public ImageView ivChannelIcon;
        public TextView tvChannelIntro,tvChannelTitle;

        public ChannelViewHolder(View itemView) {
            super(itemView);
            cvChannel = (CardView)itemView.findViewById(R.id.cvChannel);
            ivChannelIcon = (ImageView)itemView.findViewById(R.id.ivChannelIcon);
            tvChannelTitle = (TextView)itemView.findViewById(R.id.tvChannelTitle);
            tvChannelIntro = (TextView)itemView.findViewById(R.id.tvChannelIntro);

        }
    }
}
