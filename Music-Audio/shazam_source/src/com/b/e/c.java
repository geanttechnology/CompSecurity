// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import android.util.Log;

// Referenced classes of package com.b.e:
//            g

public final class c
{

    public static void a(Class class1)
    {
        if (g.a)
        {
            class1.getSimpleName();
        }
    }

    public static void a(Class class1, String s)
    {
        if (g.a)
        {
            Log.e(class1.getSimpleName(), s);
        }
    }

    public static void a(Exception exception)
    {
        if (g.a)
        {
            exception.printStackTrace();
        }
    }

    public static void a(Object obj)
    {
        if (g.a)
        {
            a(obj.getClass());
        }
    }

    public static void a(Object obj, String s)
    {
        if (g.a)
        {
            a(obj.getClass(), s);
        }
    }
}
