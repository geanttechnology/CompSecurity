// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;


// Referenced classes of package com.amazon.gallery.framework.network.download:
//            CustomDownloadId

public interface DownloadStatusNotifier
{

    public abstract void onDownloadQueueCreated(CustomDownloadId customdownloadid);

    public abstract void onDownloadQueueRemoved(CustomDownloadId customdownloadid);

    public abstract void onDownloadQueuesCleared();

    public abstract void onItemDownloadCompleted(CustomDownloadId customdownloadid);

    public abstract void onItemDownloadFailed(CustomDownloadId customdownloadid);

    public abstract void onItemDownloadStarted(CustomDownloadId customdownloadid, String s);
}
