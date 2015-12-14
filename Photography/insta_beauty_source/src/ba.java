// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class ba extends BaseAdapter
{

    final az a;
    private int b;

    public ba(az az1)
    {
        a = az1;
        super();
        b = -1;
        a();
    }

    public MenuItemImpl a(int i)
    {
        ArrayList arraylist = a.c.l();
        int j = az.a(a) + i;
        i = j;
        if (b >= 0)
        {
            i = j;
            if (j >= b)
            {
                i = j + 1;
            }
        }
        return (MenuItemImpl)arraylist.get(i);
    }

    void a()
    {
        MenuItemImpl menuitemimpl = a.c.r();
        if (menuitemimpl != null)
        {
            ArrayList arraylist = a.c.l();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                if ((MenuItemImpl)arraylist.get(i) == menuitemimpl)
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
        int i = a.c.l().size() - az.a(a);
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
        ((br)view).initialize(a(i), 0);
        return view;
    }

    public void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }
}
