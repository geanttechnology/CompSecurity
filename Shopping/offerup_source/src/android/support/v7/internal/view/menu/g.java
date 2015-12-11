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
//            x, ExpandedMenuView, h, y, 
//            i, ac, l, z, 
//            m

public final class g
    implements x, android.widget.AdapterView.OnItemClickListener
{

    LayoutInflater a;
    i b;
    int c;
    private Context d;
    private ExpandedMenuView e;
    private int f;
    private y g;
    private h h;

    private g(int j, int k)
    {
        c = j;
        f = 0;
    }

    public g(Context context, int j)
    {
        this(j, 0);
        d = context;
        a = LayoutInflater.from(d);
    }

    static int a(g g1)
    {
        return 0;
    }

    public final z a(ViewGroup viewgroup)
    {
        if (e == null)
        {
            e = (ExpandedMenuView)a.inflate(android.support.v7.appcompat.R.layout.abc_expanded_menu_layout, viewgroup, false);
            if (h == null)
            {
                h = new h(this);
            }
            e.setAdapter(h);
            e.setOnItemClickListener(this);
        }
        return e;
    }

    public final ListAdapter a()
    {
        if (h == null)
        {
            h = new h(this);
        }
        return h;
    }

    public final void a(y y1)
    {
        g = y1;
    }

    public final boolean collapseItemActionView(i j, m m)
    {
        return false;
    }

    public final boolean expandItemActionView(i j, m m)
    {
        return false;
    }

    public final boolean flagActionItems()
    {
        return false;
    }

    public final int getId()
    {
        return 0;
    }

    public final void initForMenu(Context context, i j)
    {
        if (f == 0) goto _L2; else goto _L1
_L1:
        d = new ContextThemeWrapper(context, f);
        a = LayoutInflater.from(d);
_L4:
        b = j;
        if (h != null)
        {
            h.notifyDataSetChanged();
        }
        return;
_L2:
        if (d != null)
        {
            d = context;
            if (a == null)
            {
                a = LayoutInflater.from(d);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void onCloseMenu(i j, boolean flag)
    {
        if (g != null)
        {
            g.onCloseMenu(j, flag);
        }
    }

    public final void onItemClick(AdapterView adapterview, View view, int j, long l1)
    {
        b.a(h.a(j), this, 0);
    }

    public final void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = ((Bundle)parcelable).getSparseParcelableArray("android:menu:list");
        if (parcelable != null)
        {
            e.restoreHierarchyState(parcelable);
        }
    }

    public final Parcelable onSaveInstanceState()
    {
        if (e == null)
        {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray sparsearray = new SparseArray();
        if (e != null)
        {
            e.saveHierarchyState(sparsearray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparsearray);
        return bundle;
    }

    public final boolean onSubMenuSelected(ac ac1)
    {
        if (!ac1.hasVisibleItems())
        {
            return false;
        }
        (new l(ac1)).a(null);
        if (g != null)
        {
            g.onOpenSubMenu(ac1);
        }
        return true;
    }

    public final void updateMenuView(boolean flag)
    {
        if (h != null)
        {
            h.notifyDataSetChanged();
        }
    }
}
