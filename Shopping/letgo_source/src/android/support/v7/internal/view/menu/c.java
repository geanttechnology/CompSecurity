// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.ag;
import android.support.v7.ah;
import android.support.v7.at;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7.internal.view.menu:
//            d, n

abstract class c extends d
{

    final Context a;
    private Map c;
    private Map d;

    c(Context context, Object obj)
    {
        super(obj);
        a = context;
    }

    final MenuItem a(MenuItem menuitem)
    {
        if (menuitem instanceof ag)
        {
            ag ag1 = (ag)menuitem;
            if (c == null)
            {
                c = new at();
            }
            MenuItem menuitem1 = (MenuItem)c.get(menuitem);
            menuitem = menuitem1;
            if (menuitem1 == null)
            {
                menuitem = n.a(a, ag1);
                c.put(ag1, menuitem);
            }
            return menuitem;
        } else
        {
            return menuitem;
        }
    }

    final SubMenu a(SubMenu submenu)
    {
        if (submenu instanceof ah)
        {
            ah ah1 = (ah)submenu;
            if (d == null)
            {
                d = new at();
            }
            SubMenu submenu1 = (SubMenu)d.get(ah1);
            submenu = submenu1;
            if (submenu1 == null)
            {
                submenu = n.a(a, ah1);
                d.put(ah1, submenu);
            }
            return submenu;
        } else
        {
            return submenu;
        }
    }

    final void a()
    {
        if (c != null)
        {
            c.clear();
        }
        if (d != null)
        {
            d.clear();
        }
    }

    final void a(int i)
    {
        if (c != null)
        {
            Iterator iterator = c.keySet().iterator();
            while (iterator.hasNext()) 
            {
                if (i == ((MenuItem)iterator.next()).getGroupId())
                {
                    iterator.remove();
                }
            }
        }
    }

    final void b(int i)
    {
        if (c != null)
        {
            Iterator iterator = c.keySet().iterator();
            while (iterator.hasNext()) 
            {
                if (i == ((MenuItem)iterator.next()).getItemId())
                {
                    iterator.remove();
                    return;
                }
            }
        }
    }
}
