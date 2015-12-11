// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.DownloadTask;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.publicTools;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList, DownloadAppManager

class this._cls0 extends BroadcastReceiver
{

    final MyDownloaderList this$0;

    public void onReceive(Context context, Intent intent)
    {
        View view;
        ImageView imageview;
        String s;
        int i;
        intent = getMyApp().getStartDownloadMovieItem();
        view = getLayoutInflater().inflate(0x7f030068, null);
        imageview = (ImageView)view.findViewById(0x7f070277);
        s = intent.getMovieHeadImagePath();
        i = intent.getSerial();
        Log.e("qwa", (new StringBuilder("serial=")).append(i).toString());
        if (i != 110) goto _L2; else goto _L1
_L1:
        context = new MyAppInfo(context);
        try
        {
            imageview.setBackgroundDrawable(context.getAppIcon(intent.getFile_id()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
_L4:
        intent.setDownloadState(Integer.valueOf(7));
        MyDownloaderList.access$15(MyDownloaderList.this).addView(view);
        (new DownloadTask(getmContext(), view, intent, false)).setOnDeleteTaskListener(new leteTask(MyDownloaderList.this, MyDownloaderList.access$15(MyDownloaderList.this)));
        if (intent.getType().equals("app"))
        {
            context = new Notification();
            context.flags = 16;
            context.icon = 0x7f0200ec;
            intent = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
            intent.setFlags(0x10000000);
            context.contentIntent = PendingIntent.getActivity(getApplicationContext(), 110, intent, 0x8000000);
            intent = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030090);
            MyDownloaderList.access$1(MyDownloaderList.this, MyDownloaderList.access$0(MyDownloaderList.this).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
            intent.setTextViewText(0x7f07031c, (new StringBuilder("Downloading(")).append(MyDownloaderList.access$2(MyDownloaderList.this).size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
            intent.setTextViewText(0x7f07031b, DateFormat.format("kk:mm", System.currentTimeMillis()));
            context.contentView = intent;
            if (MyDownloaderList.access$2(MyDownloaderList.this).size() > 0)
            {
                MyDownloaderList.mNotificationManager.notify(110, context);
            }
        }
        return;
_L2:
        if (i != 110)
        {
            MyDownloaderList.access$14(MyDownloaderList.this).asyncLoadImage(s, imageview);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    xception()
    {
        this$0 = MyDownloaderList.this;
        super();
    }
}
