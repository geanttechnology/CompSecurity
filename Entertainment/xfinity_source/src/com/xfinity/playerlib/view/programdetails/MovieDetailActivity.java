// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailActivity

public class MovieDetailActivity extends DetailActivity
    implements DetailFragment.PlayPressedListener
{

    public MovieDetailActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.movie_detail_shell;
    }

    public void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable)
    {
        startActivity(VideoPlayerActivity.createIntentForPlayer(videofacade, watchable));
    }
}
