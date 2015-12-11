// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package at.markushi.ui;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package at.markushi.ui:
//            RevealColorView

final class a
    implements android.animation.istener
{

    final android.animation.istener a;
    final RevealColorView b;

    public final void onAnimationCancel(Animator animator)
    {
        if (a != null)
        {
            a.onAnimationCancel(animator);
        }
    }

    public final void onAnimationEnd(Animator animator)
    {
        RevealColorView.a(b).setVisibility(4);
        if (a != null)
        {
            a.onAnimationEnd(animator);
        }
    }

    public final void onAnimationRepeat(Animator animator)
    {
        if (a != null)
        {
            a.onAnimationRepeat(animator);
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        if (a != null)
        {
            a.onAnimationStart(animator);
        }
    }

    orListener(RevealColorView revealcolorview, android.animation.istener istener)
    {
        b = revealcolorview;
        a = istener;
        super();
    }
}
