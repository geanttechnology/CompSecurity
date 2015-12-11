// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

public class ExpandablePanel extends LinearLayout
{
    private static class ExpandAnimation extends Animation
    {

        private final View mContent;
        private final int mDeltaHeight;
        private final int mStartHeight;

        protected void applyTransformation(float f, Transformation transformation)
        {
            transformation = mContent.getLayoutParams();
            transformation.height = (int)((float)mStartHeight + (float)mDeltaHeight * f);
            mContent.setLayoutParams(transformation);
        }

        public boolean willChangeBounds()
        {
            return true;
        }

        public ExpandAnimation(int i, int j, View view)
        {
            mStartHeight = i;
            mDeltaHeight = j - i;
            mContent = view;
        }
    }

    public static interface OnExpandListener
    {

        public abstract void onCollapse(View view, View view1);

        public abstract void onExpand(View view, View view1);
    }

    protected class OnExpandablePanelGlobalLayoutListener
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        final ExpandablePanel this$0;

        public void onGlobalLayout()
        {
            updatePanelState(true, false);
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        protected OnExpandablePanelGlobalLayoutListener()
        {
            this$0 = ExpandablePanel.this;
            super();
        }
    }

    private class PanelOnClickListener
        implements android.view.View.OnClickListener
    {

        final ExpandablePanel this$0;

        public void onClick(View view)
        {
            view = ExpandablePanel.this;
            boolean flag;
            if (!expanded)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.updatePanelState(flag, true);
        }

        private PanelOnClickListener()
        {
            this$0 = ExpandablePanel.this;
            super();
        }

    }


    protected static final int DEFAULT_ANIMATION_DURATION = 500;
    protected static final int DEFAULT_COLLAPSED_HEIGHT = 150;
    protected int animationDuration;
    private int collapsedHeight;
    private int contentHeight;
    private int contentId;
    protected View contentView;
    private boolean expanded;
    private int handleId;
    protected View handleView;
    private OnExpandListener listener;
    protected boolean shouldExpandAfterLayout;

    public ExpandablePanel(Context context)
    {
        this(context, null);
    }

    public ExpandablePanel(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        expanded = true;
        collapsedHeight = 0;
        contentHeight = 0;
        animationDuration = 0;
        init(context, attributeset);
    }

    public void expandAfterLayout()
    {
        if (getVisibility() == 0)
        {
            getViewTreeObserver().addOnGlobalLayoutListener(new OnExpandablePanelGlobalLayoutListener());
            return;
        } else
        {
            shouldExpandAfterLayout = true;
            return;
        }
    }

    protected void init(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.ExpandablePanel, 0, 0);
        collapsedHeight = (int)context.getDimension(2, 150F);
        animationDuration = context.getInteger(3, 500);
        int i = context.getResourceId(0, 0);
        if (i == 0)
        {
            throw new IllegalArgumentException("The handleView attribute is required and must refer to a valid child.");
        }
        int j = context.getResourceId(1, 0);
        if (j == 0)
        {
            throw new IllegalArgumentException("The content attribute is required and must refer to a valid child.");
        } else
        {
            handleId = i;
            contentId = j;
            context.recycle();
            return;
        }
    }

    public boolean isExpanded()
    {
        return expanded;
    }

    public boolean isExpanding()
    {
        return contentView.getAnimation() != null;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        if (handleView == null)
        {
            handleView = findViewById(handleId);
            if (handleView == null)
            {
                throw new IllegalArgumentException("The handleView attribute is must refer to an existing child.");
            }
        }
        if (contentView == null)
        {
            contentView = findViewById(contentId);
            if (contentView == null)
            {
                throw new IllegalArgumentException("The content attribute must refer to an existing child.");
            }
        }
        handleView.setOnClickListener(new PanelOnClickListener());
    }

    protected void onMeasure(int i, int j)
    {
        contentView.measure(i, 0);
        contentHeight = contentView.getMeasuredHeight();
        if (contentHeight < collapsedHeight)
        {
            handleView.setVisibility(8);
        } else
        {
            handleView.setVisibility(0);
        }
        super.onMeasure(i, j);
    }

    public void setAnimationDuration(int i)
    {
        animationDuration = i;
    }

    public void setCollapsedHeight(int i)
    {
        collapsedHeight = i;
    }

    public void setOnExpandListener(OnExpandListener onexpandlistener)
    {
        listener = onexpandlistener;
    }

    public void updatePanelState(boolean flag, boolean flag1)
    {
        if (expanded == flag)
        {
            return;
        }
        expanded = flag;
        if (!flag1) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        ExpandAnimation expandanimation;
        ExpandAnimation expandanimation1 = new ExpandAnimation(collapsedHeight, contentHeight, contentView);
        expandanimation = expandanimation1;
        if (listener != null)
        {
            listener.onExpand(handleView, contentView);
            expandanimation = expandanimation1;
        }
_L5:
        expandanimation.setDuration(animationDuration);
        contentView.startAnimation(expandanimation);
        return;
_L4:
        ExpandAnimation expandanimation2 = new ExpandAnimation(contentHeight, collapsedHeight, contentView);
        expandanimation = expandanimation2;
        if (listener != null)
        {
            listener.onCollapse(handleView, contentView);
            expandanimation = expandanimation2;
        }
        if (true) goto _L5; else goto _L2
_L2:
        android.view.ViewGroup.LayoutParams layoutparams = contentView.getLayoutParams();
        int i;
        if (flag)
        {
            i = contentHeight;
        } else
        {
            i = collapsedHeight;
        }
        layoutparams.height = i;
        contentView.setLayoutParams(layoutparams);
        return;
    }

}
