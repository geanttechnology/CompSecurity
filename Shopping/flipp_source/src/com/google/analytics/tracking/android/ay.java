// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            k, au, i, an, 
//            ai, aj, az

public final class ay
{

    final Map a;
    private final String b;
    private final az c;
    private long d;
    private long e;
    private final k f;
    private final au g;
    private final i h;

    ay(String s, String s1, az az1)
    {
        this(s, s1, az1, k.a(), au.a(), i.a());
    }

    private ay(String s, String s1, az az1, k k1, au au1, i j)
    {
        a = new HashMap();
        d = 0x1d4c0L;
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        } else
        {
            b = s;
            c = az1;
            a.put("&tid", s1);
            a.put("useSecure", "1");
            f = k1;
            g = au1;
            h = j;
            return;
        }
    }

    private boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = System.currentTimeMillis();
        if (d >= 0x1d4c0L)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        l1 = l - e;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        d = Math.min(0x1d4c0L, l1 + d);
        e = l;
        if (d < 2000L) goto _L2; else goto _L1
_L1:
        d = d - 2000L;
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        an.d("Excessive tracking detected.  Tracking call ignored.");
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(Map map)
    {
        ai.a().a(aj.l);
        HashMap hashmap = new HashMap();
        hashmap.putAll(a);
        if (map != null)
        {
            hashmap.putAll(map);
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("&tid")))
        {
            an.d(String.format("Missing tracking id (%s) parameter.", new Object[] {
                "&tid"
            }));
        }
        String s = (String)hashmap.get("&t");
        map = s;
        if (TextUtils.isEmpty(s))
        {
            an.d(String.format("Missing hit type (%s) parameter.", new Object[] {
                "&t"
            }));
            map = "";
        }
        if (!map.equals("transaction") && !map.equals("item") && !a())
        {
            an.d("Too many hits sent too quickly, rate limiting invoked.");
            return;
        } else
        {
            c.a(hashmap);
            return;
        }
    }
}
