// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.Looper;
import android.util.Log;
import com.cyberlink.you.b.a;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.chat:
//            u, y, a

class a extends Thread
{

    final u a;

    public void run()
    {
        Log.d("XMPPManager", "[MessageProcessThread] start");
_L4:
        if (!isAlive()) goto _L2; else goto _L1
_L1:
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[startEventProcessThread] is ui thread start");
        }
        Object obj = com.cyberlink.you.chat.u.a(a);
        obj;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[startEventProcessThread] is ui thread end");
        }
        for (; com.cyberlink.you.chat.u.a(a).isEmpty(); com.cyberlink.you.chat.u.a(a).wait()) { }
          goto _L3
        Exception exception;
        exception;
        Log.d("XMPPManager", (new StringBuilder()).append("[EventProcessThread] Failed on waiting message queue: ").append(exception).toString());
        obj;
        JVM INSTR monitorexit ;
_L2:
        Log.d("XMPPManager", "[MessageProcessThread] end");
        return;
_L3:
        Object obj1 = (y)com.cyberlink.you.chat.u.a(a).remove(0);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        Log.d("XMPPManager", "[MessageProcessThread] params == null");
        obj;
        JVM INSTR monitorexit ;
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        JVM INSTR monitorexit ;
label0:
        {
            obj = ((y) (obj1)).a;
            obj1 = ((y) (obj1)).b;
            if (obj != null && obj1 != null)
            {
                break label0;
            }
            Log.d("XMPPManager", "[MessageProcessThread] xmppMessage == null || packetExtendsion == null");
        }
        if (true) goto _L4; else goto _L5
_L5:
        com.cyberlink.you.b.a.a().a(((b) (obj)));
        obj1 = ((com.cyberlink.you.chat.a) (obj1)).f();
        com.cyberlink.you.b.a.a().a(((b) (obj)), ((Map) (obj1)));
        obj = (String)((Map) (obj1)).get("eventType");
        Thread.sleep(10L);
          goto _L4
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L2
    }

    ion(u u1)
    {
        a = u1;
        super();
    }
}
