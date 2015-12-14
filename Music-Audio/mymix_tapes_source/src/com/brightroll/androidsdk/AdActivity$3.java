// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.VideoView;

// Referenced classes of package com.brightroll.androidsdk:
//            AdActivity

class val.activity
    implements Runnable
{

    final AdActivity this$0;
    private final AdActivity val$activity;

    public void run()
    {
        videoView = new VideoView(val$activity);
        android.widget.ayoutParams ayoutparams = new android.widget.ayoutParams(1, 1);
        videoView.setLayoutParams(ayoutparams);
        frameLayout.addView(videoView);
        videoView.setMediaController(null);
        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.setOnPreparedListener(val$activity);
        videoView.setOnCompletionListener(val$activity);
        videoView.setOnErrorListener(val$activity);
    }

    ()
    {
        this$0 = final_adactivity;
        val$activity = AdActivity.this;
        super();
    }
}
