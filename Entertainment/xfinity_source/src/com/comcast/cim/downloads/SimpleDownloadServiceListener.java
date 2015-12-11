// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceListener, DownloadFile

public abstract class SimpleDownloadServiceListener
    implements DownloadServiceListener
{

    public SimpleDownloadServiceListener()
    {
    }

    public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
    {
    }

    public void onDownloadServiceConnected()
    {
    }

    public void onFileDownloadError(DownloadFile downloadfile)
    {
    }

    public void onFileDownloadFinished(DownloadFile downloadfile)
    {
    }

    public void onFileDownloadStarted(DownloadFile downloadfile)
    {
    }

    public void onFileListUpdated()
    {
    }

    public void onFileProgressUpdated(DownloadFile downloadfile)
    {
    }
}
