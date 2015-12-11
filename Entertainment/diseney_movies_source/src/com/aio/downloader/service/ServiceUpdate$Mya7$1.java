// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Intent;
import android.util.Log;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.util.ArrayList;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls1 extends TimerTask
{

    final adcast this$1;

    public void run()
    {
        Log.e("qaz", (new StringBuilder("updateservise")).append(((DownloadMovieItem)cess._mth3(this._cls1.this).list_update.get(cess._mth2(this._cls1.this))).getId()).toString());
        Intent intent = new Intent("\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD");
        intent.putExtra("appid", ((DownloadMovieItem)cess._mth3(this._cls1.this).list_update.get(cess._mth2(this._cls1.this))).getId());
        intent.putExtra("appvirsion", ((DownloadMovieItem)cess._mth3(this._cls1.this).list_update.get(cess._mth2(this._cls1.this))).getVersion());
        intent.putExtra("appurl", ((DownloadMovieItem)cess._mth3(this._cls1.this).list_update.get(cess._mth2(this._cls1.this))).getLink_url());
        cess._mth3(this._cls1.this).sendBroadcast(intent);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
