// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Log;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.umeng.analytics.MobclickAgent;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList

class this._cls1
    implements Runnable
{

    final etFile_id this$1;

    public void run()
    {
        Looper.prepare();
        MyDownloaderList.access$16(_fld0).insertApk(wn.getFile_id(), wn.getType(), wn.getMovieName(), wn.getMovieHeadImagePath(), wn.getFileSize(), wn.getFilePath(), wn.getSerial(), wn.getCreate_time(), wn.getVersion());
        (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "file_id=?", new String[] {
            wn.getFile_id()
        });
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/MyDownloaderList$4

/* anonymous class */
    class MyDownloaderList._cls4 extends BroadcastReceiver
    {

        private DownloadMovieItem down;
        final MyDownloaderList this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (MyDownloaderList.access$16(MyDownloaderList.this) == null)
            {
                MyDownloaderList.access$17(MyDownloaderList.this, new TypeDbUtils(context));
            }
            down = getMyApp().getDownloadSuccess();
            (new Thread(new MyDownloaderList._cls4._cls1())).start();
            Log.e("qwa", (new StringBuilder("down.getSerial()=")).append(down.getSerial()).toString());
            intent = new Intent("downloadsuccess");
            intent.putExtra("headimage", down.getMovieHeadImagePath());
            intent.putExtra("appname", down.getMovieName());
            intent.putExtra("baoming", down.getFile_id());
            intent.putExtra("serial", down.getSerial());
            intent.putExtra("filepathdown", down.getFilePath());
            if (down.getSerial() == 110)
            {
                intent.putExtra("iddown", down.getId());
            }
            if (!down.getType().equals("mp3") && !down.getType().equals("video") && getSharedPreferences("downloadcomplete", 0).getInt("wycdc", 0) == 0)
            {
                context.sendBroadcast(intent);
            }
            MobclickAgent.onEvent(context, "downloadsuccess");
            MyDownloaderList.mNotificationManager.cancel(110);
        }



            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
    }

}
