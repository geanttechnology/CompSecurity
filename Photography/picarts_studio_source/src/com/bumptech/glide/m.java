// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import myobfuscated.ah.c;
import myobfuscated.ah.g;

public abstract class m
    implements Cloneable
{

    g a;

    public m()
    {
        a = c.a();
    }

    public final m a(g g1)
    {
        a = (g)myobfuscated.f.m.a(g1, "Argument must not be null");
        return this;
    }

    protected final m b()
    {
        m m1;
        try
        {
            m1 = (m)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new RuntimeException(clonenotsupportedexception);
        }
        return m1;
    }

    protected Object clone()
    {
        return b();
    }
}
