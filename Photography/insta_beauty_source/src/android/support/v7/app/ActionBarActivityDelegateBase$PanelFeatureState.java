// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import aa;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import az;
import bp;
import bq;
import r;
import y;

public final class k
{

    public int a;
    ViewGroup b;
    View c;
    MenuBuilder d;
    az e;
    Context f;
    boolean g;
    boolean h;
    boolean i;
    public boolean j;
    boolean k;
    boolean l;
    Bundle m;

    bq a(bp bp)
    {
        if (d == null)
        {
            return null;
        }
        if (e == null)
        {
            e = new az(f, y.abc_list_menu_item_layout);
            e.a(bp);
            d.a(e);
        }
        return e.a(b);
    }

    void a(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        android.content.res.te te = context.getResources().newTheme();
        te.te(context.getTheme());
        te.te(r.actionBarPopupTheme, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        }
        te.te(r.panelMenuListTheme, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        } else
        {
            te.te(aa.Theme_AppCompat_CompactMenu, true);
        }
        context = new ContextThemeWrapper(context, 0);
        context.getTheme().te(te);
        f = context;
    }

    void a(MenuBuilder menubuilder)
    {
        if (menubuilder != d)
        {
            if (d != null)
            {
                d.b(e);
            }
            d = menubuilder;
            if (menubuilder != null && e != null)
            {
                menubuilder.a(e);
                return;
            }
        }
    }

    public boolean a()
    {
        while (c == null || e.a().getCount() <= 0) 
        {
            return false;
        }
        return true;
    }

    (int i1)
    {
        a = i1;
        k = false;
    }
}
