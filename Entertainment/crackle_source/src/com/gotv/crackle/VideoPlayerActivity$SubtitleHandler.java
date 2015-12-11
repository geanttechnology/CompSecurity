// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.os.Handler;
import android.os.Message;
import com.gotv.crackle.helpers.CrackleVideoHelper;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

private class <init> extends Handler
{

    private static final int MSG_SUBTITLE_CHECK = 2000;
    final VideoPlayerActivity this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 2000: 
            VideoPlayerActivity.access$5600(VideoPlayerActivity.this, VideoPlayerActivity.access$500(VideoPlayerActivity.this).getCurrentPosition());
            break;
        }
        VideoPlayerActivity.access$5700(VideoPlayerActivity.this).sendEmptyMessageDelayed(2000, 100L);
    }

    private ()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
