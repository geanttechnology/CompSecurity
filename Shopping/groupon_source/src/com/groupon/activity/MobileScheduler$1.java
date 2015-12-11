// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.models.mobilescheduler.MobileSchedulerData;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.activity:
//            MobileScheduler

class val.bookingStatus
    implements Callable
{

    final MobileScheduler this$0;
    final String val$bookingStatus;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        MobileScheduler.access$100(MobileScheduler.this).updateBookingStatusById(MobileScheduler.access$000(MobileScheduler.this).grouponCode, val$bookingStatus);
        return null;
    }

    leSchedulerData()
    {
        this$0 = final_mobilescheduler;
        val$bookingStatus = String.this;
        super();
    }
}
