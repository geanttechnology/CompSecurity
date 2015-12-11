// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.activity.VideoViewActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import java.util.List;

public class VideoDownloadedAdapter extends BaseAdapter
{
    class ViewHolder
    {

        ImageView my_delete_movie;
        TextView my_movie_name_item;
        Button my_stop_download_bt;
        ImageView my_test_head_image;
        TextView my_totalsize;
        final VideoDownloadedAdapter this$0;

        ViewHolder()
        {
            this$0 = VideoDownloadedAdapter.this;
            super();
        }
    }


    private MyApplcation app;
    Context ctx;
    private ViewHolder holder;
    private List list;

    public VideoDownloadedAdapter(Context context, List list1)
    {
        holder = null;
        ctx = context;
        list = list1;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public int getCount()
    {
        if (list != null && list.size() > 0)
        {
            return list.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, final ViewGroup in_fo)
    {
        in_fo = (DownloadMovieItem)list.get(position);
        if (view == null)
        {
            holder = new ViewHolder();
            view = View.inflate(ctx, 0x7f0300bb, null);
            holder.my_delete_movie = (ImageView)view.findViewById(0x7f0703ee);
            holder.my_test_head_image = (ImageView)view.findViewById(0x7f0703ef);
            holder.my_movie_name_item = (TextView)view.findViewById(0x7f0703f0);
            holder.my_totalsize = (TextView)view.findViewById(0x7f0703f1);
            holder.my_stop_download_bt = (Button)view.findViewById(0x7f0703f2);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        try
        {
            holder.my_totalsize.setText(Formatter.formatFileSize(ctx, Long.parseLong(in_fo.getFileSize())));
        }
        catch (Exception exception1) { }
        holder.my_movie_name_item.setText(in_fo.getMovieName());
        try
        {
            app.asyncLoadImage(in_fo.getMovieHeadImagePath(), holder.my_test_head_image);
        }
        catch (Exception exception) { }
        holder.my_stop_download_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoDownloadedAdapter this$0;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/aio/downloader/activity/VideoViewActivity);
                view1.putExtra("playurl", in_fo.getFilePath());
                ctx.startActivity(view1);
            }

            
            {
                this$0 = VideoDownloadedAdapter.this;
                in_fo = downloadmovieitem;
                super();
            }
        });
        holder.my_delete_movie.setOnClickListener(new android.view.View.OnClickListener() {

            final VideoDownloadedAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                view1 = new Intent();
                view1.setAction("videodelete");
                view1.putExtra("position", position);
                ctx.sendBroadcast(view1);
            }

            
            {
                this$0 = VideoDownloadedAdapter.this;
                position = i;
                super();
            }
        });
        return view;
    }
}
