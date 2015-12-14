// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import java.util.concurrent.PriorityBlockingQueue;

// Referenced classes of package com.cyberlink.you.chat:
//            ab, n, XMPPObject

class a
    implements Runnable
{

    final ab a;

    public void run()
    {
        Thread.currentThread().setName("Send Message");
        n.a();
        Log.d("XMPPQueue", "Send Message Thread Enter");
_L5:
        Object obj = ab.a(a);
        obj;
        JVM INSTR monitorenter ;
        ab.a(a).wait(60000L);
_L6:
        if (ab.b(a).size() <= 0) goto _L2; else goto _L1
_L1:
        Object obj1 = (XMPPObject)ab.b(a).peek();
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        Log.d("XMPPQueue", "Queue Empty");
_L2:
        obj;
        JVM INSTR monitorexit ;
        Log.d("XMPPQueue", "Send Message Thread Loop");
          goto _L5
_L4:
        int i;
        if (!((XMPPObject) (obj1)).b.equals(bject.ContentType.a))
        {
            break MISSING_BLOCK_LABEL_172;
        }
        i = ab.a(a, ((XMPPObject) (obj1)));
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        try
        {
            ab.a(a).wait(1000L);
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        finally { }
        ab.a(a, false);
        ((InterruptedException) (obj1)).printStackTrace();
          goto _L2
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        if (i != 2);
          goto _L2
        if (!((XMPPObject) (obj1)).b.equals(bject.ContentType.b))
        {
            break; /* Loop/switch isn't completed */
        }
        i = ab.b(a, ((XMPPObject) (obj1)));
        if (i != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        ab.a(a).wait(1000L);
        break; /* Loop/switch isn't completed */
        if (i != 4) goto _L6; else goto _L2
    }

    on(ab ab1)
    {
        a = ab1;
        super();
    }
}
