// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ad;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.perfectcorp.utility.e;

public class YouTubeActivity extends YouTubeBaseActivity
    implements com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
{

    private String a;

    public YouTubeActivity()
    {
        a = null;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_youtube);
        bundle = getIntent();
        if (bundle != null)
        {
            bundle = bundle.getStringExtra("YouTubeVideoId");
        } else
        {
            bundle = null;
        }
        a = bundle;
        if (a == null)
        {
            DialogUtils.a(this, null, getString(m.bc_youtube_video_id_invalid), null, null, getString(m.bc_dialog_button_ok), new Runnable() {

                final YouTubeActivity a;

                public void run()
                {
                    a.finish();
                }

            
            {
                a = YouTubeActivity.this;
                super();
            }
            });
            return;
        } else
        {
            ((YouTubePlayerView)findViewById(j.youtube_view)).initialize(ad.a, this);
            return;
        }
    }

    public void onInitializationFailure(com.google.android.youtube.player.YouTubePlayer.Provider provider, YouTubeInitializationResult youtubeinitializationresult)
    {
        if (youtubeinitializationresult.isUserRecoverableError())
        {
            youtubeinitializationresult.getErrorDialog(this, 1).show();
        }
    }

    public void onInitializationSuccess(com.google.android.youtube.player.YouTubePlayer.Provider provider, YouTubePlayer youtubeplayer, boolean flag)
    {
        if (youtubeplayer == null)
        {
            e.e(new Object[] {
                "Player is null"
            });
        } else
        {
            youtubeplayer.setShowFullscreenButton(false);
            if (!flag)
            {
                youtubeplayer.loadVideo(a);
                youtubeplayer.play();
                return;
            }
        }
    }
}
