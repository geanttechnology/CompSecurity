// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;

import com.nineoldandroids.animation.Animator;

// Referenced classes of package it.sephiroth.android.library.tooltip:
//            TooltipView

class this._cls0
    implements com.nineoldandroids.animation.torListener
{

    boolean cancelled;
    final TooltipView this$0;

    public void onAnimationCancel(Animator animator)
    {
        cancelled = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        if (TooltipView.access$000(TooltipView.this) != null && !cancelled)
        {
            TooltipView.access$000(TooltipView.this).onShowCompleted(TooltipView.this);
            postActivate(TooltipView.access$100(TooltipView.this));
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        setVisibility(0);
        cancelled = false;
    }

    ToolTipListener()
    {
        this$0 = TooltipView.this;
        super();
    }
}
