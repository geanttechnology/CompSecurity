// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;


// Referenced classes of package com.gotv.crackle:
//            ShowWatchlistDetailsActivity, Application

class this._cls0
    implements Runnable
{

    final ShowWatchlistDetailsActivity this$0;

    public void run()
    {
        fillData();
        ShowWatchlistDetailsActivity.access$000(ShowWatchlistDetailsActivity.this);
        if (ShowWatchlistDetailsActivity.access$100(ShowWatchlistDetailsActivity.this) == null) goto _L2; else goto _L1
_L1:
        if (!Application.getInstance().isTablet()) goto _L4; else goto _L3
_L3:
        onEpisodeClicked(ShowWatchlistDetailsActivity.access$100(ShowWatchlistDetailsActivity.this));
_L6:
        return;
_L4:
        if (ShowWatchlistDetailsActivity.access$200(ShowWatchlistDetailsActivity.this) == rrentScreen.PLAYLIST)
        {
            onBrowseEpisodesClick();
            return;
        }
        if (ShowWatchlistDetailsActivity.access$200(ShowWatchlistDetailsActivity.this) == rrentScreen.MEDIA)
        {
            onBrowseEpisodesClick();
            onEpisodeClicked(ShowWatchlistDetailsActivity.access$100(ShowWatchlistDetailsActivity.this));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (mMediaID != null)
        {
            if (!Application.getInstance().isTablet())
            {
                onBrowseEpisodesClick();
            }
            onEpisodeClicked(mMediaID);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    rrentScreen()
    {
        this$0 = ShowWatchlistDetailsActivity.this;
        super();
    }
}
