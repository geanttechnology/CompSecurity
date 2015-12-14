// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.supertooltips;

import android.view.ViewManager;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.supertooltips:
//            ToolTipView

private class <init> extends AnimatorListenerAdapter
{

    final ToolTipView this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (getParent() != null)
        {
            ((ViewManager)getParent()).removeView(ToolTipView.this);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    private ()
    {
        this$0 = ToolTipView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
