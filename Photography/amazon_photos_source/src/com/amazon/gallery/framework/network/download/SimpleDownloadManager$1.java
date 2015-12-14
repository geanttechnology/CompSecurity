// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;


// Referenced classes of package com.amazon.gallery.framework.network.download:
//            SimpleDownloadManager

class val.filesToScan
    implements Runnable
{

    final SimpleDownloadManager this$0;
    final String val$filesToScan[];

    public void run()
    {
        startMediaScan(val$filesToScan);
    }

    ()
    {
        this$0 = final_simpledownloadmanager;
        val$filesToScan = _5B_Ljava.lang.String_3B_.this;
        super();
    }
}
