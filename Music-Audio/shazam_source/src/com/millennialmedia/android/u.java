// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


final class u
{

    int a;
    int b;
    String c;
    int d;
    int e;
    boolean f;
    int g;
    int h;

    u(float f1, int i, int j, String s, int k, int l, boolean flag, 
            int i1, int j1)
    {
        a = (int)((float)i * f1);
        b = (int)((float)j * f1);
        c = s;
        d = (int)((float)k * f1);
        e = (int)((float)l * f1);
        f = flag;
        g = i1;
        h = j1;
    }

    public final String toString()
    {
        return String.format("width[%d] height[%d] offsetX[%d] offsetY[%d] allowOffScreen[%b] customClosePosition[%s] maxX[%d] maxY[%d]", new Object[] {
            Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(d), Integer.valueOf(e), Boolean.valueOf(f), c, Integer.valueOf(g), Integer.valueOf(h)
        });
    }
}
