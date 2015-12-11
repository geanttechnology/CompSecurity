// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.app.Activity;
import android.util.Log;
import com.sessionm.api.SessionListener;
import com.sessionm.api.SessionM;

// Referenced classes of package com.sessionm.core:
//            f

class >
    implements Runnable
{

    final f cM;
    final Activity cN;
    final SessionM cP;
    final int cQ;

    public void run()
    {
        ((SessionListener)cN).onSessionFailed(cP, cQ);
_L1:
        return;
        Throwable throwable;
        throwable;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Exception calling SessionListener.onSessionFailed()", throwable);
            return;
        }
          goto _L1
    }

    onM(f f1, Activity activity, SessionM sessionm, int i)
    {
        cM = f1;
        cN = activity;
        cP = sessionm;
        cQ = i;
        super();
    }
}
