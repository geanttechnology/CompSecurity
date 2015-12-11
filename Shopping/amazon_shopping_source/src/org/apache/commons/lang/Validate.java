// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang;

import java.util.Collection;
import java.util.Iterator;

public class Validate
{

    public Validate()
    {
    }

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

    public static void noNullElements(Collection collection, String s)
    {
        notNull(collection);
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (collection.next() == null)
            {
                throw new IllegalArgumentException(s);
            }
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
            throw new IllegalArgumentException("The validated object is null");
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
