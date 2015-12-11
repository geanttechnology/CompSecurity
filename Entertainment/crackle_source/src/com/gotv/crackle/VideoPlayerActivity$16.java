// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Dialog;
import android.content.DialogInterface;
import com.gotv.crackle.helpers.SharedPrefsManager;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements android.content.Listener
{

    final VideoPlayerActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        mResumeDialog.dismiss();
        i = SharedPrefsManager.getPlayProgressForItem(VideoPlayerActivity.access$3700(VideoPlayerActivity.this));
        VideoPlayerActivity.access$5302(VideoPlayerActivity.this, i / 1000);
        VideoPlayerActivity.access$5402(VideoPlayerActivity.this, "true");
        if ((double)VideoPlayerActivity.access$5300(VideoPlayerActivity.this) > (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) * 0.25D)
        {
            VideoPlayerActivity.access$2002(VideoPlayerActivity.this, true);
        }
        if ((double)VideoPlayerActivity.access$5300(VideoPlayerActivity.this) > (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) * 0.5D)
        {
            VideoPlayerActivity.access$2102(VideoPlayerActivity.this, true);
        }
        if ((double)VideoPlayerActivity.access$5300(VideoPlayerActivity.this) > (double)VideoPlayerActivity.access$1900(VideoPlayerActivity.this) * 0.75D)
        {
            VideoPlayerActivity.access$2202(VideoPlayerActivity.this, true);
        }
        VideoPlayerActivity.access$5100(VideoPlayerActivity.this);
    }

    ger()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
