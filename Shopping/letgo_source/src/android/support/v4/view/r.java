// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.support.v7.ag;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            d, s, t

public class r
{
    static class a
        implements d
    {

        public MenuItem a(MenuItem menuitem, View view)
        {
            return menuitem;
        }

        public View a(MenuItem menuitem)
        {
            return null;
        }

        public void a(MenuItem menuitem, int i)
        {
        }

        public MenuItem b(MenuItem menuitem, int i)
        {
            return menuitem;
        }

        public boolean b(MenuItem menuitem)
        {
            return false;
        }

        public boolean c(MenuItem menuitem)
        {
            return false;
        }

        a()
        {
        }
    }

    static class b
        implements d
    {

        public MenuItem a(MenuItem menuitem, View view)
        {
            return s.a(menuitem, view);
        }

        public View a(MenuItem menuitem)
        {
            return s.a(menuitem);
        }

        public void a(MenuItem menuitem, int i)
        {
            s.a(menuitem, i);
        }

        public MenuItem b(MenuItem menuitem, int i)
        {
            return s.b(menuitem, i);
        }

        public boolean b(MenuItem menuitem)
        {
            return false;
        }

        public boolean c(MenuItem menuitem)
        {
            return false;
        }

        b()
        {
        }
    }

    static class c extends b
    {

        public boolean b(MenuItem menuitem)
        {
            return t.a(menuitem);
        }

        public boolean c(MenuItem menuitem)
        {
            return t.b(menuitem);
        }

        c()
        {
        }
    }

    static interface d
    {

        public abstract MenuItem a(MenuItem menuitem, View view);

        public abstract View a(MenuItem menuitem);

        public abstract void a(MenuItem menuitem, int i);

        public abstract MenuItem b(MenuItem menuitem, int i);

        public abstract boolean b(MenuItem menuitem);

        public abstract boolean c(MenuItem menuitem);
    }

    public static interface e
    {

        public abstract boolean a(MenuItem menuitem);

        public abstract boolean b(MenuItem menuitem);
    }


    static final d a;

    public static MenuItem a(MenuItem menuitem, android.support.v4.view.d d1)
    {
        if (menuitem instanceof ag)
        {
            return ((ag)menuitem).a(d1);
        } else
        {
            Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            return menuitem;
        }
    }

    public static MenuItem a(MenuItem menuitem, View view)
    {
        if (menuitem instanceof ag)
        {
            return ((ag)menuitem).setActionView(view);
        } else
        {
            return a.a(menuitem, view);
        }
    }

    public static View a(MenuItem menuitem)
    {
        if (menuitem instanceof ag)
        {
            return ((ag)menuitem).getActionView();
        } else
        {
            return a.a(menuitem);
        }
    }

    public static void a(MenuItem menuitem, int i)
    {
        if (menuitem instanceof ag)
        {
            ((ag)menuitem).setShowAsAction(i);
            return;
        } else
        {
            a.a(menuitem, i);
            return;
        }
    }

    public static MenuItem b(MenuItem menuitem, int i)
    {
        if (menuitem instanceof ag)
        {
            return ((ag)menuitem).setActionView(i);
        } else
        {
            return a.b(menuitem, i);
        }
    }

    public static boolean b(MenuItem menuitem)
    {
        if (menuitem instanceof ag)
        {
            return ((ag)menuitem).expandActionView();
        } else
        {
            return a.b(menuitem);
        }
    }

    public static boolean c(MenuItem menuitem)
    {
        if (menuitem instanceof ag)
        {
            return ((ag)menuitem).isActionViewExpanded();
        } else
        {
            return a.c(menuitem);
        }
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14)
        {
            a = new c();
        } else
        if (i >= 11)
        {
            a = new b();
        } else
        {
            a = new a();
        }
    }
}
