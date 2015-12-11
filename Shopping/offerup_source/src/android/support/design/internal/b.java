// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.internal.view.menu.ac;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.x;
import android.support.v7.internal.view.menu.z;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

// Referenced classes of package android.support.design.internal:
//            NavigationMenuView, c, d

public final class b
    implements x, android.widget.AdapterView.OnItemClickListener
{

    private NavigationMenuView a;
    private LinearLayout b;
    private i c;
    private int d;
    private c e;
    private LayoutInflater f;
    private int g;
    private boolean h;
    private ColorStateList i;
    private ColorStateList j;
    private Drawable k;
    private int l;

    public b()
    {
    }

    static LayoutInflater a(b b1)
    {
        return b1.f;
    }

    static ColorStateList b(b b1)
    {
        return b1.j;
    }

    static boolean c(b b1)
    {
        return b1.h;
    }

    static int d(b b1)
    {
        return b1.g;
    }

    static ColorStateList e(b b1)
    {
        return b1.i;
    }

    static Drawable f(b b1)
    {
        return b1.k;
    }

    static i g(b b1)
    {
        return b1.c;
    }

    static int h(b b1)
    {
        return b1.l;
    }

    public final ColorStateList a()
    {
        return j;
    }

    public final z a(ViewGroup viewgroup)
    {
        if (a == null)
        {
            a = (NavigationMenuView)f.inflate(0x7f040079, viewgroup, false);
            if (e == null)
            {
                e = new c(this);
            }
            b = (LinearLayout)f.inflate(0x7f040076, a, false);
            a.addHeaderView(b, null, false);
            a.setAdapter(e);
            a.setOnItemClickListener(this);
        }
        return a;
    }

    public final void a(int i1)
    {
        d = 1;
    }

    public final void a(ColorStateList colorstatelist)
    {
        j = colorstatelist;
        updateMenuView(false);
    }

    public final void a(Drawable drawable)
    {
        k = drawable;
    }

    public final void a(m m1)
    {
        e.a(m1);
    }

    public final void a(boolean flag)
    {
        if (e != null)
        {
            e.a(flag);
        }
    }

    public final ColorStateList b()
    {
        return i;
    }

    public final View b(int i1)
    {
        View view = f.inflate(i1, b, false);
        b.addView(view);
        a.setPadding(0, 0, 0, a.getPaddingBottom());
        return view;
    }

    public final void b(ColorStateList colorstatelist)
    {
        i = colorstatelist;
        updateMenuView(false);
    }

    public final Drawable c()
    {
        return k;
    }

    public final void c(int i1)
    {
        g = i1;
        h = true;
        updateMenuView(false);
    }

    public final boolean collapseItemActionView(i i1, m m1)
    {
        return false;
    }

    public final boolean expandItemActionView(i i1, m m1)
    {
        return false;
    }

    public final boolean flagActionItems()
    {
        return false;
    }

    public final int getId()
    {
        return d;
    }

    public final void initForMenu(Context context, i i1)
    {
        f = LayoutInflater.from(context);
        c = i1;
        context = context.getResources();
        context.getDimensionPixelOffset(0x7f0b0027);
        l = context.getDimensionPixelOffset(0x7f0b00ae);
    }

    public final void onCloseMenu(i i1, boolean flag)
    {
    }

    public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        i1 -= a.getHeaderViewsCount();
        if (i1 >= 0)
        {
            a(true);
            adapterview = e.a(i1).d();
            if (adapterview != null && adapterview.isCheckable())
            {
                e.a(adapterview);
            }
            c.a(adapterview, this, 0);
            a(false);
            updateMenuView(false);
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (Bundle)parcelable;
        SparseArray sparsearray = parcelable.getSparseParcelableArray("android:menu:list");
        if (sparsearray != null)
        {
            a.restoreHierarchyState(sparsearray);
        }
        parcelable = parcelable.getBundle("android:menu:adapter");
        if (parcelable != null)
        {
            e.a(parcelable);
        }
    }

    public final Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        if (a != null)
        {
            SparseArray sparsearray = new SparseArray();
            a.saveHierarchyState(sparsearray);
            bundle.putSparseParcelableArray("android:menu:list", sparsearray);
        }
        if (e != null)
        {
            bundle.putBundle("android:menu:adapter", e.a());
        }
        return bundle;
    }

    public final boolean onSubMenuSelected(ac ac)
    {
        return false;
    }

    public final void updateMenuView(boolean flag)
    {
        if (e != null)
        {
            e.notifyDataSetChanged();
        }
    }
}
