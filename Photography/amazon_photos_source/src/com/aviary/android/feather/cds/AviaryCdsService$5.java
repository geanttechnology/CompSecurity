// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import com.aviary.android.feather.cds.json.CdsContentParser;
import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService

class val.files
    implements FutureListener
{

    final AviaryCdsService this$0;
    final String val$assetBaseUrl;
    final List val$exceptions;
    final AtomicInteger val$files;
    final String val$identifier;
    final String val$packUrl;

    public void onFutureDone(Future future)
    {
        if (!future.hasException()) goto _L2; else goto _L1
_L1:
        val$exceptions.add(new storeException(4, future.getException()));
_L3:
        synchronized (val$files)
        {
            int i = val$files.decrementAndGet();
            AviaryCdsService.logger.log("completed. remaining tasks: %d", new Object[] {
                Integer.valueOf(i)
            });
            val$files.notify();
        }
        return;
_L2:
        future = (InputStream)future.get();
        CdsContentParser cdscontentparser;
        cdscontentparser = new CdsContentParser();
        if (cdscontentparser.parse(future) == 0)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        val$exceptions.add(new storeException(3, (new StringBuilder()).append(val$identifier).append(": ").append(cdscontentparser.getStatus()).toString()));
_L4:
        IOUtils.closeSilently(future);
          goto _L3
        AviaryCdsService.access$400(AviaryCdsService.this, getBaseContext(), cdscontentparser, 10000, 0, val$assetBaseUrl);
        AviaryCdsService.logger.log("restored: %s", new Object[] {
            val$identifier
        });
          goto _L4
        Object obj;
        obj;
        AviaryCdsService.logger.error((new StringBuilder()).append("onAddNewJsonContent failed on '%s'").append(val$packUrl).toString());
        ((Throwable) (obj)).printStackTrace();
        val$exceptions.add(new storeException(5, ((Throwable) (obj))));
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
        val$exceptions = list;
        val$identifier = s;
        val$assetBaseUrl = s1;
        val$packUrl = s2;
        val$files = AtomicInteger.this;
        super();
    }
}
