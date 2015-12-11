// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.views.MediaControllerView;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements android.content.kListener
{

    final VideoPlayerActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (!VideoPlayerActivity.access$500(VideoPlayerActivity.this).isPlaying())
        {
            VideoPlayerActivity.access$500(VideoPlayerActivity.this).start();
            VideoPlayerActivity.access$600(VideoPlayerActivity.this).updatePausePlayButton();
            VideoPlayerActivity.access$700(VideoPlayerActivity.this).setVideoState(VideoPlayerActivity.access$700(VideoPlayerActivity.this).getConstants().VIDEO_STATE_PLAYING());
            VideoPlayerActivity.access$700(VideoPlayerActivity.this).setActivityState(VideoPlayerActivity.access$700(VideoPlayerActivity.this).getConstants().ACTIVITY_STATE_RESUME());
        }
        dialoginterface.dismiss();
    }

    iew()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
