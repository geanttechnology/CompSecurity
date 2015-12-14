// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.brushlib.controller:
//            h

final class a
    implements android.animation.eAnimator.AnimatorUpdateListener
{

    private h a;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.a.c.b.a.set((Matrix)valueanimator.getAnimatedValue());
        a.a.a(true);
    }

    w(h h1)
    {
        a = h1;
        super();
    }
}
