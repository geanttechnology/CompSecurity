// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Handler;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

private static class contextRef
    implements Runnable
{

    protected AtomicBoolean canceled;
    protected WeakReference contextRef;

    public void cancel()
    {
        canceled.set(true);
    }

    public void run()
    {
        HotelDetails hoteldetails = (HotelDetails)contextRef.get();
        if (hoteldetails != null && !canceled.get()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        HotelDetails.access$2800(hoteldetails);
        if (!canceled.get())
        {
            long l = (SystemClock.uptimeMillis() + 1000L) / 1000L;
            HotelDetails.access$2900(hoteldetails).postAtTime(this, l * 1000L);
            return;
        }
          goto _L1
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        if (canceled.get()) goto _L1; else goto _L3
_L3:
        long l1 = (SystemClock.uptimeMillis() + 1000L) / 1000L;
        HotelDetails.access$2900(hoteldetails).postAtTime(this, l1 * 1000L);
        return;
        obj;
        if (!canceled.get())
        {
            long l2 = (SystemClock.uptimeMillis() + 1000L) / 1000L;
            HotelDetails.access$2900(hoteldetails).postAtTime(this, l2 * 1000L);
        }
        throw obj;
    }

    protected (HotelDetails hoteldetails)
    {
        canceled = new AtomicBoolean(false);
        contextRef = new WeakReference(hoteldetails);
    }
}
