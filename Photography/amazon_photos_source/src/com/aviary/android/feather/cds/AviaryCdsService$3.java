// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService

class val.files
    implements FutureListener
{

    final AviaryCdsService this$0;
    final String val$assetBaseUrl;
    final ageCursorWrapper val$currentMessage;
    final AtomicInteger val$files;
    final AtomicBoolean val$hasException;
    final String val$key;
    final HashMap val$notificationMap;

    public void onFutureDone(Future future)
    {
        if (!future.hasException()) goto _L2; else goto _L1
_L1:
        AviaryCdsService.logger.error("future hasException: %s", new Object[] {
            future.getException()
        });
        val$hasException.set(true);
_L3:
        synchronized (val$files)
        {
            int i = val$files.decrementAndGet();
            AviaryCdsService.logger.log("completed.. remaining tasks %d", new Object[] {
                Integer.valueOf(i)
            });
            val$files.notify();
        }
        return;
_L2:
        future = (InputStream)future.get();
        AviaryCdsService.access$200(AviaryCdsService.this, getBaseContext(), future, val$currentMessage, val$key, val$assetBaseUrl);
        val$notificationMap.put(val$key, Boolean.valueOf(true));
        IOUtils.closeSilently(future);
          goto _L3
        Object obj;
        obj;
        AviaryCdsService.logger.error("onUpdateMessageContent failed: %s", new Object[] {
            ((Throwable) (obj)).getMessage()
        });
        val$hasException.set(true);
        IOUtils.closeSilently(future);
          goto _L3
        obj;
        IOUtils.closeSilently(future);
        throw obj;
        exception;
        future;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ageCursorWrapper()
    {
        this$0 = final_aviarycdsservice;
        val$hasException = atomicboolean;
        val$currentMessage = agecursorwrapper;
        val$key = s;
        val$assetBaseUrl = s1;
        val$notificationMap = hashmap;
        val$files = AtomicInteger.this;
        super();
    }
}
