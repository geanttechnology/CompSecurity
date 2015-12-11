// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.fragment;

import android.os.SystemClock;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.v3.fragment:
//            GrouponNormalFragmentV3

class this._cls0
    implements Runnable
{

    final GrouponNormalFragmentV3 this$0;

    public void run()
    {
        if (!hasLoggedWindowDrawnTime)
        {
            hasLoggedWindowDrawnTime = true;
            String s = getClass().getSimpleName();
            logger.logGeneralEvent("android_events", "window_drawn", s, (int)(SystemClock.elapsedRealtime() - onCreateStartTime), Logger.NULL_NST_FIELD);
        }
    }

    ()
    {
        this$0 = GrouponNormalFragmentV3.this;
        super();
    }
}
