// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.effect;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

// Referenced classes of package com.amazon.androidmotion.effect:
//            EffectManager, Effect

private class <init>
    implements android.animation.istener
{

    final EffectManager this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = EffectManager.access$200(EffectManager.this).getFraction(EffectManager.access$100(EffectManager.this));
        TimeInterpolator timeinterpolator = EffectManager.access$200(EffectManager.this).getInterpolator();
        valueanimator = timeinterpolator;
        if (timeinterpolator == null)
        {
            valueanimator = EffectManager.DEFAULT_INTERPOLATOR;
        }
        f = valueanimator.getInterpolation(f);
        EffectManager.access$200(EffectManager.this).update(f);
    }

    private ()
    {
        this$0 = EffectManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
