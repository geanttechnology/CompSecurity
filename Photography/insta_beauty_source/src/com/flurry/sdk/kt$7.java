// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            ly, kt, kv, kg

class nit> extends ly
{

    final String a;
    final String b;
    final kt c;

    public void a()
    {
        if (!c.c.a(a, b))
        {
            kg.a(6, c.a, (new StringBuilder()).append("Internal error. Block wasn't deleted with id = ").append(a).toString());
        }
        if (!c.b.remove(a))
        {
            kg.a(6, c.a, (new StringBuilder()).append("Internal error. Block with id = ").append(a).append(" was not in progress state").toString());
        }
    }

    der(kt kt1, String s, String s1)
    {
        c = kt1;
        a = s;
        b = s1;
        super();
    }
}
