// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.ComscoreTracker;
import com.gotv.crackle.util.Log;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

private class <init> extends Handler
{

    private static final int MSG_MIDROLL_CHECK = 1000;
    private static final int MSG_SCRUBBING_FORGIVENESS = 1001;
    final VideoPlayerActivity this$0;

    public void cancel()
    {
        removeMessages(1000);
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1000: 
            removeMessages(1000);
            Log.d("VideoPlayer", (new StringBuilder()).append("CHECK FOR AD forgiveness ").append(VideoPlayerActivity.access$1600(VideoPlayerActivity.this)).toString());
            if (VideoPlayerActivity.access$500(VideoPlayerActivity.this).isPlaying())
            {
                int i = VideoPlayerActivity.access$500(VideoPlayerActivity.this).getCurrentPosition();
                if ((i / 1000) % 15 == 0 && i != 0 && findViewById(0x7f0a019f).getVisibility() == 0)
                {
                    VideoPlayerActivity.access$5000(VideoPlayerActivity.this, i, "Every 15 Seconds");
                }
            }
            if (!VideoPlayerActivity.access$1600(VideoPlayerActivity.this))
            {
                VideoPlayerActivity.access$1700(VideoPlayerActivity.this, VideoPlayerActivity.access$500(VideoPlayerActivity.this).getCurrentPosition(), true);
            } else
            if (VideoPlayerActivity.access$500(VideoPlayerActivity.this).getCurrentPosition() > 0)
            {
                VideoPlayerActivity.access$5302(VideoPlayerActivity.this, VideoPlayerActivity.access$500(VideoPlayerActivity.this).getCurrentPosition() / 1000);
            }
            if (VideoPlayerActivity.access$1800(VideoPlayerActivity.this) != null && VideoPlayerActivity.access$500(VideoPlayerActivity.this).getCurrentPosition() != 0)
            {
                VideoPlayerActivity.access$1800(VideoPlayerActivity.this).setTimeRecentlyObserved(VideoPlayerActivity.access$500(VideoPlayerActivity.this).getCurrentPosition());
            }
            sendEmptyMessageDelayed(1000, 1000L);
            return;

        case 1001: 
            VideoPlayerActivity.access$1602(VideoPlayerActivity.this, false);
            return;
        }
    }

    public void start()
    {
        cancel();
        sendEmptyMessage(1000);
    }

    public void startScrubbingForgivenessPeriod()
    {
        if (VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem().getScrubbingForgiveness() != null)
        {
            VideoPlayerActivity.access$1602(VideoPlayerActivity.this, true);
            sendEmptyMessageDelayed(1001, VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem().getScrubbingForgiveness().intValue() * 1000);
        }
    }

    private _cls9()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
