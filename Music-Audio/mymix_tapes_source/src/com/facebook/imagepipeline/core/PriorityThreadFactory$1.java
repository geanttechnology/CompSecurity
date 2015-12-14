// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import android.os.Process;

// Referenced classes of package com.facebook.imagepipeline.core:
//            PriorityThreadFactory

class val.runnable
    implements Runnable
{

    final PriorityThreadFactory this$0;
    final Runnable val$runnable;

    public void run()
    {
        try
        {
            Process.setThreadPriority(PriorityThreadFactory.access$000(PriorityThreadFactory.this));
        }
        catch (Throwable throwable) { }
        val$runnable.run();
    }

    ()
    {
        this$0 = final_prioritythreadfactory;
        val$runnable = Runnable.this;
        super();
    }
}
