// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.kahuna.sdk:
//            m, p, v, h, 
//            c, n

class nit>
    implements Runnable
{

    final m a;

    public void run()
    {
        if (!m.b(a))
        {
            m.c(a);
        }
        Object obj = m.t();
        obj;
        JVM INSTR monitorenter ;
        if (m.g(a).incrementAndGet() == 1)
        {
            if (p.a())
            {
                p.a(m.h(a), m.i(a), m.j(a));
            }
            m.a(p.b(m.a(a)));
            if (m.k(a) == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            m.k(a).cancel();
            m.a(a, null);
            return;
        }
          goto _L1
        if (!m.l(a) || v.a(m.c)) goto _L3; else goto _L2
_L2:
        Object obj1 = h.b();
        if (!"".equals(obj1)) goto _L5; else goto _L4
_L4:
        if (m.a)
        {
            Log.d("Kahuna", "Device not registered yet, will now register with GCM");
        }
        a.c("");
        h.a(m.c);
_L3:
        m.a(a, new c("Start"));
        Object obj3 = m.a(a).getResources().getConfiguration().locale;
        obj1 = TimeZone.getDefault();
        obj1 = ((TimeZone) (obj1)).getDisplayName(((TimeZone) (obj1)).inDaylightTime(new Date(System.currentTimeMillis())), 0);
        obj3 = ((Locale) (obj3)).getLanguage();
        HashMap hashmap = new HashMap();
        hashmap.put("kahuna_tz", obj1);
        hashmap.put("kahuna_lang", obj3);
        m.a(a, hashmap);
_L7:
        m.m(a);
_L1:
        n.a();
        return;
_L5:
        a.c(((String) (obj1)));
        if (m.a)
        {
            Log.d("Kahuna", "Device already registered");
        }
          goto _L3
        Object obj2;
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
        obj2;
        if (!m.a) goto _L7; else goto _L6
_L6:
        Log.d("Kahuna", (new StringBuilder()).append("Exception occured trying to retrieve app language or timezone:").append(obj2).toString());
          goto _L7
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
