// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.util.Log;

// Referenced classes of package com.kochava.android.tracker:
//            Feature

static final class val.status extends Thread
{

    final String val$status;

    public void run()
    {
        if (tive) goto _L2; else goto _L1
_L1:
        Log.e("KochavaTracker", "AppLifeCycleStatusManager - not active");
_L4:
        return;
_L2:
        if (!val$status.equals("is_focused"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (sumed) goto _L4; else goto _L3
_L3:
        Log.e("KochavaTracker", "AppLifeCycleStatusManager - not already resumed, starting session...");
        Feature.access$3800();
        sumed = true;
        return;
        if (!val$status.equals("is_in_background") || !sumed) goto _L4; else goto _L5
_L5:
        Log.e("KochavaTracker", "AppLifeCycleStatusManager - going to background from app, ending session");
        Feature.access$3900();
        sumed = false;
        return;
    }

    (String s)
    {
        val$status = s;
        super();
    }
}
