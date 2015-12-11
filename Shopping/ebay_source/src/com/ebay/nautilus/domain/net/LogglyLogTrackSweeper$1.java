// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;


// Referenced classes of package com.ebay.nautilus.domain.net:
//            LogglyLogTrackSweeper

class this._cls0
    implements Runnable
{

    final LogglyLogTrackSweeper this$0;

    public void run()
    {
        do
        {
            sendReport();
            try
            {
                Thread.sleep(15000L);
            }
            catch (InterruptedException interruptedexception) { }
        } while (true);
    }

    ()
    {
        this$0 = LogglyLogTrackSweeper.this;
        super();
    }
}
