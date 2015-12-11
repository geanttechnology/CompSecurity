// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.d.a;
import android.support.v7.internal.a.c;
import android.support.v7.internal.view.e;
import android.support.v7.internal.view.g;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.s;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            h, a, g

abstract class i extends h
{
    private class a
        implements b.a
    {

        final i a;

        public Drawable a()
        {
            s s1 = s.a(b(), null, new int[] {
                android.support.v7.a.a.a.homeAsUpIndicator
            });
            Drawable drawable = s1.a(0);
            s1.b();
            return drawable;
        }

        public void a(int i1)
        {
            android.support.v7.app.a a1 = a.a();
            if (a1 != null)
            {
                a1.a(i1);
            }
        }

        public void a(Drawable drawable, int i1)
        {
            android.support.v7.app.a a1 = a.a();
            if (a1 != null)
            {
                a1.a(drawable);
                a1.a(i1);
            }
        }

        public Context b()
        {
            return a.k();
        }

        public boolean c()
        {
            android.support.v7.app.a a1 = a.a();
            return a1 != null && (a1.a() & 4) != 0;
        }

        private a()
        {
            a = i.this;
            super();
        }

    }

    class b extends g
    {

        final i a;

        public boolean dispatchKeyEvent(KeyEvent keyevent)
        {
            if (super.dispatchKeyEvent(keyevent))
            {
                return true;
            } else
            {
                return a.a(keyevent);
            }
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
        {
            if (a.a(keyevent.getKeyCode(), keyevent))
            {
                return true;
            } else
            {
                return super.dispatchKeyShortcutEvent(keyevent);
            }
        }

        public void onContentChanged()
        {
        }

        public boolean onCreatePanelMenu(int i1, Menu menu)
        {
            if (i1 == 0 && !(menu instanceof f))
            {
                return false;
            } else
            {
                return super.onCreatePanelMenu(i1, menu);
            }
        }

        public boolean onMenuOpened(int i1, Menu menu)
        {
            if (a.b(i1, menu))
            {
                return true;
            } else
            {
                return super.onMenuOpened(i1, menu);
            }
        }

        public void onPanelClosed(int i1, Menu menu)
        {
            if (a.a(i1, menu))
            {
                return;
            } else
            {
                super.onPanelClosed(i1, menu);
                return;
            }
        }

        public boolean onPreparePanel(int i1, View view, Menu menu)
        {
            f f1;
            boolean flag;
            if (menu instanceof f)
            {
                f1 = (f)menu;
            } else
            {
                f1 = null;
            }
            if (i1 == 0 && f1 == null)
            {
                flag = false;
            } else
            {
                if (f1 != null)
                {
                    f1.c(true);
                }
                boolean flag1 = super.onPreparePanel(i1, view, menu);
                flag = flag1;
                if (f1 != null)
                {
                    f1.c(false);
                    return flag1;
                }
            }
            return flag;
        }

        b(android.view.Window.Callback callback)
        {
            a = i.this;
            super(callback);
        }
    }


    final Context a;
    final Window b;
    final android.view.Window.Callback c;
    final android.support.v7.app.g d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    private android.support.v7.app.a j;
    private MenuInflater k;
    private CharSequence l;
    private boolean m;

    i(Context context, Window window, android.support.v7.app.g g1)
    {
        a = context;
        b = window;
        d = g1;
        c = b.getCallback();
        if (c instanceof b)
        {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        } else
        {
            b.setCallback(a(c));
            return;
        }
    }

    public android.support.v7.app.a a()
    {
        if (!e) goto _L2; else goto _L1
_L1:
        if (j == null)
        {
            j = i();
        }
_L4:
        return j;
_L2:
        if (j instanceof c)
        {
            j = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    abstract android.support.v7.d.a a(android.support.v7.d.a.a a1);

    android.view.Window.Callback a(android.view.Window.Callback callback)
    {
        return new b(callback);
    }

    public void a(Bundle bundle)
    {
        bundle = a.obtainStyledAttributes(android.support.v7.a.a.k.Theme);
        if (!bundle.hasValue(android.support.v7.a.a.k.Theme_windowActionBar))
        {
            bundle.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (bundle.getBoolean(android.support.v7.a.a.k.Theme_windowActionBar, false))
        {
            e = true;
        }
        if (bundle.getBoolean(android.support.v7.a.a.k.Theme_windowActionBarOverlay, false))
        {
            f = true;
        }
        if (bundle.getBoolean(android.support.v7.a.a.k.Theme_windowActionModeOverlay, false))
        {
            g = true;
        }
        h = bundle.getBoolean(android.support.v7.a.a.k.Theme_android_windowIsFloating, false);
        i = bundle.getBoolean(android.support.v7.a.a.k.Theme_windowNoTitle, false);
        bundle.recycle();
    }

    final void a(android.support.v7.app.a a1)
    {
        j = a1;
    }

    public final void a(CharSequence charsequence)
    {
        l = charsequence;
        b(charsequence);
    }

    abstract boolean a(int i1, KeyEvent keyevent);

    abstract boolean a(int i1, Menu menu);

    abstract boolean a(KeyEvent keyevent);

    public MenuInflater b()
    {
        if (k == null)
        {
            k = new e(k());
        }
        return k;
    }

    abstract void b(CharSequence charsequence);

    abstract boolean b(int i1, Menu menu);

    public final void f()
    {
        m = true;
    }

    public final b.a g()
    {
        return new a();
    }

    abstract android.support.v7.app.a i();

    final android.support.v7.app.a j()
    {
        return j;
    }

    final Context k()
    {
        Context context = null;
        Object obj = a();
        if (obj != null)
        {
            context = ((android.support.v7.app.a) (obj)).b();
        }
        obj = context;
        if (context == null)
        {
            obj = a;
        }
        return ((Context) (obj));
    }

    final boolean l()
    {
        return m;
    }

    final android.view.Window.Callback m()
    {
        return b.getCallback();
    }

    final CharSequence n()
    {
        if (c instanceof Activity)
        {
            return ((Activity)c).getTitle();
        } else
        {
            return l;
        }
    }
}
