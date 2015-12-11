// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            cp, he

final class b
    implements Runnable
{

    final String a;
    final String b;
    final cp c;

    public final void run()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", "precacheCanceled");
        hashmap.put("src", a);
        if (b != null)
        {
            hashmap.put("cachedSrc", b);
        }
        c.a.a("onPrecacheEvent", hashmap);
    }

    (cp cp1, String s, String s1)
    {
        c = cp1;
        a = s;
        b = s1;
        super();
    }
}
