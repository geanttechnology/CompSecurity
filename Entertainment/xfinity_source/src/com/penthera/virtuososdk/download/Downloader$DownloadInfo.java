// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;


// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

private class <init>
{

    boolean iBytesDownloaded;
    int iDownloadExceptions;
    boolean iDownloading;
    long iLastBytesRead;
    final Downloader this$0;

    private ()
    {
        this$0 = Downloader.this;
        super();
        iDownloading = false;
        iBytesDownloaded = false;
        iLastBytesRead = 0L;
        iDownloadExceptions = 0;
    }

    iDownloadExceptions(iDownloadExceptions idownloadexceptions)
    {
        this();
    }
}
