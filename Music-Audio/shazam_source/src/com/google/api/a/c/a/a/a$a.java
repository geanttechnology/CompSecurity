// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.a.a;

import com.google.api.a.a.a.a;
import com.google.api.a.a.a.f;
import com.google.api.a.a.a.j;
import com.google.api.a.d.h;
import com.google.api.a.d.l;
import com.google.api.a.d.v;
import com.google.api.a.e.c;
import com.google.api.a.g.b.d;
import com.google.api.a.g.w;
import java.util.Collection;

// Referenced classes of package com.google.api.a.c.a.a:
//            a

public static final class b extends com.google.api.a.a.a.a
{

    String o;
    String p;

    private b b(Collection collection)
    {
        boolean flag;
        if (!collection.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.b(flag);
        return (y)super.a(collection);
    }

    public final volatile com.google.api.a.a.a.a a(com.google.api.a.a.a.a a1)
    {
        return (y)super.a(a1);
    }

    public final volatile com.google.api.a.a.a.a a(com.google.api.a.a.a.a a1)
    {
        return (y)super.a(a1);
    }

    public final volatile com.google.api.a.a.a.a a(j j)
    {
        return (y)super.a(j);
    }

    public final volatile com.google.api.a.a.a.a a(h h1)
    {
        return (y)super.a(h1);
    }

    public final volatile com.google.api.a.a.a.a a(l l)
    {
        return (y)super.a(l);
    }

    public final volatile com.google.api.a.a.a.a a(v v)
    {
        return (y)super.a(v);
    }

    public final volatile com.google.api.a.a.a.a a(c c)
    {
        return (y)super.a(c);
    }

    public final volatile com.google.api.a.a.a.a a(d d)
    {
        return (y)super.a(d);
    }

    public final volatile com.google.api.a.a.a.a a(String s)
    {
        return (y)super.a(s);
    }

    public final com.google.api.a.a.a.a a(Collection collection)
    {
        return b(collection);
    }

    public final a a()
    {
        return b();
    }

    public final volatile com.google.api.a.a.a.a b(String s)
    {
        return (b)super.b(s);
    }

    public final com.google.api.a.c.a.a.a b()
    {
        return new com.google.api.a.c.a.a.a(this);
    }

    public (v v, c c, String s, String s1, Collection collection)
    {
        super(f.a(), v, c, new h("https://accounts.google.com/o/oauth2/token"), new com.google.api.a.a.a.h(s, s1), s, "https://accounts.google.com/o/oauth2/auth");
        b(collection);
    }
}
