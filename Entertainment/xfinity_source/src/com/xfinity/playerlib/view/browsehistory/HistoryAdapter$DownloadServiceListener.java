// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import com.comcast.cim.downloads.DownloadFile;
import com.comcast.cim.downloads.SimpleDownloadServiceListener;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.view.widget.DownloadProgressBar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryAdapter

class viewHolderMap extends SimpleDownloadServiceListener
{

    final HistoryAdapter this$0;
    Map viewHolderMap;

    public void add(viewHolderMap viewholdermap, PlayerDownloadFile playerdownloadfile)
    {
        if (!viewHolderMap.containsKey(playerdownloadfile))
        {
            viewHolderMap.put(playerdownloadfile, viewholdermap);
        }
    }

    public void onDownloadEngineStatusChanged(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
    {
        java.util.tConnection tconnection;
        for (ivirtuosodownloadenginestatus = viewHolderMap.entrySet().iterator(); ivirtuosodownloadenginestatus.hasNext(); ((viewHolderMap)tconnection.ViewHolder()).out.setProgress((PlayerDownloadFile)tconnection.oadFile(), HistoryAdapter.access$100(HistoryAdapter.this), HistoryAdapter.access$200(HistoryAdapter.this)))
        {
            tconnection = (java.util.dapter)ivirtuosodownloadenginestatus.next();
        }

    }

    public volatile void onFileProgressUpdated(DownloadFile downloadfile)
    {
        onFileProgressUpdated((PlayerDownloadFile)downloadfile);
    }

    public void onFileProgressUpdated(PlayerDownloadFile playerdownloadfile)
    {
        onFileProgressUpdated onfileprogressupdated = (onFileProgressUpdated)viewHolderMap.get(playerdownloadfile);
        if (onfileprogressupdated != null)
        {
            onfileprogressupdated.out.setProgress(playerdownloadfile, HistoryAdapter.access$100(HistoryAdapter.this), HistoryAdapter.access$200(HistoryAdapter.this));
        }
    }

    ()
    {
        this$0 = HistoryAdapter.this;
        super();
        viewHolderMap = new HashMap();
    }
}
