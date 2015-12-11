// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.smule.android.network.a:
//            s

public class p
{

    static final String a = com/smule/android/network/a/s.getName();
    protected static p b = null;

    private static k a(String s1)
    {
        return new k(m.a, s1, l.b, n.c, null, true);
    }

    public static o a(String s1, String s2, boolean flag)
    {
        k k1 = a("/v2/pushToken/register");
        k1.d = new HashMap();
        k1.d.put("deviceType", "AND");
        k1.d.put("deviceId", s2);
        k1.d.put("app", com.smule.android.network.core.b.b());
        k1.d.put("pushToken", s1);
        k1.d.put("gcm", Boolean.valueOf(flag));
        return com.smule.android.network.core.b.a().a(k1);
    }

}
