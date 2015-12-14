// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cl;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.socialin.android.photo.effects.factory.b;
import java.util.ArrayList;
import java.util.HashMap;

public final class c extends BaseAdapter
{

    public int a;
    private ArrayList b;
    private b c;

    public c(ArrayList arraylist, b b1)
    {
        a = -1;
        b = arraylist;
        a = 0;
        c = b1;
    }

    public final int getCount()
    {
        return b.size();
    }

    public final Object getItem(int i)
    {
        return null;
    }

    public final long getItemId(int i)
    {
        return 0L;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        Context context = viewgroup.getContext();
        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(0x7f0300c3, viewgroup, false);
        }
        viewgroup = (String)b.get(i);
        view = (TextView)view;
        view.setText(context.getString(((Integer)c.a.get(viewgroup)).intValue()));
        b b1;
        boolean flag;
        if (i == a)
        {
            view.setBackgroundResource(0x7f02055a);
        } else
        {
            view.setBackgroundResource(0x7f02055b);
        }
        b1 = c;
        if (b1.g.containsKey(viewgroup))
        {
            flag = ((Boolean)b1.g.get(viewgroup)).booleanValue();
        } else
        {
            flag = false;
        }
        if (flag)
        {
            view.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0204a2, 0);
        } else
        {
            view.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        view.setPadding((int)context.getResources().getDimension(0x7f0b0114), 0, 0, 0);
        return view;
    }
}
