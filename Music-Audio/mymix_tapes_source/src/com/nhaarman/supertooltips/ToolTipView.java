// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.supertooltips;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.nhaarman.supertooltips:
//            ToolTip

public class ToolTipView extends LinearLayout
    implements android.view.ViewTreeObserver.OnPreDrawListener, android.view.View.OnClickListener
{
    private class AppearanceAnimatorListener extends AnimatorListenerAdapter
    {

        private final float mToolTipViewX;
        private final float mToolTipViewY;
        final ToolTipView this$0;

        public void onAnimationCancel(Animator animator)
        {
        }

        public void onAnimationEnd(Animator animator)
        {
            animator = (android.widget.RelativeLayout.LayoutParams)getLayoutParams();
            animator.leftMargin = (int)mToolTipViewX;
            animator.topMargin = (int)mToolTipViewY;
            setX(0.0F);
            setY(0.0F);
            setLayoutParams(animator);
        }

        public void onAnimationRepeat(Animator animator)
        {
        }

        public void onAnimationStart(Animator animator)
        {
        }

        AppearanceAnimatorListener(float f, float f1)
        {
            this$0 = ToolTipView.this;
            super();
            mToolTipViewX = f;
            mToolTipViewY = f1;
        }
    }

    private class DisappearanceAnimatorListener extends AnimatorListenerAdapter
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

        private DisappearanceAnimatorListener()
        {
            this$0 = ToolTipView.this;
            super();
        }

    }

    public static interface OnToolTipViewClickedListener
    {

        public abstract void onToolTipViewClicked(ToolTipView tooltipview);
    }


    public static final String ALPHA_COMPAT = "alpha";
    public static final String SCALE_X_COMPAT = "scaleX";
    public static final String SCALE_Y_COMPAT = "scaleY";
    public static final String TRANSLATION_X_COMPAT = "translationX";
    public static final String TRANSLATION_Y_COMPAT = "translationY";
    private View mBottomFrame;
    private ImageView mBottomPointerView;
    private ViewGroup mContentHolder;
    private boolean mDimensionsKnown;
    private OnToolTipViewClickedListener mListener;
    private int mRelativeMasterViewX;
    private int mRelativeMasterViewY;
    private View mShadowView;
    private ToolTip mToolTip;
    private TextView mToolTipTV;
    private View mTopFrame;
    private ImageView mTopPointerView;
    private View mView;
    private int mWidth;

    public ToolTipView(Context context)
    {
        super(context);
        init();
    }

    private void applyToolTipPosition()
    {
        ArrayList arraylist;
        int i;
        int j;
        int ai[] = new int[2];
        mView.getLocationOnScreen(ai);
        Rect rect = new Rect();
        mView.getWindowVisibleDisplayFrame(rect);
        int ai1[] = new int[2];
        ((View)getParent()).getLocationOnScreen(ai1);
        j = mView.getWidth();
        i = mView.getHeight();
        mRelativeMasterViewX = ai[0] - ai1[0];
        mRelativeMasterViewY = ai[1] - ai1[1];
        int k = mRelativeMasterViewX + j / 2;
        int i1 = mRelativeMasterViewY - getHeight();
        int j1 = Math.max(0, mRelativeMasterViewY + i);
        j = Math.max(0, k - mWidth / 2);
        i = j;
        if (mWidth + j > rect.right)
        {
            i = rect.right - mWidth;
        }
        setX(i);
        setPointerCenterX(k);
        if (i1 < 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            ImageView imageview = mTopPointerView;
            float f;
            if (j != 0)
            {
                f = 1.0F;
            } else
            {
                f = 0.0F;
            }
            ViewHelper.setAlpha(imageview, f);
            imageview = mBottomPointerView;
            if (j != 0)
            {
                f = 0.0F;
            } else
            {
                f = 1.0F;
            }
            ViewHelper.setAlpha(imageview, f);
        } else
        {
            ImageView imageview1 = mTopPointerView;
            int l;
            if (j != 0)
            {
                l = 0;
            } else
            {
                l = 8;
            }
            imageview1.setVisibility(l);
            imageview1 = mBottomPointerView;
            if (j != 0)
            {
                l = 8;
            } else
            {
                l = 0;
            }
            imageview1.setVisibility(l);
        }
        if (j != 0)
        {
            j = j1;
        } else
        {
            j = i1;
        }
        if (mToolTip.getAnimationType() == ToolTip.AnimationType.NONE)
        {
            ViewHelper.setTranslationY(this, j);
            ViewHelper.setTranslationX(this, i);
            return;
        }
        arraylist = new ArrayList(5);
        if (mToolTip.getAnimationType() != ToolTip.AnimationType.FROM_MASTER_VIEW) goto _L2; else goto _L1
_L1:
        arraylist.add(ObjectAnimator.ofInt(this, "translationY", new int[] {
            (mRelativeMasterViewY + mView.getHeight() / 2) - getHeight() / 2, j
        }));
        arraylist.add(ObjectAnimator.ofInt(this, "translationX", new int[] {
            (mRelativeMasterViewX + mView.getWidth() / 2) - mWidth / 2, i
        }));
_L4:
        arraylist.add(ObjectAnimator.ofFloat(this, "scaleX", new float[] {
            0.0F, 1.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(this, "scaleY", new float[] {
            0.0F, 1.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(this, "alpha", new float[] {
            0.0F, 1.0F
        }));
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(arraylist);
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            animatorset.addListener(new AppearanceAnimatorListener(i, j));
        }
        animatorset.start();
        return;
_L2:
        if (mToolTip.getAnimationType() == ToolTip.AnimationType.FROM_TOP)
        {
            arraylist.add(ObjectAnimator.ofFloat(this, "translationY", new float[] {
                0.0F, (float)j
            }));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void init()
    {
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.tooltip, this, true);
        mTopPointerView = (ImageView)findViewById(R.id.tooltip_pointer_up);
        mTopFrame = findViewById(R.id.tooltip_topframe);
        mContentHolder = (ViewGroup)findViewById(R.id.tooltip_contentholder);
        mToolTipTV = (TextView)findViewById(R.id.tooltip_contenttv);
        mBottomFrame = findViewById(R.id.tooltip_bottomframe);
        mBottomPointerView = (ImageView)findViewById(R.id.tooltip_pointer_down);
        mShadowView = findViewById(R.id.tooltip_shadow);
        setOnClickListener(this);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    private void setContentView(View view)
    {
        mContentHolder.removeAllViews();
        mContentHolder.addView(view);
    }

    public float getX()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return super.getX();
        } else
        {
            return ViewHelper.getX(this);
        }
    }

    public float getY()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return super.getY();
        } else
        {
            return ViewHelper.getY(this);
        }
    }

    public void onClick(View view)
    {
        remove();
        if (mListener != null)
        {
            mListener.onToolTipViewClicked(this);
        }
    }

    public boolean onPreDraw()
    {
        getViewTreeObserver().removeOnPreDrawListener(this);
        mDimensionsKnown = true;
        mWidth = mContentHolder.getWidth();
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)getLayoutParams();
        layoutparams.width = mWidth;
        setLayoutParams(layoutparams);
        if (mToolTip != null)
        {
            applyToolTipPosition();
        }
        return true;
    }

    public void remove()
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)getLayoutParams();
            setX(layoutparams.leftMargin);
            setY(layoutparams.topMargin);
            layoutparams.leftMargin = 0;
            layoutparams.topMargin = 0;
            setLayoutParams(layoutparams);
        }
        if (mToolTip.getAnimationType() == ToolTip.AnimationType.NONE)
        {
            if (getParent() != null)
            {
                ((ViewManager)getParent()).removeView(this);
            }
            return;
        }
        ArrayList arraylist = new ArrayList(5);
        AnimatorSet animatorset;
        if (mToolTip.getAnimationType() == ToolTip.AnimationType.FROM_MASTER_VIEW)
        {
            arraylist.add(ObjectAnimator.ofInt(this, "translationY", new int[] {
                (int)getY(), (mRelativeMasterViewY + mView.getHeight() / 2) - getHeight() / 2
            }));
            arraylist.add(ObjectAnimator.ofInt(this, "translationX", new int[] {
                (int)getX(), (mRelativeMasterViewX + mView.getWidth() / 2) - mWidth / 2
            }));
        } else
        {
            arraylist.add(ObjectAnimator.ofFloat(this, "translationY", new float[] {
                getY(), 0.0F
            }));
        }
        arraylist.add(ObjectAnimator.ofFloat(this, "scaleX", new float[] {
            1.0F, 0.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(this, "scaleY", new float[] {
            1.0F, 0.0F
        }));
        arraylist.add(ObjectAnimator.ofFloat(this, "alpha", new float[] {
            1.0F, 0.0F
        }));
        animatorset = new AnimatorSet();
        animatorset.playTogether(arraylist);
        animatorset.addListener(new DisappearanceAnimatorListener());
        animatorset.start();
    }

    public void setColor(int i)
    {
        mTopPointerView.setColorFilter(i, android.graphics.PorterDuff.Mode.MULTIPLY);
        mTopFrame.getBackground().setColorFilter(i, android.graphics.PorterDuff.Mode.MULTIPLY);
        mBottomPointerView.setColorFilter(i, android.graphics.PorterDuff.Mode.MULTIPLY);
        mBottomFrame.getBackground().setColorFilter(i, android.graphics.PorterDuff.Mode.MULTIPLY);
        mContentHolder.setBackgroundColor(i);
    }

    public void setOnToolTipViewClickedListener(OnToolTipViewClickedListener ontooltipviewclickedlistener)
    {
        mListener = ontooltipviewclickedlistener;
    }

    public void setPointerCenterX(int i)
    {
        int j = Math.max(mTopPointerView.getMeasuredWidth(), mBottomPointerView.getMeasuredWidth());
        ViewHelper.setX(mTopPointerView, i - j / 2 - (int)getX());
        ViewHelper.setX(mBottomPointerView, i - j / 2 - (int)getX());
    }

    public void setToolTip(ToolTip tooltip, View view)
    {
        mToolTip = tooltip;
        mView = view;
        if (mToolTip.getText() == null) goto _L2; else goto _L1
_L1:
        mToolTipTV.setText(mToolTip.getText());
_L4:
        if (mToolTip.getTypeface() != null)
        {
            mToolTipTV.setTypeface(mToolTip.getTypeface());
        }
        if (mToolTip.getTextColor() != 0)
        {
            mToolTipTV.setTextColor(mToolTip.getTextColor());
        }
        if (mToolTip.getColor() != 0)
        {
            setColor(mToolTip.getColor());
        }
        if (mToolTip.getContentView() != null)
        {
            setContentView(mToolTip.getContentView());
        }
        if (!mToolTip.shouldShowShadow())
        {
            mShadowView.setVisibility(8);
        }
        if (mDimensionsKnown)
        {
            applyToolTipPosition();
        }
        return;
_L2:
        if (mToolTip.getTextResId() != 0)
        {
            mToolTipTV.setText(mToolTip.getTextResId());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setX(float f)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            super.setX(f);
            return;
        } else
        {
            ViewHelper.setX(this, f);
            return;
        }
    }

    public void setY(float f)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            super.setY(f);
            return;
        } else
        {
            ViewHelper.setY(this, f);
            return;
        }
    }
}
