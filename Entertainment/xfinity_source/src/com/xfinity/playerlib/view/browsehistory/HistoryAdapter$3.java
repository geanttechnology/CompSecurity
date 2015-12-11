// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.view.View;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.view.downloads.DownloadsItemListener;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryAdapter

class val.playerDownloadFile
    implements android.view.ner
{

    final HistoryAdapter this$0;
    final PlayerDownloadFile val$playerDownloadFile;

    public void onClick(View view)
    {
        HistoryAdapter.access$000(HistoryAdapter.this).onRetryDownloadPressed(context, val$playerDownloadFile);
    }

    ()
    {
        this$0 = final_historyadapter;
        val$playerDownloadFile = PlayerDownloadFile.this;
        super();
    }
}
