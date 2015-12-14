// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.View;

public class cu extends ap
{

    final ActionMenuPresenter c;

    public cu(ActionMenuPresenter actionmenupresenter, Context context, MenuBuilder menubuilder, View view, boolean flag)
    {
        c = actionmenupresenter;
        super(context, menubuilder, view, flag, android.support.v7.appcompat.R.attr.actionOverflowMenuStyle);
        a(0x800005);
        a(actionmenupresenter.g);
    }

    public void onDismiss()
    {
        super.onDismiss();
        ActionMenuPresenter.c(c).close();
        ActionMenuPresenter.a(c, null);
    }
}
