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
//            MyDownloaderList

class this._cls0 extends BroadcastReceiver
{

    final MyDownloaderList this$0;

    public void onReceive(final Context mp3position, Intent intent)
    {
        mp3position = intent.getStringExtra("mp3position");
        intent = intent.getStringExtra("mp3positiontitle");
        title.setText(intent);
        MyDownloaderList.access$9(MyDownloaderList.this).setVisibility(0);
        (new Thread(new Runnable() {

            final MyDownloaderList._cls2 this$1;
            private final String val$mp3position;

            public void run()
            {
                Looper.prepare();
                MyDownloaderList.access$8(this$0).playUrl(mp3position);
                MyDownloaderList.access$10(this$0, new Timer());
                MyDownloaderList.access$11(this$0, new TimerTask() {

                    final _cls1 this$2;

                    public void run()
                    {
                        Message message = new Message();
                        message.what = 101;
                        handler.sendMessage(message);
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
                MyDownloaderList.access$12(this$0).schedule(MyDownloaderList.access$13(this$0), 0L, 1000L);
            }


            
            {
                this$1 = MyDownloaderList._cls2.this;
                mp3position = s;
                super();
            }
        })).start();
    }


    _cls1.val.mp3position()
    {
        this$0 = MyDownloaderList.this;
        super();
    }
}
