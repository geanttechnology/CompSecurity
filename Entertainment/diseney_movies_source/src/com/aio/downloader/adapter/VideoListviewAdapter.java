// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.aio.downloader.model.VideoModel;
import java.util.List;

public class VideoListviewAdapter extends BaseAdapter
{
    class ViewHolder
    {

        final VideoListviewAdapter this$0;
        TextView tv_format;
        TextView tv_size;
        TextView tv_type;

        ViewHolder()
        {
            this$0 = VideoListviewAdapter.this;
            super();
        }
    }


    Context ctx;
    private List list;

    public VideoListviewAdapter(Context context, List list1)
    {
        ctx = context;
        list = list1;
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

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        VideoModel videomodel = (VideoModel)list.get(i);
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f0300ba, null);
            viewgroup.tv_format = (TextView)view.findViewById(0x7f0703ea);
            viewgroup.tv_type = (TextView)view.findViewById(0x7f0703eb);
            viewgroup.tv_size = (TextView)view.findViewById(0x7f0703ec);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).tv_format.setText((new StringBuilder(String.valueOf(videomodel.getVideo_item_format()))).append(" ").append("/").append(" ").toString());
        ((ViewHolder) (viewgroup)).tv_type.setText(videomodel.getVideo_item_type());
        try
        {
            String s = Formatter.formatFileSize(ctx, Long.parseLong(videomodel.getVideo_item_size()));
            Log.v("size", (new StringBuilder(String.valueOf(videomodel.getVideo_item_size()))).toString());
            if (!videomodel.getVideo_item_size().equals("-1") && !videomodel.getVideo_item_size().equals("0"))
            {
                ((ViewHolder) (viewgroup)).tv_size.setText((new StringBuilder("Size: ")).append(s).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            return view;
        }
        return view;
    }
}
