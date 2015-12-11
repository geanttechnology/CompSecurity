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
//            RingtoneDownloadedAdapter

class val.in_fo
    implements android.view.adedAdapter._cls3
{

    final RingtoneDownloadedAdapter this$0;
    private final DownloadMovieItem val$in_fo;

    public void onClick(View view)
    {
        view = new Intent();
        view.setAction("ringtoneplay");
        view.putExtra("ringtoneposition", val$in_fo.getFilePath());
        view.putExtra("ringtonepositiontitle", val$in_fo.getMovieName());
        Log.v("ringtoneposition", val$in_fo.getFilePath());
        ctx.sendBroadcast(view);
    }

    ()
    {
        this$0 = final_ringtonedownloadedadapter;
        val$in_fo = DownloadMovieItem.this;
        super();
    }
}
