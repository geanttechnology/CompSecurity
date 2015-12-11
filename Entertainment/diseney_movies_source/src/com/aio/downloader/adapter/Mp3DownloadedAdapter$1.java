// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.mydownload.DownloadMovieItem;

// Referenced classes of package com.aio.downloader.adapter:
//            Mp3DownloadedAdapter

class val.in_fo
    implements android.view.adedAdapter._cls1
{

    final Mp3DownloadedAdapter this$0;
    private final DownloadMovieItem val$in_fo;

    public void onClick(View view)
    {
        view = new Intent();
        view.setAction("mp3play");
        view.putExtra("mp3positiontitle", val$in_fo.getMovieName());
        view.putExtra("mp3position", val$in_fo.getFilePath());
        Log.v("mp3position", val$in_fo.getFilePath());
        Mp3DownloadedAdapter.access$0(Mp3DownloadedAdapter.this).sendBroadcast(view);
    }

    ()
    {
        this$0 = final_mp3downloadedadapter;
        val$in_fo = DownloadMovieItem.this;
        super();
    }
}
