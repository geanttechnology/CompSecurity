// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.animator;

import android.animation.ValueAnimator;

// Referenced classes of package com.amazon.androidmotion.animator:
//            TranslationAnimator

class this._cls0
    implements com.amazon.androidmotion.lifecycle.dFractionCalculator
{

    final TranslationAnimator this$0;

    public float getElapsedFraction(ValueAnimator valueanimator)
    {
        return getFraction();
    }

    edFractionCalculator()
    {
        this$0 = TranslationAnimator.this;
        super();
    }
}
