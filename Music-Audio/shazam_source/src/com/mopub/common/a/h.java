// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;

import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;

// Referenced classes of package com.mopub.common.a:
//            i, d, a

public class h
{

    private static volatile d a;

    public h()
    {
    }

    private static d a()
    {
        Object obj;
        obj = a;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        com/mopub/common/a/h;
        JVM INSTR monitorenter ;
        d d1 = a;
        obj = d1;
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj = new ArrayList();
        HandlerThread handlerthread = new HandlerThread("mopub_event_logging");
        handlerthread.start();
        ((ArrayList) (obj)).add(new i(handlerthread.getLooper()));
        obj = new d(((Iterable) (obj)), handlerthread.getLooper());
        a = ((d) (obj));
        com/mopub/common/a/h;
        JVM INSTR monitorexit ;
        return ((d) (obj));
        obj;
        com/mopub/common/a/h;
        JVM INSTR monitorexit ;
        throw obj;
        return ((d) (obj));
    }

    public static void a(a a1)
    {
        Message.obtain(a().b, 0, a1).sendToTarget();
    }
}
