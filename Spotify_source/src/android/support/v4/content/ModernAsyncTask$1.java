// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.support.v4.content:
//            ModernAsyncTask

public final class 
    implements ThreadFactory
{

    private final AtomicInteger a = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, (new StringBuilder("ModernAsyncTask #")).append(a.getAndIncrement()).toString());
    }

    ()
    {
    }
}
