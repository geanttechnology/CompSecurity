// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.util.Log;
import com.sessionm.api.SessionListener;
import com.sessionm.api.SessionM;

// Referenced classes of package com.sessionm.core:
//            f

class >
    implements Runnable
{

    final f cM;
    final SessionListener cO;
    final SessionM cP;
    final com.sessionm.api.ionM.State cR;

    public void run()
    {
        cO.onSessionStateChanged(cP, cR);
_L1:
        return;
        Throwable throwable;
        throwable;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Exception calling SessionListener.onSessionStateChanged()", throwable);
            return;
        }
          goto _L1
    }

    State(f f1, SessionListener sessionlistener, SessionM sessionm, com.sessionm.api.ionM.State state)
    {
        cM = f1;
        cO = sessionlistener;
        cP = sessionm;
        cR = state;
        super();
    }
}
