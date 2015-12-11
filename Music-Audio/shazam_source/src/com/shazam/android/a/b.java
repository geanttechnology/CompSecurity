// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends BaseAdapter
{

    protected Context a;
    protected final List b;

    public b(Context context)
    {
        b = new ArrayList();
        a(context, ((List) (null)));
    }

    public b(Context context, List list)
    {
        b = new ArrayList();
        a(context, list);
    }

    private void a(Context context, List list)
    {
        a = context;
        if (list != null)
        {
            b.clear();
            b.addAll(list);
        }
    }

    public final Context a()
    {
        return a;
    }

    public abstract View a(Context context, ViewGroup viewgroup);

    public final void a(int i, Object obj)
    {
        b.set(i, obj);
    }

    public abstract void a(View view, Object obj, int i);

    public void a(List list)
    {
        b.clear();
        if (list != null)
        {
            b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final List b()
    {
        return b;
    }

    public int getCount()
    {
        if (b != null)
        {
            return b.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        if (b != null)
        {
            return b.get(i);
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = a(a, viewgroup);
        }
        a(view1, b.get(i), i);
        return view1;
    }

    public boolean hasStableIds()
    {
        return true;
    }
}
