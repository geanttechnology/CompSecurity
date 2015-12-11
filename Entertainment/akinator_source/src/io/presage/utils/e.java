// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.util.Log;

public final class e
{

    public static transient void a(String as[])
    {
        Log.d("PRESAGE", e(as));
    }

    public static transient void b(String as[])
    {
        Log.i("PRESAGE", e(as));
    }

    public static transient void c(String as[])
    {
        Log.w("PRESAGE", e(as));
    }

    public static transient void d(String as[])
    {
        Log.e("PRESAGE", e(as));
    }

    private static transient String e(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(as[i]);
            stringbuilder.append(" ");
        }

        return stringbuilder.toString();
    }
}
