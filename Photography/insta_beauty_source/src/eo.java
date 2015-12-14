// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.MenuItem;

public class eo
    implements bp
{

    final ActionMenuPresenter a;

    private eo(ActionMenuPresenter actionmenupresenter)
    {
        a = actionmenupresenter;
        super();
    }

    public eo(ActionMenuPresenter actionmenupresenter, eh eh)
    {
        this(actionmenupresenter);
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        if (menubuilder instanceof SubMenuBuilder)
        {
            ((SubMenuBuilder)menubuilder).p().a(false);
        }
        bp bp1 = a.a();
        if (bp1 != null)
        {
            bp1.a(menubuilder, flag);
        }
    }

    public boolean a(MenuBuilder menubuilder)
    {
        if (menubuilder == null)
        {
            return false;
        }
        a.h = ((SubMenuBuilder)menubuilder).getItem().getItemId();
        bp bp1 = a.a();
        boolean flag;
        if (bp1 != null)
        {
            flag = bp1.a(menubuilder);
        } else
        {
            flag = false;
        }
        return flag;
    }
}
