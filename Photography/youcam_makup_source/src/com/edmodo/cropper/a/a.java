// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.a;

import android.graphics.Rect;

public class a
{

    public static float a(float f, float f1, float f2)
    {
        return (f1 - f) * f2;
    }

    public static float a(float f, float f1, float f2, float f3)
    {
        return (f2 - f) / (f3 - f1);
    }

    public static float a(Rect rect)
    {
        return (float)rect.width() / (float)rect.height();
    }

    public static float b(float f, float f1, float f2)
    {
        return (f1 - f) / f2;
    }

    public static float b(float f, float f1, float f2, float f3)
    {
        return f1 - (f2 - f) * f3;
    }

    public static float c(float f, float f1, float f2, float f3)
    {
        return f2 - (f1 - f) / f3;
    }

    public static float d(float f, float f1, float f2, float f3)
    {
        return (f2 - f1) * f3 + f;
    }

    public static float e(float f, float f1, float f2, float f3)
    {
        return (f2 - f) / f3 + f1;
    }
}
