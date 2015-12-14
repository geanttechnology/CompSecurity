// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            o

final class a
    implements android.animation.ator.AnimatorListener
{

    private o a;

    public final void onAnimationCancel(Animator animator)
    {
    }

    public final void onAnimationEnd(Animator animator)
    {
        if (o.c(a) != null && !o.c(a).isRecycled() && a.a.getVisibility() != 0)
        {
            a.a.setAlpha(0.0F);
            a.a.animate().setDuration(300L).setListener(null).alpha(1.0F);
            a.a.setVisibility(0);
        }
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
    }

    r(o o1)
    {
        a = o1;
        super();
    }
}
