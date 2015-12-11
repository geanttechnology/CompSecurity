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

class this._cls0 extends BroadcastReceiver
{

    final RingtoneDownloadedActivity this$0;

    public void onReceive(final Context ringtoneposition, Intent intent)
    {
        ringtoneposition = intent.getStringExtra("ringtoneposition");
        intent = intent.getStringExtra("ringtonepositiontitle");
        title.setText(intent);
        RingtoneDownloadedActivity.access$5(RingtoneDownloadedActivity.this).setVisibility(0);
        (new Thread(new Runnable() {

            final RingtoneDownloadedActivity._cls5 this$1;
            private final String val$ringtoneposition;

            public void run()
            {
                Looper.prepare();
                RingtoneDownloadedActivity.access$3(this$0).playUrl(ringtoneposition);
                RingtoneDownloadedActivity.access$6(this$0, new Timer());
                RingtoneDownloadedActivity.access$7(this$0, new TimerTask() {

                    final _cls1 this$2;

                    public void run()
                    {
                        Message message = new Message();
                        message.what = 100;
                        handler.sendMessage(message);
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
                RingtoneDownloadedActivity.access$8(this$0).schedule(RingtoneDownloadedActivity.access$9(this$0), 0L, 1000L);
            }


            
            {
                this$1 = RingtoneDownloadedActivity._cls5.this;
                ringtoneposition = s;
                super();
            }
        })).start();
    }


    _cls1.val.ringtoneposition()
    {
        this$0 = RingtoneDownloadedActivity.this;
        super();
    }
}
