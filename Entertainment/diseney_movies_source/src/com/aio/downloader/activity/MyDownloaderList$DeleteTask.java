// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import com.aio.downloader.mydownload.DownloadFile;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.publicTools;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList, DownloadAppManager

class lin
    implements com.aio.downloader.mydownload.tener
{

    private LinearLayout lin;
    final MyDownloaderList this$0;

    public void onDelete(View view, DownloadMovieItem downloadmovieitem, Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            lin.removeView(view);
            view = downloadmovieitem.getDownloadFile();
            if (view != null)
            {
                view.stopDownload();
            }
            view = new File(downloadmovieitem.getFilePath());
            if (view.exists())
            {
                view.delete();
            }
            (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "file_id=?", new String[] {
                downloadmovieitem.getFile_id()
            });
        } else
        {
            lin.removeView(view);
            view = downloadmovieitem.getDownloadFile();
            if (view != null)
            {
                view.stopDownload();
            }
            view = new File(downloadmovieitem.getFilePath());
            if (view.exists())
            {
                view.delete();
            }
            (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "movieName=?", new String[] {
                downloadmovieitem.getMovieName()
            });
            view = new Notification();
            view.flags = 16;
            view.icon = 0x7f0200eb;
            downloadmovieitem = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
            downloadmovieitem.setFlags(0x10000000);
            view.contentIntent = PendingIntent.getActivity(getApplicationContext(), 110, downloadmovieitem, 0x8000000);
            downloadmovieitem = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030090);
            MyDownloaderList.access$1(MyDownloaderList.this, MyDownloaderList.access$0(MyDownloaderList.this).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
            downloadmovieitem.setTextViewText(0x7f07031c, (new StringBuilder("Downloading(")).append(MyDownloaderList.access$2(MyDownloaderList.this).size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
            view.contentView = downloadmovieitem;
            if (MyDownloaderList.access$2(MyDownloaderList.this).size() > 0)
            {
                MyDownloaderList.mNotificationManager.notify(110, view);
            }
            if (MyDownloaderList.access$2(MyDownloaderList.this).size() == 0)
            {
                MyDownloaderList.mNotificationManager.cancel(110);
                return;
            }
        }
    }

    public istener(LinearLayout linearlayout)
    {
        this$0 = MyDownloaderList.this;
        super();
        lin = linearlayout;
    }
}
