// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.g.b.a:
//            k

static final class ct
    implements ThreadFactory
{

    final String a;
    final boolean b = true;

    public final Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, a);
        runnable.setDaemon(b);
        return runnable;
    }

    ng(String s)
    {
        a = s;
        super();
    }
}
