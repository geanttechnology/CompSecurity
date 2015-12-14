// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.Context;
import android.net.Uri;
import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService, CdsUtils

class val.files
    implements FutureListener
{

    final AviaryCdsService this$0;
    final AtomicInteger val$files;
    final AtomicBoolean val$hasException;
    final Uri val$iconUri;
    final rsorWrapper val$pack;

    public void onFutureDone(Future future)
    {
        if (!future.hasException()) goto _L2; else goto _L1
_L1:
        AviaryCdsService.logger.error("error: %s", new Object[] {
            future.getException()
        });
        val$hasException.set(true);
_L5:
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
        Future future1;
        Future future2;
        future2 = null;
        future1 = null;
        future = (InputStream)future.get();
        future1 = future;
        future2 = future;
        File file = new File((new StringBuilder()).append(getBaseContext().getFilesDir()).append("/").append(CdsUtils.getPackIconPath(val$pack.getIdentifier())).toString());
        future1 = future;
        future2 = future;
        int j = AviaryCdsService.access$500(AviaryCdsService.this, val$pack.getContent().getId(), val$pack.getId(), file, val$iconUri.getLastPathSegment(), future);
        if (j <= 0) goto _L4; else goto _L3
_L3:
        future1 = future;
        future2 = future;
        CdsUtils.notifyPackContentUpdate(getBaseContext(), val$pack.getId());
        future1 = future;
        future2 = future;
        CdsUtils.notifyPacksContentUpdated(getBaseContext(), val$pack.getPackType());
_L6:
        IOUtils.closeSilently(future);
          goto _L5
_L4:
        future1 = future;
        future2 = future;
        AviaryCdsService.logger.error("onUpdatedPackIcon result: %d", new Object[] {
            Integer.valueOf(j)
        });
        future1 = future;
        future2 = future;
        val$hasException.set(true);
          goto _L6
        future;
        future2 = future1;
        AviaryCdsService.logger.error("failed to update icon");
        future2 = future1;
        future.printStackTrace();
        future2 = future1;
        val$hasException.set(true);
        IOUtils.closeSilently(future1);
          goto _L5
        future;
        IOUtils.closeSilently(future2);
        throw future;
        exception;
        future;
        JVM INSTR monitorexit ;
        throw exception;
    }

    rsorWrapper()
    {
        this$0 = final_aviarycdsservice;
        val$hasException = atomicboolean;
        val$pack = rsorwrapper;
        val$iconUri = uri;
        val$files = AtomicInteger.this;
        super();
    }
}
