// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.sessionm.c.b;
import com.sessionm.c.d;
import com.sessionm.net.RequestQueue;
import com.sessionm.ui.ButtonManager;

// Referenced classes of package com.sessionm.core:
//            f, d

class cT
    implements Runnable
{

    final  cT;

    public void run()
    {
        cT..();
    }

    ( )
    {
        cT = ;
        super();
    }

    // Unreferenced inner class com/sessionm/core/f$9

/* anonymous class */
    static final class f._cls9
        implements Runnable
    {

        final f.a cS;
        final Context val$context;
        final f val$session;

        public void run()
        {
            f f1 = f.E();
            f1;
            JVM INSTR monitorenter ;
            RequestQueue requestqueue;
            f.a(session, context.getApplicationContext());
            CookieSyncManager.createInstance(context);
            CookieManager.getInstance().removeAllCookie();
            ButtonManager.reset();
            session.O();
            session.T();
            session.b(0L);
            requestqueue = session.M();
            if (requestqueue == null)
            {
                break MISSING_BLOCK_LABEL_85;
            }
            requestqueue.reset();
            f.a(session, null);
            session.S();
            session.Q();
            session.ah();
            f.a(session, null);
            if (cS != null)
            {
                (new Handler(context.getMainLooper())).post(new f._cls9._cls1(this));
            }
            session.aq().g(context);
            b.i(false);
            d.s(context);
            f1;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            f1;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                session = f1;
                context = context1;
                cS = a;
                super();
            }
    }

}
