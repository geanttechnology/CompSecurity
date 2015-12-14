// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clone;

import android.graphics.BlurMaskFilter;

public final class b
{

    public int a;
    public int b;
    private int c;
    private int d;
    private float e;
    private int f;

    public b(b b1)
    {
        a = b1.a;
        b = b1.b;
        e = 100F - (100F - b1.e);
        f = b1.f;
        c = b1.c;
        d = b1.d;
    }

    public final BlurMaskFilter a(float f1)
    {
        BlurMaskFilter blurmaskfilter = null;
        if (e > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter((e * f1) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        return blurmaskfilter;
    }
}
