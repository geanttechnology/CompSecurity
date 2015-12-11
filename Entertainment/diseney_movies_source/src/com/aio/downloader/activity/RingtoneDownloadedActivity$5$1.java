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
//            RingtoneDownloadedActivity

class val.ringtoneposition
    implements Runnable
{

    final is._cls0 this$1;
    private final String val$ringtoneposition;

    public void run()
    {
        Looper.prepare();
        RingtoneDownloadedActivity.access$3(_fld0).playUrl(val$ringtoneposition);
        RingtoneDownloadedActivity.access$6(_fld0, new Timer());
        RingtoneDownloadedActivity.access$7(_fld0, new TimerTask() {

            final RingtoneDownloadedActivity._cls5._cls1 this$2;

            public void run()
            {
                Message message = new Message();
                message.what = 100;
                handler.sendMessage(message);
            }

            
            {
                this$2 = RingtoneDownloadedActivity._cls5._cls1.this;
                super();
            }
        });
        RingtoneDownloadedActivity.access$8(_fld0).schedule(RingtoneDownloadedActivity.access$9(_fld0), 0L, 1000L);
    }


    is._cls0()
    {
        this$1 = final__pcls0;
        val$ringtoneposition = String.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/RingtoneDownloadedActivity$5

/* anonymous class */
    class RingtoneDownloadedActivity._cls5 extends BroadcastReceiver
    {

        final RingtoneDownloadedActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = intent.getStringExtra("ringtoneposition");
            intent = intent.getStringExtra("ringtonepositiontitle");
            title.setText(intent);
            RingtoneDownloadedActivity.access$5(RingtoneDownloadedActivity.this).setVisibility(0);
            (new Thread(context. new RingtoneDownloadedActivity._cls5._cls1())).start();
        }


            
            {
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
    }

}
