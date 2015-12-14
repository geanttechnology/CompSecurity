// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.foundationtouchview;

import android.animation.ValueAnimator;
import android.graphics.RectF;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.foundationtouchview:
//            FoundationView

class a
    implements android.animation.matorUpdateListener
{

    final FoundationView a;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        valueanimator = (Float)valueanimator.getAnimatedValue();
        float f = ((1.0F - valueanimator.floatValue()) * (float)FoundationView.d(a)) / 2.0F;
        float f1 = ((1.0F - valueanimator.floatValue()) * (float)FoundationView.e(a)) / 2.0F;
        FoundationView.f(a).left = f + FoundationView.g(a).left;
        FoundationView.f(a).top = f1 + FoundationView.g(a).top;
        FoundationView.f(a).right = FoundationView.f(a).left + (float)FoundationView.d(a) * valueanimator.floatValue();
        RectF rectf = FoundationView.f(a);
        f = FoundationView.f(a).top;
        f1 = FoundationView.e(a);
        rectf.bottom = valueanimator.floatValue() * f1 + f;
        a.invalidate();
    }

    (FoundationView foundationview)
    {
        a = foundationview;
        super();
    }
}
