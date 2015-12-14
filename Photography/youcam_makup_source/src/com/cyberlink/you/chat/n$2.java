// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Pair;

// Referenced classes of package com.cyberlink.you.chat:
//            n, q

class d extends Thread
{

    final String a;
    final String b;
    final boolean c;
    final q d;
    final n e;

    public void run()
    {
        Thread.currentThread().setName("XMPP Auth");
        Pair pair = n.a(e, a, b, c);
        if (((Boolean)pair.first).booleanValue())
        {
            if (d != null)
            {
                d.a();
            }
        } else
        if (d != null)
        {
            d.a((String)pair.second);
            return;
        }
    }

    (n n1, String s, String s1, boolean flag, q q1)
    {
        e = n1;
        a = s;
        b = s1;
        c = flag;
        d = q1;
        super();
    }
}
