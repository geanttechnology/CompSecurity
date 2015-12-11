// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

public static class threadScheduler extends r
{

    private final r threadScheduler;
    private final r threadVerify;

    public void execute(Runnable runnable)
    {
        m.amazon.device.ads.ThreadUtils.ExecutionThread[threadScheduler.getExecutionThread().ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 51
    //                   2 71;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_71;
_L1:
        boolean flag = false;
_L4:
        if (flag)
        {
            threadScheduler.execute(runnable);
            return;
        } else
        {
            runnable.run();
            return;
        }
_L2:
        if (!threadVerify.OnMainThread())
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L4
        flag = threadVerify.OnMainThread();
          goto _L4
    }

    public (r r, r r1)
    {
        super(RUN_ASAP, r.access._mth100(r1));
        threadVerify = r;
        threadScheduler = r1;
    }
}
