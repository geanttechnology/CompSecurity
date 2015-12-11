// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.aio.downloader.model.SearcherPromitModel;
import java.util.List;

public class AppsearchpromitAdapter extends BaseAdapter
{
    class ViewHolder
    {

        private TextView keytv;
        final AppsearchpromitAdapter this$0;



        ViewHolder()
        {
            this$0 = AppsearchpromitAdapter.this;
            super();
        }
    }


    private Context ctx;
    private List list;

    public AppsearchpromitAdapter(Context context, List list1)
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
        SearcherPromitModel searcherpromitmodel = (SearcherPromitModel)list.get(i);
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f03001e, null);
            viewgroup.keytv = (TextView)view.findViewById(0x7f07011f);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).keytv.setText(searcherpromitmodel.getS());
        return view;
    }
}
