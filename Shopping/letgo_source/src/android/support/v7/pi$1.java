// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            pi, ul

class e
    implements Runnable
{

    final String a;
    final String b;
    final int c;
    final int d;
    final boolean e;
    final pi f;

    public void run()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", "precacheProgress");
        hashmap.put("src", a);
        hashmap.put("cachedSrc", b);
        hashmap.put("bytesLoaded", Integer.toString(c));
        hashmap.put("totalBytes", Integer.toString(d));
        String s;
        if (e)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        hashmap.put("cacheReady", s);
        f.a.a("onPrecacheEvent", hashmap);
    }

    (pi pi1, String s, String s1, int i, int j, boolean flag)
    {
        f = pi1;
        a = s;
        b = s1;
        c = i;
        d = j;
        e = flag;
        super();
    }
}
