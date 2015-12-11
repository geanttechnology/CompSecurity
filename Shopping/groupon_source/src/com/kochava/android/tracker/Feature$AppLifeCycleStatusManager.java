// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.util.Log;

// Referenced classes of package com.kochava.android.tracker:
//            Feature

protected static class _cls1.val.status
{

    protected static boolean active = false;
    protected static boolean resumed = false;

    protected static void changeStatus(String s)
    {
        (new Thread(s) {

            final String val$status;

            public void run()
            {
                if (Feature.AppLifeCycleStatusManager.active) goto _L2; else goto _L1
_L1:
                Log.e("KochavaTracker", "AppLifeCycleStatusManager - not active");
_L4:
                return;
_L2:
                if (!status.equals("is_focused"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (Feature.AppLifeCycleStatusManager.resumed) goto _L4; else goto _L3
_L3:
                Log.e("KochavaTracker", "AppLifeCycleStatusManager - not already resumed, starting session...");
                Feature.access$3800();
                Feature.AppLifeCycleStatusManager.resumed = true;
                return;
                if (!status.equals("is_in_background") || !Feature.AppLifeCycleStatusManager.resumed) goto _L4; else goto _L5
_L5:
                Log.e("KochavaTracker", "AppLifeCycleStatusManager - going to background from app, ending session");
                Feature.access$3900();
                Feature.AppLifeCycleStatusManager.resumed = false;
                return;
            }

            
            {
                status = s;
                super();
            }
        }).start();
    }

}
