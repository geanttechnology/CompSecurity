// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.animator;

import android.animation.ValueAnimator;
import android.widget.ImageView;

// Referenced classes of package com.amazon.androidmotion.animator:
//            ImageViewAlphaAnimator

class this._cls0
    implements android.animation.ateListener
{

    final ImageViewAlphaAnimator this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        int i = ((Integer)valueanimator.getAnimatedValue()).intValue();
        setAlpha(i);
        if (i == 0)
        {
            ImageViewAlphaAnimator.access$000(ImageViewAlphaAnimator.this).setVisibility(4);
            return;
        } else
        {
            ImageViewAlphaAnimator.access$000(ImageViewAlphaAnimator.this).setVisibility(0);
            return;
        }
    }

    ()
    {
        this$0 = ImageViewAlphaAnimator.this;
        super();
    }
}
