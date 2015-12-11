// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.precache;

import android.os.Handler;
import android.os.Message;
import com.supersonicads.sdk.data.SSAFile;

// Referenced classes of package com.supersonicads.sdk.precache:
//            DownloadManager

class this._cls0 extends Handler
{

    final DownloadManager this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1012 1017: default 44
    //                   1012 44
    //                   1013 44
    //                   1014 44
    //                   1015 44
    //                   1016 45
    //                   1017 75;
           goto _L1 _L1 _L1 _L1 _L1 _L2 _L3
_L1:
        return;
_L2:
        if (DownloadManager.access$200(DownloadManager.this) != null)
        {
            DownloadManager.access$200(DownloadManager.this).onFileDownloadSuccess((SSAFile)message.obj);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (DownloadManager.access$200(DownloadManager.this) != null)
        {
            DownloadManager.access$200(DownloadManager.this).onFileDownloadFail((SSAFile)message.obj);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    PreCacheCompletion()
    {
        this$0 = DownloadManager.this;
        super();
    }
}
