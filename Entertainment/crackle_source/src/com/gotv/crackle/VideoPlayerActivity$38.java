// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import com.gotv.crackle.adapters.DeviceListAdapter;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.smarttv.SmartTV;
import com.gotv.crackle.views.MediaControllerView;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements android.content.Listener
{

    final VideoPlayerActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        SmartTV.getInstance().stopDiscovery();
        i = VideoPlayerActivity.access$7700(VideoPlayerActivity.this).getCurIndex();
        if (i >= 0 && i < VideoPlayerActivity.access$7700(VideoPlayerActivity.this).getCount())
        {
            SmartTV.getInstance().connectToTV(VideoPlayerActivity.access$7700(VideoPlayerActivity.this).getCurIndex(), VideoPlayerActivity.access$7800(VideoPlayerActivity.this));
            finish();
        } else
        {
            VideoPlayerActivity.access$7900(VideoPlayerActivity.this, getString(0x7f0b00de));
        }
        if (!VideoPlayerActivity.access$500(VideoPlayerActivity.this).isPlaying())
        {
            VideoPlayerActivity.access$500(VideoPlayerActivity.this).start();
            VideoPlayerActivity.access$600(VideoPlayerActivity.this).updatePausePlayButton();
            VideoPlayerActivity.access$700(VideoPlayerActivity.this).setVideoState(VideoPlayerActivity.access$700(VideoPlayerActivity.this).getConstants().VIDEO_STATE_PLAYING());
            VideoPlayerActivity.access$700(VideoPlayerActivity.this).setActivityState(VideoPlayerActivity.access$700(VideoPlayerActivity.this).getConstants().ACTIVITY_STATE_RESUME());
        }
        VideoPlayerActivity.access$7700(VideoPlayerActivity.this).unselectItem();
    }

    ew()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
