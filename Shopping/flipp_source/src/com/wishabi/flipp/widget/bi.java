// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.graphics.RectF;

public final class bi
{

    public final RectF a;
    public final float b;
    public final Object c;
    public final int d;
    private final String e;

    public bi(float f, float f1, float f2, float f3)
    {
        this(f, f1, f2, f3, 0.0F, null, null, 1);
    }

    public bi(float f, float f1, float f2, float f3, float f4, String s, Object obj, 
            int i)
    {
        a = new RectF(f, f1, f2, f3);
        b = f4;
        e = s;
        c = obj;
        d = i;
    }

    public final RectF a(boolean flag)
    {
        if (flag)
        {
            return new RectF(a);
        } else
        {
            return a;
        }
    }

    public final boolean a(float f, float f1)
    {
        return a.contains(f, f1);
    }
}
