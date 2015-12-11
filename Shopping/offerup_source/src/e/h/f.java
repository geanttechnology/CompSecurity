// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.h;

import e.k;
import java.util.concurrent.Future;

final class f
    implements k
{

    private Future a;

    public f(Future future)
    {
        a = future;
    }

    public final void b()
    {
        a.cancel(true);
    }

    public final boolean c()
    {
        return a.isCancelled();
    }
}
