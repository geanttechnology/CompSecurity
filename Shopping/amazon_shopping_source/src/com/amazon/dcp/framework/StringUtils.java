// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.framework;


public final class StringUtils
{

    private StringUtils()
    {
    }

    public static transient boolean equalsAny(String s, String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s1 = as[i];
            if (s != null && s.equals(s1) || s == null && s1 == null)
            {
                return true;
            }
        }

        return false;
    }
}
