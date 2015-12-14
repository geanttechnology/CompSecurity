// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.util;


public class MathUtil
{

    public static float clamp(float f, float f1, float f2)
    {
        return Math.min(f2, Math.max(f1, f));
    }
}
