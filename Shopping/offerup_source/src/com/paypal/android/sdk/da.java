// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class da extends Enum
{

    public static final da a;
    private static da b;
    private static da c;
    private static final da d[];

    private da(String s, int i)
    {
        super(s, i);
    }

    public static da valueOf(String s)
    {
        return (da)Enum.valueOf(com/paypal/android/sdk/da, s);
    }

    public static da[] values()
    {
        return (da[])d.clone();
    }

    static 
    {
        b = new da("USER_REQUIRED", 0);
        c = new da("USER_OPTIONAL", 1);
        a = new da("PROMPT_LOGIN", 2);
        d = (new da[] {
            b, c, a
        });
    }
}
