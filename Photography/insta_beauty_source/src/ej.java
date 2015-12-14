// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ListPopupWindow;

public class ej extends av
{

    final ActionMenuPresenter a;

    private ej(ActionMenuPresenter actionmenupresenter)
    {
        a = actionmenupresenter;
        super();
    }

    public ej(ActionMenuPresenter actionmenupresenter, eh eh)
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
