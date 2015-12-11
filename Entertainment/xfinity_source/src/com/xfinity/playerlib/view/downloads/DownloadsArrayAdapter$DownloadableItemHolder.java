// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.view.widget.DownloadProgressBar;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsArrayAdapter

private class <init>
{

    protected ImageView coverArt;
    protected LinearLayout downloadedLayout;
    protected TextView episodeNumText;
    protected TextView expirationText;
    protected DownloadProgressBar inProgressLayout;
    protected ImageView networkLogo;
    protected TextView networkText;
    protected LinearLayout playButton;
    public ImageView playButtonArt;
    public TextView playButtonCaption;
    protected PlayerDownloadFile playerDownloadFile;
    protected TextView progressIndicator;
    final DownloadsArrayAdapter this$0;
    protected TextView titleText;

    private ()
    {
        this$0 = DownloadsArrayAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
