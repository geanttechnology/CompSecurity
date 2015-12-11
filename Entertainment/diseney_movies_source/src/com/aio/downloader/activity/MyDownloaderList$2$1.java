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

class val.mp3position
    implements Runnable
{

    final is._cls0 this$1;
    private final String val$mp3position;

    public void run()
    {
        Looper.prepare();
        MyDownloaderList.access$8(_fld0).playUrl(val$mp3position);
        MyDownloaderList.access$10(_fld0, new Timer());
        MyDownloaderList.access$11(_fld0, new TimerTask() {

            final MyDownloaderList._cls2._cls1 this$2;

            public void run()
            {
                Message message = new Message();
                message.what = 101;
                handler.sendMessage(message);
            }

            
            {
                this$2 = MyDownloaderList._cls2._cls1.this;
                super();
            }
        });
        MyDownloaderList.access$12(_fld0).schedule(MyDownloaderList.access$13(_fld0), 0L, 1000L);
    }


    is._cls0()
    {
        this$1 = final__pcls0;
        val$mp3position = String.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/MyDownloaderList$2

/* anonymous class */
    class MyDownloaderList._cls2 extends BroadcastReceiver
    {

        final MyDownloaderList this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = intent.getStringExtra("mp3position");
            intent = intent.getStringExtra("mp3positiontitle");
            title.setText(intent);
            MyDownloaderList.access$9(MyDownloaderList.this).setVisibility(0);
            (new Thread(context. new MyDownloaderList._cls2._cls1())).start();
        }


            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
    }

}
