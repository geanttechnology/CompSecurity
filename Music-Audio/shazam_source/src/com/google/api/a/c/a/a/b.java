// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.a.a;

import com.google.api.a.a.a.e;
import com.google.api.a.d.h;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.l;
import com.google.api.a.g.w;
import java.util.Collection;
import java.util.Iterator;

public final class b extends com.google.api.a.a.a.b
{

    String accessType;
    String approvalPrompt;

    public b(String s, String s1, String s2, Collection collection)
    {
        super(s, s1);
        i(s2);
        f(collection);
    }

    private b d(String s, Object obj)
    {
        return (b)super.a(s, obj);
    }

    private b e(Collection collection)
    {
        return (b)super.a(collection);
    }

    private b f(Collection collection)
    {
        w.a(collection.iterator().hasNext());
        return (b)super.b(collection);
    }

    private b i(String s)
    {
        com.google.api.a.f.a.a.a.a.c.a(s);
        return (b)super.a(s);
    }

    private b j(String s)
    {
        return (b)super.b(s);
    }

    private b k(String s)
    {
        return (b)super.c(s);
    }

    public final volatile com.google.api.a.a.a.b a()
    {
        return (b)super.a();
    }

    public final com.google.api.a.a.a.b a(String s)
    {
        return i(s);
    }

    public final com.google.api.a.a.a.b a(String s, Object obj)
    {
        return d(s, obj);
    }

    public final com.google.api.a.a.a.b a(Collection collection)
    {
        return e(collection);
    }

    public final com.google.api.a.a.a.b b(String s)
    {
        return j(s);
    }

    public final com.google.api.a.a.a.b b(Collection collection)
    {
        return f(collection);
    }

    public final e b()
    {
        return (b)super.a();
    }

    public final e b(String s, Object obj)
    {
        return d(s, obj);
    }

    public final com.google.api.a.a.a.b c(String s)
    {
        return k(s);
    }

    public final e c(Collection collection)
    {
        return f(collection);
    }

    public final h c()
    {
        return (b)super.a();
    }

    public final h c(String s, Object obj)
    {
        return d(s, obj);
    }

    public final l clone()
    {
        return (b)super.a();
    }

    public final Object clone()
    {
        return (b)super.a();
    }

    public final e d(String s)
    {
        return k(s);
    }

    public final e d(Collection collection)
    {
        return e(collection);
    }

    public final e e(String s)
    {
        return j(s);
    }

    public final e f(String s)
    {
        return i(s);
    }

    public final l set(String s, Object obj)
    {
        return d(s, obj);
    }
}
