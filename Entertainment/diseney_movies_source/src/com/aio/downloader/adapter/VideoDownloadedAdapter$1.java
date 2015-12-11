// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.aio.downloader.activity.VideoViewActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;

// Referenced classes of package com.aio.downloader.adapter:
//            VideoDownloadedAdapter

class val.in_fo
    implements android.view.adedAdapter._cls1
{

    final VideoDownloadedAdapter this$0;
    private final DownloadMovieItem val$in_fo;

    public void onClick(View view)
    {
        view = new Intent(ctx, com/aio/downloader/activity/VideoViewActivity);
        view.putExtra("playurl", val$in_fo.getFilePath());
        ctx.startActivity(view);
    }

    _cls9()
    {
        this$0 = final_videodownloadedadapter;
        val$in_fo = DownloadMovieItem.this;
        super();
    }
}
