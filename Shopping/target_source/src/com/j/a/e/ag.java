// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            af

class ag
    implements Runnable
{

    final JSONObject a;
    final af b;

    ag(af af, JSONObject jsonobject)
    {
        b = af;
        a = jsonobject;
        super();
    }

    public void run()
    {
        com.j.a.d.ag.c().b(a);
    }
}
