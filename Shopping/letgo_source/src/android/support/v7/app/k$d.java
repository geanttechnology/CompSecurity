// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.cb;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.m;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.app:
//            k

private static final class q
{

    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    f j;
    e k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    Bundle s;

    m a(android.support.v7.internal.view.menu. )
    {
        if (j == null)
        {
            return null;
        }
        if (k == null)
        {
            k = new e(l, android.support.v7..abc_list_menu_item_layout);
            k.a();
            j.a(k);
        }
        return k.a(g);
    }

    void a(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        android.content.res.urces.Theme theme = context.getResources().newTheme();
        theme.setTo(context.getTheme());
        theme.resolveAttribute(android.support.v7..actionBarPopupTheme, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            theme.applyStyle(typedvalue.resourceId, true);
        }
        theme.resolveAttribute(android.support.v7..panelMenuListTheme, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            theme.applyStyle(typedvalue.resourceId, true);
        } else
        {
            theme.applyStyle(android.support.v7..Theme_AppCompat_CompactMenu, true);
        }
        context = new cb(context, 0);
        context.getTheme().setTo(theme);
        l = context;
        context = context.obtainStyledAttributes(android.support.v7..Theme);
        b = context.getResourceId(android.support.v7..Theme_panelBackground, 0);
        f = context.getResourceId(android.support.v7..Theme_android_windowAnimationStyle, 0);
        context.recycle();
    }

    void a(f f1)
    {
        if (f1 != j)
        {
            if (j != null)
            {
                j.b(k);
            }
            j = f1;
            if (f1 != null && k != null)
            {
                f1.a(k);
                return;
            }
        }
    }

    public boolean a()
    {
        boolean flag1 = true;
        boolean flag;
        if (h == null)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (i == null)
            {
                flag = flag1;
                if (k.a().getCount() <= 0)
                {
                    return false;
                }
            }
        }
        return flag;
    }

    .view.menu.f(int i1)
    {
        a = i1;
        q = false;
    }
}
