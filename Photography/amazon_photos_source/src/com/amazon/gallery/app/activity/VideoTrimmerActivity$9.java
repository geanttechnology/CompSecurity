// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.app.activity;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.amazon.gallery.app.activity:
//            VideoTrimmerActivity

class this._cls0 extends Handler
{

    final VideoTrimmerActivity this$0;

    public void handleMessage(Message message)
    {
        if (message.what == 0)
        {
            VideoTrimmerActivity.access$2000(VideoTrimmerActivity.this);
            VideoTrimmerActivity.access$2100(VideoTrimmerActivity.this).sendEmptyMessage(0);
        } else
        if (message.what == 1)
        {
            removeMessages(0);
            return;
        }
    }

    ()
    {
        this$0 = VideoTrimmerActivity.this;
        super();
    }
}
