// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.model.Programe;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            ViewHolder

public class ListAdapter extends BaseAdapter
{

    Context context;
    LayoutInflater la;
    List list;
    android.view.ViewGroup.LayoutParams lp;

    public ListAdapter(List list1, Context context1)
    {
        list = new ArrayList();
        list = list1;
        context = context1;
    }

    private int dip2px(Context context1, float f)
    {
        return (int)(f * context1.getResources().getDisplayMetrics().density + 0.5F);
    }

    public int getCount()
    {
        if (list.size() > 20)
        {
            return 20;
        } else
        {
            return list.size();
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
        Programe programe;
        if (view == null)
        {
            la = LayoutInflater.from(context);
            view = la.inflate(0x7f0300a3, null);
            viewgroup = new ViewHolder();
            viewgroup.imgage = (ImageView)view.findViewById(0x7f07037f);
            viewgroup.text = (TextView)view.findViewById(0x7f070380);
            lp = ((ViewHolder) (viewgroup)).imgage.getLayoutParams();
            lp.width = dip2px(context, 40F);
            lp.height = dip2px(context, 40F);
            ((ViewHolder) (viewgroup)).imgage.setLayoutParams(lp);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        programe = (Programe)list.get(i);
        ((ViewHolder) (viewgroup)).imgage.setImageDrawable(programe.getIcon());
        Log.e("toggletag", (new StringBuilder("toggletag=")).append(programe.getPackagename()).toString());
        ((ViewHolder) (viewgroup)).text.setText(programe.getName());
        return view;
    }
}
