// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.MenuItem;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.util.ComscoreTracker;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.views.MediaControllerView;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity, Application

class this._cls0
    implements Runnable
{

    final VideoPlayerActivity this$0;

    public void run()
    {
        if (VideoPlayerActivity.mConvivaSessionID < 0)
        {
            Log.d("CONVIVA", (new StringBuilder()).append("SESSIONID = ").append(VideoPlayerActivity.mConvivaSessionID).toString());
            VideoPlayerActivity.mConvivaMediaDetailsItem = VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem();
            VideoPlayerActivity.mConvivaMediaUrl = VideoPlayerActivity.access$100(VideoPlayerActivity.this);
            if (VideoPlayerActivity.access$500(VideoPlayerActivity.this).getCurrentPosition() == 0);
        }
        int i = SharedPrefsManager.getPlayProgressForItem(VideoPlayerActivity.access$3700(VideoPlayerActivity.this));
        VideoPlayerActivity.access$1800(VideoPlayerActivity.this).setTimeRecentlyObserved(i);
        VideoPlayerActivity.access$1800(VideoPlayerActivity.this).setClipToMediaItem();
        VideoPlayerActivity.access$600(VideoPlayerActivity.this).playVideo(VideoPlayerActivity.access$100(VideoPlayerActivity.this), VideoPlayerActivity.access$1900(VideoPlayerActivity.this));
        Log.v(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("Resume to ").append(i).toString());
        if (i > 0)
        {
            VideoPlayerActivity.access$600(VideoPlayerActivity.this).seekTo(i);
        }
        if (!Application.isLeanBack())
        {
            VideoPlayerActivity.access$6600(VideoPlayerActivity.this).setVisible(true);
        }
    }

    ew()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
