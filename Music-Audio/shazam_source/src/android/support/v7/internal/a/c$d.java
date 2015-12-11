// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.g;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.h;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.internal.a:
//            c

private final class  extends g
{

    final c a;

    public final View onCreatePanelView(int i)
    {
        i;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 26;
           goto _L1 _L2
_L1:
        Menu menu;
        return super.onCreatePanelView(i);
_L2:
        if (onPreparePanel(i, null, menu = a.a.q()) && onMenuOpened(i, menu))
        {
            c c1 = a;
            if (c1.d == null && (menu instanceof f))
            {
                f f1 = (f)menu;
                Object obj = c1.a.b();
                TypedValue typedvalue = new TypedValue();
                android.content.res.urces.Theme theme = ((Context) (obj)).getResources().newTheme();
                theme.setTo(((Context) (obj)).getTheme());
                theme.resolveAttribute(android.support.v7.b.actionBarPopupTheme, typedvalue, true);
                if (typedvalue.resourceId != 0)
                {
                    theme.applyStyle(typedvalue.resourceId, true);
                }
                theme.resolveAttribute(android.support.v7.b.panelMenuListTheme, typedvalue, true);
                if (typedvalue.resourceId != 0)
                {
                    theme.applyStyle(typedvalue.resourceId, true);
                } else
                {
                    theme.applyStyle(android.support.v7.b.Theme_AppCompat_CompactMenu, true);
                }
                obj = new ContextThemeWrapper(((Context) (obj)), 0);
                ((Context) (obj)).getTheme().setTo(theme);
                c1.d = new e(((Context) (obj)), android.support.v7.b.abc_list_menu_item_layout);
                c1.d.g = new <init>(c1, (byte)0);
                f1.a(c1.d);
            }
            if (menu == null || c1.d == null)
            {
                return null;
            }
            if (c1.d.b().getCount() > 0)
            {
                return (View)c1.d.a(c1.a.a());
            } else
            {
                return null;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final boolean onPreparePanel(int i, View view, Menu menu)
    {
        boolean flag = super.onPreparePanel(i, view, menu);
        if (flag && !a.b)
        {
            a.a.k();
            a.b = true;
        }
        return flag;
    }

    public enu.e(c c1, android.view.ow.Callback callback)
    {
        a = c1;
        super(callback);
    }
}
