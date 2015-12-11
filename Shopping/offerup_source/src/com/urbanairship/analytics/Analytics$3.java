// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.app.Activity;
import com.urbanairship.UAirship;

// Referenced classes of package com.urbanairship.analytics:
//            Analytics

final class val.timeMS
    implements com.urbanairship.eadyCallback
{

    final Activity val$activity;
    final long val$timeMS;

    public final void onAirshipReady(UAirship uairship)
    {
        Analytics.access$200(uairship.getAnalytics(), val$activity, 0, val$timeMS);
    }

    ck()
    {
        val$activity = activity1;
        val$timeMS = l;
        super();
    }
}
