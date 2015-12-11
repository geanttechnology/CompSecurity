// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;


// Referenced classes of package org.apache.commons.lang3:
//            StringUtils

public class Validate
{

    public static void isTrue(boolean flag)
    {
        if (!flag)
        {
            throw new IllegalArgumentException("The validated expression is false");
        } else
        {
            return;
        }
    }

    public static void isTrue(boolean flag, String s, long l)
    {
        if (!flag)
        {
            throw new IllegalArgumentException(String.format(s, new Object[] {
                Long.valueOf(l)
            }));
        } else
        {
            return;
        }
    }

    public static CharSequence notBlank(CharSequence charsequence)
    {
        return notBlank(charsequence, "The validated character sequence is blank", new Object[0]);
    }

    public static transient CharSequence notBlank(CharSequence charsequence, String s, Object aobj[])
    {
        if (charsequence == null)
        {
            throw new NullPointerException(String.format(s, aobj));
        }
        if (StringUtils.isBlank(charsequence))
        {
            throw new IllegalArgumentException(String.format(s, aobj));
        } else
        {
            return charsequence;
        }
    }

    public static CharSequence notEmpty(CharSequence charsequence)
    {
        return notEmpty(charsequence, "The validated character sequence is empty", new Object[0]);
    }

    public static transient CharSequence notEmpty(CharSequence charsequence, String s, Object aobj[])
    {
        if (charsequence == null)
        {
            throw new NullPointerException(String.format(s, aobj));
        }
        if (charsequence.length() == 0)
        {
            throw new IllegalArgumentException(String.format(s, aobj));
        } else
        {
            return charsequence;
        }
    }

    public static Object notNull(Object obj)
    {
        return notNull(obj, "The validated object is null", new Object[0]);
    }

    public static transient Object notNull(Object obj, String s, Object aobj[])
    {
        if (obj == null)
        {
            throw new NullPointerException(String.format(s, aobj));
        } else
        {
            return obj;
        }
    }
}
