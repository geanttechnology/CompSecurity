// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            Mp3_Recent_Fragment

class this._cls1
    implements Runnable
{

    final  this$1;

    public void run()
    {
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/report_fail.php?type=")).append(pe).append("&id=").append().toString());
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/fragments/Mp3_Recent_Fragment$5

/* anonymous class */
    class Mp3_Recent_Fragment._cls5 extends Handler
    {

        private String id;
        final Mp3_Recent_Fragment this$0;
        private String type;

        public void handleMessage(Message message)
        {
            type = message.getData().getString("type");
            id = message.getData().getString("id");
            message.what;
            JVM INSTR tableswitch 1212 1212: default 48
        //                       1212 54;
               goto _L1 _L2
_L1:
            super.handleMessage(message);
            return;
_L2:
            (new Thread(new Mp3_Recent_Fragment._cls5._cls1())).start();
            if (true) goto _L1; else goto _L3
_L3:
        }



            
            {
                this$0 = Mp3_Recent_Fragment.this;
                super();
            }
    }

}
