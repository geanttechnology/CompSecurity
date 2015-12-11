// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.Intent;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            MovieDetailActivity

public class BabyGuideMovieActivity extends MovieDetailActivity
{

    public BabyGuideMovieActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.babyguide_movie_detail_shell;
    }

    public void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable)
    {
        videofacade = VideoPlayerActivity.createIntentForPlayer(videofacade, watchable);
        videofacade.setAction("reset");
        videofacade.setFlags(0x4000000);
        startActivity(videofacade);
    }
}
