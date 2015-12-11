// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.h;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.l;
import com.google.api.a.g.n;
import com.google.api.a.g.w;
import java.util.Collection;
import java.util.Iterator;

public class e extends h
{

    private String clientId;
    private String redirectUri;
    private String responseTypes;
    private String scopes;
    private String state;

    public e(String s, String s1, Collection collection)
    {
        super(s);
        boolean flag;
        if (super.b == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        e(s1);
        d(collection);
    }

    public e b()
    {
        return (e)super.c();
    }

    public e b(String s, Object obj)
    {
        return (e)super.c(s, obj);
    }

    public e c(Collection collection)
    {
        if (collection == null || !collection.iterator().hasNext())
        {
            collection = null;
        } else
        {
            collection = n.a().a(collection);
        }
        scopes = collection;
        return this;
    }

    public h c()
    {
        return b();
    }

    public h c(String s, Object obj)
    {
        return b(s, obj);
    }

    public l clone()
    {
        return b();
    }

    public Object clone()
    {
        return b();
    }

    public e d(String s)
    {
        state = s;
        return this;
    }

    public e d(Collection collection)
    {
        responseTypes = n.a().a(collection);
        return this;
    }

    public e e(String s)
    {
        clientId = (String)com.google.api.a.f.a.a.a.a.c.a(s);
        return this;
    }

    public e f(String s)
    {
        redirectUri = s;
        return this;
    }

    public l set(String s, Object obj)
    {
        return b(s, obj);
    }
}
