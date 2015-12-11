// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            fu, kt

public final class fv
{

    private final Map a = new LinkedHashMap();

    public fv()
    {
    }

    static Map a(fv fv1)
    {
        return fv1.a;
    }

    public final fu a()
    {
        return new fu(this, (byte)0);
    }

    public final transient fv a(String s, String as[])
    {
        if (s == null)
        {
            throw new IllegalArgumentException("hostname == null");
        }
        LinkedHashSet linkedhashset = new LinkedHashSet();
        s = (Set)a.put(s, Collections.unmodifiableSet(linkedhashset));
        if (s != null)
        {
            linkedhashset.addAll(s);
        }
        for (int i = 0; i <= 0; i++)
        {
            s = as[0];
            if (!s.startsWith("sha1/"))
            {
                throw new IllegalArgumentException((new StringBuilder("pins must start with 'sha1/': ")).append(s).toString());
            }
            kt kt1 = kt.b(s.substring(5));
            if (kt1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder("pins must be base64: ")).append(s).toString());
            }
            linkedhashset.add(kt1);
        }

        return this;
    }
}
