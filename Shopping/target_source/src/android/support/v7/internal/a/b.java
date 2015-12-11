// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v7.app.a;
import android.support.v7.internal.view.g;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.h;
import android.support.v7.internal.widget.t;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class android.support.v7.internal.a.b extends android.support.v7.app.a
{
    private final class a
        implements android.support.v7.internal.view.menu.l.a
    {

        final android.support.v7.internal.a.b a;
        private boolean b;

        public void a(f f1, boolean flag)
        {
            if (b)
            {
                return;
            }
            b = true;
            android.support.v7.internal.a.b.c(a).o();
            if (android.support.v7.internal.a.b.a(a) != null)
            {
                android.support.v7.internal.a.b.a(a).onPanelClosed(8, f1);
            }
            b = false;
        }

        public boolean a_(f f1)
        {
            if (android.support.v7.internal.a.b.a(a) != null)
            {
                android.support.v7.internal.a.b.a(a).onMenuOpened(8, f1);
                return true;
            } else
            {
                return false;
            }
        }

        private a()
        {
            a = android.support.v7.internal.a.b.this;
            super();
        }

    }

    private final class b
        implements android.support.v7.internal.view.menu.f.a
    {

        final android.support.v7.internal.a.b a;

        public void a(f f1)
        {
            if (android.support.v7.internal.a.b.a(a) != null)
            {
                if (android.support.v7.internal.a.b.c(a).j())
                {
                    android.support.v7.internal.a.b.a(a).onPanelClosed(8, f1);
                } else
                if (android.support.v7.internal.a.b.a(a).onPreparePanel(0, null, f1))
                {
                    android.support.v7.internal.a.b.a(a).onMenuOpened(8, f1);
                    return;
                }
            }
        }

        public boolean a(f f1, MenuItem menuitem)
        {
            return false;
        }

        private b()
        {
            a = android.support.v7.internal.a.b.this;
            super();
        }

    }

    private final class c
        implements android.support.v7.internal.view.menu.l.a
    {

        final android.support.v7.internal.a.b a;

        public void a(f f1, boolean flag)
        {
            if (android.support.v7.internal.a.b.a(a) != null)
            {
                android.support.v7.internal.a.b.a(a).onPanelClosed(0, f1);
            }
        }

        public boolean a_(f f1)
        {
            if (f1 == null && android.support.v7.internal.a.b.a(a) != null)
            {
                android.support.v7.internal.a.b.a(a).onMenuOpened(0, f1);
            }
            return true;
        }

        private c()
        {
            a = android.support.v7.internal.a.b.this;
            super();
        }

    }

    private class d extends g
    {

        final android.support.v7.internal.a.b a;

        public View onCreatePanelView(int k)
        {
            k;
            JVM INSTR tableswitch 0 0: default 20
        //                       0 26;
               goto _L1 _L2
_L1:
            Menu menu;
            return super.onCreatePanelView(k);
_L2:
            if (onPreparePanel(k, null, menu = android.support.v7.internal.a.b.c(a).r()) && onMenuOpened(k, menu))
            {
                return android.support.v7.internal.a.b.a(a, menu);
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public boolean onPreparePanel(int k, View view, Menu menu)
        {
            boolean flag = super.onPreparePanel(k, view, menu);
            if (flag && !android.support.v7.internal.a.b.b(a))
            {
                android.support.v7.internal.a.b.c(a).n();
                android.support.v7.internal.a.b.a(a, true);
            }
            return flag;
        }

        public d(android.view.Window.Callback callback)
        {
            a = android.support.v7.internal.a.b.this;
            super(callback);
        }
    }


    private h a;
    private boolean b;
    private android.view.Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList f;
    private Window g;
    private e h;
    private final Runnable i = new Runnable() {

        final android.support.v7.internal.a.b a;

        public void run()
        {
            a.f();
        }

            
            {
                a = android.support.v7.internal.a.b.this;
                super();
            }
    };
    private final android.support.v7.widget.Toolbar.c j = new android.support.v7.widget.Toolbar.c() {

        final android.support.v7.internal.a.b a;

        public boolean a(MenuItem menuitem)
        {
            return android.support.v7.internal.a.b.a(a).onMenuItemSelected(0, menuitem);
        }

            
            {
                a = android.support.v7.internal.a.b.this;
                super();
            }
    };

    public android.support.v7.internal.a.b(Toolbar toolbar, CharSequence charsequence, Window window)
    {
        f = new ArrayList();
        a = new t(toolbar, false);
        c = new d(window.getCallback());
        a.a(c);
        toolbar.setOnMenuItemClickListener(j);
        a.a(charsequence);
        g = window;
    }

    static View a(android.support.v7.internal.a.b b1, Menu menu)
    {
        return b1.a(menu);
    }

    private View a(Menu menu)
    {
        b(menu);
        while (menu == null || h == null || h.d().getCount() <= 0) 
        {
            return null;
        }
        return (View)h.a(a.a());
    }

    static android.view.Window.Callback a(android.support.v7.internal.a.b b1)
    {
        return b1.c;
    }

    static boolean a(android.support.v7.internal.a.b b1, boolean flag)
    {
        b1.b = flag;
        return flag;
    }

    private void b(Menu menu)
    {
        if (h == null && (menu instanceof f))
        {
            menu = (f)menu;
            Object obj = a.b();
            TypedValue typedvalue = new TypedValue();
            android.content.res.Resources.Theme theme = ((Context) (obj)).getResources().newTheme();
            theme.setTo(((Context) (obj)).getTheme());
            theme.resolveAttribute(android.support.v7.a.a.a.panelMenuListTheme, typedvalue, true);
            if (typedvalue.resourceId != 0)
            {
                theme.applyStyle(typedvalue.resourceId, true);
            } else
            {
                theme.applyStyle(android.support.v7.a.a.j.Theme_AppCompat_CompactMenu, true);
            }
            obj = new ContextThemeWrapper(((Context) (obj)), 0);
            ((Context) (obj)).getTheme().setTo(theme);
            h = new e(((Context) (obj)), android.support.v7.a.a.h.abc_list_menu_item_layout);
            h.a(new c());
            menu.a(h);
        }
    }

    static boolean b(android.support.v7.internal.a.b b1)
    {
        return b1.b;
    }

    static h c(android.support.v7.internal.a.b b1)
    {
        return b1.a;
    }

    private Menu g()
    {
        if (!d)
        {
            a.a(new a(), new b());
            d = true;
        }
        return a.r();
    }

    public int a()
    {
        return a.p();
    }

    public void a(float f1)
    {
        ai.f(a.a(), f1);
    }

    public void a(int k)
    {
        a.e(k);
    }

    public void a(int k, int l)
    {
        int i1 = a.p();
        a.c(i1 & ~l | k & l);
    }

    public void a(Configuration configuration)
    {
        super.a(configuration);
    }

    public void a(Drawable drawable)
    {
        a.b(drawable);
    }

    public void a(CharSequence charsequence)
    {
        a.b(charsequence);
    }

    public void a(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        a(byte0, 4);
    }

    public boolean a(int k, KeyEvent keyevent)
    {
        boolean flag = false;
        Menu menu = g();
        if (menu != null)
        {
            flag = menu.performShortcut(k, keyevent, 0);
        }
        return flag;
    }

    public Context b()
    {
        return a.b();
    }

    public void b(CharSequence charsequence)
    {
        a.a(charsequence);
    }

    public void b(boolean flag)
    {
    }

    public boolean c()
    {
        a.a().removeCallbacks(i);
        ai.a(a.a(), i);
        return true;
    }

    public void d(boolean flag)
    {
    }

    public boolean d()
    {
        if (a.d())
        {
            a.e();
            return true;
        } else
        {
            return false;
        }
    }

    public android.view.Window.Callback e()
    {
        return c;
    }

    public void e(boolean flag)
    {
    }

    void f()
    {
        f f1;
        Menu menu = g();
        if (menu instanceof f)
        {
            f1 = (f)menu;
        } else
        {
            f1 = null;
        }
        if (f1 != null)
        {
            f1.g();
        }
        menu.clear();
        if (!c.onCreatePanelMenu(0, menu) || !c.onPreparePanel(0, null, menu))
        {
            menu.clear();
        }
        if (f1 != null)
        {
            f1.h();
        }
        return;
        Exception exception;
        exception;
        if (f1 != null)
        {
            f1.h();
        }
        throw exception;
    }

    public void f(boolean flag)
    {
        if (flag != e)
        {
            e = flag;
            int l = f.size();
            int k = 0;
            while (k < l) 
            {
                ((android.support.v7.app.a.b)f.get(k)).a(flag);
                k++;
            }
        }
    }
}
