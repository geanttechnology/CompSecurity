// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import ad;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import as;
import at;

public final class k
{

    public int a;
    ViewGroup b;
    View c;
    MenuBuilder d;
    ad e;
    Context f;
    boolean g;
    boolean h;
    boolean i;
    public boolean j;
    boolean k;
    boolean l;
    Bundle m;

    at a(as as)
    {
        if (d == null)
        {
            return null;
        }
        if (e == null)
        {
            e = new ad(f, android.support.v7.appcompat.);
            e.a(as);
            d.a(e);
        }
        return e.a(b);
    }

    void a(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        android.content.res.te te = context.getResources().newTheme();
        te.te(context.getTheme());
        te.te(android.support.v7.appcompat., typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        }
        te.te(android.support.v7.appcompat., typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        } else
        {
            te.te(android.support.v7.appcompat., true);
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
