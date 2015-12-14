// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.utils;

import java.util.Collection;

public class AssertUtils
{

    public static void assertNotNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new RuntimeException(s);
        } else
        {
            return;
        }
    }

    public static void assertNotNullOrEmpty(String s, String s1)
    {
        if (s == null || s.equals(""))
        {
            throw new RuntimeException(s1);
        } else
        {
            return;
        }
    }

    public static void assertNotNullOrEmpty(Collection collection, String s)
    {
        if (collection == null || collection.isEmpty())
        {
            throw new RuntimeException(s);
        } else
        {
            return;
        }
    }
}
