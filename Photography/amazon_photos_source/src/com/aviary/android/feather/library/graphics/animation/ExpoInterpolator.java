// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.animation;

import android.view.animation.Interpolator;

public class ExpoInterpolator
    implements Interpolator
{

    private EasingType.Type type;

    public ExpoInterpolator(EasingType.Type type1)
    {
        type = type1;
    }

    private float in(float f)
    {
        double d;
        if (f == 0.0F)
        {
            d = 0.0D;
        } else
        {
            d = Math.pow(2D, 10F * (f - 1.0F));
        }
        return (float)d;
    }

    private float inout(float f)
    {
        if (f == 0.0F)
        {
            return 0.0F;
        }
        if (f >= 1.0F)
        {
            return 1.0F;
        }
        f *= 2.0F;
        if (f < 1.0F)
        {
            return (float)(Math.pow(2D, 10F * (f - 1.0F)) * 0.5D);
        } else
        {
            return (float)((-Math.pow(2D, -10F * (f - 1.0F)) + 2D) * 0.5D);
        }
    }

    private float out(float f)
    {
        double d = 1.0D;
        if (f < 1.0F)
        {
            d = 1.0D + -Math.pow(2D, -10F * f);
        }
        return (float)d;
    }

    public float getInterpolation(float f)
    {
        if (type == EasingType.Type.IN)
        {
            return in(f);
        }
        if (type == EasingType.Type.OUT)
        {
            return out(f);
        }
        if (type == EasingType.Type.INOUT)
        {
            return inout(f);
        } else
        {
            return 0.0F;
        }
    }
}
