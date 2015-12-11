// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;


// Referenced classes of package com.smule.android.d:
//            p

public class i extends Exception
{

    p a;

    public i(int j, String s)
    {
        this(new p(j, s));
    }

    public i(int j, String s, Exception exception)
    {
        this(new p(j, s), exception);
    }

    public i(p p1)
    {
        this(p1, ((Exception) (null)));
    }

    public i(p p1, Exception exception)
    {
        super(p1.b(), exception);
        a = p1;
    }

    public p a()
    {
        return a;
    }
}
