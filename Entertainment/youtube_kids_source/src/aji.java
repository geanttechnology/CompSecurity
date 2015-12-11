// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class aji extends Handler
{

    private amd a;
    private ajh b;

    aji(ajh ajh1, Looper looper, amd amd1)
    {
        b = ajh1;
        a = amd1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (a.i().a())
        {
            b.r();
            b.a.sendMessageDelayed(Message.obtain(this, 1), 1000L);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
