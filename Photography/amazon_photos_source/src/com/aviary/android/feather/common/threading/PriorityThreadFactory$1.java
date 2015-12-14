// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.threading;

import android.os.Process;

// Referenced classes of package com.aviary.android.feather.common.threading:
//            PriorityThreadFactory

class this._cls0 extends Thread
{

    final PriorityThreadFactory this$0;

    public void run()
    {
        Process.setThreadPriority(PriorityThreadFactory.access$000(PriorityThreadFactory.this));
        super.run();
    }

    I(Runnable runnable, String s)
    {
        this$0 = PriorityThreadFactory.this;
        super(runnable, s);
    }
}
