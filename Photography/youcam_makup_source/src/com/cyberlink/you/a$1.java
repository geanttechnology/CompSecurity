// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.util.Log;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you:
//            a

class > extends Thread
{

    final a a;

    public void run()
    {
        Thread.currentThread().setName("reconnect");
_L7:
        if (!a.c()) goto _L2; else goto _L1
_L1:
        if (!l.a() || !n.a().d()) goto _L4; else goto _L3
_L3:
        ULogUtility.a("reconnect successful", "XMPP Connection");
        Log.i("ConnectionManager", "reconnect successful. break.");
        com.cyberlink.you.a.a(a);
_L6:
        com.cyberlink.you.a.a(a, false);
        return;
_L4:
        n.a().a(true);
        if (!n.a().h()) goto _L2; else goto _L5
_L5:
        Log.i("ConnectionManager", "XMPP is authorized, break");
        ULogUtility.a("XMPP is authorized", "XMPP Connection");
        com.cyberlink.you.a.a(a);
          goto _L6
_L2:
        sleep(5000L);
          goto _L7
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L6
    }

    xception(a a1)
    {
        a = a1;
        super();
    }
}
