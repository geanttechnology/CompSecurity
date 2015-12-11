// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


// Referenced classes of package com.a.a:
//            j

public class t extends Exception
{

    public final j a;
    private long b;

    public t()
    {
        a = null;
    }

    public t(j j)
    {
        a = j;
    }

    public t(Throwable throwable)
    {
        super(throwable);
        a = null;
    }

    void a(long l)
    {
        b = l;
    }
}
