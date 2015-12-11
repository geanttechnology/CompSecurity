// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.google.a.a.e;

public final class u
{
    public static interface a
    {

        public abstract boolean a(Object obj, Object obj1);
    }


    public static Object a(Object obj, Class class1)
    {
        if (obj != null && class1.isAssignableFrom(obj.getClass()))
        {
            return obj;
        } else
        {
            return null;
        }
    }

    public static boolean a(e e1, e e2, a a1)
    {
        if (e1.b() != e2.b())
        {
            return false;
        } else
        {
            return a(e1.d(), e2.d(), a1);
        }
    }

    public static boolean a(Object obj, Object obj1, a a1)
    {
        if (a(new Object[] {
    obj, obj1
}))
        {
            return true;
        }
        if (obj == null && obj1 != null || obj != null && obj1 == null)
        {
            return false;
        } else
        {
            return a1.a(obj, obj1);
        }
    }

    public static transient boolean a(Object aobj[])
    {
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            if (aobj[i] != null)
            {
                return false;
            }
        }

        return true;
    }
}
