// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.net.Uri;
import android.util.Log;
import com.facebook.ads.a.a.a;
import com.facebook.ads.a.f.b;
import com.facebook.ads.a.f.c;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.ads.a.b:
//            n, r, p, q, 
//            c

final class a
    implements com.facebook.ads.a.g.a
{

    final q a;
    final n b;

    public final void a()
    {
        n n1 = b;
        if (n1.a != null)
        {
            n1.a.a();
        } else
        if (n1.b != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("mil", Boolean.valueOf(false));
            n1.b.a(hashmap);
            return;
        }
    }

    public final void a(int i)
    {
        if (i == 0 && com.facebook.ads.a.b.n.c(b) > 0L && n.d(b) != null)
        {
            c.a(com.facebook.ads.a.f.b.a(com.facebook.ads.a.b.n.c(b), n.d(b), a.e));
            com.facebook.ads.a.b.n.a(b, 0L);
            com.facebook.ads.a.b.n.a(b, null);
        }
    }

    public final void a(String s)
    {
        if (com.facebook.ads.a.b.n.a(b) != null)
        {
            com.facebook.ads.a.b.n.a(b).b();
        }
        s = Uri.parse(s);
        s = com.facebook.ads.a.a.b.a(com.facebook.ads.a.b.n.b(b), s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        com.facebook.ads.a.b.n.a(b, s.a());
        com.facebook.ads.a.b.n.a(b, System.currentTimeMillis());
        s.b();
        return;
        s;
        Log.e(com.facebook.ads.a.b.n.c(), "Error executing action", s);
        return;
    }

    (n n1, q q1)
    {
        b = n1;
        a = q1;
        super();
    }
}
