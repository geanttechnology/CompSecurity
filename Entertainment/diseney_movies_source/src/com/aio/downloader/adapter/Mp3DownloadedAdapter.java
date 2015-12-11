// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import java.util.List;

public class Mp3DownloadedAdapter extends BaseAdapter
{
    class ViewHolder
    {

        ImageView my_delete_movie;
        TextView my_movie_name_item;
        Button my_stop_download_bt;
        ImageView my_test_head_image;
        TextView my_totalsize;
        final Mp3DownloadedAdapter this$0;

        ViewHolder()
        {
            this$0 = Mp3DownloadedAdapter.this;
            super();
        }
    }


    private MyApplcation app;
    private Context ctx;
    private List list;

    public Mp3DownloadedAdapter(Context context, List list1)
    {
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

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        final DownloadMovieItem in_fo = (DownloadMovieItem)list.get(position);
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f03007b, null);
            viewgroup.my_delete_movie = (ImageView)view.findViewById(0x7f0702e8);
            viewgroup.my_test_head_image = (ImageView)view.findViewById(0x7f0702e9);
            viewgroup.my_movie_name_item = (TextView)view.findViewById(0x7f0702ea);
            viewgroup.my_totalsize = (TextView)view.findViewById(0x7f0702eb);
            viewgroup.my_stop_download_bt = (Button)view.findViewById(0x7f0702ec);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        try
        {
            ((ViewHolder) (viewgroup)).my_totalsize.setText(Formatter.formatFileSize(ctx, Long.parseLong(in_fo.getFileSize())));
        }
        catch (Exception exception) { }
        ((ViewHolder) (viewgroup)).my_movie_name_item.setText(in_fo.getMovieName());
        ((ViewHolder) (viewgroup)).my_stop_download_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final Mp3DownloadedAdapter this$0;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                view1 = new Intent();
                view1.setAction("mp3play");
                view1.putExtra("mp3positiontitle", in_fo.getMovieName());
                view1.putExtra("mp3position", in_fo.getFilePath());
                Log.v("mp3position", in_fo.getFilePath());
                ctx.sendBroadcast(view1);
            }

            
            {
                this$0 = Mp3DownloadedAdapter.this;
                in_fo = downloadmovieitem;
                super();
            }
        });
        ((ViewHolder) (viewgroup)).my_delete_movie.setOnClickListener(new android.view.View.OnClickListener() {

            final Mp3DownloadedAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                view1 = new Intent();
                view1.setAction("mp3delete");
                view1.putExtra("position", position);
                ctx.sendBroadcast(view1);
            }

            
            {
                this$0 = Mp3DownloadedAdapter.this;
                position = i;
                super();
            }
        });
        return view;
    }

}
