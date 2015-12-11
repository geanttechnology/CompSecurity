// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

final class gx extends BaseAdapter
{

    private gt a;
    private int b;
    private gw c;

    public gx(gw gw1, gt gt1)
    {
        c = gw1;
        super();
        b = -1;
        a = gt1;
        a();
    }

    static gt a(gx gx1)
    {
        return gx1.a;
    }

    private void a()
    {
        gv gv1 = gw.c(c).g;
        if (gv1 != null)
        {
            ArrayList arraylist = gw.c(c).f();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                if ((gv)arraylist.get(i) == gv1)
                {
                    b = i;
                    return;
                }
            }

        }
        b = -1;
    }

    public final gv a(int i)
    {
        ArrayList arraylist;
        int j;
        if (gw.a(c))
        {
            arraylist = a.f();
        } else
        {
            arraylist = a.d();
        }
        j = i;
        if (b >= 0)
        {
            j = i;
            if (i >= b)
            {
                j = i + 1;
            }
        }
        return (gv)arraylist.get(j);
    }

    public final int getCount()
    {
        ArrayList arraylist;
        if (gw.a(c))
        {
            arraylist = a.f();
        } else
        {
            arraylist = a.d();
        }
        if (b < 0)
        {
            return arraylist.size();
        } else
        {
            return arraylist.size() - 1;
        }
    }

    public final Object getItem(int i)
    {
        return a(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = gw.b(c).inflate(gw.a, viewgroup, false);
        }
        viewgroup = (ha)view;
        if (c.e)
        {
            ListMenuItemView listmenuitemview = (ListMenuItemView)view;
            listmenuitemview.b = true;
            listmenuitemview.a = true;
        }
        viewgroup.a(a(i), 0);
        return view;
    }

    public final void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }
}
