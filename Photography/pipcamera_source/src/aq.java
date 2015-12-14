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

class aq extends BaseAdapter
{

    final ap a;
    private MenuBuilder b;
    private int c;

    public aq(ap ap1, MenuBuilder menubuilder)
    {
        a = ap1;
        super();
        c = -1;
        b = menubuilder;
        a();
    }

    static MenuBuilder a(aq aq1)
    {
        return aq1.b;
    }

    public MenuItemImpl a(int i)
    {
        ArrayList arraylist;
        int j;
        if (ap.a(a))
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
        MenuItemImpl menuitemimpl = ap.c(a).r();
        if (menuitemimpl != null)
        {
            ArrayList arraylist = ap.c(a).l();
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
        if (ap.a(a))
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
            view = ap.b(a).inflate(ap.a, viewgroup, false);
        }
        viewgroup = (au)view;
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
