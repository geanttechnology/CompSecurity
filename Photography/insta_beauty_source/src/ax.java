// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class ax extends ay
{

    final Context a;
    private Map c;
    private Map d;

    ax(Context context, Object obj)
    {
        super(obj);
        a = context;
    }

    final MenuItem a(MenuItem menuitem)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            SupportMenuItem supportmenuitem = (SupportMenuItem)menuitem;
            if (c == null)
            {
                c = new ArrayMap();
            }
            MenuItem menuitem1 = (MenuItem)c.get(menuitem);
            menuitem = menuitem1;
            if (menuitem1 == null)
            {
                menuitem = bs.a(a, supportmenuitem);
                c.put(supportmenuitem, menuitem);
            }
            return menuitem;
        } else
        {
            return menuitem;
        }
    }

    final SubMenu a(SubMenu submenu)
    {
        if (submenu instanceof SupportSubMenu)
        {
            SupportSubMenu supportsubmenu = (SupportSubMenu)submenu;
            if (d == null)
            {
                d = new ArrayMap();
            }
            SubMenu submenu1 = (SubMenu)d.get(supportsubmenu);
            submenu = submenu1;
            if (submenu1 == null)
            {
                submenu = bs.a(a, supportsubmenu);
                d.put(supportsubmenu, submenu);
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
