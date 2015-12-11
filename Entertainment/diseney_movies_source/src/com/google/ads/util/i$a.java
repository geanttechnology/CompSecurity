// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;


// Referenced classes of package com.google.ads.util:
//            i

public abstract class <init>
{

    protected Object a;
    protected final String b;
    final i c;

    public String toString()
    {
        return (new StringBuilder()).append(c.toString()).append(".").append(b).append(" = ").append(a).toString();
    }

    private (i j, String s)
    {
        this(j, s, null);
    }

    <init>(i j, String s, <init> <init>1)
    {
        this(j, s);
    }

    private <init>(i j, String s, Object obj)
    {
        c = j;
        super();
        b = s;
        i.a(j, this);
        a = obj;
    }

    a(i j, String s, Object obj, a a1)
    {
        this(j, s, obj);
    }
}
