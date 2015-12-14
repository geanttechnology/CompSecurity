// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.internal.view.menu.ExpandedMenuView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

public class az
    implements android.widget.AdapterView.OnItemClickListener, bo
{

    Context a;
    LayoutInflater b;
    MenuBuilder c;
    ExpandedMenuView d;
    int e;
    int f;
    ba g;
    private int h;
    private bp i;

    public az(int j, int k)
    {
        f = j;
        e = k;
    }

    public az(Context context, int j)
    {
        this(j, 0);
        a = context;
        b = LayoutInflater.from(a);
    }

    static int a(az az1)
    {
        return az1.h;
    }

    public ListAdapter a()
    {
        if (g == null)
        {
            g = new ba(this);
        }
        return g;
    }

    public bq a(ViewGroup viewgroup)
    {
        if (d == null)
        {
            d = (ExpandedMenuView)b.inflate(y.abc_expanded_menu_layout, viewgroup, false);
            if (g == null)
            {
                g = new ba(this);
            }
            d.setAdapter(g);
            d.setOnItemClickListener(this);
        }
        return d;
    }

    public void a(Context context, MenuBuilder menubuilder)
    {
        if (e == 0) goto _L2; else goto _L1
_L1:
        a = new ContextThemeWrapper(context, e);
        b = LayoutInflater.from(a);
_L4:
        c = menubuilder;
        if (g != null)
        {
            g.notifyDataSetChanged();
        }
        return;
_L2:
        if (a != null)
        {
            a = context;
            if (b == null)
            {
                b = LayoutInflater.from(a);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        if (i != null)
        {
            i.a(menubuilder, flag);
        }
    }

    public void a(bp bp1)
    {
        i = bp1;
    }

    public void a(boolean flag)
    {
        if (g != null)
        {
            g.notifyDataSetChanged();
        }
    }

    public boolean a(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public boolean a(SubMenuBuilder submenubuilder)
    {
        if (!submenubuilder.hasVisibleItems())
        {
            return false;
        }
        (new bd(submenubuilder)).a(null);
        if (i != null)
        {
            i.a(submenubuilder);
        }
        return true;
    }

    public boolean b()
    {
        return false;
    }

    public boolean b(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public void onItemClick(AdapterView adapterview, View view, int j, long l)
    {
        c.a(g.a(j), this, 0);
    }
}
