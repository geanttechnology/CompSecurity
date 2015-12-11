// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import com.thin.downloadmanager.DownloadStatusListener;
import java.io.File;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0
    implements DownloadStatusListener
{

    final MyMainActivity this$0;

    public void onDownloadComplete(int i)
    {
        Log.e("jone", "download completed");
        Notification notification = new Notification();
        notification.flags = 16;
        notification.icon = 0x7f0200eb;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(MyMainActivity.access$55(MyMainActivity.this)).append(File.separator).append("aioupdate.apk").toString()), "application/vnd.android.package-archive");
        notification.contentIntent = PendingIntent.getActivity(MyMainActivity.this, 231, intent, 0x8000000);
        notification.contentView = new RemoteViews(getPackageName(), 0x7f03008e);
        MyMainActivity.access$56(MyMainActivity.this).notify(231, notification);
        MyMainActivity.access$57(MyMainActivity.this);
    }

    public void onDownloadFailed(int i, int j, String s)
    {
        Log.i("jone", "DownloadFailed");
        if (i == MyMainActivity.access$58(MyMainActivity.this))
        {
            MyMainActivity.access$59(MyMainActivity.this).setProgress(0);
        }
    }

    public void onProgress(int i, long l, long l1, int j)
    {
        Log.i("jone", (new StringBuilder(String.valueOf(j))).toString());
        if (i == MyMainActivity.access$58(MyMainActivity.this))
        {
            MyMainActivity.access$59(MyMainActivity.this).setProgress(j);
        }
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
