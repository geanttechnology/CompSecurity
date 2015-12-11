// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            dj, dy, ba, cm, 
//            cz, du, ck, dc, 
//            cd, cn, dl

final class dk
{
    static final class a
    {

        public static transient dk a(dl dl1, dj adj[])
        {
            return new dk(dl1, adj);
        }

        a()
        {
        }
    }


    private final dj a[];
    private final dl b;
    private final dy.d c;

    public transient dk(dl dl1, dj adj[])
    {
        this(new dy.d(), dl1, adj);
    }

    private transient dk(dy.d d, dl dl1, dj adj[])
    {
        c = d;
        b = dl1;
        a = adj;
    }

    public final void a()
    {
        dj adj[];
        int i;
        int j;
        adj = a;
        j = adj.length;
        i = 0;
_L2:
        dj dj1;
        dy dy1;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        dj1 = adj[i];
        dy1 = c.a();
        dy1.e(dj1.a());
        dy1.a(dy.a.b);
        Object obj2 = ba.a().a(ba.a.b);
        Object obj = obj2;
        if (obj2 != null)
        {
            int k = ((String) (obj2)).indexOf("/");
            obj = obj2;
            if (k >= 0)
            {
                obj = ((String) (obj2)).substring(0, k);
            }
        }
        dy1.b(((String) (obj)));
        obj2 = ba.a().a(ba.a.b);
        obj = obj2;
        if (obj2 != null)
        {
            int l = ((String) (obj2)).indexOf("/");
            if (l >= 0)
            {
                obj = ((String) (obj2)).substring(l);
            } else
            {
                obj = "";
            }
        }
        dy1.e = (new StringBuilder()).append(((String) (obj))).append("/api3").append(dj1.c()).toString();
        dy1.e();
        if (dj1.e() != null)
        {
            for (obj = dj1.e().entrySet().iterator(); ((Iterator) (obj)).hasNext(); dy1.b((String)((java.util.Map.Entry) (obj2)).getKey(), (String)((java.util.Map.Entry) (obj2)).getValue()))
            {
                obj2 = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

        }
        obj = dj1.d();
        ((dy.b) (obj)).a("appId", cm.a().c.d());
        ((dy.b) (obj)).a("sdkVer", du.b());
        dy1.a(((dy.b) (obj)));
        dy1.h = ck.a().b;
        dy1.a(dj1.b());
        Object obj1 = dy1.c();
        obj1 = ((dy.g) (obj1)).a().b();
        if (obj1 != null)
        {
            int i1 = cd.a(((org.json.JSONObject) (obj1)), "rcode", 0);
            String s = cd.a(((org.json.JSONObject) (obj1)), "msg", "");
            if (i1 == 1)
            {
                dj1.f().a("Result - code: %d, msg: %s", new Object[] {
                    Integer.valueOf(i1), s
                });
                dj1.a(((org.json.JSONObject) (obj1)));
            } else
            {
                dj1.f().c("Result - code: %d, msg: %s", new Object[] {
                    Integer.valueOf(i1), s
                });
            }
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        dl dl1 = b;
        if (dl1 != null)
        {
            dl1.a();
        }
        return;
        dy.c c1;
        c1;
          goto _L3
    }
}
