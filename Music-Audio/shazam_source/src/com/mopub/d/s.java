// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;


// Referenced classes of package com.mopub.d:
//            i

public class s extends Exception
{

    public final i c;
    long d;

    public s()
    {
        c = null;
    }

    public s(i i)
    {
        c = i;
    }

    public s(String s1)
    {
        super(s1);
        c = null;
    }

    public s(String s1, Throwable throwable)
    {
        super(s1, throwable);
        c = null;
    }

    public s(Throwable throwable)
    {
        super(throwable);
        c = null;
    }
}
