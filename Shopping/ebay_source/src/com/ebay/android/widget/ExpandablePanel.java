// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ExpandablePanel extends LinearLayout
{
    private class DefaultOnExpandListener
        implements OnExpandListener
    {

        final ExpandablePanel this$0;

        public void onCollapse(View view, View view1)
        {
        }

        public void onExpand(View view, View view1)
        {
        }

        private DefaultOnExpandListener()
        {
            this$0 = ExpandablePanel.this;
            super();
        }

    }

    private class ExpandAnimation extends Animation
    {

        private final int mDeltaHeight;
        private final int mStartHeight;
        final ExpandablePanel this$0;

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

        public ExpandAnimation(int i, int j)
        {
            this$0 = ExpandablePanel.this;
            super();
            mStartHeight = i;
            mDeltaHeight = j - i;
        }
    }

    public static interface OnExpandListener
    {

        public abstract void onCollapse(View view, View view1);

        public abstract void onExpand(View view, View view1);
    }

    private class PanelToggler
        implements android.view.View.OnClickListener
    {

        final ExpandablePanel this$0;

        public void onClick(View view)
        {
            boolean flag1 = true;
            boolean flag;
            if (view.getId() == mHandle.getId())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return;
            }
            if (mExpanded)
            {
                view = new ExpandAnimation(mContentHeight, mCollapsedHeight);
                mListener.onCollapse(mHandle, mContent);
                mHandle.setImageResource(0x7f020252);
            } else
            {
                view = new ExpandAnimation(mCollapsedHeight, mContentHeight);
                mListener.onExpand(mHandle, mContent);
                mHandle.setImageResource(0x7f020256);
            }
            if (view != null)
            {
                view.setDuration(mAnimationDuration);
                mContent.startAnimation(view);
            }
            view = ExpandablePanel.this;
            if (mExpanded)
            {
                flag1 = false;
            }
            view.mExpanded = flag1;
        }

        private PanelToggler()
        {
            this$0 = ExpandablePanel.this;
            super();
        }

    }


    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ExpandablePanel", 3, "Expandable panel");
    private int mAnimationDuration;
    private int mCollapsedHeight;
    private View mContent;
    private int mContentHeight;
    private final int mContentId;
    private boolean mExpanded;
    private ImageView mHandle;
    private final int mHandleId;
    private OnExpandListener mListener;

    public ExpandablePanel(Context context)
    {
        this(context, null);
    }

    public ExpandablePanel(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mExpanded = false;
        mCollapsedHeight = 0;
        mContentHeight = 0;
        mAnimationDuration = 0;
        mListener = new DefaultOnExpandListener();
        context = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.ExpandablePanel, 0, 0);
        mCollapsedHeight = (int)context.getDimension(2, 0.0F);
        mAnimationDuration = context.getInteger(3, 500);
        int i = context.getResourceId(0, 0);
        if (i == 0)
        {
            throw new IllegalArgumentException("The openCloseActionId attribute is required and must refer to a valid child.");
        }
        int j = context.getResourceId(1, 0);
        if (j == 0)
        {
            throw new IllegalArgumentException("The contentToMeasureId attribute is required and must refer to a valid child.");
        } else
        {
            mHandleId = i;
            mContentId = j;
            context.recycle();
            return;
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mHandle = (ImageView)findViewById(mHandleId);
        if (mHandle == null)
        {
            throw new IllegalArgumentException("The handle attribute is must refer to an existing child.");
        }
        mContent = findViewById(mContentId);
        if (mContent == null)
        {
            throw new IllegalArgumentException("The content attribute must refer to an existing child.");
        } else
        {
            android.view.ViewGroup.LayoutParams layoutparams = mContent.getLayoutParams();
            layoutparams.height = mCollapsedHeight;
            mContent.setLayoutParams(layoutparams);
            mHandle.setOnClickListener(new PanelToggler());
            setOnClickListener(new PanelToggler());
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        mContent.measure(0, 0);
        mContentHeight = mContent.getMeasuredHeight();
        if (logTag.isLoggable)
        {
            logTag.log((new StringBuilder()).append("cHeight=").append(mContentHeight).toString());
            logTag.log((new StringBuilder()).append("cCollapseHeight=").append(mCollapsedHeight).toString());
        }
        if (mContentHeight < mCollapsedHeight)
        {
            mHandle.setVisibility(8);
        } else
        {
            mHandle.setVisibility(0);
        }
        super.onMeasure(i, j);
    }

    public void setAnimationDuration(int i)
    {
        mAnimationDuration = i;
    }

    public void setCollapsedHeight(int i)
    {
        mCollapsedHeight = i;
    }

    public void setOnExpandListener(OnExpandListener onexpandlistener)
    {
        mListener = onexpandlistener;
    }





/*
    static boolean access$302(ExpandablePanel expandablepanel, boolean flag)
    {
        expandablepanel.mExpanded = flag;
        return flag;
    }

*/





}
