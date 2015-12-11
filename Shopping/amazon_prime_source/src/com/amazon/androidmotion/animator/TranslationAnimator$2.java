// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.animator;

import android.animation.ValueAnimator;
import android.view.View;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.androidmotion.animator:
//            TranslationAnimator

class val.finishY
    implements android.animation.UpdateListener
{

    final TranslationAnimator this$0;
    final int val$finishX;
    final int val$finishY;
    final int val$startX;
    final int val$startY;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        int i = Math.round((float)val$startX + (float)(val$finishX - val$startX) * f);
        int j = Math.round((float)val$startY + (float)(val$finishY - val$startY) * f);
        View view;
        for (valueanimator = TranslationAnimator.access$000(TranslationAnimator.this).iterator(); valueanimator.hasNext(); view.setTranslationY(j))
        {
            view = (View)valueanimator.next();
            view.setTranslationX(i);
        }

    }

    ()
    {
        this$0 = final_translationanimator;
        val$startX = i;
        val$finishX = j;
        val$startY = k;
        val$finishY = I.this;
        super();
    }
}
