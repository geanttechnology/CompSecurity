// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.inmobi.commons.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.core.utilities:
//            Logger

public class c
{
    public static interface a
    {

        public abstract void a(boolean flag);
    }

    static final class b extends BroadcastReceiver
    {

        private static final String a = com/inmobi/commons/core/utilities/c$b.getSimpleName();

        public void onReceive(Context context, Intent intent)
        {
            if (intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
            context = (ConnectivityManager)context.getSystemService("connectivity");
            if (context == null) goto _L2; else goto _L3
_L3:
            context = context.getActiveNetworkInfo();
            if (context == null || !context.isConnected()) goto _L2; else goto _L4
_L4:
            boolean flag = true;
_L6:
            com.inmobi.commons.core.utilities.c.a(flag);
            com.inmobi.commons.core.utilities.Logger.a(Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Network connectivity changed. Is network available:").append(flag).toString());
            return;
_L2:
            flag = false;
            if (true) goto _L6; else goto _L5
_L5:
        }


        b()
        {
        }
    }


    private static final String a = com/inmobi/commons/core/utilities/c.getSimpleName();
    private static List b = new ArrayList();
    private static final Object c = new Object();
    private static volatile c d;
    private static b e;

    public c()
    {
    }

    public static c a()
    {
        Object obj;
        obj = d;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        c c1 = d;
        obj = c1;
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new c();
        d = ((c) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((c) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((c) (obj));
    }

    static void a(boolean flag)
    {
        b(flag);
    }

    private void b()
    {
        e = new b();
        com.inmobi.commons.a.a.b().registerReceiver(e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private static void b(boolean flag)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((a)iterator.next()).a(flag)) { }
    }

    public void a(a a1)
    {
        b.add(a1);
        if (b.size() == 1)
        {
            b();
        }
    }

}
