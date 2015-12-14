// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.livemixtapes.ui.widgets.DjBadgesView;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            MixtapeList, Utils, ImageLoader

public class activity extends BaseAdapter
{

    private Activity activity;
    private LayoutInflater inflater;
    final MixtapeList this$0;

    public int getCount()
    {
        return mixtapeList.size();
    }

    public Object getItem(int i)
    {
        return mixtapeList.get(i);
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
        view = inflater.inflate(0x7f030028, null);
        viewgroup = (Map)mixtapeList.get(i);
        Object obj = ((WindowManager)activity.getApplicationContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Display) (obj)).getMetrics(displaymetrics);
        float f = displaymetrics.widthPixels;
        obj = (ImageView)view.findViewById(0x7f0800ba);
        ((ImageView) (obj)).getLayoutParams(). = (int)(0.15F * f);
        ((TextView)view.findViewById(0x7f0800bb)).setText(Utils.getArtistAndTitle(viewgroup));
        imageLoader.DisplayImage(viewgroup.get("thumbnail").toString(), ((ImageView) (obj)));
        ((DjBadgesView)view.findViewById(0x7f0800b9)).loadDjs(viewgroup.get("DJ").toString().split(","), false);
        return view;
    }

    public (Activity activity1)
    {
        this$0 = MixtapeList.this;
        super();
        activity = activity1;
    }
}
