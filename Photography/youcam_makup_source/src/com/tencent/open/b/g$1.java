// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.tencent.open.b:
//            g

class t> extends Handler
{

    final g a;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1000 1001: default 28
    //                   1000 34
    //                   1001 44;
           goto _L1 _L2 _L3
_L1:
        super.handleMessage(message);
        return;
_L2:
        a.b();
        continue; /* Loop/switch isn't completed */
_L3:
        a.e();
        if (true) goto _L1; else goto _L4
_L4:
    }

    (g g1, Looper looper)
    {
        a = g1;
        super(looper);
    }
}
