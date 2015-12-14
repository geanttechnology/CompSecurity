// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.cyberlink.uma.a:
//            b

class a
    implements ThreadFactory
{

    final b a;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, "CountlyConnectionQueue");
        try
        {
            runnable.setPriority(4);
        }
        catch (Throwable throwable)
        {
            return runnable;
        }
        return runnable;
    }

    eadFactory(b b1)
    {
        a = b1;
        super();
    }
}
