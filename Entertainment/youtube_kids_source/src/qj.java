// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.ConditionVariable;
import java.util.concurrent.Executor;

final class qj
{

    final cpj a;
    final ConditionVariable b;
    volatile qv c;
    final qi d;

    qj(qi qi1, cpj cpj)
    {
        d = qi1;
        super();
        a = cpj;
        b = new ConditionVariable();
        qi1.b.execute(new qk(this, qi1));
    }

    qj(qi qi1, cpj cpj, qv qv)
    {
        d = qi1;
        super();
        a = cpj;
        b = new ConditionVariable(true);
        c = qv;
    }
}
