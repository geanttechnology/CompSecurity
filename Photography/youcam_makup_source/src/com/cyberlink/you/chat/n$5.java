// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import com.cyberlink.you.a;
import com.cyberlink.you.g;
import java.util.Random;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.d;

// Referenced classes of package com.cyberlink.you.chat:
//            n, j

class a extends Thread
{

    final n a;

    public void run()
    {
        int i;
        int i1;
        i = 0;
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        i1 = random.nextInt(3);
        n.b("Reconnect Thread, enter");
_L4:
        int l;
label0:
        {
            if (n.l() != null && !n.l().f() && com.cyberlink.you.a.a() != null && com.cyberlink.you.a.a().c())
            {
                l = i + 1;
                if (l <= 15)
                {
                    break label0;
                }
                try
                {
                    n.b("tried 15 times, give up");
                    n.l().r();
                    com.cyberlink.you.chat.n.a().a(null);
                    com.cyberlink.you.a.a().e();
                }
                catch (org.jivesoftware.smack.kException.NotConnectedException notconnectedexception)
                {
                    notconnectedexception.printStackTrace();
                }
            }
            com.cyberlink.you.chat.j.a();
            j.b();
            n.b("Reconnect Thread, exit");
            return;
        }
        i = (int)((double)(i1 + 3) * Math.pow(1.2D, l));
        n.b((new StringBuilder()).append("Waiting for ").append(i).append(" second(s) to reconnect").toString());
_L2:
        int k;
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i;
        Thread.sleep(1000L);
        i--;
        k = i;
        try
        {
            a.c.reconnectingIn(i);
        }
        catch (InterruptedException interruptedexception)
        {
            Log.w("XMPPManager", "Sleeping thread interrupted");
            a.c.reconnectionFailed(interruptedexception);
            i = k;
        }
        if (true) goto _L2; else goto _L1
_L1:
        n.b((new StringBuilder()).append("reconnect #").append(l).toString());
        i = l;
        if (n.l() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        com.cyberlink.you.chat.n.a(System.currentTimeMillis());
        n.l().h();
        g.a().e(false);
        a.g();
        i = l;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        a.c.reconnectionFailed(exception);
        n.b(exception.toString());
        i = l;
        if (true) goto _L4; else goto _L3
_L3:
    }

    ion(n n1)
    {
        a = n1;
        super();
    }
}
