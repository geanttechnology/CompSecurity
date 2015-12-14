// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.View;
import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            HighlightView

class val.parent
    implements com.nineoldandroids.animation.rListener
{

    final HighlightView this$0;
    final boolean val$maintainAspectRatio;
    final View val$parent;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        HighlightView.access$102(HighlightView.this, val$maintainAspectRatio);
        mRunning = false;
        invalidate();
        if (val$parent != null)
        {
            val$parent.postInvalidate();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    r()
    {
        this$0 = final_highlightview;
        val$maintainAspectRatio = flag;
        val$parent = View.this;
        super();
    }
}
