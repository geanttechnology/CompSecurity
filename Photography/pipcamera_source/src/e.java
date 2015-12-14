// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.internal.view.menu.MenuBuilder;

public final class e
    implements as
{

    final ActionBarActivityDelegateBase a;

    private e(ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        a = actionbaractivitydelegatebase;
        super();
    }

    public e(ActionBarActivityDelegateBase actionbaractivitydelegatebase, android.support.v7.app.ActionBarActivityDelegateBase._cls1 _pcls1)
    {
        this(actionbaractivitydelegatebase);
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        ActionBarActivityDelegateBase.a(a, menubuilder);
    }

    public boolean a(MenuBuilder menubuilder)
    {
        l l1 = a.m();
        if (l1 != null)
        {
            l1.c(8, menubuilder);
        }
        return true;
    }
}
