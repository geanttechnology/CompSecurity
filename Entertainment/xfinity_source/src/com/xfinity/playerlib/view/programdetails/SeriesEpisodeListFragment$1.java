// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.downloads.SimpleDownloadServiceListener;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEpisodeListFragment

class this._cls0 extends SimpleDownloadServiceListener
{

    final SeriesEpisodeListFragment this$0;

    public void onFileListUpdated()
    {
        if (!SeriesEpisodeListFragment.access$000(SeriesEpisodeListFragment.this).firstTimeLoadStarted())
        {
            SeriesEpisodeListFragment.access$100(SeriesEpisodeListFragment.this);
        }
    }

    ate()
    {
        this$0 = SeriesEpisodeListFragment.this;
        super();
    }
}
