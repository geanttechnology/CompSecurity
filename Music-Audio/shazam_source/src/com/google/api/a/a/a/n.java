// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.h;
import com.google.api.a.d.l;
import com.google.api.a.d.r;
import com.google.api.a.d.v;
import com.google.api.a.f.a.a.a.a.c;
import java.util.Collection;

// Referenced classes of package com.google.api.a.a.a:
//            r

public final class n extends com.google.api.a.a.a.r
{

    private String password;
    private String username;

    public n(v v, com.google.api.a.e.c c1, h h, String s, String s1)
    {
        super(v, c1, h, "password");
        username = (String)c.a(s);
        password = (String)c.a(s1);
    }

    private n a(String s, Object obj)
    {
        return (n)super.b(s, obj);
    }

    public final n a(l l)
    {
        return (n)super.b(l);
    }

    public final volatile com.google.api.a.a.a.r b(h h)
    {
        return (n)super.b(h);
    }

    public final com.google.api.a.a.a.r b(l l)
    {
        return a(l);
    }

    public final volatile com.google.api.a.a.a.r b(r r1)
    {
        return (n)super.b(r1);
    }

    public final com.google.api.a.a.a.r b(String s, Object obj)
    {
        return a(s, obj);
    }

    public final volatile com.google.api.a.a.a.r b(Collection collection)
    {
        return (n)super.b(collection);
    }

    public final volatile com.google.api.a.a.a.r d(String s)
    {
        return (n)super.d(s);
    }

    public final com.google.api.a.g.l set(String s, Object obj)
    {
        return a(s, obj);
    }
}
