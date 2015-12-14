// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            kn, io, kg, jz

class it>
    implements it>
{

    final io a;

    public volatile void a(kn kn1, Object obj)
    {
        a(kn1, (Void)obj);
    }

    public void a(kn kn1, Void void1)
    {
        int i = kn1.h();
        if (i > 0)
        {
            if (i >= 200 && i < 300)
            {
                kg.a(3, io.d(), (new StringBuilder()).append("Pulse logging report sent successfully HTTP response:").append(i).toString());
                io.a(a).clear();
                io.b(a).a(io.a(a));
                return;
            } else
            {
                kg.a(3, io.d(), (new StringBuilder()).append("Pulse logging report sent unsuccessfully, HTTP response:").append(i).toString());
                return;
            }
        } else
        {
            kg.e(io.d(), (new StringBuilder()).append("Server Error: ").append(i).toString());
            return;
        }
    }

    der(io io1)
    {
        a = io1;
        super();
    }
}
