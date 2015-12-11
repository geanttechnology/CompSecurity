// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.amazon.retailsearch.android.ui.animations.AnimatableResultsImage;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackView

public class StackViewContainer extends FrameLayout
{

    private AnimatableResultsImage animatableResultsImage;
    private StackView attachedStackView;

    public StackViewContainer(Context context)
    {
        super(context);
    }

    public StackViewContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void attachStackView(StackView stackview)
    {
        if (stackview == null || stackview.getView() == null)
        {
            return;
        } else
        {
            attachedStackView = stackview;
            addView(stackview.getView(), 0);
            return;
        }
    }

    public void detachStackView(StackView stackview)
    {
        if (stackview == null || stackview.getParent() != this || stackview.getView() == null)
        {
            return;
        } else
        {
            removeView(stackview.getView());
            return;
        }
    }

    public AnimatableResultsImage getAnimatableResultsImage()
    {
        return animatableResultsImage;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        animatableResultsImage = (AnimatableResultsImage)findViewById(com.amazon.retailsearch.R.id.rs_animatable_results_image);
        if (animatableResultsImage != null)
        {
            animatableResultsImage.setParentView(this);
        }
    }
}
