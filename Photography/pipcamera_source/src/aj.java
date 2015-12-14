// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class aj extends ActionProvider
{

    final android.view.ActionProvider a;
    final ai b;

    public aj(ai ai1, Context context, android.view.ActionProvider actionprovider)
    {
        b = ai1;
        super(context);
        a = actionprovider;
    }

    public boolean hasSubMenu()
    {
        return a.hasSubMenu();
    }

    public View onCreateActionView()
    {
        return a.onCreateActionView();
    }

    public boolean onPerformDefaultAction()
    {
        return a.onPerformDefaultAction();
    }

    public void onPrepareSubMenu(SubMenu submenu)
    {
        a.onPrepareSubMenu(b.a(submenu));
    }
}
