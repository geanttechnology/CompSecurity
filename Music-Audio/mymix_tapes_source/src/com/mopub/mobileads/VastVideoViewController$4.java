// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.media.MediaPlayer;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastVideoConfig, VastVideoView, VastErrorCode

class val.videoView
    implements android.media.r
{

    final VastVideoViewController this$0;
    final VastVideoView val$videoView;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (val$videoView.retryMediaPlayer(mediaplayer, i, j, VastVideoViewController.access$400(VastVideoViewController.this).getDiskMediaFileUrl()))
        {
            return true;
        } else
        {
            VastVideoViewController.access$1300(VastVideoViewController.this);
            makeVideoInteractable();
            videoError(false);
            VastVideoViewController.access$1402(VastVideoViewController.this, true);
            VastVideoViewController.access$400(VastVideoViewController.this).handleError(getContext(), VastErrorCode.GENERAL_LINEAR_AD_ERROR, getCurrentPosition());
            return false;
        }
    }

    ()
    {
        this$0 = final_vastvideoviewcontroller;
        val$videoView = VastVideoView.this;
        super();
    }
}
