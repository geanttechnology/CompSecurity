// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.livemixtapes.ui.widgets.DjBadgesView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            ImageLoader, App, Utils

public class LazyAdapterMixtapes extends BaseAdapter
{

    private static LayoutInflater inflater = null;
    private Activity activity;
    public ArrayList data;
    public ImageLoader imageLoader;

    public LazyAdapterMixtapes(Activity activity1, ArrayList arraylist)
    {
        activity = activity1;
        data = arraylist;
        inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        imageLoader = new ImageLoader(activity.getApplicationContext());
    }

    public int getCount()
    {
        return data.size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        ImageView imageview;
        DjBadgesView djbadgesview;
        int j;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (view == null)
        {
            if (App.viewStyle.equals("list"))
            {
                viewgroup = inflater.inflate(0x7f030028, null);
            } else
            {
                viewgroup = view;
                if (App.viewStyle.equals("grid"))
                {
                    viewgroup = inflater.inflate(0x7f030026, null);
                }
            }
        }
        view = (TextView)viewgroup.findViewById(0x7f0800bb);
        imageview = (ImageView)viewgroup.findViewById(0x7f0800ba);
        djbadgesview = (DjBadgesView)viewgroup.findViewById(0x7f0800b9);
        view.setText(Utils.getArtistAndTitle((Map)data.get(i)));
        flag = ((HashMap)data.get(i)).get("featured").toString().equals("1");
        if (((HashMap)data.get(i)).containsKey("site"))
        {
            view = ((HashMap)data.get(i)).get("site").toString();
        } else
        {
            view = "";
        }
        flag1 = view.equals("club");
        flag2 = view.equals("indy");
        view = viewgroup.findViewById(0x7f0800be);
        if (flag)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
        view = viewgroup.findViewById(0x7f0800bd);
        if (flag1)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
        view = viewgroup.findViewById(0x7f0800bc);
        if (flag2)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
        if (App.viewStyle.equals("grid"))
        {
            view = "cover";
        } else
        {
            view = "thumbnail";
        }
        imageLoader.DisplayImage(((HashMap)data.get(i)).get(view).toString(), imageview);
        djbadgesview.loadDjs(((HashMap)data.get(i)).get("DJ").toString().split(","), App.viewStyle.equals("grid"));
        return viewgroup;
    }

    public void setData(Activity activity1, ArrayList arraylist)
    {
        activity = activity1;
        data = arraylist;
        inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        imageLoader = new ImageLoader(activity.getApplicationContext());
    }

}
