// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.aio.downloader.adapter.AppDownloadedAdapter;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.views.MyListView;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList

class this._cls0 extends BroadcastReceiver
{

    final MyDownloaderList this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = MyDownloaderList.access$5(MyDownloaderList.this);
        Myutils.getInstance();
        context.add(Myutils.successItem);
        MyDownloaderList.access$19(MyDownloaderList.this).setAdapter(MyDownloaderList.access$18(MyDownloaderList.this));
        MyDownloaderList.access$18(MyDownloaderList.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = MyDownloaderList.this;
        super();
    }
}
