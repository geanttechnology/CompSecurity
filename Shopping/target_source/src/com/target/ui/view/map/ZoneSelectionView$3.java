// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.view.map:
//            ZoneSelectionView

class init> extends AnimatorListenerAdapter
{

    final ZoneSelectionView this$0;

    public void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        animator = ZoneSelectionView.this;
        boolean flag;
        if (!ZoneSelectionView.b(ZoneSelectionView.this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ZoneSelectionView.a(animator, flag);
        ZoneSelectionView.b(ZoneSelectionView.this, false);
    }

    public void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        ZoneSelectionView.b(ZoneSelectionView.this, true);
    }

    ()
    {
        this$0 = ZoneSelectionView.this;
        super();
    }
}
