// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import com.mopub.common.c.a;
import java.util.IllegalFormatException;

public final class m
{
    public static final class a
    {

        private static volatile boolean a = false;

        public static boolean a(Object obj)
        {
            return com.mopub.common.m.a(obj, a, "Object can not be null.", new Object[] {
                ""
            });
        }

        public static boolean a(Object obj, String s)
        {
            return com.mopub.common.m.a(obj, a, s, new Object[] {
                ""
            });
        }

        public static boolean a(boolean flag)
        {
            return com.mopub.common.m.a(flag, a, "Illegal argument", new Object[] {
                ""
            });
        }

    }


    public static transient String a(String s, Object aobj[])
    {
        s = String.valueOf(s);
        try
        {
            aobj = String.format(s, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            com.mopub.common.c.a.e((new StringBuilder("MoPub preconditions had a format exception: ")).append(((IllegalFormatException) (aobj)).getMessage()).toString());
            return s;
        }
        return ((String) (aobj));
    }

    public static void a(Object obj)
    {
        a(obj, true, "Object can not be null.", new Object[] {
            ""
        });
    }

    public static void a(Object obj, String s)
    {
        a(obj, true, s, new Object[] {
            ""
        });
    }

    public static void a(boolean flag)
    {
        a(flag, true, "Illegal argument.", new Object[] {
            ""
        });
    }

    static transient boolean a(Object obj, boolean flag, String s, Object aobj[])
    {
        if (obj != null)
        {
            return true;
        }
        obj = a(s, aobj);
        if (flag)
        {
            throw new NullPointerException(((String) (obj)));
        } else
        {
            com.mopub.common.c.a.e(((String) (obj)));
            return false;
        }
    }

    public static transient boolean a(boolean flag, String s, Object aobj[])
    {
        if (flag)
        {
            return true;
        } else
        {
            throw new IllegalStateException(a(s, aobj));
        }
    }

    public static transient boolean a(boolean flag, boolean flag1, String s, Object aobj[])
    {
        if (flag)
        {
            return true;
        }
        s = a(s, aobj);
        if (flag1)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            com.mopub.common.c.a.e(s);
            return false;
        }
    }

    public static void b(boolean flag)
    {
        a(flag, "Illegal state.", new Object[] {
            ""
        });
    }
}
