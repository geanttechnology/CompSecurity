// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import java.util.concurrent.Executor;

final class ut
    implements bhv
{

    final uq a;

    ut(uq uq1)
    {
        a = uq1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        a.s = a.t;
        a.h = null;
        a.a(new cse(csf.d, true, a.e.a(exception), exception));
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bxb)obj1;
        a.s = a.t;
        a.a(((bxb) (obj)));
        obj = new Handler();
        a.m.execute(new uu(this, ((Handler) (obj))));
    }
}
