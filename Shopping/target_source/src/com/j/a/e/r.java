// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            q, az

class r
    implements Runnable
{

    final JSONObject a;
    final q b;

    r(q q1, JSONObject jsonobject)
    {
        b = q1;
        a = jsonobject;
        super();
    }

    public void run()
    {
        az.b(b.a, a);
    }
}
