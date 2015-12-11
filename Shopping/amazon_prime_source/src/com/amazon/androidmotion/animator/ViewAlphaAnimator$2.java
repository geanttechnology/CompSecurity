// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.animator;

import android.animation.ValueAnimator;

// Referenced classes of package com.amazon.androidmotion.animator:
//            ViewAlphaAnimator

class this._cls0
    implements android.animation.orUpdateListener
{

    final ViewAlphaAnimator this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        setAlpha(f);
    }

    ()
    {
        this$0 = ViewAlphaAnimator.this;
        super();
    }
}
