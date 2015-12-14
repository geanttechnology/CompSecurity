// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;


class RequestAssertUtils
{

    static void assertNotNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    static void assertNotNullOrEmpty(String s, String s1)
    {
        if (s == null || s.equals(""))
        {
            throw new IllegalArgumentException(s1);
        } else
        {
            return;
        }
    }
}
