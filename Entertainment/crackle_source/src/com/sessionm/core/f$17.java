// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.sessionm.core:
//            f

class 
    implements ThreadFactory
{

    final f cM;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable);
        runnable.setName("SessionM Session Thread");
        return runnable;
    }

    readFactory(f f1)
    {
        cM = f1;
        super();
    }
}
