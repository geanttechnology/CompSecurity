// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ah;
import android.support.v7.app.ActionBar;
import android.support.v7.internal.view.menu.e;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.g;
import android.support.v7.internal.widget.r;
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

// Referenced classes of package android.support.v7:
//            cg

public class bw extends ActionBar
{
    private final class a
        implements android.support.v7.internal.view.menu.l.a
    {

        final bw a;
        private boolean b;

        public void onCloseMenu(f f1, boolean flag)
        {
            if (b)
            {
                return;
            }
            b = true;
            bw.c(a).o();
            if (bw.a(a) != null)
            {
                bw.a(a).onPanelClosed(8, f1);
            }
            b = false;
        }

        public boolean onOpenSubMenu(f f1)
        {
            if (bw.a(a) != null)
            {
                bw.a(a).onMenuOpened(8, f1);
                return true;
            } else
            {
                return false;
            }
        }

        private a()
        {
            a = bw.this;
            super();
        }

    }

    private final class b
        implements android.support.v7.internal.view.menu.f.a
    {

        final bw a;

        public boolean onMenuItemSelected(f f1, MenuItem menuitem)
        {
            return false;
        }

        public void onMenuModeChange(f f1)
        {
            if (bw.a(a) != null)
            {
                if (bw.c(a).j())
                {
                    bw.a(a).onPanelClosed(8, f1);
                } else
                if (bw.a(a).onPreparePanel(0, null, f1))
                {
                    bw.a(a).onMenuOpened(8, f1);
                    return;
                }
            }
        }

        private b()
        {
            a = bw.this;
            super();
        }

    }

    private final class c
        implements android.support.v7.internal.view.menu.l.a
    {

        final bw a;

        public void onCloseMenu(f f1, boolean flag)
        {
            if (bw.a(a) != null)
            {
                bw.a(a).onPanelClosed(0, f1);
            }
        }

        public boolean onOpenSubMenu(f f1)
        {
            if (f1 == null && bw.a(a) != null)
            {
                bw.a(a).onMenuOpened(0, f1);
            }
            return true;
        }

        private c()
        {
            a = bw.this;
            super();
        }

    }

    private class d extends cg
    {

        final bw a;

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
            if (onPreparePanel(k, null, menu = bw.c(a).s()) && onMenuOpened(k, menu))
            {
                return bw.a(a, menu);
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public boolean onPreparePanel(int k, View view, Menu menu)
        {
            boolean flag = super.onPreparePanel(k, view, menu);
            if (flag && !bw.b(a))
            {
                bw.c(a).n();
                bw.a(a, true);
            }
            return flag;
        }

        public d(android.view.Window.Callback callback)
        {
            a = bw.this;
            super(callback);
        }
    }


    private g a;
    private boolean b;
    private android.view.Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList f;
    private Window g;
    private e h;
    private final Runnable i = new Runnable() {

        final bw a;

        public void run()
        {
            a.g();
        }

            
            {
                a = bw.this;
                super();
            }
    };
    private final android.support.v7.widget.Toolbar.OnMenuItemClickListener j = new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {

        final bw a;

        public boolean onMenuItemClick(MenuItem menuitem)
        {
            return bw.a(a).onMenuItemSelected(0, menuitem);
        }

            
            {
                a = bw.this;
                super();
            }
    };

    public bw(Toolbar toolbar, CharSequence charsequence, Window window)
    {
        f = new ArrayList();
        a = new r(toolbar, false);
        c = new d(window.getCallback());
        a.a(c);
        toolbar.setOnMenuItemClickListener(j);
        a.a(charsequence);
        g = window;
    }

    static View a(bw bw1, Menu menu)
    {
        return bw1.a(menu);
    }

    private View a(Menu menu)
    {
        b(menu);
        while (menu == null || h == null || h.a().getCount() <= 0) 
        {
            return null;
        }
        return (View)h.a(a.a());
    }

    static android.view.Window.Callback a(bw bw1)
    {
        return bw1.c;
    }

    static boolean a(bw bw1, boolean flag)
    {
        bw1.b = flag;
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
            theme.resolveAttribute(br.a.panelMenuListTheme, typedvalue, true);
            if (typedvalue.resourceId != 0)
            {
                theme.applyStyle(typedvalue.resourceId, true);
            } else
            {
                theme.applyStyle(br.j.Theme_AppCompat_CompactMenu, true);
            }
            obj = new ContextThemeWrapper(((Context) (obj)), 0);
            ((Context) (obj)).getTheme().setTo(theme);
            h = new e(((Context) (obj)), br.h.abc_list_menu_item_layout);
            h.a(new c());
            menu.a(h);
        }
    }

    static boolean b(bw bw1)
    {
        return bw1.b;
    }

    static g c(bw bw1)
    {
        return bw1.a;
    }

    private Menu h()
    {
        if (!d)
        {
            a.a(new a(), new b());
            d = true;
        }
        return a.s();
    }

    public View a()
    {
        return a.r();
    }

    public void a(float f1)
    {
        ah.f(a.a(), f1);
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

    public void a(View view, android.support.v7.app.ActionBar.LayoutParams layoutparams)
    {
        view.setLayoutParams(layoutparams);
        a.a(view);
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
        Menu menu = h();
        if (menu != null)
        {
            flag = menu.performShortcut(k, keyevent, 0);
        }
        return flag;
    }

    public int b()
    {
        return a.p();
    }

    public void b(CharSequence charsequence)
    {
        a.a(charsequence);
    }

    public void b(boolean flag)
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

    public Context c()
    {
        return a.b();
    }

    public void c(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 16;
        } else
        {
            byte0 = 0;
        }
        a(byte0, 16);
    }

    public void d(boolean flag)
    {
    }

    public boolean d()
    {
        a.a().removeCallbacks(i);
        ah.a(a.a(), i);
        return true;
    }

    public boolean e()
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

    public android.view.Window.Callback f()
    {
        return c;
    }

    public void f(boolean flag)
    {
    }

    void g()
    {
        f f1;
        Menu menu = h();
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

    public void g(boolean flag)
    {
    }

    public void h(boolean flag)
    {
        if (flag != e)
        {
            e = flag;
            int l = f.size();
            int k = 0;
            while (k < l) 
            {
                ((android.support.v7.app.ActionBar.a)f.get(k)).a(flag);
                k++;
            }
        }
    }
}
