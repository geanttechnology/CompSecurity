// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.cyberlink.you.chat:
//            ab

final class AtomicInteger
    implements ThreadFactory
{

    private final AtomicInteger a = new AtomicInteger(1);

    public Thread newThread(Runnable runnable)
    {
        return new Thread(ab.h(), runnable, (new StringBuilder()).append("Single AsyncTask #").append(a.getAndIncrement()).toString());
    }

    AtomicInteger()
    {
    }
}
