// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.e.a;
import android.support.v7.internal.a.d;
import android.support.v7.internal.view.e;
import android.support.v7.internal.view.g;
import android.support.v7.internal.view.menu.f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v7.a:
//            h, a, g

abstract class i extends h
{
    private final class a
        implements c.a
    {

        final i a;

        private a()
        {
            a = i.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    class b extends g
    {

        final i a;

        public boolean dispatchKeyEvent(KeyEvent keyevent)
        {
            if (a.a(keyevent))
            {
                return true;
            } else
            {
                return super.dispatchKeyEvent(keyevent);
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
            if (a.d(i1))
            {
                return true;
            } else
            {
                return super.onMenuOpened(i1, menu);
            }
        }

        public void onPanelClosed(int i1, Menu menu)
        {
            if (a.c(i1))
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
                    f1.k = true;
                }
                boolean flag1 = super.onPreparePanel(i1, view, menu);
                flag = flag1;
                if (f1 != null)
                {
                    f1.k = false;
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
    final android.view.Window.Callback d;
    final android.support.v7.a.g e;
    android.support.v7.a.a f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    CharSequence l;
    boolean m;
    private MenuInflater n;

    i(Context context, Window window, android.support.v7.a.g g1)
    {
        a = context;
        b = window;
        e = g1;
        c = b.getCallback();
        if (c instanceof b)
        {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        } else
        {
            d = a(c);
            b.setCallback(d);
            return;
        }
    }

    public final android.support.v7.a.a a()
    {
        if (!g) goto _L2; else goto _L1
_L1:
        if (f == null)
        {
            f = j();
        }
_L4:
        return f;
_L2:
        if (f instanceof d)
        {
            f = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    android.view.Window.Callback a(android.view.Window.Callback callback)
    {
        return new b(callback);
    }

    public void a(Bundle bundle)
    {
        bundle = a.obtainStyledAttributes(android.support.v7.b.a.k.Theme);
        if (!bundle.hasValue(android.support.v7.b.a.k.Theme_windowActionBar))
        {
            bundle.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (bundle.getBoolean(android.support.v7.b.a.k.Theme_windowActionBar, false))
        {
            g = true;
        }
        if (bundle.getBoolean(android.support.v7.b.a.k.Theme_windowActionBarOverlay, false))
        {
            h = true;
        }
        if (bundle.getBoolean(android.support.v7.b.a.k.Theme_windowActionModeOverlay, false))
        {
            i = true;
        }
        j = bundle.getBoolean(android.support.v7.b.a.k.Theme_android_windowIsFloating, false);
        k = bundle.getBoolean(android.support.v7.b.a.k.Theme_windowNoTitle, false);
        bundle.recycle();
    }

    public final void a(CharSequence charsequence)
    {
        l = charsequence;
        b(charsequence);
    }

    abstract boolean a(int i1, KeyEvent keyevent);

    abstract boolean a(KeyEvent keyevent);

    abstract android.support.v7.e.a b(android.support.v7.e.a.a a1);

    public final MenuInflater b()
    {
        if (n == null)
        {
            n = new e(k());
        }
        return n;
    }

    abstract void b(CharSequence charsequence);

    abstract boolean c(int i1);

    abstract boolean d(int i1);

    public final void g()
    {
        m = true;
    }

    public final c.a h()
    {
        return new a((byte)0);
    }

    abstract android.support.v7.a.a j();

    final Context k()
    {
        Context context = null;
        Object obj = a();
        if (obj != null)
        {
            context = ((android.support.v7.a.a) (obj)).f();
        }
        obj = context;
        if (context == null)
        {
            obj = a;
        }
        return ((Context) (obj));
    }
}
