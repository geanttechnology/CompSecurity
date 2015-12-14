// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            AsyncTask

final class 
    implements ThreadFactory
{

    private final AtomicInteger a = new AtomicInteger(1);

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, (new StringBuilder()).append("AsyncTask #").append(a.getAndIncrement()).toString());
    }

    ()
    {
    }
}
