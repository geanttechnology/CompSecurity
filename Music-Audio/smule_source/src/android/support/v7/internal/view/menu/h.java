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
//            g, MenuBuilder, j

class h extends BaseAdapter
{

    final g a;
    private int b;

    public h(g g1)
    {
        a = g1;
        super();
        b = -1;
        a();
    }

    public j a(int i)
    {
        ArrayList arraylist = a.c.l();
        int k = g.a(a) + i;
        i = k;
        if (b >= 0)
        {
            i = k;
            if (k >= b)
            {
                i = k + 1;
            }
        }
        return (j)arraylist.get(i);
    }

    void a()
    {
        j j1 = a.c.r();
        if (j1 != null)
        {
            ArrayList arraylist = a.c.l();
            int k = arraylist.size();
            for (int i = 0; i < k; i++)
            {
                if ((j)arraylist.get(i) == j1)
                {
                    b = i;
                    return;
                }
            }

        }
        b = -1;
    }

    public int getCount()
    {
        int i = a.c.l().size() - g.a(a);
        if (b < 0)
        {
            return i;
        } else
        {
            return i - 1;
        }
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = a.b.inflate(a.f, viewgroup, false);
        }
        ((MenuView.ItemView)view).initialize(a(i), 0);
        return view;
    }

    public void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }
}
