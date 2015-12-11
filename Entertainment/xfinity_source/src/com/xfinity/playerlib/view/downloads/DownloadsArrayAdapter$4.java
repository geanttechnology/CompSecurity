// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import com.comcast.cim.downloads.DownloadFile;
import com.comcast.cim.downloads.SimpleDownloadServiceListener;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.view.widget.DownloadProgressBar;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsArrayAdapter

class > extends SimpleDownloadServiceListener
{

    final DownloadsArrayAdapter this$0;
    final wnloadableItemHolder val$holder;

    public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
    {
        val$holder.inProgressLayout.setProgress(val$holder.playerDownloadFile, downloadManager, internetConnection);
    }

    public volatile void onFileProgressUpdated(DownloadFile downloadfile)
    {
        onFileProgressUpdated((PlayerDownloadFile)downloadfile);
    }

    public void onFileProgressUpdated(PlayerDownloadFile playerdownloadfile)
    {
        if (val$holder.playerDownloadFile.equals(playerdownloadfile))
        {
            val$holder.inProgressLayout.setProgress(playerdownloadfile, downloadManager, internetConnection);
        }
    }

    wnloadableItemHolder()
    {
        this$0 = final_downloadsarrayadapter;
        val$holder = wnloadableItemHolder.this;
        super();
    }
}
