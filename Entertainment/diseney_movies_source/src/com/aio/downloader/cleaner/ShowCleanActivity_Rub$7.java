// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity_Rub

class this._cls0 extends Thread
{

    final ShowCleanActivity_Rub this$0;

    public void run()
    {
        super.run();
        Message message;
        try
        {
            sleep(2000L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        message = new Message();
        ShowCleanActivity_Rub.access$11(ShowCleanActivity_Rub.this).sendMessage(message);
    }

    ()
    {
        this$0 = ShowCleanActivity_Rub.this;
        super();
    }
}
