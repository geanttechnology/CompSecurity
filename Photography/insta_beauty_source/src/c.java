// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public abstract class c
{

    public final ActionBarActivity a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    final ad f = new d(this);
    private ActionBar g;
    private MenuInflater h;
    private ad i;
    private boolean j;

    public c(ActionBarActivity actionbaractivity)
    {
        a = actionbaractivity;
        i = f;
    }

    public static c a(ActionBarActivity actionbaractivity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return new n(actionbaractivity);
        } else
        {
            return new ActionBarActivityDelegateBase(actionbaractivity);
        }
    }

    public abstract ActionBar a();

    public abstract View a(String s, Context context, AttributeSet attributeset);

    public abstract ee a(ef ef);

    public abstract void a(int i1);

    public abstract void a(int i1, Menu menu);

    public abstract void a(Configuration configuration);

    public void a(Bundle bundle)
    {
        bundle = a.obtainStyledAttributes(ab.Theme);
        if (!bundle.hasValue(ab.Theme_windowActionBar))
        {
            bundle.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (bundle.getBoolean(ab.Theme_windowActionBar, false))
        {
            b = true;
        }
        if (bundle.getBoolean(ab.Theme_windowActionBarOverlay, false))
        {
            c = true;
        }
        if (bundle.getBoolean(ab.Theme_windowActionModeOverlay, false))
        {
            d = true;
        }
        e = bundle.getBoolean(ab.Theme_android_windowIsFloating, false);
        bundle.recycle();
    }

    public abstract void a(View view);

    public abstract void a(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract void a(CharSequence charsequence);

    public boolean a(int i1, KeyEvent keyevent)
    {
        return false;
    }

    public abstract boolean a(int i1, View view, Menu menu);

    public boolean a(View view, Menu menu)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            return a.onPrepareOptionsMenu(menu);
        } else
        {
            return a.a(view, menu);
        }
    }

    public final ActionBar b()
    {
        if (b && g == null)
        {
            g = a();
        }
        return g;
    }

    public abstract View b(int i1);

    public abstract void b(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract boolean b(int i1, KeyEvent keyevent);

    public abstract boolean b(int i1, Menu menu);

    public final ActionBar c()
    {
        return g;
    }

    public abstract boolean c(int i1, Menu menu);

    public MenuInflater d()
    {
        if (h == null)
        {
            h = new ap(l());
        }
        return h;
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract boolean h();

    public final android.support.v4.app.ActionBarDrawerToggle.Delegate i()
    {
        return new e(this, null);
    }

    public abstract int j();

    public abstract void k();

    public final Context l()
    {
        Context context = null;
        Object obj = b();
        if (obj != null)
        {
            context = ((ActionBar) (obj)).b();
        }
        obj = context;
        if (context == null)
        {
            obj = a;
        }
        return ((Context) (obj));
    }

    public final ad m()
    {
        return i;
    }

    public final void n()
    {
        j = true;
    }

    public final boolean o()
    {
        return j;
    }
}
