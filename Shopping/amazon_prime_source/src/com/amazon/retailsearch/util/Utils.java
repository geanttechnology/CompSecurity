// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.util;

import java.util.Collection;

public final class Utils
{

    private Utils()
    {
    }

    public static final boolean isEmpty(Collection collection)
    {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEqual(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static final transient boolean isEqual(long al[])
    {
        if (al != null && al.length >= 1)
        {
            int i = 1;
            while (i < al.length) 
            {
                if (al[i - 1] != al[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static final transient boolean isEqual(String as[])
    {
        if (as != null && as.length >= 1)
        {
            int i = 1;
            while (i < as.length) 
            {
                if (as[i - 1] != null ? !as[i - 1].equals(as[i]) : as[i] != null)
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
