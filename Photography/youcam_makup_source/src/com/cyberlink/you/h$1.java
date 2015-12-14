// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.os.CountDownTimer;
import android.util.Log;

// Referenced classes of package com.cyberlink.you:
//            h, a

class mer extends CountDownTimer
{

    final h a;

    public void onFinish()
    {
        Log.w("Globals", "XMPP disconnected");
        com.cyberlink.you.a.a().b("Globals");
    }

    public void onTick(long l)
    {
        l /= 1000L;
        Log.w("Globals", (new StringBuilder()).append("XMPP will disconnect in ").append(l).append(" seconds").toString());
    }

    r(h h1, long l, long l1)
    {
        a = h1;
        super(l, l1);
    }
}
