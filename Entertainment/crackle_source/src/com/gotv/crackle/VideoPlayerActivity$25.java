// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.views.MediaControllerView;
import com.nielsen.app.sdk.AppSdk;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements Runnable
{

    final VideoPlayerActivity this$0;

    public void run()
    {
        if (VideoPlayerActivity.access$7000() != null)
        {
            VideoPlayerActivity.access$7100().play(VideoPlayerActivity.access$2500(VideoPlayerActivity.this));
        }
        VideoPlayerActivity.access$700(VideoPlayerActivity.this).setVideoState(VideoPlayerActivity.access$700(VideoPlayerActivity.this).getConstants().VIDEO_STATE_PLAYING());
        VideoPlayerActivity.access$500(VideoPlayerActivity.this).setVisibility(8);
        VideoPlayerActivity.access$500(VideoPlayerActivity.this).setVisibility(0);
        VideoPlayerActivity.access$600(VideoPlayerActivity.this).stopPlayback(true);
        VideoPlayerActivity.access$600(VideoPlayerActivity.this).stopBufferingDetector();
        System.gc();
    }

    ew()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
