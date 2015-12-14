// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.perfectcorp.utility:
//            e

final class a
    implements ThreadFactory
{

    int a;

    public Thread newThread(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        i = a;
        a = i + 1;
        this;
        JVM INSTR monitorexit ;
        return new Thread(runnable, (new StringBuilder()).append("BCLog #").append(i).toString());
        runnable;
        this;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    actory()
    {
        a = 0;
    }
}
