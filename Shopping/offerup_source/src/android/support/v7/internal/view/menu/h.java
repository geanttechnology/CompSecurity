// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            g, i, m, aa

final class h extends BaseAdapter
{

    private int a;
    private g b;

    public h(g g1)
    {
        b = g1;
        super();
        a = -1;
        a();
    }

    private void a()
    {
        m m1 = b.b.o();
        if (m1 != null)
        {
            ArrayList arraylist = b.b.m();
            int k = arraylist.size();
            for (int j = 0; j < k; j++)
            {
                if ((m)arraylist.get(j) == m1)
                {
                    a = j;
                    return;
                }
            }

        }
        a = -1;
    }

    public final m a(int j)
    {
        ArrayList arraylist = b.b.m();
        int k = g.a(b) + j;
        j = k;
        if (a >= 0)
        {
            j = k;
            if (k >= a)
            {
                j = k + 1;
            }
        }
        return (m)arraylist.get(j);
    }

    public final int getCount()
    {
        int j = b.b.m().size() - g.a(b);
        if (a < 0)
        {
            return j;
        } else
        {
            return j - 1;
        }
    }

    public final Object getItem(int j)
    {
        return a(j);
    }

    public final long getItemId(int j)
    {
        return (long)j;
    }

    public final View getView(int j, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = b.a.inflate(b.c, viewgroup, false);
        }
        ((aa)view).a(a(j), 0);
        return view;
    }

    public final void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }
}
