// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            c, a, d

private final class  extends Handler
{

    public final c a;

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 9: default 56
    //                   1 57
    //                   2 114
    //                   3 139
    //                   4 237
    //                   5 247
    //                   6 56
    //                   7 56
    //                   8 255
    //                   9 264;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L1 _L7 _L8
_L1:
        return;
_L2:
        com.immersion.hapticmediasdk.a.c.b(a).removeCallbacks(com.immersion.hapticmediasdk.a.c.a(a));
        com.immersion.hapticmediasdk.a.c.a(a, message.arg1);
        com.immersion.hapticmediasdk.a.c.b(a, message.arg2);
        com.immersion.hapticmediasdk.a.c.c(a);
        com.immersion.hapticmediasdk.a.c.d(a);
        return;
_L3:
        message = message.getData();
        com.immersion.hapticmediasdk.a.c.a(a, message.getInt("playback_timecode"), message.getLong("playback_uptime"));
        return;
_L4:
        if (com.immersion.hapticmediasdk.a.c.e(a) == null)
        {
            com.immersion.hapticmediasdk.a.c.a(a, com.immersion.hapticmediasdk.a.a.a(com.immersion.hapticmediasdk.a.c.f(a), com.immersion.hapticmediasdk.a.c.f()));
        }
        if (com.immersion.hapticmediasdk.a.c.e(a) != null && com.immersion.hapticmediasdk.a.c.g(a) == 0)
        {
            com.immersion.hapticmediasdk.a.c.c(a, com.immersion.hapticmediasdk.a.c.e(a).a());
        }
        if (com.immersion.hapticmediasdk.a.c.e(a) != null)
        {
            com.immersion.hapticmediasdk.a.c.e(a).a(message.arg1);
            return;
        }
          goto _L1
_L5:
        com.immersion.hapticmediasdk.a.c.h(a);
        do
        {
        } while (true);
_L6:
        com.immersion.hapticmediasdk.a.c.i(a);
        return;
_L7:
        com.immersion.hapticmediasdk.a.c.a(a, message);
        return;
_L8:
        com.immersion.hapticmediasdk.a.c.j(a);
        return;
    }

    private ()
    {
        do
        {
        } while (true);
    }
}
