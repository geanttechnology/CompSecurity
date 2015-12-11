// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.os.Handler;
import android.os.Message;
import com.appnexus.opensdk.b.b;
import java.lang.ref.WeakReference;

// Referenced classes of package com.appnexus.opensdk:
//            e, c, z, ao, 
//            l, o, v, ak, 
//            ai

private static final class ce extends Handler
{

    private final WeakReference a;

    public final void handleMessage(Message message)
    {
        this;
        JVM INSTR monitorenter ;
        message = (e)a.get();
        if (message == null) goto _L2; else goto _L1
_L1:
        boolean flag = ((e) (message)).d.a();
        if (flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        if (((e) (message)).b != -1L)
        {
            com.appnexus.opensdk.b.b.b(b.b, com.appnexus.opensdk.b.b.a(.new_ad_since, Math.max(0, (int)(System.currentTimeMillis() - ((e) (message)).b))));
        }
        message.b = System.currentTimeMillis();
        com.appnexus.opensdk.b[((e) (message)).d.getMediaType().ordinal()];
        JVM INSTR tableswitch 1 3: default 198
    //                   1 135
    //                   2 156
    //                   3 177;
           goto _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_177;
_L8:
        ((e) (message)).e.d();
          goto _L2
        message;
        throw message;
_L5:
        message.e = new l((o)((e) (message)).d);
          goto _L8
_L6:
        message.e = new l((v)((e) (message)).d);
          goto _L8
        message.e = new ak((ai)((e) (message)).d);
          goto _L8
    }

    ce(e e1)
    {
        a = new WeakReference(e1);
    }
}
