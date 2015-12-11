// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.b;

import android.util.Log;

public final class b
{

    public static int a = 48;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;

    public static void a()
    {
        int i = a;
        switch ((i * (i + 1)) % d)
        {
        default:
            a = 75;
            b = 9;
            // fall through

        case 0: // '\0'
            return;
        }
    }

    public static void a(String s, String s1)
    {
        Log.e(s, s1);
        switch (((c + 1) * 1) % d)
        {
        default:
            a = 1;
            b = 56;
            // fall through

        case 0: // '\0'
            return;
        }
    }
}
