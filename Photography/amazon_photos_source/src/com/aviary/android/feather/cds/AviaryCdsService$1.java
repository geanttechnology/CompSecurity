// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService

class val.files
    implements FutureListener
{

    final AviaryCdsService this$0;
    final String val$assetBaseUrl;
    final AtomicInteger val$files;
    final AtomicBoolean val$hasException;
    final int val$order;
    final String val$packUrl;

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
            AviaryCdsService.logger.log("completed. remaining tasks: %d ", new Object[] {
                Integer.valueOf(i)
            });
            val$files.notify();
        }
        return;
_L2:
        future = (InputStream)future.get();
        AviaryCdsService.access$000(AviaryCdsService.this, getBaseContext(), future, val$order, 1, val$assetBaseUrl);
        IOUtils.closeSilently(future);
          goto _L3
        Object obj;
        obj;
        AviaryCdsService.logger.error("onParseJsonContent failed: '%s' for packUrl: %s", new Object[] {
            ((Throwable) (obj)).getMessage(), val$packUrl
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

    ()
    {
        this$0 = final_aviarycdsservice;
        val$hasException = atomicboolean;
        val$order = i;
        val$assetBaseUrl = s;
        val$packUrl = s1;
        val$files = AtomicInteger.this;
        super();
    }
}
