// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager, DownloadServiceListener

class this._cls0
    implements Runnable
{

    final DownloadServiceManager this$0;

    public void run()
    {
        Set set = DownloadServiceManager.access$1200(DownloadServiceManager.this);
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = DownloadServiceManager.access$1200(DownloadServiceManager.this).iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onFileListUpdated()) { }
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        set;
        JVM INSTR monitorexit ;
    }

    ()
    {
        this$0 = DownloadServiceManager.this;
        super();
    }
}
