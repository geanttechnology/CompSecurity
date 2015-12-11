// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.util.Log;
import com.sessionm.api.SessionListener;
import com.sessionm.api.SessionM;

// Referenced classes of package com.sessionm.core:
//            f, h

class 
    implements Runnable
{

    final f cM;
    final SessionListener cO;
    final SessionM cP;
    final h dc;

    public void run()
    {
        cO.onUserUpdated(cP, dc);
_L1:
        return;
        Throwable throwable;
        throwable;
        if (Log.isLoggable("SessionM", 6))
        {
            Log.e("SessionM", "Exception calling SessionListener.onUserUpdated()", throwable);
            return;
        }
          goto _L1
    }

    nM(f f1, SessionListener sessionlistener, SessionM sessionm, h h)
    {
        cM = f1;
        cO = sessionlistener;
        cP = sessionm;
        dc = h;
        super();
    }
}
