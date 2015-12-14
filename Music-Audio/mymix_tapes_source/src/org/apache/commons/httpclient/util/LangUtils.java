// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;


public class LangUtils
{

    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;

    private LangUtils()
    {
    }

    public static boolean equals(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static int hashCode(int i, int j)
    {
        return i * 37 + j;
    }

    public static int hashCode(int i, Object obj)
    {
        int j;
        if (obj != null)
        {
            j = obj.hashCode();
        } else
        {
            j = 0;
        }
        return hashCode(i, j);
    }

    public static int hashCode(int i, boolean flag)
    {
        int j;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        return hashCode(i, j);
    }
}
