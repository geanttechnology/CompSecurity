// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;

import com.nineoldandroids.animation.Animator;

// Referenced classes of package it.sephiroth.android.library.tooltip:
//            TooltipView

class val.remove
    implements com.nineoldandroids.animation.torListener
{

    boolean cancelled;
    final TooltipView this$0;
    final boolean val$remove;

    public void onAnimationCancel(Animator animator)
    {
        cancelled = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        if (cancelled)
        {
            return;
        }
        if (val$remove)
        {
            TooltipView.access$400(TooltipView.this);
        }
        mShowAnimation = null;
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        cancelled = false;
    }

    ener()
    {
        this$0 = final_tooltipview;
        val$remove = Z.this;
        super();
    }
}
