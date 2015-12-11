// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.support.v7.internal.view.menu.n;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

// Referenced classes of package android.support.v7:
//            cd, ba, af, ag, 
//            cj

public static class a
    implements a
{

    final android.view.nMode.Callback a;
    final Context b;
    final ArrayList c = new ArrayList();
    final ba d = new ba();

    private Menu a(Menu menu)
    {
        Menu menu2 = (Menu)d.get(menu);
        Menu menu1 = menu2;
        if (menu2 == null)
        {
            menu1 = n.a(b, (af)menu);
            d.put(menu, menu1);
        }
        return menu1;
    }

    private ActionMode b(cj cj)
    {
        int j = c.size();
        for (int i = 0; i < j; i++)
        {
            cd cd1 = (cd)c.get(i);
            if (cd1 != null && cd1.b == cj)
            {
                return cd1;
            }
        }

        cj = new cd(b, cj);
        c.add(cj);
        return cj;
    }

    public void a(cd cd1)
    {
        c.add(cd1);
    }

    public void a(cj cj)
    {
        a.onDestroyActionMode(b(cj));
    }

    public boolean a(cj cj, Menu menu)
    {
        return a.onCreateActionMode(b(cj), a(menu));
    }

    public boolean a(cj cj, MenuItem menuitem)
    {
        return a.onActionItemClicked(b(cj), n.a(b, (ag)menuitem));
    }

    public boolean b(cj cj, Menu menu)
    {
        return a.onPrepareActionMode(b(cj), a(menu));
    }

    public ack(Context context, android.view.nMode.Callback callback)
    {
        b = context;
        a = callback;
    }
}
