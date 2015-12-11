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

static final class >
    implements Runnable
{

    final val.context cS;
    final Context val$context;
    final f val$session;

    public void run()
    {
        f f1 = f.E();
        f1;
        JVM INSTR monitorenter ;
        RequestQueue requestqueue;
        f.a(val$session, val$context.getApplicationContext());
        CookieSyncManager.createInstance(val$context);
        CookieManager.getInstance().removeAllCookie();
        ButtonManager.reset();
        val$session.O();
        val$session.T();
        val$session.b(0L);
        requestqueue = val$session.M();
        if (requestqueue == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        requestqueue.reset();
        f.a(val$session, null);
        val$session.S();
        val$session.Q();
        val$session.ah();
        f.a(val$session, null);
        if (cS != null)
        {
            (new Handler(val$context.getMainLooper())).post(new Runnable() {

                final f._cls9 cT;

                public void run()
                {
                    cT.cS.au();
                }

            
            {
                cT = f._cls9.this;
                super();
            }
            });
        }
        val$session.aq().g(val$context);
        b.i(false);
        d.s(val$context);
        f1;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    t(f f1, Context context1, t t)
    {
        val$session = f1;
        val$context = context1;
        cS = t;
        super();
    }
}
