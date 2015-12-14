// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import java.util.Locale;

public class q
{

    public final int a;
    public final int b;

    public q(int i, int j)
    {
        a = i;
        b = j;
    }

    public String toString()
    {
        return String.format(Locale.ENGLISH, "%d, %d", new Object[] {
            Integer.valueOf(a), Integer.valueOf(b)
        });
    }
}
