// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.internal.view.menu.MenuBuilder;

public final class j
    implements bp
{

    final ActionBarActivityDelegateBase a;

    private j(ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        a = actionbaractivitydelegatebase;
        super();
    }

    public j(ActionBarActivityDelegateBase actionbaractivitydelegatebase, f f)
    {
        this(actionbaractivitydelegatebase);
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        ActionBarActivityDelegateBase.a(a, menubuilder);
    }

    public boolean a(MenuBuilder menubuilder)
    {
        ad ad1 = a.m();
        if (ad1 != null)
        {
            ad1.c(8, menubuilder);
        }
        return true;
    }
}
