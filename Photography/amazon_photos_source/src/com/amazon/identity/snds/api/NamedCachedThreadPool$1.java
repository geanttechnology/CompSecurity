// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.amazon.identity.snds.api:
//            NamedCachedThreadPool

class val.name
    implements ThreadFactory
{

    final NamedCachedThreadPool this$0;
    final String val$name;

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, String.format("%s#%d", new Object[] {
            val$name, Integer.valueOf(NamedCachedThreadPool.access$004(NamedCachedThreadPool.this))
        }));
    }

    ()
    {
        this$0 = final_namedcachedthreadpool;
        val$name = String.this;
        super();
    }
}
