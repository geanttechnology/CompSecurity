// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;

class em extends ez
{

    final ActionMenuPresenter a;
    final el b;

    em(el el1, View view, ActionMenuPresenter actionmenupresenter)
    {
        b = el1;
        a = actionmenupresenter;
        super(view);
    }

    public ListPopupWindow a()
    {
        if (ActionMenuPresenter.a(b.a) == null)
        {
            return null;
        } else
        {
            return ActionMenuPresenter.a(b.a).c();
        }
    }

    public boolean b()
    {
        b.a.c();
        return true;
    }

    public boolean c()
    {
        if (ActionMenuPresenter.b(b.a) != null)
        {
            return false;
        } else
        {
            b.a.d();
            return true;
        }
    }
}
