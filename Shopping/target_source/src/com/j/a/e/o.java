// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.d.ag;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            n, az

class o
    implements Runnable
{

    final JSONObject a;
    final n b;

    o(n n1, JSONObject jsonobject)
    {
        b = n1;
        a = jsonobject;
        super();
    }

    public void run()
    {
        az.a(b.a, a);
        ag.c().j();
    }
}
