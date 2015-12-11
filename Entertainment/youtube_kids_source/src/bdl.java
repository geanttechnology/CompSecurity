// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.ConditionVariable;

final class bdl
    implements Runnable
{

    private ConditionVariable a;
    private bdi b;

    bdl(bdi bdi1, ConditionVariable conditionvariable)
    {
        b = bdi1;
        a = conditionvariable;
        super();
    }

    public final void run()
    {
        bdi.a(b, new ats(bdi.d(b), bdi.e(b)));
        a.open();
    }
}
