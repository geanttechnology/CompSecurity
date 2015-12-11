// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements Runnable
{

    final VideoPlayerActivity this$0;

    public void run()
    {
        BaseActivity.mAccountManager.setItemProgress(VideoPlayerActivity.access$800(VideoPlayerActivity.this), 0, null);
        playMediaItem(VideoPlayerActivity.access$800(VideoPlayerActivity.this));
        VideoPlayerActivity.access$802(VideoPlayerActivity.this, null);
    }

    ager()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
