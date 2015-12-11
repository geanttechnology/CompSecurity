// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.utils.Player;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.activity:
//            Mp3DownloadedActivity

class this._cls2 extends TimerTask
{

    final r this$2;

    public void run()
    {
        Message message = new Message();
        message.what = 100;
        handler.sendMessage(message);
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/Mp3DownloadedActivity$5

/* anonymous class */
    class Mp3DownloadedActivity._cls5 extends BroadcastReceiver
    {

        final Mp3DownloadedActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = intent.getStringExtra("mp3position");
            intent = intent.getStringExtra("mp3positiontitle");
            title.setText(intent);
            Mp3DownloadedActivity.access$5(Mp3DownloadedActivity.this).setVisibility(0);
            (new Thread(context. new Mp3DownloadedActivity._cls5._cls1())).start();
        }


            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
    }


    // Unreferenced inner class com/aio/downloader/activity/Mp3DownloadedActivity$5$1

/* anonymous class */
    class Mp3DownloadedActivity._cls5._cls1
        implements Runnable
    {

        final Mp3DownloadedActivity._cls5 this$1;
        private final String val$mp3position;

        public void run()
        {
            Looper.prepare();
            Mp3DownloadedActivity.access$3(this$0).playUrl(mp3position);
            Mp3DownloadedActivity.access$6(this$0, new Timer());
            Mp3DownloadedActivity.access$7(this$0, new Mp3DownloadedActivity._cls5._cls1._cls1());
            Mp3DownloadedActivity.access$8(this$0).schedule(Mp3DownloadedActivity.access$9(this$0), 0L, 1000L);
        }


            
            {
                this$1 = final__pcls5;
                mp3position = String.this;
                super();
            }
    }

}
