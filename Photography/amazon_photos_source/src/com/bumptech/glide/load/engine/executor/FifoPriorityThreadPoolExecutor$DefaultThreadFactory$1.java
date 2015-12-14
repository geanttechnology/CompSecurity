// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import android.os.Process;

// Referenced classes of package com.bumptech.glide.load.engine.executor:
//            FifoPriorityThreadPoolExecutor

class this._cls0 extends Thread
{

    final this._cls0 this$0;

    public void run()
    {
        Process.setThreadPriority(10);
        super.run();
    }

    (Runnable runnable, String s)
    {
        this$0 = this._cls0.this;
        super(runnable, s);
    }
}
