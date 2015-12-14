// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import java.util.Random;

public final class h
{

    private static final float a[];
    private int b;
    private float c;
    private float d;

    public h()
    {
        a(0);
        a(0.0F, 1.0F);
    }

    public h(float f, float f1)
    {
        a(0);
        a(f, f1);
    }

    public final void a(float f, float f1)
    {
        c = f;
        d = f1;
    }

    public final void a(int i)
    {
        int j = Math.abs(i);
        i = j;
        if (j > 0x1fffffff)
        {
            i = j / 2;
        }
        b = (i * 2 + 1) % 2048;
    }

    public final float b(int i)
    {
        i = Math.abs(i);
        float f = a[(i * b) % 2048];
        float f1 = c;
        return f * (d - c) + f1;
    }

    static 
    {
        a = new float[2048];
        Random random = new Random(0L);
        for (int i = 0; i < 2048; i++)
        {
            a[i] = random.nextFloat();
        }

    }
}
