// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.MenuItem;

public class cv
    implements as
{

    final ActionMenuPresenter a;

    private cv(ActionMenuPresenter actionmenupresenter)
    {
        a = actionmenupresenter;
        super();
    }

    public cv(ActionMenuPresenter actionmenupresenter, android.support.v7.widget.ActionMenuPresenter._cls1 _pcls1)
    {
        this(actionmenupresenter);
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        if (menubuilder instanceof SubMenuBuilder)
        {
            ((SubMenuBuilder)menubuilder).p().a(false);
        }
        as as1 = a.a();
        if (as1 != null)
        {
            as1.a(menubuilder, flag);
        }
    }

    public boolean a(MenuBuilder menubuilder)
    {
        if (menubuilder == null)
        {
            return false;
        }
        a.h = ((SubMenuBuilder)menubuilder).getItem().getItemId();
        as as1 = a.a();
        boolean flag;
        if (as1 != null)
        {
            flag = as1.a(menubuilder);
        } else
        {
            flag = false;
        }
        return flag;
    }
}
