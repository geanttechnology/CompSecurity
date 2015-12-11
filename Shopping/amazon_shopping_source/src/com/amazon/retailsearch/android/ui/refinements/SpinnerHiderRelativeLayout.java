// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.amazon.androidmotion.animator.ViewAlphaAnimator;

public class SpinnerHiderRelativeLayout extends RelativeLayout
{

    public static final long DEFAULT_APPEAR_DURATION = 175L;
    public static final float DEFAULT_OVERLAY_ALPHA = 0.75F;
    public static final int DEFAULT_OVERLAY_COLOR = Color.parseColor("#F2F3F4");
    private long mAppearDuration;
    private View mOverlay;
    private float mOverlayAlpha;
    private int mOverlayColor;
    private ViewAlphaAnimator mOverlayVisibility;
    private ProgressBar mSpinner;
    private ViewAlphaAnimator mSpinnerVisibility;
    private boolean useAnimation;

    public SpinnerHiderRelativeLayout(Context context)
    {
        super(context);
        mOverlayColor = DEFAULT_OVERLAY_COLOR;
        mOverlayAlpha = 0.75F;
        mAppearDuration = 175L;
        useAnimation = false;
        init(context);
    }

    public SpinnerHiderRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mOverlayColor = DEFAULT_OVERLAY_COLOR;
        mOverlayAlpha = 0.75F;
        mAppearDuration = 175L;
        useAnimation = false;
        init(context);
    }

    public SpinnerHiderRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mOverlayColor = DEFAULT_OVERLAY_COLOR;
        mOverlayAlpha = 0.75F;
        mAppearDuration = 175L;
        useAnimation = false;
        init(context);
    }

    private void init(Context context)
    {
        mOverlay = new View(context);
        mOverlay.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        mOverlay.setBackgroundColor(mOverlayColor);
        mOverlay.setOnTouchListener(new android.view.View.OnTouchListener() {

            final SpinnerHiderRelativeLayout this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = SpinnerHiderRelativeLayout.this;
                super();
            }
        });
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        mSpinner = new ProgressBar(context);
        mSpinner.setLayoutParams(layoutparams);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            useAnimation = true;
        }
        if (useAnimation)
        {
            mOverlayVisibility = new ViewAlphaAnimator(mOverlay, 0.0F, mOverlayAlpha, mAppearDuration);
            mOverlayVisibility.hide();
            mSpinnerVisibility = new ViewAlphaAnimator(mSpinner, mAppearDuration);
            mSpinnerVisibility.hide();
        }
    }

    public long getAppearDuration()
    {
        return mAppearDuration;
    }

    public float getOverlayAlpha()
    {
        return mOverlayAlpha;
    }

    public int getOverlayColor()
    {
        return mOverlayColor;
    }

    public void hide()
    {
        if (useAnimation)
        {
            mOverlayVisibility.animateHide();
            mSpinnerVisibility.animateHide();
            return;
        } else
        {
            mOverlay.setVisibility(8);
            mSpinner.setVisibility(8);
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        if (mOverlay.getParent() == null)
        {
            addView(mOverlay);
            addView(mSpinner);
        }
        super.onMeasure(i, j);
    }

    public void setAppearDuration(long l)
    {
        mAppearDuration = l;
        if (useAnimation)
        {
            mOverlayVisibility.setDuration(l);
            mSpinnerVisibility.setDuration(l);
        }
    }

    public void setOverlayAlpha(float f)
    {
        mOverlayAlpha = f;
        if (useAnimation)
        {
            mOverlayVisibility.setMaxAlpha(f);
        }
    }

    public void setOverlayColor(int i)
    {
        mOverlayColor = i;
        mOverlay.setBackgroundColor(i);
    }

    public void show()
    {
        if (useAnimation)
        {
            mOverlayVisibility.animateShow();
            mSpinnerVisibility.animateShow();
            return;
        } else
        {
            mOverlay.setVisibility(0);
            mSpinner.setVisibility(0);
            return;
        }
    }

}
