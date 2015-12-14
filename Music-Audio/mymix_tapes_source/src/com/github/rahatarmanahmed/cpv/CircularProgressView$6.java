// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.rahatarmanahmed.cpv;

import android.animation.ValueAnimator;

// Referenced classes of package com.github.rahatarmanahmed.cpv:
//            CircularProgressView

class this._cls0
    implements android.animation.pdateListener
{

    final CircularProgressView this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        CircularProgressView.access$302(CircularProgressView.this, ((Float)valueanimator.getAnimatedValue()).floatValue());
        invalidate();
    }

    ()
    {
        this$0 = CircularProgressView.this;
        super();
    }
}
