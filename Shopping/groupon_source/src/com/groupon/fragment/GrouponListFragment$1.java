// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.os.SystemClock;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.fragment:
//            GrouponListFragment

class this._cls0
    implements Runnable
{

    final GrouponListFragment this$0;

    public void run()
    {
        if (!GrouponListFragment.access$000(GrouponListFragment.this))
        {
            GrouponListFragment.access$002(GrouponListFragment.this, true);
            String s = getClass().getSimpleName();
            logger.logGeneralEvent("android_events", "window_drawn", s, (int)(SystemClock.elapsedRealtime() - GrouponListFragment.access$100(GrouponListFragment.this)), Logger.NULL_NST_FIELD);
        }
    }

    ()
    {
        this$0 = GrouponListFragment.this;
        super();
    }
}
