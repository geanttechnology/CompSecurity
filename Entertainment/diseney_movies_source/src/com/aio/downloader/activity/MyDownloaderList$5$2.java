// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.RemoteViews;
import com.aio.downloader.adapter.AppDownloadedAdapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList, DownloadAppManager

class this._cls1
    implements android.content.ckListener
{

    final ificationManager this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MyDownloaderList.access$16(_fld0).deletefile(((DownloadMovieItem)MyDownloaderList.access$5(_fld0).get(s)).getFile_id());
        dialoginterface = new File(((DownloadMovieItem)MyDownloaderList.access$5(_fld0).get(s)).getFilePath());
        Log.e("www", (new StringBuilder("listdd.get(pos).getFilePath()=")).append(((DownloadMovieItem)MyDownloaderList.access$5(_fld0).get(s)).getFilePath()).toString());
        if (dialoginterface.exists())
        {
            dialoginterface.delete();
        }
        MyDownloaderList.access$5(_fld0).remove(s);
        MyDownloaderList.access$18(_fld0).notifyDataSetChanged();
        MyDownloaderList.mNotificationManager = (NotificationManager)getSystemService("notification");
        dialoginterface = new Notification();
        dialoginterface.flags = 16;
        dialoginterface.icon = 0x7f0200eb;
        Object obj = new Intent(_fld0, com/aio/downloader/activity/DownloadAppManager);
        ((Intent) (obj)).setFlags(0x10000000);
        dialoginterface.contentIntent = PendingIntent.getActivity(_fld0, 110, ((Intent) (obj)), 0x8000000);
        obj = new RemoteViews(getPackageName(), 0x7f030090);
        MyDownloaderList.access$1(_fld0, MyDownloaderList.access$0(_fld0).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
        ((RemoteViews) (obj)).setTextViewText(0x7f07031c, (new StringBuilder("Downloading(")).append(MyDownloaderList.access$2(_fld0).size()).append(") & Completed").append("(").append(MyDownloaderList.access$5(_fld0).size()).append(")").toString());
        ((RemoteViews) (obj)).setTextViewText(0x7f07031b, DateFormat.format("kk:mm", System.currentTimeMillis()));
        dialoginterface.contentView = ((RemoteViews) (obj));
        if (MyDownloaderList.access$2(_fld0).size() > 0)
        {
            MyDownloaderList.mNotificationManager.notify(110, dialoginterface);
        }
        try
        {
            if (MyDownloaderList.access$2(_fld0).size() == 0)
            {
                MyDownloaderList.mNotificationManager.cancel(110);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/MyDownloaderList$5

/* anonymous class */
    class MyDownloaderList._cls5 extends BroadcastReceiver
    {

        private int pos;
        final MyDownloaderList this$0;

        public void onReceive(Context context, Intent intent)
        {
            pos = intent.getIntExtra("position", 0);
            (new android.app.AlertDialog.Builder(MyDownloaderList.this)).setTitle(getString(0x7f0b0034)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b003c)))).append(((DownloadMovieItem)MyDownloaderList.access$5(MyDownloaderList.this).get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b003b), new MyDownloaderList._cls5._cls1()).setPositiveButton(getString(0x7f0b003c), new MyDownloaderList._cls5._cls2()).show();
        }



            
            {
                this$0 = MyDownloaderList.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/activity/MyDownloaderList$5$1

/* anonymous class */
        class MyDownloaderList._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final MyDownloaderList._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = MyDownloaderList._cls5.this;
                        super();
                    }
        }

    }

}
