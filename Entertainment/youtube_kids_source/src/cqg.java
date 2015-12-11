// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class cqg
    implements crb
{

    final crb a;
    private final Executor b;

    private cqg(Executor executor, crb crb1)
    {
        b = executor;
        a = crb1;
    }

    public static cqg a(Executor executor, crb crb1)
    {
        b.a(executor);
        b.a(crb1);
        return new cqg(executor, crb1);
    }

    public final void a(Object obj, bhv bhv1)
    {
        b.a(obj);
        b.a(bhv1);
        try
        {
            b.execute(new cqh(this, obj, bhv1));
            return;
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            bhv1.a(obj, rejectedexecutionexception);
        }
    }
}
