// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.view.MenuItem;

public class cy
    implements af
{

    final ActionMenuView a;

    private cy(ActionMenuView actionmenuview)
    {
        a = actionmenuview;
        super();
    }

    public cy(ActionMenuView actionmenuview, android.support.v7.widget.ActionMenuView._cls1 _pcls1)
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
