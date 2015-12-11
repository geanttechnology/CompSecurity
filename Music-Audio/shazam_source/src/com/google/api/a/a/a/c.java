// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.h;
import com.google.api.a.g.l;
import com.google.api.a.g.w;

public final class c extends h
{

    public String code;
    public String error;
    private String errorDescription;
    private String errorUri;
    private String state;

    public c(String s)
    {
        boolean flag2 = true;
        super(s);
        boolean flag;
        boolean flag1;
        if (code == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (error == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag == flag1)
        {
            flag2 = false;
        }
        w.a(flag2);
    }

    private c a(String s, Object obj)
    {
        return (c)super.c(s, obj);
    }

    public final volatile h c()
    {
        return (c)super.c();
    }

    public final h c(String s, Object obj)
    {
        return a(s, obj);
    }

    public final l clone()
    {
        return (c)super.c();
    }

    public final Object clone()
    {
        return (c)super.c();
    }

    public final l set(String s, Object obj)
    {
        return a(s, obj);
    }
}
