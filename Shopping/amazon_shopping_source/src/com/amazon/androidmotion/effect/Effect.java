// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.effect;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public interface Effect
{

    public abstract float getFraction(ValueAnimator valueanimator);

    public abstract TimeInterpolator getInterpolator();

    public abstract void update(float f);
}
