// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.util.Log;
import com.sessionm.api.ActivityListener;
import com.sessionm.api.SessionM;

// Referenced classes of package com.sessionm.core:
//            f

class 
    implements Runnable
{

    final f cM;

    public void run()
    {
        SessionM sessionm = SessionM.getInstance();
        ActivityListener activitylistener = sessionm.getActivityListener();
        android.app.Activity activity;
        if (activitylistener != null)
        {
            try
            {
                activitylistener.onDismissed(sessionm);
            }
            catch (Throwable throwable1)
            {
                if (Log.isLoggable("SessionM", 6))
                {
                    Log.e("SessionM.Session", "Exception calling ActivityListener.onDismissed()", throwable1);
                }
                continue; /* Loop/switch isn't completed */
            }
        }
_L4:
        activity = cM.J();
        if (!(activity instanceof ActivityListener) || activity == activitylistener)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        ((ActivityListener)activity).onDismissed(sessionm);
_L2:
        return;
        Throwable throwable;
        throwable;
        if (!Log.isLoggable("SessionM", 6)) goto _L2; else goto _L1
_L1:
        Log.e("SessionM.Session", "Exception calling ActivityListener.onDismissed()", throwable);
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    tyListener(f f1)
    {
        cM = f1;
        super();
    }
}
