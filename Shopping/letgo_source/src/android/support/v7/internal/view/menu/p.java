// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.i;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

// Referenced classes of package android.support.v7.internal.view.menu:
//            f, h

public class p extends f
    implements SubMenu
{

    private f d;
    private h e;

    public p(Context context, f f1, h h1)
    {
        super(context);
        d = f1;
        e = h1;
    }

    public String a()
    {
        int j;
        if (e != null)
        {
            j = e.getItemId();
        } else
        {
            j = 0;
        }
        if (j == 0)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(super.a()).append(":").append(j).toString();
        }
    }

    public void a(f.a a1)
    {
        d.a(a1);
    }

    boolean a(f f1, MenuItem menuitem)
    {
        return super.a(f1, menuitem) || d.a(f1, menuitem);
    }

    public boolean b()
    {
        return d.b();
    }

    public boolean c()
    {
        return d.c();
    }

    public boolean c(h h1)
    {
        return d.c(h1);
    }

    public boolean d(h h1)
    {
        return d.d(h1);
    }

    public MenuItem getItem()
    {
        return e;
    }

    public f p()
    {
        return d;
    }

    public Menu s()
    {
        return d;
    }

    public SubMenu setHeaderIcon(int j)
    {
        super.a(i.a(e(), j));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable)
    {
        super.a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int j)
    {
        super.a(e().getResources().getString(j));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charsequence)
    {
        super.a(charsequence);
        return this;
    }

    public SubMenu setHeaderView(View view)
    {
        super.a(view);
        return this;
    }

    public SubMenu setIcon(int j)
    {
        e.setIcon(j);
        return this;
    }

    public SubMenu setIcon(Drawable drawable)
    {
        e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean flag)
    {
        d.setQwertyMode(flag);
    }
}
