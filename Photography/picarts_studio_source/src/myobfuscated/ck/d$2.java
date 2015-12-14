// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;

// Referenced classes of package myobfuscated.ck:
//            d

final class it>
    implements android.animation.ator.AnimatorListener
{

    private d a;

    public final void onAnimationCancel(Animator animator)
    {
    }

    public final void onAnimationEnd(Animator animator)
    {
        if (d.c(a) != null && !d.c(a).isRecycled() && a.f.getVisibility() != 0)
        {
            a.f.setAlpha(0.0F);
            a.f.animate().setDuration(300L).setListener(null).alpha(1.0F);
            a.f.setVisibility(0);
        }
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
    }

    imator(d d1)
    {
        a = d1;
        super();
    }
}
