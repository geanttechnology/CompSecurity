// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.aio.downloader.model.SearchkeywordModel;
import java.util.List;

public class ApprecommendkeywordAdapter extends BaseAdapter
{
    class ViewHolder
    {

        private TextView searchtitle;
        final ApprecommendkeywordAdapter this$0;
        private TextView xian;




        ViewHolder()
        {
            this$0 = ApprecommendkeywordAdapter.this;
            super();
        }
    }


    private Context ctx;
    private int i;
    private List list;
    private int x1;
    private int x2;

    public ApprecommendkeywordAdapter(Context context, List list1)
    {
        i = 0;
        ctx = context;
        list = list1;
    }

    public int getCount()
    {
        if (list != null && list.size() > 0)
        {
            Log.v("sda", (new StringBuilder(String.valueOf(list.size()))).toString());
            return list.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int j)
    {
        return list.get(j);
    }

    public long getItemId(int j)
    {
        return (long)j;
    }

    public View getView(int j, View view, ViewGroup viewgroup)
    {
        SearchkeywordModel searchkeywordmodel = (SearchkeywordModel)list.get(j);
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f0300ad, null);
            viewgroup.searchtitle = (TextView)view.findViewById(0x7f0703b7);
            viewgroup.xian = (TextView)view.findViewById(0x7f0700c1);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).searchtitle.setText(searchkeywordmodel.getKeyword());
        if (i == 0)
        {
            i = i + 1;
            x1 = (int)(Math.random() * (double)list.size());
            x2 = (int)(Math.random() * (double)list.size());
            if (x1 == x2)
            {
                x2 = (int)(Math.random() * (double)list.size());
            }
        }
        if (j == x1 || j == x2)
        {
            ((ViewHolder) (viewgroup)).searchtitle.setTextColor(0xffff0000);
            return view;
        } else
        {
            ((ViewHolder) (viewgroup)).searchtitle.setTextColor(0xff000000);
            return view;
        }
    }
}
