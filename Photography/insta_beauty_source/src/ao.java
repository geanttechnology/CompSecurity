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

public class ao
    implements ef
{

    final android.view.ActionMode.Callback a;
    final Context b;
    final SimpleArrayMap c = new SimpleArrayMap();
    final SimpleArrayMap d = new SimpleArrayMap();

    public ao(Context context, android.view.ActionMode.Callback callback)
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
            menu1 = bs.a(b, (SupportMenu)menu);
            d.put(menu, menu1);
        }
        return menu1;
    }

    private ActionMode b(ee ee)
    {
        an an1 = (an)c.get(ee);
        if (an1 != null)
        {
            return an1;
        } else
        {
            an an2 = new an(b, ee);
            c.put(ee, an2);
            return an2;
        }
    }

    public void a(ee ee)
    {
        a.onDestroyActionMode(b(ee));
    }

    public boolean a(ee ee, Menu menu)
    {
        return a.onCreateActionMode(b(ee), a(menu));
    }

    public boolean a(ee ee, MenuItem menuitem)
    {
        return a.onActionItemClicked(b(ee), bs.a(b, (SupportMenuItem)menuitem));
    }

    public boolean b(ee ee, Menu menu)
    {
        return a.onPrepareActionMode(b(ee), a(menu));
    }
}
