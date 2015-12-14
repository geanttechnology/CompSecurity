// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.animation.Animator;
import android.graphics.RectF;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.brushlib.controller:
//            d

final class a
    implements android.animation.ator.AnimatorListener
{

    private d a;

    public final void onAnimationCancel(Animator animator)
    {
    }

    public final void onAnimationEnd(Animator animator)
    {
        a.e.set(((a) (a)).a.getTransformedBounds(true));
        a.e.roundOut(a.d);
        ((a) (a)).a.getTransform().setScale(1.0F);
        a.b.invalidate(a.d);
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
        a.e.set(((a) (a)).a.getTransformedBounds(true));
        a.e.roundOut(a.d);
        ((a) (a)).a.getTransform().setScale(0.0F);
        a.b.invalidate(a.d);
    }

    w(d d1)
    {
        a = d1;
        super();
    }
}
