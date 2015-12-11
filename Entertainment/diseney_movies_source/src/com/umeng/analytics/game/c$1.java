// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import com.umeng.analytics.d;
import com.umeng.analytics.f;
import java.util.HashMap;

// Referenced classes of package com.umeng.analytics.game:
//            c, b

class b extends f
{

    final c a;
    private final String b;

    public void a()
    {
        c.a(a).a(b);
        HashMap hashmap = new HashMap();
        hashmap.put("level", b);
        hashmap.put("status", Integer.valueOf(0));
        if (c.a(a).b != null)
        {
            hashmap.put("user_level", c.a(a).b);
        }
        c.b(a).a(c.c(a), "level", hashmap);
    }

    (c c1, String s)
    {
        a = c1;
        b = s;
        super();
    }
}
