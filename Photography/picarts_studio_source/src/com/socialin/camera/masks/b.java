// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.masks;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.socialin.camera.masks:
//            c

public final class b extends BaseAdapter
{

    public int a;
    private Context b;
    private ArrayList c;

    public b(Context context, ArrayList arraylist)
    {
        b = null;
        a = 0;
        b = context;
        c = arraylist;
    }

    public final int getCount()
    {
        return c.size();
    }

    public final Object getItem(int i)
    {
        return c.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(b).inflate(0x7f030053, viewgroup, false);
        }
        view = (TextView)view;
        view.setText(((c)c.get(i)).a(b));
        if (i == a)
        {
            view.setBackgroundResource(0x7f02055a);
        } else
        {
            view.setBackgroundResource(0x7f02055b);
        }
        view.setPadding((int)b.getResources().getDimension(0x7f0b0114), 0, 0, 0);
        return view;
    }
}
