// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public final class hb extends gt
    implements SubMenu
{

    public gt h;
    private gv i;

    public hb(Context context, gt gt1, gv gv1)
    {
        super(context);
        h = gt1;
        i = gv1;
    }

    public final boolean a()
    {
        return h.a();
    }

    final boolean a(gt gt1, MenuItem menuitem)
    {
        return super.a(gt1, menuitem) || h.a(gt1, menuitem);
    }

    public final boolean a(gv gv1)
    {
        return h.a(gv1);
    }

    public final boolean b()
    {
        return h.b();
    }

    public final boolean b(gv gv1)
    {
        return h.b(gv1);
    }

    public final gt g()
    {
        return h;
    }

    public final MenuItem getItem()
    {
        return i;
    }

    public final SubMenu setHeaderIcon(int j)
    {
        super.a(aw.a(super.a, j));
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable)
    {
        super.a(drawable);
        return this;
    }

    public final SubMenu setHeaderTitle(int j)
    {
        super.a(super.a.getResources().getString(j));
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charsequence)
    {
        super.a(charsequence);
        return this;
    }

    public final SubMenu setHeaderView(View view)
    {
        super.a(0, null, 0, null, view);
        return this;
    }

    public final SubMenu setIcon(int j)
    {
        i.setIcon(j);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable)
    {
        i.setIcon(drawable);
        return this;
    }

    public final void setQwertyMode(boolean flag)
    {
        h.setQwertyMode(flag);
    }
}
