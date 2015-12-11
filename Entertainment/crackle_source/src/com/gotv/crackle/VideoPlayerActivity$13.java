// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import android.net.Uri;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.util.Log;
import com.nielsen.app.sdk.AppSdk;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements Runnable
{

    final VideoPlayerActivity this$0;

    public void run()
    {
        Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("playResume").toString());
        VideoPlayerActivity.access$500(VideoPlayerActivity.this).setVisibility(0);
        if (VideoPlayerActivity.access$4600() != null)
        {
            VideoPlayerActivity.access$4700().play(VideoPlayerActivity.access$2500(VideoPlayerActivity.this));
            VideoPlayerActivity.access$4800().loadMetadata(VideoPlayerActivity.access$2700(VideoPlayerActivity.this));
        }
        String s;
        try
        {
            Uri.parse(VideoPlayerActivity.access$100(VideoPlayerActivity.this));
        }
        catch (Exception exception)
        {
            backToYosemite(VideoPlayerActivity.access$4900(VideoPlayerActivity.this));
        }
        VideoPlayerActivity.access$4902(VideoPlayerActivity.this, getIntent().getStringExtra("CONTROL"));
        s = getIntent().getStringExtra("SEEKTO");
        if (s != null && !"".equals(s) && "START_BY_YOSEMITE".equals(VideoPlayerActivity.access$4900(VideoPlayerActivity.this)))
        {
            VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem();
            VideoPlayerActivity.access$2902(VideoPlayerActivity.this, true);
            int i = Integer.parseInt(getIntent().getStringExtra("SEEKTO"));
            VideoPlayerActivity.access$5000(VideoPlayerActivity.this, i, "YOSEMITE_SEEK");
            VideoPlayerActivity.access$5100(VideoPlayerActivity.this);
            return;
        }
        if (SharedPrefsManager.getPlayProgressForItem(VideoPlayerActivity.access$3700(VideoPlayerActivity.this)) > 0 && (double)(SharedPrefsManager.getPlayProgressForItem(VideoPlayerActivity.access$3700(VideoPlayerActivity.this)) / 1000) < (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) - (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) * 0.10000000000000001D)
        {
            if (SharedPrefsManager.getShowResumePrompt())
            {
                VideoPlayerActivity.access$5200(VideoPlayerActivity.this);
                return;
            } else
            {
                int j = SharedPrefsManager.getPlayProgressForItem(VideoPlayerActivity.access$3700(VideoPlayerActivity.this));
                VideoPlayerActivity.access$5302(VideoPlayerActivity.this, j / 1000);
                VideoPlayerActivity.access$5402(VideoPlayerActivity.this, "true");
                VideoPlayerActivity.access$5100(VideoPlayerActivity.this);
                return;
            }
        } else
        {
            VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem();
            VideoPlayerActivity.access$2902(VideoPlayerActivity.this, true);
            VideoPlayerActivity.access$5000(VideoPlayerActivity.this, 0, "START OVER");
            VideoPlayerActivity.access$5100(VideoPlayerActivity.this);
            return;
        }
    }

    ger()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
