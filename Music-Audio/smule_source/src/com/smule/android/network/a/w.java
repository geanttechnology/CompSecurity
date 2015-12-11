// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.HashMap;
import java.util.Map;

public class w
{

    static final String a = com/smule/android/network/a/w.getName();
    private static w b;

    private w()
    {
    }

    public static w a()
    {
        com/smule/android/network/a/w;
        JVM INSTR monitorenter ;
        w w1;
        if (b == null)
        {
            b = new w();
        }
        w1 = b;
        com/smule/android/network/a/w;
        JVM INSTR monitorexit ;
        return w1;
        Exception exception;
        exception;
        throw exception;
    }

    private o a(Map map)
    {
        try
        {
            map = new k(m.b, "/v2/store/subscription/update", l.b, n.c, map, true);
            map = com.smule.android.network.core.b.a().a(map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            aa.b(a, "Exception thrown updating subscription status: ", map);
            return null;
        }
        return map;
    }

    public o a(String s, String s1, long l1, String s2)
    {
        aa.c(a, (new StringBuilder()).append("reporting subscription: ").append(s2).toString());
        s1 = new HashMap();
        s1.put("sku", s);
        s1.put("receipt", (new StringBuilder()).append("{\"orders\":[").append(s2).append("]}").toString());
        int i = 0;
        while (i < 4) 
        {
            if (i > 0)
            {
                aa.e(a, (new StringBuilder()).append("Re-trying the subscription report API call to server. Try #").append(i + 1).toString());
            }
            o o1 = a(((Map) (s1)));
            if (o1 != null)
            {
                if (o1.b == 1005 || o1.b == 10 || o1.b == 1013)
                {
                    aa.b(a, (new StringBuilder()).append("Error updating subscription, retrying: ").append(o1.h).toString());
                } else
                {
                    if (o1.b == 0)
                    {
                        aa.b(a, "Subscription report succeeded.  Persisting subscription.");
                        return o1;
                    }
                    com.smule.android.network.core.b.a(o1);
                    aa.b(a, "Error updating subscription, retrying");
                }
            } else
            {
                try
                {
                    aa.b(a, "Error updating subscription, retrying");
                    Thread.sleep(600L);
                }
                catch (InterruptedException interruptedexception)
                {
                    aa.b(a, (new StringBuilder()).append("InterruptedException!").append(interruptedexception.toString()).toString());
                }
            }
            i++;
        }
        aa.b(a, (new StringBuilder()).append("report subscription failed for:").append(s).append(" receipt: ").append(s2).toString());
        return null;
    }

    public o b()
    {
        Object obj = new HashMap();
        ((Map) (obj)).put("Cache-control", "no-cache");
        ((Map) (obj)).put("Pragma", "no-cache");
        obj = new k(m.a, "/v2/store/subscription/status", l.b, n.c, null, ((Map) (obj)), true);
        obj.d = new HashMap();
        return com.smule.android.network.core.b.a().a(((k) (obj)));
    }

}
