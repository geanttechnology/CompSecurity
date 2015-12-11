// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


public final class hw
{

    public static hw a = new hw(null);
    private String b;
    private Throwable c;
    private Object d[];

    public hw(String s)
    {
        this(s, null, null);
    }

    public hw(String s, Object aobj[], Throwable throwable)
    {
        b = s;
        c = throwable;
        if (throwable == null)
        {
            d = aobj;
            return;
        }
        if (aobj == null || aobj.length == 0)
        {
            throw new IllegalStateException("non-sensical empty or null argument array");
        } else
        {
            int i = aobj.length - 1;
            s = ((String) (new Object[i]));
            System.arraycopy(((Object) (aobj)), 0, s, 0, i);
            d = s;
            return;
        }
    }

    public final String a()
    {
        return b;
    }

    public final Throwable b()
    {
        return c;
    }

}
