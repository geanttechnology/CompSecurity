// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Dialog;
import android.content.DialogInterface;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements android.content.Listener
{

    final VideoPlayerActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        VideoPlayerActivity.access$3000(VideoPlayerActivity.this).getCurrentItem();
        VideoPlayerActivity.access$2902(VideoPlayerActivity.this, true);
        mResumeDialog.dismiss();
        VideoPlayerActivity.access$5000(VideoPlayerActivity.this, 0, "START_OVER");
        VideoPlayerActivity.access$5100(VideoPlayerActivity.this);
        VideoPlayerActivity.access$5402(VideoPlayerActivity.this, "false");
    }

    ocessor()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
