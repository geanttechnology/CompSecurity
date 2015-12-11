// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.w;
import android.support.v7.a.a;
import android.support.v7.internal.view.g;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.h;
import android.support.v7.internal.widget.s;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import java.util.ArrayList;

public final class android.support.v7.internal.a.c extends android.support.v7.a.a
{
    private final class a
        implements android.support.v7.internal.view.menu.l.a
    {

        final android.support.v7.internal.a.c a;
        private boolean b;

        public final void a(f f1, boolean flag)
        {
            if (b)
            {
                return;
            }
            b = true;
            a.a.l();
            if (a.c != null)
            {
                a.c.onPanelClosed(8, f1);
            }
            b = false;
        }

        public final boolean a(f f1)
        {
            if (a.c != null)
            {
                a.c.onMenuOpened(8, f1);
                return true;
            } else
            {
                return false;
            }
        }

        private a()
        {
            a = android.support.v7.internal.a.c.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.support.v7.internal.view.menu.f.a
    {

        final android.support.v7.internal.a.c a;

        public final void a(f f1)
        {
            if (a.c != null)
            {
                if (a.a.g())
                {
                    a.c.onPanelClosed(8, f1);
                } else
                if (a.c.onPreparePanel(0, null, f1))
                {
                    a.c.onMenuOpened(8, f1);
                    return;
                }
            }
        }

        public final boolean a(f f1, MenuItem menuitem)
        {
            return false;
        }

        private b()
        {
            a = android.support.v7.internal.a.c.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c
        implements android.support.v7.internal.view.menu.l.a
    {

        final android.support.v7.internal.a.c a;

        public final void a(f f1, boolean flag)
        {
            if (a.c != null)
            {
                a.c.onPanelClosed(0, f1);
            }
        }

        public final boolean a(f f1)
        {
            if (f1 == null && a.c != null)
            {
                a.c.onMenuOpened(0, f1);
            }
            return true;
        }

        private c()
        {
            a = android.support.v7.internal.a.c.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }

    private final class d extends g
    {

        final android.support.v7.internal.a.c a;

        public final View onCreatePanelView(int j)
        {
            j;
            JVM INSTR tableswitch 0 0: default 20
        //                       0 26;
               goto _L1 _L2
_L1:
            Menu menu;
            return super.onCreatePanelView(j);
_L2:
            if (onPreparePanel(j, null, menu = a.a.q()) && onMenuOpened(j, menu))
            {
                android.support.v7.internal.a.c c1 = a;
                if (c1.d == null && (menu instanceof f))
                {
                    f f1 = (f)menu;
                    Object obj = c1.a.b();
                    TypedValue typedvalue = new TypedValue();
                    android.content.res.Resources.Theme theme = ((Context) (obj)).getResources().newTheme();
                    theme.setTo(((Context) (obj)).getTheme());
                    theme.resolveAttribute(android.support.v7.b.a.a.actionBarPopupTheme, typedvalue, true);
                    if (typedvalue.resourceId != 0)
                    {
                        theme.applyStyle(typedvalue.resourceId, true);
                    }
                    theme.resolveAttribute(android.support.v7.b.a.a.panelMenuListTheme, typedvalue, true);
                    if (typedvalue.resourceId != 0)
                    {
                        theme.applyStyle(typedvalue.resourceId, true);
                    } else
                    {
                        theme.applyStyle(android.support.v7.b.a.j.Theme_AppCompat_CompactMenu, true);
                    }
                    obj = new ContextThemeWrapper(((Context) (obj)), 0);
                    ((Context) (obj)).getTheme().setTo(theme);
                    c1.d = new e(((Context) (obj)), android.support.v7.b.a.h.abc_list_menu_item_layout);
                    c1.d.g = c1. new c((byte)0);
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

        public final boolean onPreparePanel(int j, View view, Menu menu)
        {
            boolean flag = super.onPreparePanel(j, view, menu);
            if (flag && !a.b)
            {
                a.a.k();
                a.b = true;
            }
            return flag;
        }

        public d(android.view.Window.Callback callback)
        {
            a = android.support.v7.internal.a.c.this;
            super(callback);
        }
    }


    h a;
    boolean b;
    public android.view.Window.Callback c;
    e d;
    private boolean e;
    private boolean f;
    private ArrayList g;
    private final Runnable h = new Runnable() {

        final android.support.v7.internal.a.c a;

        public final void run()
        {
            f f1;
            android.support.v7.internal.a.c c1 = a;
            Menu menu = c1.i();
            if (menu instanceof f)
            {
                f1 = (f)menu;
            } else
            {
                f1 = null;
            }
            if (f1 != null)
            {
                f1.d();
            }
            menu.clear();
            if (!c1.c.onCreatePanelMenu(0, menu) || !c1.c.onPreparePanel(0, null, menu))
            {
                menu.clear();
            }
            if (f1 != null)
            {
                f1.e();
            }
            return;
            Exception exception;
            exception;
            if (f1 != null)
            {
                f1.e();
            }
            throw exception;
        }

            
            {
                a = android.support.v7.internal.a.c.this;
                super();
            }
    };
    private final android.support.v7.widget.Toolbar.c i = new android.support.v7.widget.Toolbar.c() {

        final android.support.v7.internal.a.c a;

        public final boolean a(MenuItem menuitem)
        {
            return a.c.onMenuItemSelected(0, menuitem);
        }

            
            {
                a = android.support.v7.internal.a.c.this;
                super();
            }
    };

    public android.support.v7.internal.a.c(Toolbar toolbar, CharSequence charsequence, android.view.Window.Callback callback)
    {
        g = new ArrayList();
        a = new s(toolbar, false);
        c = new d(callback);
        a.a(c);
        toolbar.setOnMenuItemClickListener(i);
        a.a(charsequence);
    }

    private void a(int j, int k)
    {
        int l = a.m();
        a.c(l & ~k | j & k);
    }

    public final int a()
    {
        return a.m();
    }

    public final void a(Configuration configuration)
    {
        super.a(configuration);
    }

    public final void a(CharSequence charsequence)
    {
        a.b(charsequence);
    }

    public final void a(boolean flag)
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

    public final boolean a(int j, KeyEvent keyevent)
    {
        boolean flag = false;
        Menu menu = i();
        if (menu != null)
        {
            flag = menu.performShortcut(j, keyevent, 0);
        }
        return flag;
    }

    public final int b()
    {
        return a.o();
    }

    public final void b(CharSequence charsequence)
    {
        a.a(charsequence);
    }

    public final void b(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        a(byte0, 8);
    }

    public final void c()
    {
        a.e(0);
    }

    public final void c(boolean flag)
    {
    }

    public final void d()
    {
        a.e(8);
    }

    public final void d(boolean flag)
    {
    }

    public final void e(boolean flag)
    {
        if (flag != f)
        {
            f = flag;
            int k = g.size();
            int j = 0;
            while (j < k) 
            {
                g.get(j);
                j++;
            }
        }
    }

    public final boolean e()
    {
        return a.p() == 0;
    }

    public final Context f()
    {
        return a.b();
    }

    public final boolean g()
    {
        a.a().removeCallbacks(h);
        w.a(a.a(), h);
        return true;
    }

    public final boolean h()
    {
        if (a.c())
        {
            a.d();
            return true;
        } else
        {
            return false;
        }
    }

    final Menu i()
    {
        if (!e)
        {
            a.a(new a((byte)0), new b((byte)0));
            e = true;
        }
        return a.q();
    }
}
