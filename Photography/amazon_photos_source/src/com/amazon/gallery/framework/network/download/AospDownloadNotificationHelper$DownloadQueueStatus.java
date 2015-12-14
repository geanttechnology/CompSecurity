// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;


// Referenced classes of package com.amazon.gallery.framework.network.download:
//            AospDownloadNotificationHelper

private static class numTotalToDownload
{

    private long numDownloadCompleted;
    private long numDownloadFailed;
    private long numTotalToDownload;

    public long getRemainingItemCount()
    {
        return numTotalToDownload - (numDownloadCompleted + numDownloadFailed);
    }

    public boolean hasFailedItems()
    {
        return numDownloadFailed != 0L;
    }

    public void onItemDownloadComplete()
    {
        numDownloadCompleted = numDownloadCompleted + 1L;
    }

    public void onItemDownloadFailed()
    {
        numDownloadFailed = numDownloadFailed + 1L;
    }

    public void onItemsAdded(long l)
    {
        numTotalToDownload = numTotalToDownload + l;
    }

    public (long l)
    {
        numTotalToDownload = l;
    }
}
