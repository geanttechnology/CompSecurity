// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;


// Referenced classes of package com.target.mothership.services:
//            a, v, o, w, 
//            x

public class h extends a
{

    public h(w w1)
    {
        super(w1, null);
    }

    public void a(v v1, boolean flag, com.target.mothership.services.f.a.b.b b)
    {
        if (a() != null)
        {
            a().onResult(null, v1.b(), new o(b, this));
        }
    }

    public void a(x x, com.target.mothership.services.f.a.b.b b)
    {
        if (a() != null)
        {
            a().onError(x, new o(b, this));
        }
    }
}
