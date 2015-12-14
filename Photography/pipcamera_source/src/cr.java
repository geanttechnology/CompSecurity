// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ListPopupWindow;

public class cr extends z
{

    final ActionMenuPresenter a;

    private cr(ActionMenuPresenter actionmenupresenter)
    {
        a = actionmenupresenter;
        super();
    }

    public cr(ActionMenuPresenter actionmenupresenter, android.support.v7.widget.ActionMenuPresenter._cls1 _pcls1)
    {
        this(actionmenupresenter);
    }

    public ListPopupWindow a()
    {
        if (ActionMenuPresenter.h(a) != null)
        {
            return ActionMenuPresenter.h(a).c();
        } else
        {
            return null;
        }
    }
}
