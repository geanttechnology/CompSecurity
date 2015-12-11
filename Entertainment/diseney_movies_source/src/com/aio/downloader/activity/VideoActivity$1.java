// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import com.aio.downloader.adapter.VideoListviewAdapter;
import com.aio.downloader.utils.ProgressWheel;

// Referenced classes of package com.aio.downloader.activity:
//            VideoActivity

class this._cls0 extends Handler
{

    final VideoActivity this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            VideoActivity.access$0(VideoActivity.this).setVisibility(0);
            VideoActivity.access$1(VideoActivity.this).setVisibility(8);
            VideoActivity.access$2(VideoActivity.this).setVisibility(8);
            VideoActivity.access$3(VideoActivity.this).setVisibility(8);
            return;

        case 2: // '\002'
            VideoActivity.access$1(VideoActivity.this).setVisibility(0);
            VideoActivity.access$0(VideoActivity.this).setVisibility(8);
            return;

        case 3: // '\003'
            VideoActivity.access$4(VideoActivity.this).notifyDataSetChanged();
            break;
        }
    }

    ter()
    {
        this$0 = VideoActivity.this;
        super();
    }
}
