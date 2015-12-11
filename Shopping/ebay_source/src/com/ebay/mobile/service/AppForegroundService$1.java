// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;


// Referenced classes of package com.ebay.mobile.service:
//            AppForegroundService

class this._cls0
    implements Runnable
{

    final AppForegroundService this$0;

    public void run()
    {
        try
        {
            Thread.sleep(100L);
            if (AppForegroundService.access$000() == 0)
            {
                stopSelf();
            }
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    ()
    {
        this$0 = AppForegroundService.this;
        super();
    }
}
