// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.media.MediaPlayer;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity, Application

class this._cls0
    implements android.media.tener
{

    final VideoPlayerActivity this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (VideoPlayerActivity.access$000(VideoPlayerActivity.this) && android.os.ity < 11 && !Application.isNookTablet())
        {
            forwardToFlashPlayer();
            return true;
        }
        if (i == 1 && !VideoPlayerActivity.access$000(VideoPlayerActivity.this))
        {
            VideoPlayerActivity.access$102(VideoPlayerActivity.this, VideoPlayerActivity.access$100(VideoPlayerActivity.this).replace("http:", "httplive:"));
            VideoPlayerActivity.access$002(VideoPlayerActivity.this, true);
            VideoPlayerActivity.access$200(VideoPlayerActivity.this);
            return true;
        } else
        {
            mVideoErrorDialog.show();
            return true;
        }
    }

    er()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
