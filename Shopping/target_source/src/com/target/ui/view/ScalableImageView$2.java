// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.view:
//            ScalableImageView

class er extends AnimatorListenerAdapter
{

    final ScalableImageView this$0;

    public void onAnimationEnd(Animator animator)
    {
        ScalableImageView.a(ScalableImageView.this, false);
        ScalableImageView.c(ScalableImageView.this);
    }

    public void onAnimationStart(Animator animator)
    {
        ScalableImageView.a(ScalableImageView.this, true);
    }

    er()
    {
        this$0 = ScalableImageView.this;
        super();
    }
}
