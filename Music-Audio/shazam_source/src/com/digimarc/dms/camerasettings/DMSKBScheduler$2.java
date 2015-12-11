// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import java.util.concurrent.ScheduledFuture;

// Referenced classes of package com.digimarc.dms.camerasettings:
//            DMSKBScheduler

class this._cls0
    implements Runnable
{

    final DMSKBScheduler this$0;

    public void run()
    {
        DMSKBScheduler.access$200(DMSKBScheduler.this).cancel(true);
    }

    ()
    {
        this$0 = DMSKBScheduler.this;
        super();
    }
}
