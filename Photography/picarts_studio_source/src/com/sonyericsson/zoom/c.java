// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sonyericsson.zoom;

import java.util.Observable;

public final class c extends Observable
{

    public float a;
    float b;
    float c;

    public c()
    {
    }

    public final float a(float f)
    {
        return Math.min(a, a * f);
    }

    public final float b(float f)
    {
        return Math.min(a, a / f);
    }

    public final void c(float f)
    {
        if (f != b)
        {
            b = f;
            setChanged();
        }
    }

    public final void d(float f)
    {
        if (f != c)
        {
            c = f;
            setChanged();
        }
    }

    public final void e(float f)
    {
        if (f != a)
        {
            a = f;
            setChanged();
        }
    }
}
