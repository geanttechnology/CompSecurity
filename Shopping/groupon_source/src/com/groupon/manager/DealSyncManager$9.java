// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.os.SystemClock;
import com.groupon.db.dao.DaoDeal;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.manager:
//            DealSyncManager

class alResponse
    implements Callable
{

    final DealSyncManager this$0;
    final alResponse val$dealObject;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        long l = SystemClock.currentThreadTimeMillis();
        ((DaoDeal)DealSyncManager.access$100(DealSyncManager.this).get()).save(alResponse.access._mth000(val$dealObject));
        long l1 = SystemClock.currentThreadTimeMillis();
        DealSyncManager.access$300(DealSyncManager.this).logGeneralEvent("deal_performance", "store_deal_to_db", DealSyncManager.access$200(DealSyncManager.this), (int)(l1 - l), Logger.NULL_NST_FIELD);
        DealSyncManager.access$400(DealSyncManager.this).set(true);
        return null;
    }

    alResponse()
    {
        this$0 = final_dealsyncmanager;
        val$dealObject = alResponse.this;
        super();
    }
}
