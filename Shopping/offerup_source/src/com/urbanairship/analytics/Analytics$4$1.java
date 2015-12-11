// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.app.Activity;
import com.urbanairship.UAirship;

// Referenced classes of package com.urbanairship.analytics:
//            Analytics

class val.timeStamp
    implements com.urbanairship.dyCallback
{

    final val.timeStamp this$0;
    final Activity val$activity;
    final long val$timeStamp;

    public void onAirshipReady(UAirship uairship)
    {
        Analytics.access$100(uairship.getAnalytics(), val$activity, 1, val$timeStamp);
    }

    ()
    {
        this$0 = final_;
        val$activity = activity1;
        val$timeStamp = J.this;
        super();
    }
}
