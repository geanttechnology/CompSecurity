// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.support.v4.d.a.b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ao, an, am, aq, 
//            ar, k

public final class al
{

    private static aq a;

    public static MenuItem a(MenuItem menuitem, ar ar)
    {
        if (menuitem instanceof b)
        {
            return ((b)menuitem).a(ar);
        } else
        {
            return a.a(menuitem, ar);
        }
    }

    public static MenuItem a(MenuItem menuitem, k k)
    {
        if (menuitem instanceof b)
        {
            return ((b)menuitem).a(k);
        } else
        {
            Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            return menuitem;
        }
    }

    public static MenuItem a(MenuItem menuitem, View view)
    {
        if (menuitem instanceof b)
        {
            return ((b)menuitem).setActionView(view);
        } else
        {
            return a.a(menuitem, view);
        }
    }

    public static View a(MenuItem menuitem)
    {
        if (menuitem instanceof b)
        {
            return ((b)menuitem).getActionView();
        } else
        {
            return a.a(menuitem);
        }
    }

    public static void a(MenuItem menuitem, int i)
    {
        if (menuitem instanceof b)
        {
            ((b)menuitem).setShowAsAction(i);
            return;
        } else
        {
            a.a(menuitem, i);
            return;
        }
    }

    public static MenuItem b(MenuItem menuitem, int i)
    {
        if (menuitem instanceof b)
        {
            return ((b)menuitem).setActionView(i);
        } else
        {
            return a.b(menuitem, i);
        }
    }

    public static boolean b(MenuItem menuitem)
    {
        if (menuitem instanceof b)
        {
            return ((b)menuitem).expandActionView();
        } else
        {
            return a.b(menuitem);
        }
    }

    public static boolean c(MenuItem menuitem)
    {
        if (menuitem instanceof b)
        {
            return ((b)menuitem).collapseActionView();
        } else
        {
            return a.c(menuitem);
        }
    }

    public static boolean d(MenuItem menuitem)
    {
        if (menuitem instanceof b)
        {
            return ((b)menuitem).isActionViewExpanded();
        } else
        {
            return a.d(menuitem);
        }
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14)
        {
            a = new ao();
        } else
        if (i >= 11)
        {
            a = new an();
        } else
        {
            a = new am();
        }
    }
}
