// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.helper;


public final class Validate
{

    private Validate()
    {
    }

    public static void fail(String s)
    {
        throw new IllegalArgumentException(s);
    }

    public static void isFalse(boolean flag)
    {
        if (flag)
        {
            throw new IllegalArgumentException("Must be false");
        } else
        {
            return;
        }
    }

    public static void isFalse(boolean flag, String s)
    {
        if (flag)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public static void isTrue(boolean flag)
    {
        if (!flag)
        {
            throw new IllegalArgumentException("Must be true");
        } else
        {
            return;
        }
    }

    public static void isTrue(boolean flag, String s)
    {
        if (!flag)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public static void noNullElements(Object aobj[])
    {
        noNullElements(aobj, "Array must not contain any null objects");
    }

    public static void noNullElements(Object aobj[], String s)
    {
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            if (aobj[i] == null)
            {
                throw new IllegalArgumentException(s);
            }
        }

    }

    public static void notEmpty(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("String must not be empty");
        } else
        {
            return;
        }
    }

    public static void notEmpty(String s, String s1)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException(s1);
        } else
        {
            return;
        }
    }

    public static void notNull(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Object must not be null");
        } else
        {
            return;
        }
    }

    public static void notNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }
}
