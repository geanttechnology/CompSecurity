// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            bj, bk

public final class bl extends bj
{

    public bl(bk bk1, Exception exception)
    {
        this(bk1.toString(), ((Throwable) (exception)));
    }

    public bl(String s)
    {
        super("RequestError", s);
    }

    public bl(String s, String s1, String s2)
    {
        super("RequestError", s, s1);
    }

    private bl(String s, Throwable throwable)
    {
        String s1 = throwable.getClass().toString();
        String s2 = throwable.toString();
        throwable.getMessage();
        super(s1, s, s2);
    }
}
