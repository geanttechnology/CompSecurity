// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.ValueAnimator;

// Referenced classes of package com.picsart.studio.editor.view:
//            PerspectiveView, RulerView

public final class a
    implements android.animation.atorUpdateListener
{

    private PerspectiveView a;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        if (PerspectiveView.a(a) == rspectiveMode.HORIZONTAL)
        {
            a.setHorizontalPerspective(((Float)valueanimator.getAnimatedValue()).floatValue());
            PerspectiveView.c(a).setProgress(PerspectiveView.b(a));
            return;
        } else
        {
            a.setVerticalPerspective(((Float)valueanimator.getAnimatedValue()).floatValue());
            PerspectiveView.c(a).setProgress(PerspectiveView.d(a));
            return;
        }
    }

    public rspectiveMode(PerspectiveView perspectiveview)
    {
        a = perspectiveview;
        super();
    }
}
