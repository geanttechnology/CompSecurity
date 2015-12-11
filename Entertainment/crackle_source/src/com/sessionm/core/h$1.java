// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;
import com.sessionm.api.SessionListener;
import com.sessionm.api.SessionM;
import com.sessionm.api.User;
import com.sessionm.b.a;
import com.sessionm.net.Request;
import com.sessionm.net.RequestQueue;
import com.sessionm.net.c;

// Referenced classes of package com.sessionm.core:
//            h, f, d

class >
    implements Runnable
{

    final Context cK;
    final t dR;
    final boolean dS;
    final h dT;
    final f val$session;

    public void run()
    {
        f f1 = val$session;
        f1;
        JVM INSTR monitorenter ;
        if (dT.isOptedOut())
        {
            val$session.aq().g(val$session.getApplicationContext());
        }
        com.sessionm.core.h.a(dT);
        if (val$session.getSessionState() != com.sessionm.api.ionM.State.STOPPED) goto _L2; else goto _L1
_L1:
        val$session.a(new SessionListener() {

            final h._cls1 dU;

            public void onSessionFailed(SessionM sessionm, int i)
            {
                if (dU.dR != null)
                {
                    dU.dR.onOptInFailed();
                }
                dU.session.b(this);
            }

            public void onSessionStateChanged(SessionM sessionm, com.sessionm.api.SessionM.State state)
            {
                if (dU.dR != null && state.isStarted())
                {
                    if (state == com.sessionm.api.SessionM.State.STARTED_ONLINE && dU.session.D().isOptedOut() == dU.dS)
                    {
                        dU.dR.onOptInSucceeded();
                    } else
                    {
                        dU.dR.onOptInFailed();
                    }
                    dU.session.b(this);
                }
            }

            public void onUserUpdated(SessionM sessionm, User user)
            {
            }

            
            {
                dU = h._cls1.this;
                super();
            }
        });
        if (!val$session.b(cK, val$session.F()) && dR != null)
        {
            dR.onOptInFailed();
        }
_L3:
        return;
_L2:
        Object obj1 = a.aG();
        Object obj;
        if (dS)
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        ((a) (obj1)).put("member[opted_out]", ((String) (obj)));
        obj = new Request(com.sessionm.net.est.Type.fr);
        ((Request) (obj)).d(((a) (obj1)));
        obj1 = val$session.M();
        ((RequestQueue) (obj1)).a(((Request) (obj)), new c() {

            final h._cls1 dU;

            public void onReplyReceived(Request request)
            {
                if (request.ba() == com.sessionm.net.Request.State.fg)
                {
                    if (dU.dR != null)
                    {
                        dU.dR.onOptInSucceeded();
                    }
                } else
                if (dU.dR != null)
                {
                    dU.dR.onOptInFailed();
                    return;
                }
            }

            
            {
                dU = h._cls1.this;
                super();
            }
        });
        ((RequestQueue) (obj1)).d(((Request) (obj)));
          goto _L3
        obj;
        f1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    t(f f1, t t, boolean flag, Context context)
    {
        dT = final_h1;
        val$session = f1;
        dR = t;
        dS = flag;
        cK = context;
        super();
    }
}
