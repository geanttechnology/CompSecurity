// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import com.aio.downloader.adapter.Mp3DownloadedAdapter;
import com.aio.downloader.utils.Myutils;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            Mp3DownloadedActivity

class this._cls0 extends BroadcastReceiver
{

    final Mp3DownloadedActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = Mp3DownloadedActivity.access$0(Mp3DownloadedActivity.this);
        Myutils.getInstance();
        context.add(Myutils.successItem);
        Mp3DownloadedActivity.access$4(Mp3DownloadedActivity.this).setAdapter(Mp3DownloadedActivity.access$2(Mp3DownloadedActivity.this));
        Mp3DownloadedActivity.access$2(Mp3DownloadedActivity.this).notifyDataSetChanged();
    }

    _cls9()
    {
        this$0 = Mp3DownloadedActivity.this;
        super();
    }
}
