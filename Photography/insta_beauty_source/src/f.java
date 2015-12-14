// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.app.ActionBarActivityDelegateBase;

public class f
    implements Runnable
{

    final ActionBarActivityDelegateBase a;

    public f(ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        a = actionbaractivitydelegatebase;
        super();
    }

    public void run()
    {
        if ((ActionBarActivityDelegateBase.a(a) & 1) != 0)
        {
            ActionBarActivityDelegateBase.a(a, 0);
        }
        if ((ActionBarActivityDelegateBase.a(a) & 0x100) != 0)
        {
            ActionBarActivityDelegateBase.a(a, 8);
        }
        ActionBarActivityDelegateBase.a(a, false);
        ActionBarActivityDelegateBase.b(a, 0);
    }
}
