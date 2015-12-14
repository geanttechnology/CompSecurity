// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.rendering.mraid:
//            g

static final class it> extends Handler
{

    private final WeakReference a;

    public void handleMessage(Message message)
    {
        g g1 = (g)a.get();
        if (g1 == null) goto _L2; else goto _L1
_L1:
        message.what;
        JVM INSTR tableswitch 1 1: default 36
    //                   1 42;
           goto _L2 _L3
_L2:
        super.handleMessage(message);
_L5:
        return;
_L3:
        if (b != g1.c) goto _L5; else goto _L4
_L4:
        int i = Math.round((float)g1.getCurrentPosition() / 1000F);
        int j = Math.round((float)g1.getDuration() / 1000F);
        if (g1.i != i)
        {
            g1.a(i, j);
            g1.i = i;
            g1.j = i;
        }
        sendEmptyMessageDelayed(1, 1000L);
        if (true) goto _L2; else goto _L6
_L6:
    }

    public (g g1)
    {
        a = new WeakReference(g1);
    }
}
