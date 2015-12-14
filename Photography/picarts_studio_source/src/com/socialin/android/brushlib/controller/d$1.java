// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.animation.ValueAnimator;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.brushlib.controller:
//            d

final class a
    implements android.animation.eAnimator.AnimatorUpdateListener
{

    private d a;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        ((a) (a)).a.getTransform().setScale(((Float)valueanimator.getAnimatedValue()).floatValue());
        a.b.invalidate(a.d);
    }

    w(d d1)
    {
        a = d1;
        super();
    }
}
