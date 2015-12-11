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

public class d extends com.google.api.a.a.a.r
{

    private String code;
    private String redirectUri;

    public d(v v, com.google.api.a.e.c c1, h h, String s)
    {
        super(v, c1, h, "authorization_code");
        b(s);
    }

    public d a(h h)
    {
        return (d)super.b(h);
    }

    public d a(l l)
    {
        return (d)super.b(l);
    }

    public d a(r r1)
    {
        return (d)super.b(r1);
    }

    public d a(String s)
    {
        return (d)super.d(s);
    }

    public d a(String s, Object obj)
    {
        return (d)super.b(s, obj);
    }

    public d a(Collection collection)
    {
        return (d)super.b(collection);
    }

    public d b(String s)
    {
        code = (String)com.google.api.a.f.a.a.a.a.c.a(s);
        return this;
    }

    public com.google.api.a.a.a.r b(h h)
    {
        return a(h);
    }

    public com.google.api.a.a.a.r b(l l)
    {
        return a(l);
    }

    public com.google.api.a.a.a.r b(r r1)
    {
        return a(r1);
    }

    public com.google.api.a.a.a.r b(String s, Object obj)
    {
        return a(s, obj);
    }

    public com.google.api.a.a.a.r b(Collection collection)
    {
        return a(collection);
    }

    public d c(String s)
    {
        redirectUri = s;
        return this;
    }

    public com.google.api.a.a.a.r d(String s)
    {
        return a(s);
    }

    public com.google.api.a.g.l set(String s, Object obj)
    {
        return a(s, obj);
    }
}
