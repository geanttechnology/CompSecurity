// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Handler;
import android.os.SystemClock;
import com.groupon.mvc.controller.BottomBarController;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.activity:
//            DealDetails

protected static class contextRef
    implements Runnable
{

    private static final int TIME_LEFT_UPDATE_INTERVAL = 500;
    private AtomicBoolean canceled;
    private WeakReference contextRef;

    public void cancel()
    {
        canceled.set(true);
    }

    public void run()
    {
        Object obj = (DealDetails)contextRef.get();
        if (obj != null && !canceled.get()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        BottomBarController bottombarcontroller;
        bottombarcontroller = DealDetails.access$3000(((DealDetails) (obj)));
        obj = DealDetails.access$3100(((DealDetails) (obj)));
        bottombarcontroller.updateTimeLeftView();
        if (!canceled.get())
        {
            ((Handler) (obj)).postAtTime(this, ((SystemClock.uptimeMillis() + 500L) / 500L) * 500L);
            return;
        }
          goto _L1
        Object obj1;
        obj1;
        if (canceled.get()) goto _L1; else goto _L3
_L3:
        ((Handler) (obj)).postAtTime(this, ((SystemClock.uptimeMillis() + 500L) / 500L) * 500L);
        return;
        obj1;
        if (!canceled.get())
        {
            ((Handler) (obj)).postAtTime(this, ((SystemClock.uptimeMillis() + 500L) / 500L) * 500L);
        }
        throw obj1;
    }

    public (DealDetails dealdetails)
    {
        canceled = new AtomicBoolean(false);
        contextRef = new WeakReference(dealdetails);
    }
}
