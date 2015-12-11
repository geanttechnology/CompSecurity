// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.digimarc.dms.camerasettings:
//            DMSKBScheduler, DMSKBDownload

class this._cls0 extends Thread
{

    final DMSKBScheduler this$0;

    public void run()
    {
        DMSKBDownload.getInstance(DMSKBScheduler.access$000(DMSKBScheduler.this)).readKB();
        try
        {
            if (DMSKBScheduler.access$100(DMSKBScheduler.this))
            {
                DMSKBDownload dmskbdownload = DMSKBDownload.getInstance(DMSKBScheduler.access$000(DMSKBScheduler.this));
                DMSKBScheduler.access$202(DMSKBScheduler.this, DMSKBScheduler.access$300(DMSKBScheduler.this).scheduleAtFixedRate(dmskbdownload, 0L, 0x15180L, TimeUnit.SECONDS));
            }
            DMSKBScheduler.access$102(DMSKBScheduler.this, false);
            return;
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            return;
        }
    }

    ()
    {
        this$0 = DMSKBScheduler.this;
        super();
    }
}
