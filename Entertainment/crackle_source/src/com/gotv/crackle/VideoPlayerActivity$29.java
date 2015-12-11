// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.MenuItem;
import android.view.View;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.views.MediaControllerView;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements Runnable
{

    final VideoPlayerActivity this$0;

    public void run()
    {
        VideoPlayerActivity.access$6600(VideoPlayerActivity.this).setVisible(false);
        Log.d(VideoPlayerActivity.access$1400(VideoPlayerActivity.this), (new StringBuilder()).append(VideoPlayerActivity.access$1400(VideoPlayerActivity.this)).append("runPreRoll").toString());
        VideoPlayerActivity.access$600(VideoPlayerActivity.this).hideControls();
        VideoPlayerActivity.access$3400(VideoPlayerActivity.this).setVisibility(4);
        VideoPlayerActivity.access$500(VideoPlayerActivity.this).setVisibility(8);
        VideoPlayerActivity.access$7300(VideoPlayerActivity.this).play();
        VideoPlayerActivity.access$6802(VideoPlayerActivity.this, VideoPlayerActivity.access$7300(VideoPlayerActivity.this));
    }

    per()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
