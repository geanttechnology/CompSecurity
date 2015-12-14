// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.concurrent;

import android.os.Process;

// Referenced classes of package com.amazon.mixtape.concurrent:
//            KeyedThreads

private class mKey extends Thread
{

    private final Object mKey;
    private final mKey mTask;
    final KeyedThreads this$0;

    public void run()
    {
        Process.setThreadPriority(10);
        mTask.n();
        KeyedThreads.access$000(KeyedThreads.this, mKey);
        return;
        Exception exception;
        exception;
        KeyedThreads.access$000(KeyedThreads.this, mKey);
        throw exception;
    }

    public (Object obj, String s,  )
    {
        this$0 = KeyedThreads.this;
        super(s);
        mTask = ;
        mKey = obj;
    }
}
