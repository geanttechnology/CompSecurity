// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class am extends ee
    implements bb
{

    private Context a;
    private ActionBarContextView b;
    private ef c;
    private WeakReference d;
    private boolean e;
    private boolean f;
    private MenuBuilder g;

    public am(Context context, ActionBarContextView actionbarcontextview, ef ef1, boolean flag)
    {
        a = context;
        b = actionbarcontextview;
        c = ef1;
        g = (new MenuBuilder(context)).a(1);
        g.a(this);
        f = flag;
    }

    public MenuInflater a()
    {
        return new MenuInflater(a);
    }

    public void a(int j)
    {
        b(a.getString(j));
    }

    public void a(MenuBuilder menubuilder)
    {
        d();
        b.showOverflowMenu();
    }

    public void a(View view)
    {
        b.setCustomView(view);
        if (view != null)
        {
            view = new WeakReference(view);
        } else
        {
            view = null;
        }
        d = view;
    }

    public void a(CharSequence charsequence)
    {
        b.setSubtitle(charsequence);
    }

    public void a(boolean flag)
    {
        super.a(flag);
        b.setTitleOptional(flag);
    }

    public boolean a(MenuBuilder menubuilder, MenuItem menuitem)
    {
        return c.a(this, menuitem);
    }

    public Menu b()
    {
        return g;
    }

    public void b(int j)
    {
        a(a.getString(j));
    }

    public void b(CharSequence charsequence)
    {
        b.setTitle(charsequence);
    }

    public void c()
    {
        if (e)
        {
            return;
        } else
        {
            e = true;
            b.sendAccessibilityEvent(32);
            c.a(this);
            return;
        }
    }

    public void d()
    {
        c.b(this, g);
    }

    public CharSequence f()
    {
        return b.getTitle();
    }

    public CharSequence g()
    {
        return b.getSubtitle();
    }

    public boolean h()
    {
        return b.isTitleOptional();
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
