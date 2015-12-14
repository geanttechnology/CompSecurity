// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory
    implements ThreadFactory
{

    private final int mThreadPriority;

    public PriorityThreadFactory(int i)
    {
        mThreadPriority = i;
    }

    public Thread newThread(final Runnable runnable)
    {
        return new Thread(new Runnable() {

            final PriorityThreadFactory this$0;
            final Runnable val$runnable;

            public void run()
            {
                try
                {
                    Process.setThreadPriority(mThreadPriority);
                }
                catch (Throwable throwable) { }
                runnable.run();
            }

            
            {
                this$0 = PriorityThreadFactory.this;
                runnable = runnable1;
                super();
            }
        });
    }

}
