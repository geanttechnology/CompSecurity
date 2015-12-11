// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import android.os.Message;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.ebay.common.util:
//            ImageCache

private static final class data
    implements Runnable
{

    private final dler.fetching data;
    private final dler handler;

    public void run()
    {
        obj = data.;
        break MISSING_BLOCK_LABEL_8;
_L2:
        do
        {
            return;
        } while (Thread.interrupted() || !((String) (obj)).equals(((ImageView)data.ws.get(0)).getTag()));
        HashMap hashmap = handler.fetching;
        hashmap;
        JVM INSTR monitorenter ;
        data data1 = (dler.fetching)handler.fetching.get(obj);
        if (data1 == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        data1.(data);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        obj;
        hashmap;
        JVM INSTR monitorexit ;
        throw obj;
        handler.fetching.put(obj, data);
        hashmap;
        JVM INSTR monitorexit ;
        data.map = handler.getImage(((String) (obj)));
        synchronized (handler.fetching)
        {
            handler.fetching.remove(obj);
        }
        if (Thread.interrupted()) goto _L2; else goto _L1
_L1:
        handler.obtainMessage(1, data).sendToTarget();
        return;
        obj;
        hashmap1;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception1;
        exception1;
        synchronized (handler.fetching)
        {
            handler.fetching.remove(obj);
        }
        throw exception1;
        exception;
        hashmap2;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public dler(dler dler, dler dler1)
    {
        handler = dler;
        data = dler1;
    }
}
