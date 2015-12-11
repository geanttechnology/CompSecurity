// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.ValueAnimator;
import android.graphics.RectF;

// Referenced classes of package com.wishabi.flipp.widget:
//            FlyerViewGroup, dw, bt

final class bs
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final RectF a;
    final float b;
    final FlyerViewGroup c;

    bs(FlyerViewGroup flyerviewgroup, RectF rectf, float f)
    {
        c = flyerviewgroup;
        a = rectf;
        b = f;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        if (valueanimator.getAnimatedFraction() >= 1.0F)
        {
            FlyerViewGroup.b(c).setZooming(false);
            c.scrollTo((int)a.left, (int)a.top);
            c.setZoomScale(b);
            if (FlyerViewGroup.e(c) != null)
            {
                FlyerViewGroup.e(c).a(c);
            }
        } else
        {
            valueanimator = (RectF)valueanimator.getAnimatedValue();
            if (valueanimator != null)
            {
                c.scrollTo((int)((RectF) (valueanimator)).left, (int)((RectF) (valueanimator)).top);
                c.setZoomScale(Math.max((float)c.getWidth() / valueanimator.width(), (float)c.getHeight() / valueanimator.height()));
                if (FlyerViewGroup.e(c) != null)
                {
                    FlyerViewGroup.e(c).a(c);
                    return;
                }
            }
        }
    }
}
