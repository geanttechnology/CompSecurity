// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.view.View;
import com.offerup.android.dto.Item;
import java.util.List;

public abstract class ah extends android.support.v7.widget.RecyclerView.Adapter
{

    private List a;
    public Context b;
    public int c;
    public View d;
    private int e;
    private boolean f;
    private boolean g;

    public ah(Context context, List list)
    {
        f = false;
        g = false;
        a = list;
        b = context;
    }

    public final Object a(int i)
    {
        int j = i;
        if (f)
        {
            j = i - 1;
        }
        if (a == null)
        {
            return null;
        } else
        {
            return a.get(j);
        }
    }

    public final void a()
    {
        a.clear();
    }

    public final void a(View view)
    {
        f = true;
        d = view;
    }

    public final void a(List list)
    {
        if (list != null && list.size() > 0)
        {
            a.addAll(list);
        }
    }

    public final int b()
    {
        return e;
    }

    public final void b(int i)
    {
        e = i;
    }

    public final boolean c()
    {
        return f;
    }

    public int getItemCount()
    {
        int i;
        if (a == null)
        {
            i = 0;
        } else
        {
            int j = a.size();
            i = j;
            if (f)
            {
                return j + 1;
            }
        }
        return i;
    }

    public long getItemId(int i)
    {
        int j = i;
        if (f)
        {
            j = i - 1;
        }
        if (a == null)
        {
            return (long)j;
        } else
        {
            return ((Item)a.get(j)).getId();
        }
    }

    public int getItemViewType(int i)
    {
        if (i == 0 && f)
        {
            return 0x80000000;
        } else
        {
            getItemCount();
            return super.getItemViewType(i) + 2;
        }
    }
}
