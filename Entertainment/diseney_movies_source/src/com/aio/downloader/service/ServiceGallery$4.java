// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.aio.downloader.service:
//            ServiceGallery

class this._cls0 extends Thread
{

    final ServiceGallery this$0;

    public void run()
    {
        super.run();
        try
        {
            sleep(0x1d4c0L);
            Message message = new Message();
            message.what = 30;
            ServiceGallery.access$7(ServiceGallery.this).sendMessage(message);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }

    ()
    {
        this$0 = ServiceGallery.this;
        super();
    }
}
