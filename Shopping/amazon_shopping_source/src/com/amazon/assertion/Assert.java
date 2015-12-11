// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.assertion;


// Referenced classes of package com.amazon.assertion:
//            AssertionException

public final class Assert
{

    private Assert()
    {
    }

    public static transient void fail(String s, String s1, Object aobj[])
    {
        throw new AssertionException(String.format((new StringBuilder()).append(s).append(": ").append(s1).toString(), aobj));
    }

    public static void isTrue(String s, boolean flag)
    {
        if (!flag)
        {
            fail(s, "not true", new Object[0]);
        }
    }

    public static void notEmpty(String s, String s1)
    {
        if (s1 == null || s1.length() == 0)
        {
            fail(s, "empty", new Object[0]);
        }
    }

    public static void notEmpty(String s, Object aobj[])
    {
        if (aobj == null || aobj.length == 0)
        {
            fail(s, "empty", new Object[0]);
        }
    }

    public static void notNull(String s, Object obj)
    {
        if (obj == null)
        {
            fail(s, "null", new Object[0]);
        }
    }
}
