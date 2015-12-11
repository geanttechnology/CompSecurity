// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.g;

import java.util.concurrent.ThreadFactory;

final class e extends e.d.c.e
{

    private long a;

    e(ThreadFactory threadfactory)
    {
        super(threadfactory);
        a = 0L;
    }

    public final void a(long l)
    {
        a = l;
    }

    public final long d()
    {
        return a;
    }
}
