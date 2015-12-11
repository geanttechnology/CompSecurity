// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.support.v7.app.ActionBar;
import com.gotv.crackle.views.MediaControllerView;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements com.google.util.lityChangeListener
{

    final VideoPlayerActivity this$0;

    public void onVisibilityChange(boolean flag)
    {
        if (flag)
        {
            VideoPlayerActivity.access$1000(VideoPlayerActivity.this).show();
            if (!VideoPlayerActivity.access$600(VideoPlayerActivity.this).isShowing() && !VideoPlayerActivity.access$1100(VideoPlayerActivity.this))
            {
                VideoPlayerActivity.access$600(VideoPlayerActivity.this).showControls();
            }
            VideoPlayerActivity.access$1200(VideoPlayerActivity.this, 6000);
            return;
        } else
        {
            VideoPlayerActivity.access$1302(VideoPlayerActivity.this, -1);
            VideoPlayerActivity.access$600(VideoPlayerActivity.this).setSecondaryProgress(0);
            VideoPlayerActivity.access$1000(VideoPlayerActivity.this).hide();
            VideoPlayerActivity.access$600(VideoPlayerActivity.this).hideControls();
            return;
        }
    }

    iew()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
