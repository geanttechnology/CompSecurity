// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public class t
    implements co
{

    final android.view.ActionMode.Callback a;
    final Context b;
    final SimpleArrayMap c = new SimpleArrayMap();
    final SimpleArrayMap d = new SimpleArrayMap();

    public t(Context context, android.view.ActionMode.Callback callback)
    {
        b = context;
        a = callback;
    }

    private Menu a(Menu menu)
    {
        Menu menu2 = (Menu)d.get(menu);
        Menu menu1 = menu2;
        if (menu2 == null)
        {
            menu1 = av.a(b, (SupportMenu)menu);
            d.put(menu, menu1);
        }
        return menu1;
    }

    private ActionMode b(cn cn)
    {
        s s1 = (s)c.get(cn);
        if (s1 != null)
        {
            return s1;
        } else
        {
            s s2 = new s(b, cn);
            c.put(cn, s2);
            return s2;
        }
    }

    public void a(cn cn)
    {
        a.onDestroyActionMode(b(cn));
    }

    public boolean a(cn cn, Menu menu)
    {
        return a.onCreateActionMode(b(cn), a(menu));
    }

    public boolean a(cn cn, MenuItem menuitem)
    {
        return a.onActionItemClicked(b(cn), av.a(b, (SupportMenuItem)menuitem));
    }

    public boolean b(cn cn, Menu menu)
    {
        return a.onPrepareActionMode(b(cn), a(menu));
    }
}
