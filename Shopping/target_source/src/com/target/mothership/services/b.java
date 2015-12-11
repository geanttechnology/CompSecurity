// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;


// Referenced classes of package com.target.mothership.services:
//            f, h, c, aa, 
//            w

public abstract class b
{

    public b()
    {
    }

    protected void a(com.target.mothership.services.f.a.b b1, aa aa, w w)
    {
        aa = new f(w, aa);
        com.target.mothership.b.a().a(b1, aa);
    }

    protected void a(com.target.mothership.services.f.a.b b1, w w)
    {
        w = new h(w);
        com.target.mothership.b.a().a(b1, w);
    }

    protected void a(com.target.mothership.services.f.a.b b1, Class class1, w w)
    {
        a(b1, ((aa) (new c(class1))), w);
    }
}
