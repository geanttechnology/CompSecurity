// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import com.aio.downloader.adapter.VideoDownloadedAdapter;
import com.aio.downloader.utils.Myutils;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            VideoDownloadedActivity

class this._cls0 extends BroadcastReceiver
{

    final VideoDownloadedActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = VideoDownloadedActivity.access$0(VideoDownloadedActivity.this);
        Myutils.getInstance();
        context.add(Myutils.successItem);
        VideoDownloadedActivity.access$3(VideoDownloadedActivity.this).setAdapter(VideoDownloadedActivity.access$2(VideoDownloadedActivity.this));
        VideoDownloadedActivity.access$2(VideoDownloadedActivity.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = VideoDownloadedActivity.this;
        super();
    }
}
