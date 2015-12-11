// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import com.google.a.a.e;
import java.util.Collections;
import java.util.List;

public class k
{

    public static e a(Object obj)
    {
        return e.c(obj);
    }

    public static List a(List list)
    {
        List list1 = list;
        if (list == null)
        {
            list1 = Collections.emptyList();
        }
        return list1;
    }

    public static boolean a(long l, long l1)
    {
        return l == l1;
    }

    public static boolean a(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static boolean a(boolean flag, boolean flag1)
    {
        return flag == flag1;
    }
}
