// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.jirbo.adcolony:
//            ak, s, h, o, 
//            au, be, db, bc

class al extends Handler
{

    s a;

    al()
    {
    }

    public void a(s s1)
    {
        if (s1 == null)
        {
            a = ak.A;
        } else
        {
            a = s1;
        }
        sendMessage(obtainMessage(1));
    }

    public void b(s s1)
    {
        if (s1 == null)
        {
            a = ak.A;
        } else
        {
            a = s1;
        }
        sendMessage(obtainMessage(0));
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 29
    //                   1 58;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        ak.a("skip", a);
        if (ak.A != null)
        {
            ak.A.a = 1;
            ak.A.g();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        message = new h();
        if (ak.C.C.P)
        {
            message.b("html5_endcard_loading_started", ak.C.j);
        }
        if (ak.C.C.P)
        {
            message.b("html5_endcard_loading_finished", ak.C.k);
        }
        if (ak.C.C.P)
        {
            message.b("html5_endcard_loading_time", ak.C.o);
        }
        if (ak.C.C.P)
        {
            message.b("html5_endcard_loading_timeout", ak.C.l);
        }
        if (ak.C.p < 60000D)
        {
            message.b("endcard_time_spent", ak.C.p);
        }
        message.b("endcard_dissolved", ak.C.m);
        o o1 = ak.C;
        message.b("replay", o.e);
        message.b("reward", ak.C.n);
        ak.c.d.a("continue", message, a);
        ak.c.b.e();
        if (ak.A != null)
        {
            ak.A.a = 4;
            ak.A.g();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
