// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

final class ik extends Handler
{

    private ii a;

    ik(ii ii1)
    {
        a = ii1;
        super();
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 29
    //                   2 59;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        message = a;
        message.h = false;
        if (((ii) (message)).d != null)
        {
            ((ii) (message)).d.a(message, ((ii) (message)).g);
            return;
        }
          goto _L1
_L3:
        message = a;
        message.f = false;
        message.b(((ii) (message)).e);
        return;
    }
}
