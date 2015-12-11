// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.e.a;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class c extends a
    implements android.support.v7.internal.view.menu.f.a
{

    private Context a;
    private ActionBarContextView d;
    private android.support.v7.e.a.a e;
    private WeakReference f;
    private boolean g;
    private boolean h;
    private f i;

    public c(Context context, ActionBarContextView actionbarcontextview, android.support.v7.e.a.a a1, boolean flag)
    {
        a = context;
        d = actionbarcontextview;
        e = a1;
        context = new f(actionbarcontextview.getContext());
        context.e = 1;
        i = context;
        i.a(this);
        h = flag;
    }

    public final MenuInflater a()
    {
        return new MenuInflater(d.getContext());
    }

    public final void a(int j)
    {
        b(a.getString(j));
    }

    public final void a(f f1)
    {
        d();
        d.a();
    }

    public final void a(View view)
    {
        d.setCustomView(view);
        if (view != null)
        {
            view = new WeakReference(view);
        } else
        {
            view = null;
        }
        f = view;
    }

    public final void a(CharSequence charsequence)
    {
        d.setSubtitle(charsequence);
    }

    public final void a(boolean flag)
    {
        super.a(flag);
        d.setTitleOptional(flag);
    }

    public final boolean a(f f1, MenuItem menuitem)
    {
        return e.a(this, menuitem);
    }

    public final Menu b()
    {
        return i;
    }

    public final void b(int j)
    {
        a(a.getString(j));
    }

    public final void b(CharSequence charsequence)
    {
        d.setTitle(charsequence);
    }

    public final void c()
    {
        if (g)
        {
            return;
        } else
        {
            g = true;
            d.sendAccessibilityEvent(32);
            e.a(this);
            return;
        }
    }

    public final void d()
    {
        e.b(this, i);
    }

    public final CharSequence f()
    {
        return d.getTitle();
    }

    public final CharSequence g()
    {
        return d.getSubtitle();
    }

    public final boolean h()
    {
        return d.k;
    }

    public final View i()
    {
        if (f != null)
        {
            return (View)f.get();
        } else
        {
            return null;
        }
    }
}
