// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;


public final class j
{

    public static float a(float f, float f1, float f2)
    {
        float f3;
        if (f1 < f2)
        {
            f3 = f2;
            f2 = f1;
        } else
        {
            f3 = f1;
        }
        return Math.min(Math.max(f, f2), f3);
    }
}
