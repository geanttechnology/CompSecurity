// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

// Referenced classes of package com.google.a.g.a:
//            f, j

public abstract class g extends f
    implements j
{
    public static abstract class a extends g
    {

        private final j a;

        protected final volatile Future a()
        {
            return a;
        }

        protected final volatile Object b()
        {
            return a;
        }

        protected final j c()
        {
            return a;
        }

        protected a(j j1)
        {
            a = (j)com.google.a.a.g.a(j1);
        }
    }


    protected g()
    {
    }

    protected Future a()
    {
        return c();
    }

    public final void a(Runnable runnable, Executor executor)
    {
        c().a(runnable, executor);
    }

    protected Object b()
    {
        return c();
    }

    protected abstract j c();
}
