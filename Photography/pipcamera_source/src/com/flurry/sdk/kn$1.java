// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            kn, kp, lb

class it>
    implements it>
{

    final kn a;

    public void a(kp kp1)
    {
        kn.d(a);
    }

    public void a(kp kp1, InputStream inputstream)
    {
        while (!kp1.g() || kn.c(a) == null) 
        {
            return;
        }
        kn.a(a, kn.c(a).b(inputstream));
    }

    public void a(kp kp1, OutputStream outputstream)
    {
        if (kn.a(a) != null && kn.b(a) != null)
        {
            kn.b(a).a(outputstream, kn.a(a));
        }
    }

    (kn kn1)
    {
        a = kn1;
        super();
    }
}
