// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.b;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.j.a.b:
//            j

class l extends Handler
{

    final j a;

    l(j j1)
    {
        a = j1;
        super();
    }

    l(j j1, Handler handler)
    {
        a = j1;
        super(handler.getLooper());
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 59
    //                   2 79
    //                   3 87;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new RuntimeException((new StringBuilder()).append("Unknown message ").append(message).toString());
_L2:
        j.b(a).onShowPress(j.a(a));
_L6:
        return;
_L3:
        j.c(a);
        return;
_L4:
        if (j.d(a) != null)
        {
            if (!j.e(a))
            {
                j.d(a).onSingleTapConfirmed(j.a(a));
                return;
            } else
            {
                j.a(a, true);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
