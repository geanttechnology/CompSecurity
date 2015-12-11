// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.view.browseprograms.SortPolicy;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsFragment

class this._cls0
    implements com.comcast.cim.cmasl.android.util.view.widget.legate.ReadyListener
{

    final DownloadsFragment this$0;

    public void onReady()
    {
        setEditMode(false);
        updateSortButtonStates(DownloadsFragment.access$900(DownloadsFragment.this).getCurrentSortType());
        if (downloadsManager.isFileListReady())
        {
            DownloadsFragment.access$000(DownloadsFragment.this);
        }
    }

    ceManager()
    {
        this$0 = DownloadsFragment.this;
        super();
    }
}
