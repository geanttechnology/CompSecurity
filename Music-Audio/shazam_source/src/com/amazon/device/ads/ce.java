// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            co, cn

class ce
{
    public static class a
    {

        private final ce a;
        private boolean b;

        public a(ce ce1)
        {
            b = false;
            a = ce1;
            if (b)
            {
                ce1 = ce.a(a);
                if (ce1 != null)
                {
                    ce1.toString();
                }
            }
        }
    }

    public static abstract class b
    {

        final String a;

        protected abstract JSONObject a();

        protected b(String s)
        {
            a = s;
        }
    }


    private static final String b = com/amazon/device/ads/ce.getSimpleName();
    private static String c;
    private static final cn e = co.a(b);
    final a a = new a(this);
    private final Map d = new ConcurrentHashMap();

    public ce()
    {
    }

    public static String a()
    {
        if (c == null)
        {
            Method amethod[] = com/amazon/device/ads/ce$a.getDeclaredMethods();
            if (amethod != null && amethod.length == 1)
            {
                c = amethod[0].getName();
            } else
            {
                e.d("Could not obtain the method name for javascript interfacing.", null);
            }
        }
        return c;
    }

    static JSONObject a(ce ce1)
    {
        if (ce1.d.containsKey(null))
        {
            return ((b)ce1.d.get(null)).a();
        } else
        {
            e.c("The method %s was not recongized by this javascript interface.", new Object[] {
                null
            });
            return null;
        }
    }

    public final void a(b b1)
    {
        if (d.containsKey(b1.a))
        {
            throw new IllegalArgumentException("There is another executor with that method name already added.");
        } else
        {
            d.put(b1.a, b1);
            return;
        }
    }

    static 
    {
        new co();
    }
}
