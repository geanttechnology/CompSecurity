// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model;

import com.google.a.a.e;
import com.target.mothership.services.o;
import com.target.mothership.services.r;

public abstract class d
{

    private o mRequestRetryable;

    public d()
    {
    }

    public String a()
    {
        return null;
    }

    public abstract void a(Object obj);

    public final void a(Object obj, o o)
    {
        mRequestRetryable = o;
        a(obj);
    }

    public r b()
    {
        return (new com.target.mothership.services.r.a()).a();
    }

    public abstract void b(Object obj);

    public final void b(Object obj, o o)
    {
        mRequestRetryable = o;
        b(obj);
    }

    public final e c()
    {
        return e.c(mRequestRetryable);
    }
}
