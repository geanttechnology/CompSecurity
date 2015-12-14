// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.socialin.android.util.ag;

// Referenced classes of package com.picsart.studio.editor.view:
//            PerspectiveView

public final class a extends ag
{

    private Runnable a;
    private PerspectiveView b;

    public final void onAnimationCancel(Animator animator)
    {
        super.onAnimationCancel(animator);
        PerspectiveView.a(b, false);
    }

    public final void onAnimationEnd(Animator animator)
    {
        PerspectiveView.a(b, false);
        PerspectiveView.e(b).removeAllListeners();
        PerspectiveView.e(b).removeAllUpdateListeners();
        PerspectiveView.f(b);
        if (a != null)
        {
            a.run();
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        PerspectiveView.a(b, true);
    }

    public (PerspectiveView perspectiveview, Runnable runnable)
    {
        b = perspectiveview;
        a = null;
        super();
    }
}
