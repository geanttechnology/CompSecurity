// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import com.comcast.cim.downloads.SimpleDownloadServiceListener;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryFragment, HistoryAdapter

class it> extends SimpleDownloadServiceListener
{

    final HistoryFragment this$0;

    public void onFileListUpdated()
    {
        HistoryFragment.access$400(HistoryFragment.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = HistoryFragment.this;
        super();
    }
}
