// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.TShareGridView;
import java.util.ArrayList;
import java.util.HashMap;

public class qy extends BaseAdapter
{

    final TShareGridView a;
    private ArrayList b;

    public qy(TShareGridView tsharegridview, ArrayList arraylist)
    {
        a = tsharegridview;
        super();
        b = arraylist;
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int i)
    {
        return b.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        HashMap hashmap = (HashMap)b.get(i);
        if (view == null)
        {
            i = TShareGridView.access$000(a).getResources().getDisplayMetrics().widthPixels;
            view = LayoutInflater.from(TShareGridView.access$000(a)).inflate(0x7f0300c3, null);
            viewgroup = new qx(a, null);
            qx.a(viewgroup, (ImageView)view.findViewById(0x7f0d01cd));
            qx.a(viewgroup, (TextView)view.findViewById(0x7f0d0317));
            qx.a(viewgroup, (LinearLayout)view.findViewById(0x7f0d0316));
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
            layoutparams.width = i / 4;
            layoutparams.height = yp.a(TShareGridView.access$000(a), 90F);
            qx.a(viewgroup).setLayoutParams(layoutparams);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (qx)view.getTag();
        }
        qx.a(viewgroup).setTag(qx.b(viewgroup));
        qx.b(viewgroup).setBackgroundResource(Integer.valueOf((String)hashmap.get(TShareGridView.access$500())).intValue());
        qx.b(viewgroup).setTag(hashmap.get(TShareGridView.access$600()));
        qx.c(viewgroup).setText((CharSequence)hashmap.get(TShareGridView.access$700()));
        qx.a(viewgroup).setOnClickListener(new qz(this));
        return view;
    }
}
