// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import com.iovation.mobile.android.details.background.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.iovation.mobile.android.details:
//            j, e, f, m, 
//            v, s, b, d, 
//            p, r, q, n, 
//            a, RootProvider, t, u, 
//            g, l, o, i, 
//            c

public class h
{

    static List a;
    static List b;
    static j c = new j();

    public static Map a(Context context)
    {
        new HashMap();
        long l1 = System.currentTimeMillis();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((i)iterator.next()).a(context, c)) { }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); ((c)iterator1.next()).a(context, c)) { }
        c.a("BBRT", Double.toString((double)(System.currentTimeMillis() - l1) / 1000D));
        return c.a();
    }

    static 
    {
        a = new ArrayList();
        b = new ArrayList();
        a.add(new e());
        a.add(new f());
        a.add(new m());
        a.add(new v());
        a.add(new s());
        a.add(new b());
        a.add(new d());
        a.add(new p());
        a.add(new r());
        a.add(new q());
        a.add(new n());
        a.add(new com.iovation.mobile.android.details.a());
        a.add(new RootProvider());
        a.add(new t());
        a.add(new u());
        a.add(new g());
        a.add(new l());
        a.add(new o());
        b.add(new a());
    }
}
