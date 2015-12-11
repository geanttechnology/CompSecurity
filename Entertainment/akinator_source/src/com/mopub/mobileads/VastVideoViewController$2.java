// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.media.MediaPlayer;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastVideoView, VastVideoConfig, VastVideoProgressBarWidget, 
//            VastVideoRadialCountdownWidget

class val.videoView
    implements android.media.ener
{

    final VastVideoViewController this$0;
    final VastVideoView val$videoView;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        VastVideoViewController.access$302(VastVideoViewController.this, VastVideoViewController.access$500(VastVideoViewController.this).getDuration());
        VastVideoViewController.access$600(VastVideoViewController.this);
        if (VastVideoViewController.access$700(VastVideoViewController.this) == null)
        {
            val$videoView.prepareBlurredLastVideoFrame(VastVideoViewController.access$800(VastVideoViewController.this), VastVideoViewController.access$400(VastVideoViewController.this).getDiskMediaFileUrl());
        }
        VastVideoViewController.access$1000(VastVideoViewController.this).calibrateAndMakeVisible(getDuration(), VastVideoViewController.access$900(VastVideoViewController.this));
        VastVideoViewController.access$1100(VastVideoViewController.this).calibrateAndMakeVisible(VastVideoViewController.access$900(VastVideoViewController.this));
        VastVideoViewController.access$1202(VastVideoViewController.this, true);
    }

    dget()
    {
        this$0 = final_vastvideoviewcontroller;
        val$videoView = VastVideoView.this;
        super();
    }
}
