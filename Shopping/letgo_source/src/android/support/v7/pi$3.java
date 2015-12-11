// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            pi, ul

class b
    implements Runnable
{

    final String a;
    final String b;
    final pi c;

    public void run()
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

    (pi pi1, String s, String s1)
    {
        c = pi1;
        a = s;
        b = s1;
        super();
    }
}
