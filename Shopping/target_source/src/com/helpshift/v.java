// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Context;

public class v
{

    private static Context a;
    private static String b;

    public static Context a()
    {
        return a;
    }

    public static void a(Context context)
    {
        a = context;
    }

    public static void a(String s)
    {
        b = s;
    }

    public static String b()
    {
        return b;
    }
}
