// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ThorGalleryApplication

class this._cls0 extends Thread
{

    final ThorGalleryApplication this$0;

    public void run()
    {
        try
        {
            ThorGalleryApplication.access$300(ThorGalleryApplication.this);
            if (!ThorGalleryApplication.access$400(ThorGalleryApplication.this).await(300L, TimeUnit.SECONDS))
            {
                GLogger.w("SecondaryServicesScheduler", "Haven't get first sync notification for 300 seconds.", new Object[0]);
            }
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        startSecondaryServices();
    }

    (String s)
    {
        this$0 = ThorGalleryApplication.this;
        super(s);
    }
}
