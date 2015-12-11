// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;


// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

public class None
{

    ission iPermission;
    ission iReason;
    private boolean iStopDownload;
    final Downloader this$0;

    void clear()
    {
        this;
        JVM INSTR monitorenter ;
        iStopDownload = false;
        iPermission = ission.EDownloadAllowed;
        iReason = None;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isSet()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = iDownloadStop.iStopDownload;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void stop(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        iDownloadStop.iStopDownload = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public ission()
    {
        this$0 = Downloader.this;
        super();
        iStopDownload = false;
        iPermission = ission.EDownloadAllowed;
        iReason = None;
    }
}
