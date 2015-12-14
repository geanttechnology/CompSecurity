// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.threading;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
    implements ThreadFactory
{

    private final String mName;
    private final AtomicInteger mNumber = new AtomicInteger();
    private final int mPriority;

    public PriorityThreadFactory(String s, int i)
    {
        mName = s;
        mPriority = i;
    }

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, (new StringBuilder()).append(mName).append('-').append(mNumber.getAndIncrement()).toString()) {

            final PriorityThreadFactory this$0;

            public void run()
            {
                Process.setThreadPriority(mPriority);
                super.run();
            }

            
            {
                this$0 = PriorityThreadFactory.this;
                super(runnable, s);
            }
        };
    }

}
