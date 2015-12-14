// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class ge
    implements bo
{

    MenuBuilder a;
    public MenuItemImpl b;
    final Toolbar c;

    private ge(Toolbar toolbar)
    {
        c = toolbar;
        super();
    }

    public ge(Toolbar toolbar, gb gb)
    {
        this(toolbar);
    }

    public void a(Context context, MenuBuilder menubuilder)
    {
        if (a != null && b != null)
        {
            a.d(b);
        }
        a = menubuilder;
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
    }

    public void a(boolean flag)
    {
        boolean flag2 = false;
        if (b == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = flag2;
        if (a == null) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        j = a.size();
        i = 0;
_L9:
        flag1 = flag2;
        if (i >= j) goto _L4; else goto _L5
_L5:
        if (a.getItem(i) != b) goto _L7; else goto _L6
_L6:
        flag1 = true;
_L4:
        if (!flag1)
        {
            b(a, b);
        }
_L2:
        return;
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public boolean a(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        Toolbar.access$200(c);
        if (Toolbar.access$300(c).getParent() != c)
        {
            c.addView(Toolbar.access$300(c));
        }
        c.mExpandedActionView = menuitemimpl.getActionView();
        b = menuitemimpl;
        if (c.mExpandedActionView.getParent() != c)
        {
            menubuilder = c.generateDefaultLayoutParams();
            menubuilder.a = 0x800003 | Toolbar.access$400(c) & 0x70;
            menubuilder.b = 2;
            c.mExpandedActionView.setLayoutParams(menubuilder);
            c.addView(c.mExpandedActionView);
        }
        Toolbar.access$500(c, true);
        c.requestLayout();
        menuitemimpl.e(true);
        if (c.mExpandedActionView instanceof eg)
        {
            ((eg)c.mExpandedActionView).onActionViewExpanded();
        }
        return true;
    }

    public boolean a(SubMenuBuilder submenubuilder)
    {
        return false;
    }

    public boolean b()
    {
        return false;
    }

    public boolean b(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        if (c.mExpandedActionView instanceof eg)
        {
            ((eg)c.mExpandedActionView).onActionViewCollapsed();
        }
        c.removeView(c.mExpandedActionView);
        c.removeView(Toolbar.access$300(c));
        c.mExpandedActionView = null;
        Toolbar.access$500(c, false);
        b = null;
        c.requestLayout();
        menuitemimpl.e(false);
        return true;
    }
}
