// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadFile

public interface DownloadServiceListener
{

    public abstract void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus);

    public abstract void onDownloadServiceConnected();

    public abstract void onFileDownloadError(DownloadFile downloadfile);

    public abstract void onFileDownloadFinished(DownloadFile downloadfile);

    public abstract void onFileDownloadStarted(DownloadFile downloadfile);

    public abstract void onFileListUpdated();

    public abstract void onFileProgressUpdated(DownloadFile downloadfile);
}
