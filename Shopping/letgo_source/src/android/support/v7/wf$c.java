// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Process;

// Referenced classes of package android.support.v7:
//            wf

private static class  extends Thread
{

    public void run()
    {
        Process.setThreadPriority(10);
        super.run();
    }

    (Runnable runnable, String s)
    {
        super(runnable, s);
    }
}
