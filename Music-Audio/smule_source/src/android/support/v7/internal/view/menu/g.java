// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuPresenter, h, ExpandedMenuView, MenuBuilder, 
//            v, i, j, MenuView

public class g
    implements MenuPresenter, android.widget.AdapterView.OnItemClickListener
{

    Context a;
    LayoutInflater b;
    MenuBuilder c;
    ExpandedMenuView d;
    int e;
    int f;
    h g;
    private int h;
    private MenuPresenter.Callback i;
    private int j;

    public g(int k, int l)
    {
        f = k;
        e = l;
    }

    public g(Context context, int k)
    {
        this(k, 0);
        a = context;
        b = LayoutInflater.from(a);
    }

    static int a(g g1)
    {
        return g1.h;
    }

    public ListAdapter a()
    {
        if (g == null)
        {
            g = new h(this);
        }
        return g;
    }

    public void a(Bundle bundle)
    {
        SparseArray sparsearray = new SparseArray();
        if (d != null)
        {
            d.saveHierarchyState(sparsearray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparsearray);
    }

    public void b(Bundle bundle)
    {
        bundle = bundle.getSparseParcelableArray("android:menu:list");
        if (bundle != null)
        {
            d.restoreHierarchyState(bundle);
        }
    }

    public boolean collapseItemActionView(MenuBuilder menubuilder, j j1)
    {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menubuilder, j j1)
    {
        return false;
    }

    public boolean flagActionItems()
    {
        return false;
    }

    public int getId()
    {
        return j;
    }

    public MenuView getMenuView(ViewGroup viewgroup)
    {
        if (d == null)
        {
            d = (ExpandedMenuView)b.inflate(android.support.v7.appcompat.R.layout.abc_expanded_menu_layout, viewgroup, false);
            if (g == null)
            {
                g = new h(this);
            }
            d.setAdapter(g);
            d.setOnItemClickListener(this);
        }
        return d;
    }

    public void initForMenu(Context context, MenuBuilder menubuilder)
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

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        if (i != null)
        {
            i.onCloseMenu(menubuilder, flag);
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int k, long l)
    {
        c.a(g.a(k), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        b((Bundle)parcelable);
    }

    public Parcelable onSaveInstanceState()
    {
        if (d == null)
        {
            return null;
        } else
        {
            Bundle bundle = new Bundle();
            a(bundle);
            return bundle;
        }
    }

    public boolean onSubMenuSelected(v v1)
    {
        if (!v1.hasVisibleItems())
        {
            return false;
        }
        (new i(v1)).a(null);
        if (i != null)
        {
            i.onOpenSubMenu(v1);
        }
        return true;
    }

    public void setCallback(MenuPresenter.Callback callback)
    {
        i = callback;
    }

    public void updateMenuView(boolean flag)
    {
        if (g != null)
        {
            g.notifyDataSetChanged();
        }
    }
}
