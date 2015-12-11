// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.CountDownTimer;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

class this._cls0 extends CountDownTimer
{

    final HotelDetails this$0;

    public void onFinish()
    {
        HotelDetails.access$2500(HotelDetails.this).set(false);
        HotelDetails.access$2400(HotelDetails.this, 0);
        HotelDetails.access$2600(HotelDetails.this);
        HotelDetails.access$2700(HotelDetails.this);
    }

    public void onTick(long l)
    {
        int i = (int)l / 1000;
        HotelDetails.access$2400(HotelDetails.this, i);
    }

    lean(long l, long l1)
    {
        this$0 = HotelDetails.this;
        super(l, l1);
    }
}
