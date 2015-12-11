// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.support.v7.je;
import android.support.v7.jf;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.appsflyer:
//            b

private static class Reference
    implements Runnable
{

    private WeakReference a;

    public void run()
    {
        if (!com.appsflyer.b.c()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        com.appsflyer.b.a(System.currentTimeMillis());
        if (a == null) goto _L1; else goto _L3
_L3:
        com.appsflyer.b.a(true);
        String s = com.appsflyer.b.a("AppsFlyerKey");
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = je.a().b((Context)a.get()).iterator();
_L6:
        if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
        jf jf1;
        jf1 = (jf)iterator.next();
        if (com.appsflyer.b.g((Context)a.get()))
        {
            Log.i("AppsFlyer_1.18", (new StringBuilder()).append("resending request: ").append(jf1.c()).toString());
        }
        com.appsflyer.b.a((new StringBuilder()).append(jf1.c()).append("&isCachedRequest=true").toString(), jf1.b(), s, a, jf1.d(), "AppsFlyer_1.18", false);
          goto _L6
        Exception exception2;
        exception2;
        Log.i("AppsFlyer_1.18", "Failed to resend cached request");
          goto _L6
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        Exception exception;
        try
        {
            throw exception1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            com.appsflyer.b.a(false);
        }
        Log.e("AppsFlyer_1.18", "failed to check cache.");
        com.appsflyer.b.a(false);
_L8:
        com.appsflyer.b.d().shutdown();
        com.appsflyer.b.a(null);
        return;
_L5:
        obj;
        JVM INSTR monitorexit ;
        com.appsflyer.b.a(false);
        if (true) goto _L8; else goto _L7
_L7:
        throw exception;
    }

    public ntext(Context context)
    {
        a = null;
        a = new WeakReference(context);
    }
}
