// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.view.MenuItem;

public class et
    implements bb
{

    final ActionMenuView a;

    private et(ActionMenuView actionmenuview)
    {
        a = actionmenuview;
        super();
    }

    public et(ActionMenuView actionmenuview, eq eq)
    {
        this(actionmenuview);
    }

    public void a(MenuBuilder menubuilder)
    {
        if (ActionMenuView.access$300(a) != null)
        {
            ActionMenuView.access$300(a).a(menubuilder);
        }
    }

    public boolean a(MenuBuilder menubuilder, MenuItem menuitem)
    {
        return ActionMenuView.access$200(a) != null && ActionMenuView.access$200(a).a(menuitem);
    }
}
