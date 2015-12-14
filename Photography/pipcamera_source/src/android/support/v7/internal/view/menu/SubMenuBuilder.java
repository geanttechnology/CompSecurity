// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import af;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

// Referenced classes of package android.support.v7.internal.view.menu:
//            MenuBuilder, MenuItemImpl

public class SubMenuBuilder extends MenuBuilder
    implements SubMenu
{

    private MenuBuilder d;
    private MenuItemImpl e;

    public SubMenuBuilder(Context context, MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        super(context);
        d = menubuilder;
        e = menuitemimpl;
    }

    public String a()
    {
        int i;
        if (e != null)
        {
            i = e.getItemId();
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(super.a()).append(":").append(i).toString();
        }
    }

    public void a(af af)
    {
        d.a(af);
    }

    boolean a(MenuBuilder menubuilder, MenuItem menuitem)
    {
        return super.a(menubuilder, menuitem) || d.a(menubuilder, menuitem);
    }

    public boolean b()
    {
        return d.b();
    }

    public boolean c()
    {
        return d.c();
    }

    public boolean c(MenuItemImpl menuitemimpl)
    {
        return d.c(menuitemimpl);
    }

    public boolean d(MenuItemImpl menuitemimpl)
    {
        return d.d(menuitemimpl);
    }

    public MenuItem getItem()
    {
        return e;
    }

    public MenuBuilder p()
    {
        return d;
    }

    public Menu s()
    {
        return d;
    }

    public SubMenu setHeaderIcon(int i)
    {
        super.a(ContextCompat.getDrawable(e(), i));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable)
    {
        super.a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i)
    {
        super.a(e().getResources().getString(i));
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

    public SubMenu setIcon(int i)
    {
        e.setIcon(i);
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
