// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gt, do

public static final class c extends c
    implements c
{

    private int b;
    private Object c;
    private long d;

    static c f()
    {
        return new <init>();
    }

    private <init> g()
    {
        <init> <init>1 = new <init>();
        <init> <init>2 = e();
        if (<init>2 == e())
        {
            return <init>1;
        }
        if (<init>2.e())
        {
            <init>1.b = <init>1.b | 1;
            <init>1.c = c(<init>2);
        }
        if (<init>2.c())
        {
            <init>1.a(<init>2.a());
        }
        <init>1.a = ((a) (<init>1)).a.a(a(<init>2));
        return <init>1;
    }

    public final a a()
    {
        return g();
    }

    public final g a(long l)
    {
        b = b | 2;
        d = l;
        return this;
    }

    public final d a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 1;
            c = s;
            return this;
        }
    }

    public final c b()
    {
        return g();
    }

    public final Object clone()
    {
        return g();
    }

    public final boolean d()
    {
        boolean flag;
        if ((b & 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            boolean flag1;
            if ((b & 2) == 2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                return true;
            }
        }
        return false;
    }

    final b e()
    {
        int i = 1;
        b b1 = new nit>(this, (byte)0);
        int l = b;
        int k;
        if ((l & 1) != 1)
        {
            i = 0;
        }
        b(b1, c);
        k = i;
        if ((l & 2) == 2)
        {
            k = i | 2;
        }
        c(b1, d);
        d(b1, k);
        return b1;
    }

    private ion()
    {
        c = "";
    }
}
