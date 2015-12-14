// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class n extends cn
    implements af
{

    final m a;
    private co b;
    private MenuBuilder c;
    private WeakReference d;

    public n(m m1, co co1)
    {
        a = m1;
        super();
        b = co1;
        c = (new MenuBuilder(m1.b())).a(1);
        c.a(this);
    }

    public MenuInflater a()
    {
        return new u(a.b());
    }

    public void a(int j)
    {
        b(m.k(a).getResources().getString(j));
    }

    public void a(MenuBuilder menubuilder)
    {
        if (b == null)
        {
            return;
        } else
        {
            d();
            m.i(a).showOverflowMenu();
            return;
        }
    }

    public void a(View view)
    {
        m.i(a).setCustomView(view);
        d = new WeakReference(view);
    }

    public void a(CharSequence charsequence)
    {
        m.i(a).setSubtitle(charsequence);
    }

    public void a(boolean flag)
    {
        super.a(flag);
        m.i(a).setTitleOptional(flag);
    }

    public boolean a(MenuBuilder menubuilder, MenuItem menuitem)
    {
        if (b != null)
        {
            return b.a(this, menuitem);
        } else
        {
            return false;
        }
    }

    public Menu b()
    {
        return c;
    }

    public void b(int j)
    {
        a(m.k(a).getResources().getString(j));
    }

    public void b(CharSequence charsequence)
    {
        m.i(a).setTitle(charsequence);
    }

    public void c()
    {
        if (a.a != this)
        {
            return;
        }
        if (!m.a(m.g(a), m.h(a), false))
        {
            a.b = this;
            a.c = b;
        } else
        {
            b.a(this);
        }
        b = null;
        a.j(false);
        m.i(a).closeMode();
        m.j(a).a().sendAccessibilityEvent(32);
        m.f(a).setHideOnContentScrollEnabled(a.d);
        a.a = null;
    }

    public void d()
    {
        c.g();
        b.b(this, c);
        c.h();
        return;
        Exception exception;
        exception;
        c.h();
        throw exception;
    }

    public boolean e()
    {
        c.g();
        boolean flag = b.a(this, c);
        c.h();
        return flag;
        Exception exception;
        exception;
        c.h();
        throw exception;
    }

    public CharSequence f()
    {
        return m.i(a).getTitle();
    }

    public CharSequence g()
    {
        return m.i(a).getSubtitle();
    }

    public boolean h()
    {
        return m.i(a).isTitleOptional();
    }

    public View i()
    {
        if (d != null)
        {
            return (View)d.get();
        } else
        {
            return null;
        }
    }
}
