// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.animation;

import android.view.animation.Interpolator;

public class QuadInterpolator
    implements Interpolator
{

    private EasingType.Type type;

    public QuadInterpolator(EasingType.Type type1)
    {
        type = type1;
    }

    private float in(float f)
    {
        return f * f;
    }

    private float inout(float f)
    {
        f *= 2.0F;
        if (f < 1.0F)
        {
            return 0.5F * f * f;
        } else
        {
            f--;
            return -0.5F * ((f - 2.0F) * f - 1.0F);
        }
    }

    private float out(float f)
    {
        return -f * (f - 2.0F);
    }

    public float getInterpolation(float f)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$library$graphics$animation$EasingType$Type[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$library$graphics$animation$EasingType$Type = new int[EasingType.Type.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$graphics$animation$EasingType$Type[EasingType.Type.IN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$graphics$animation$EasingType$Type[EasingType.Type.OUT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$graphics$animation$EasingType$Type[EasingType.Type.INOUT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.aviary.android.feather.library.graphics.animation.EasingType.Type[type.ordinal()])
        {
        default:
            return (f / 1.0F) * (f - 2.0F);

        case 1: // '\001'
            return in(f);

        case 2: // '\002'
            return out(f);

        case 3: // '\003'
            return inout(f);
        }
    }
}
