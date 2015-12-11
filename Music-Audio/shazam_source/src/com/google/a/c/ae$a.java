// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;


// Referenced classes of package com.google.a.c:
//            ae, av

public static final class b
{

    public a a[];
    public int b;

    public final b a(Object obj, Object obj1)
    {
        a(b + 1);
        obj = ae.c(obj, obj1);
        obj1 = a;
        int i = b;
        b = i + 1;
        obj1[i] = obj;
        return this;
    }

    public final void a(int i)
    {
        if (i > a.length)
        {
            a = (a[])av.b(a, (a.length, i));
        }
    }

    public ()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        a = new a[4];
        b = 0;
    }
}
