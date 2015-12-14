// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.View;

public class ek
    implements Runnable
{

    final ActionMenuPresenter a;
    private en b;

    public ek(ActionMenuPresenter actionmenupresenter, en en1)
    {
        a = actionmenupresenter;
        super();
        b = en1;
    }

    public void run()
    {
        ActionMenuPresenter.f(a).f();
        View view = (View)ActionMenuPresenter.g(a);
        if (view != null && view.getWindowToken() != null && b.d())
        {
            ActionMenuPresenter.a(a, b);
        }
        ActionMenuPresenter.a(a, null);
    }
}
