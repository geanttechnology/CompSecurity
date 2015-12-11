// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

public class SortAdapter extends BaseAdapter
{

    private ArrayList array;
    private Context ctx;
    String currentPlaylistId;
    SongItem currentSong;
    LayoutInflater mInflater;

    public SortAdapter(Context context, ArrayList arraylist)
    {
        ctx = context;
        array = arraylist;
        mInflater = (LayoutInflater)ctx.getSystemService("layout_inflater");
    }

    public int getCount()
    {
        return array.size();
    }

    public Object getItem(int i)
    {
        return array.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        if (view == null)
        {
            view1 = mInflater.inflate(0x7f030050, null);
            viewgroup = new ViewHolder(null);
            viewgroup.tvName = (TextView)view1.findViewById(0x7f0700fa);
            viewgroup.tvTime = (TextView)view1.findViewById(0x7f070124);
            viewgroup.iv = (ImageView)view1.findViewById(0x7f070123);
            view1.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
            view1 = view;
        }
        ((ViewHolder) (viewgroup)).tvName.setText(((SongItem)array.get(i)).getSongName());
        ((ViewHolder) (viewgroup)).tvTime.setText(MixerBoxUtils.getSongTime(((SongItem)array.get(i)).getSongTime()));
        if (((SongItem)array.get(i)).getSongSource() == 3)
        {
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                view = new android.widget.RelativeLayout.LayoutParams(ctx.getResources().getDimensionPixelSize(0x7f0b0041), ctx.getResources().getDimensionPixelSize(0x7f0b0042));
                ((ViewHolder) (viewgroup)).iv.setLayoutParams(view);
            }
            view = ((SongItem)array.get(i)).getSongThumbnail();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            view = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(((SongItem)array.get(i)).getSongYtId()).append("/mqdefault.jpg").toString();
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(ctx.getResources().getDimensionPixelSize(0x7f0b0041), ctx.getResources().getDimensionPixelSize(0x7f0b0042));
            ((ViewHolder) (viewgroup)).iv.setLayoutParams(layoutparams);
        } else
        {
            view = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(((SongItem)array.get(i)).getSongYtId()).append("/default.jpg").toString();
        }
        ImageLoader.getInstance().displayImage(view, ((ViewHolder) (viewgroup)).iv);
        return view1;
    }

    private class ViewHolder
    {

        public ImageView iv;
        public TextView tvName;
        public TextView tvTime;

        private ViewHolder()
        {
        }

        ViewHolder(_cls1 _pcls1)
        {
            this();
        }
    }

}
