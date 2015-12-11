// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.animation.ValueAnimator;
import android.graphics.Point;
import com.poshmark.ui.customviews.GestureView;

// Referenced classes of package com.poshmark.utils:
//            GestureViewUtils

class w
    implements android.animation.torUpdateListener
{

    final GestureViewUtils this$0;
    final GestureView val$v;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        valueanimator = (Point)valueanimator.getAnimatedValue();
        val$v.updateTranslation(valueanimator);
    }

    w()
    {
        this$0 = final_gestureviewutils;
        val$v = GestureView.this;
        super();
    }
}
