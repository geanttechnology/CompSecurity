// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;

// Referenced classes of package com.tapjoy:
//            TJCloseButton

final class a
    implements Runnable
{

    final TJCloseButton a;

    public final void run()
    {
        a.animate().alpha(1.0F).setDuration(500L).setListener(new android.animation.Animator.AnimatorListener() {

            final TJCloseButton._cls1 a;

            public final void onAnimationCancel(Animator animator)
            {
                a.a.setClickable(true);
            }

            public final void onAnimationEnd(Animator animator)
            {
                a.a.setClickable(true);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
            }

            
            {
                a = TJCloseButton._cls1.this;
                super();
            }
        });
    }

    _cls1.a(TJCloseButton tjclosebutton)
    {
        a = tjclosebutton;
        super();
    }
}
