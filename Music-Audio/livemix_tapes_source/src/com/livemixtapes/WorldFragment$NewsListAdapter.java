// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.livemixtapes:
//            WorldFragment, ImageLoader

public class activity extends BaseAdapter
{

    private Activity activity;
    private LayoutInflater inflater;
    final WorldFragment this$0;

    public int getCount()
    {
        return newsList.size();
    }

    public Object getItem(int i)
    {
        return newsList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (inflater == null)
        {
            inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        }
        viewgroup = view;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f03002b, null);
        }
        Object obj = (TextView)viewgroup.findViewById(0x7f0800cf);
        ImageView imageview = (ImageView)viewgroup.findViewById(0x7f0800cd);
        view = (ImageView)viewgroup.findViewById(0x7f0800ce);
        HashMap hashmap = (HashMap)newsList.get(i);
        ((TextView) (obj)).setText((CharSequence)hashmap.get("title"));
        (new ImageLoader(activity)).DisplayImage((String)hashmap.get("poster"), imageview);
        obj = (new StringBuilder("property_")).append(((String)hashmap.get("property")).toLowerCase()).toString();
        try
        {
            view.setImageResource(getResources().getIdentifier(((String) (obj)), "drawable", activity.getPackageName()));
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return viewgroup;
        }
        return viewgroup;
    }

    public (Activity activity1)
    {
        this$0 = WorldFragment.this;
        super();
        activity = activity1;
    }
}
