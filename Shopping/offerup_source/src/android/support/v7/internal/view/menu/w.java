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
//            v, i, m, aa, 
//            ListMenuItemView

final class w extends BaseAdapter
{

    private i a;
    private int b;
    private v c;

    public w(v v1, i j)
    {
        c = v1;
        super();
        b = -1;
        a = j;
        a();
    }

    static i a(w w1)
    {
        return w1.a;
    }

    private void a()
    {
        m m1 = v.access$300(c).o();
        if (m1 != null)
        {
            ArrayList arraylist = v.access$300(c).m();
            int k = arraylist.size();
            for (int j = 0; j < k; j++)
            {
                if ((m)arraylist.get(j) == m1)
                {
                    b = j;
                    return;
                }
            }

        }
        b = -1;
    }

    public final m a(int j)
    {
        ArrayList arraylist;
        int k;
        if (v.access$100(c))
        {
            arraylist = a.m();
        } else
        {
            arraylist = a.j();
        }
        k = j;
        if (b >= 0)
        {
            k = j;
            if (j >= b)
            {
                k = j + 1;
            }
        }
        return (m)arraylist.get(k);
    }

    public final int getCount()
    {
        ArrayList arraylist;
        if (v.access$100(c))
        {
            arraylist = a.m();
        } else
        {
            arraylist = a.j();
        }
        if (b < 0)
        {
            return arraylist.size();
        } else
        {
            return arraylist.size() - 1;
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
            view = v.access$200(c).inflate(v.ITEM_LAYOUT, viewgroup, false);
        }
        viewgroup = (aa)view;
        if (c.mForceShowIcon)
        {
            ((ListMenuItemView)view).setForceShowIcon(true);
        }
        viewgroup.a(a(j), 0);
        return view;
    }

    public final void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }
}
