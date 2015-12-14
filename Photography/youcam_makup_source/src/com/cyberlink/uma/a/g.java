// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import java.util.Locale;
import java.util.TimeZone;

final class g
{

    private final long a = System.currentTimeMillis();
    private final long b;

    g()
    {
        b = TimeZone.getDefault().getOffset(a);
    }

    static String a(long l)
    {
        char c;
        int i;
        int j;
        if (l >= 0L)
        {
            c = '+';
        } else
        {
            c = '-';
        }
        i = (int)(Math.abs(l) / 1000L / 60L);
        j = i / 60;
        return String.format(Locale.US, "%c%02d%02d", new Object[] {
            Character.valueOf(c), Integer.valueOf(j), Integer.valueOf(i % 60)
        });
    }

    int a()
    {
        return (int)(a / 1000L);
    }

    String b()
    {
        return a(b);
    }
}
