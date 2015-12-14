// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            ly, kt, kg

class nit> extends ly
{

    final String a;
    final kt b;

    public void a()
    {
        if (!b.b.remove(a))
        {
            kg.a(6, b.a, (new StringBuilder()).append("Internal error. Block with id = ").append(a).append(" was not in progress state").toString());
        }
    }

    der(kt kt1, String s)
    {
        b = kt1;
        a = s;
        super();
    }
}
