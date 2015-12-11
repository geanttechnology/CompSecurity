// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.paypal.android.sdk:
//            bb, cj

final class bc extends Handler
{

    private WeakReference a;

    public bc(bb bb1)
    {
        a = new WeakReference(bb1);
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 2 2: default 24
    //                   2 25;
           goto _L1 _L2
_L1:
        bb bb1;
        return;
_L2:
        if ((bb1 = (bb)a.get()) != null)
        {
            bb.a(bb1, (cj)message.obj);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
