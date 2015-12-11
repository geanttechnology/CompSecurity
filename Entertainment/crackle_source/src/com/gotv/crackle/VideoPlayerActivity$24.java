// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.MenuItem;
import android.view.View;
import com.conviva.LivePass;
import com.google.util.SystemUiHider;
import com.gotv.crackle.captions.CaptionWindow;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.views.MediaControllerView;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements Runnable
{

    final VideoPlayerActivity this$0;

    public void run()
    {
        Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("runMidRoll").toString());
        VideoPlayerActivity.access$6600(VideoPlayerActivity.this).setVisible(false);
        try
        {
            LivePass.pauseMonitor(VideoPlayerActivity.mConvivaSessionID);
        }
        catch (Exception exception) { }
        VideoPlayerActivity.access$600(VideoPlayerActivity.this).stopPlayback(false);
        VideoPlayerActivity.access$900(VideoPlayerActivity.this).hide();
        VideoPlayerActivity.access$700(VideoPlayerActivity.this).setVideoState(VideoPlayerActivity.access$700(VideoPlayerActivity.this).getConstants().VIDEO_STATE_PAUSED());
        VideoPlayerActivity.access$3400(VideoPlayerActivity.this).setVisibility(4);
        VideoPlayerActivity.access$500(VideoPlayerActivity.this).setVisibility(8);
        VideoPlayerActivity.access$1500(VideoPlayerActivity.this).setText("");
        VideoPlayerActivity.access$6702(VideoPlayerActivity.this, true);
        VideoPlayerActivity.access$6800(VideoPlayerActivity.this).play();
    }

    per()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
