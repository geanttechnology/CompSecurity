// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Message;

// Referenced classes of package com.bumptech.glide.load.engine:
//            s

final class u
    implements android.os.Handler.Callback
{

    private u()
    {
    }

    u(byte byte0)
    {
        this();
    }

    public final boolean handleMessage(Message message)
    {
        s s1 = (s)message.obj;
        message.what;
        JVM INSTR tableswitch 1 3: default 40
    //                   1 67
    //                   2 73
    //                   3 80;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException((new StringBuilder("Unrecognized message: ")).append(message.what).toString());
_L2:
        s.a(s1);
_L6:
        return true;
_L3:
        s.b(s1);
        continue; /* Loop/switch isn't completed */
_L4:
        s.c(s1);
        if (true) goto _L6; else goto _L5
_L5:
    }
}
