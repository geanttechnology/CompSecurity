// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls1 extends TimerTask
{

    final Broadcast this$1;

    public void run()
    {
        Intent intent = new Intent("\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD");
        intent.putExtra("appid", ((DownloadMovieItem)list_update.get(owup)).getId());
        intent.putExtra("appvirsion", ((DownloadMovieItem)list_update.get(owup)).getVersion());
        intent.putExtra("appurl", ((DownloadMovieItem)list_update.get(owup)).getLink_url());
        sendBroadcast(intent);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/service/ServiceUpdate$1

/* anonymous class */
    class ServiceUpdate._cls1 extends Handler
    {

        private int showup;
        final ServiceUpdate this$0;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1001 1001: default 24
        //                       1001 30;
               goto _L1 _L2
_L1:
            super.handleMessage(message);
            return;
_L2:
            Log.e("qaz", (new StringBuilder("10001")).append(message.obj.toString()).toString());
            list_update.addAll(Myutils.parseupdata(message.obj.toString()));
            if (Myutils.status == 1)
            {
                try
                {
                    Log.e("qaz", (new StringBuilder(String.valueOf(list_update.size()))).toString());
                    showup = (int)(Math.random() * (double)list_update.size());
                    (new Timer()).schedule(new ServiceUpdate._cls1._cls1(), 1000L, 30000L);
                }
                catch (Exception exception) { }
            }
            if (true) goto _L1; else goto _L3
_L3:
        }



            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
    }

}
