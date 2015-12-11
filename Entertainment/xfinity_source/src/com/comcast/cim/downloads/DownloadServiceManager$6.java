// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.ServiceException;
import com.penthera.virtuososdk.client.Virtuoso;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager, DownloadFile

class val.files
    implements Runnable
{

    final DownloadServiceManager this$0;
    final List val$files;

    public void run()
    {
        Iterator iterator = val$files.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (DownloadFile)iterator.next();
            try
            {
                DownloadServiceManager.access$500(DownloadServiceManager.this).delete(((DownloadFile) (obj)).getAsset());
            }
            catch (ServiceException serviceexception)
            {
                synchronized (DownloadServiceManager.access$1100(DownloadServiceManager.this))
                {
                    obj = (CountDownLatch)DownloadServiceManager.access$1100(DownloadServiceManager.this).remove(obj);
                }
                if (obj != null)
                {
                    ((CountDownLatch) (obj)).countDown();
                }
            }
        } while (true);
        break MISSING_BLOCK_LABEL_92;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = final_downloadservicemanager;
        val$files = List.this;
        super();
    }
}
