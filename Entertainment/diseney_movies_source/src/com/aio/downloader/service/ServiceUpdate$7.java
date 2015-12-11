// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.os.Handler;
import android.os.Message;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls0 extends Thread
{

    final ServiceUpdate this$0;

    public void run()
    {
        super.run();
        ServiceUpdate.access$55(ServiceUpdate.this, "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=1");
        String s = publicTools.getUrl(ServiceUpdate.access$56(ServiceUpdate.this));
        Message message = new Message();
        message.what = 10;
        message.obj = s;
        ServiceUpdate.access$54(ServiceUpdate.this).sendMessage(message);
    }

    ()
    {
        this$0 = ServiceUpdate.this;
        super();
    }
}
