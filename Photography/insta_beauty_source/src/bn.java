// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.ListMenuItemView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class bn extends BaseAdapter
{

    final bm a;
    private MenuBuilder b;
    private int c;

    public bn(bm bm1, MenuBuilder menubuilder)
    {
        a = bm1;
        super();
        c = -1;
        b = menubuilder;
        a();
    }

    static MenuBuilder a(bn bn1)
    {
        return bn1.b;
    }

    public MenuItemImpl a(int i)
    {
        ArrayList arraylist;
        int j;
        if (bm.a(a))
        {
            arraylist = b.l();
        } else
        {
            arraylist = b.i();
        }
        j = i;
        if (c >= 0)
        {
            j = i;
            if (i >= c)
            {
                j = i + 1;
            }
        }
        return (MenuItemImpl)arraylist.get(j);
    }

    void a()
    {
        MenuItemImpl menuitemimpl = bm.c(a).r();
        if (menuitemimpl != null)
        {
            ArrayList arraylist = bm.c(a).l();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                if ((MenuItemImpl)arraylist.get(i) == menuitemimpl)
                {
                    c = i;
                    return;
                }
            }

        }
        c = -1;
    }

    public int getCount()
    {
        ArrayList arraylist;
        if (bm.a(a))
        {
            arraylist = b.l();
        } else
        {
            arraylist = b.i();
        }
        if (c < 0)
        {
            return arraylist.size();
        } else
        {
            return arraylist.size() - 1;
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
            view = bm.b(a).inflate(bm.a, viewgroup, false);
        }
        viewgroup = (br)view;
        if (a.b)
        {
            ((ListMenuItemView)view).setForceShowIcon(true);
        }
        viewgroup.initialize(a(i), 0);
        return view;
    }

    public void notifyDataSetChanged()
    {
        a();
        super.notifyDataSetChanged();
    }
}
