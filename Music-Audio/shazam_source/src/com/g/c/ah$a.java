// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.os.Process;

// Referenced classes of package com.g.c:
//            ah

private static final class nable extends Thread
{

    public final void run()
    {
        Process.setThreadPriority(10);
        super.run();
    }

    public nable(Runnable runnable)
    {
        super(runnable);
    }
}
