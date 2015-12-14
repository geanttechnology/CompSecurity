// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fullscreenad;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import jh;

// Referenced classes of package com.fotoable.fullscreenad:
//            FullScreenAdView

class b
    implements android.animation.stener
{

    final View a;
    final ViewGroup b;
    final FullScreenAdView c;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        try
        {
            a.setAlpha(1.0F);
        }
        // Misplaced declaration of an exception variable
        catch (Animator animator)
        {
            animator.printStackTrace();
        }
        b.removeView(a);
        if (FullScreenAdView.access$600(c) != null)
        {
            FullScreenAdView.access$600(c).a();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    (FullScreenAdView fullscreenadview, View view, ViewGroup viewgroup)
    {
        c = fullscreenadview;
        a = view;
        b = viewgroup;
        super();
    }
}
