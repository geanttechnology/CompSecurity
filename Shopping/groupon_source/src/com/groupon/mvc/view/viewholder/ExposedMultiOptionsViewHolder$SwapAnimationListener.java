// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.groupon.callbacks.OnExposedOptionsEventListener;
import com.groupon.view.optioncards.CheckableOptionCardView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            ExposedMultiOptionsViewHolder

private class <init> extends AnimatorListenerAdapter
{

    final ExposedMultiOptionsViewHolder this$0;

    public void onAnimationEnd(Animator animator)
    {
        ExposedMultiOptionsViewHolder.access$602(ExposedMultiOptionsViewHolder.this, secondOptionView.getOptionId());
        animator = secondOptionView;
        secondOptionView = firstOptionView;
        firstOptionView = animator;
        if (callback != null)
        {
            ((OnExposedOptionsEventListener)callback).onOptionSelectionChange(ExposedMultiOptionsViewHolder.access$600(ExposedMultiOptionsViewHolder.this));
        }
        ExposedMultiOptionsViewHolder.access$300(ExposedMultiOptionsViewHolder.this);
        ExposedMultiOptionsViewHolder.access$700(ExposedMultiOptionsViewHolder.this);
    }

    public void onAnimationStart(Animator animator)
    {
        secondOptionView.setOnClickListener(null);
        secondOptionView.bringToFront();
    }

    private Y()
    {
        this$0 = ExposedMultiOptionsViewHolder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
