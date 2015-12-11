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
        ShowWatchlistDetailsActivity.access$300(ShowWatchlistDetailsActivity.this);
        if (ShowWatchlistDetailsActivity.access$100(ShowWatchlistDetailsActivity.this) != null)
        {
            if (Application.getInstance().isTablet())
            {
                onEpisodeClicked(ShowWatchlistDetailsActivity.access$100(ShowWatchlistDetailsActivity.this));
            } else
            {
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
            }
        }
    }

    rrentScreen()
    {
        this$0 = ShowWatchlistDetailsActivity.this;
        super();
    }
}
