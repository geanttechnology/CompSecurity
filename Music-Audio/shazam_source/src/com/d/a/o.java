// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.util.Log;

final class o
{

    private static boolean a = false;
    private static int b = 5;

    static int a(String s, String s1)
    {
        if (a || b <= 6)
        {
            return 0;
        } else
        {
            return Log.e(s, s1);
        }
    }

    static int a(String s, String s1, Throwable throwable)
    {
        if (a || b <= 6)
        {
            return 0;
        } else
        {
            return Log.e(s, s1, throwable);
        }
    }

}
