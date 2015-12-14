// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public class EffectThumbLayout extends RelativeLayout
    implements Checkable
{

    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator(1.0F);
    private static final boolean IS_HONEYCOMB;
    static final String LOG_TAG = "EffectThumbLayout";
    public long id;
    private ObjectAnimator mAnimator;
    private boolean mChecked;
    private com.nineoldandroids.animation.Animator.AnimatorListener mCloseListener;
    private ImageView mHiddenView;
    private View mImageView;
    private com.nineoldandroids.animation.Animator.AnimatorListener mOpenListener;
    private boolean mOpened;
    private int mThumbAnimationDuration;
    private int mTranslationHeight;

    public EffectThumbLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        id = -1L;
        mTranslationHeight = 0;
        mCloseListener = new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final EffectThumbLayout this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                if (mHiddenView != null)
                {
                    mHiddenView.setVisibility(4);
                }
            }

            
            {
                this$0 = EffectThumbLayout.this;
                super();
            }
        };
        mOpenListener = new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final EffectThumbLayout this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                if (mHiddenView != null)
                {
                    mHiddenView.setVisibility(0);
                    ObjectAnimator.ofInt(mHiddenView, "alpha", new int[] {
                        0, 255
                    }).start();
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = EffectThumbLayout.this;
                super();
            }
        };
        init(context, attributeset, 0);
    }

    private void cancelAnimation()
    {
        ObjectAnimator objectanimator = getAnimator();
        if (objectanimator != null)
        {
            objectanimator.removeAllListeners();
            objectanimator.cancel();
        }
    }

    private ObjectAnimator getAnimator()
    {
        if (mAnimator == null)
        {
            mAnimator = ObjectAnimator.ofFloat(mImageView, "translationY", new float[] {
                0.0F, 0.0F
            });
            mAnimator.setDuration(mThumbAnimationDuration);
            mAnimator.setInterpolator(INTERPOLATOR);
        }
        return mAnimator;
    }

    private void init(Context context, AttributeSet attributeset, int i)
    {
        mThumbAnimationDuration = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryEffectThumbLayout, i, 0).getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryEffectThumbLayout_aviary_animationDuration, 200);
    }

    protected void animateView(final int durationMs, final boolean isClosing)
    {
        float f1 = 0.0F;
        if (mHiddenView == null || mImageView == null || getHandler() == null)
        {
            return;
        }
        mTranslationHeight = mHiddenView.getMeasuredHeight() + mHiddenView.getPaddingTop() + mHiddenView.getPaddingBottom() + 4;
        float f;
        if (isClosing)
        {
            f = -mTranslationHeight;
        } else
        {
            f = 0.0F;
        }
        if (!isClosing)
        {
            f1 = -mTranslationHeight;
        }
        if (mTranslationHeight <= 0)
        {
            post(new Runnable() {

                final EffectThumbLayout this$0;
                final int val$durationMs;
                final boolean val$isClosing;

                public void run()
                {
                    animateView(durationMs, isClosing);
                }

            
            {
                this$0 = EffectThumbLayout.this;
                durationMs = i;
                isClosing = flag;
                super();
            }
            });
            return;
        }
        cancelAnimation();
        ObjectAnimator objectanimator = getAnimator();
        objectanimator.setFloatValues(new float[] {
            f, f1
        });
        com.nineoldandroids.animation.Animator.AnimatorListener animatorlistener;
        if (isClosing)
        {
            animatorlistener = mCloseListener;
        } else
        {
            animatorlistener = mOpenListener;
        }
        objectanimator.addListener(animatorlistener);
        objectanimator.start();
    }

    public void close()
    {
        if (IS_HONEYCOMB)
        {
            if (mOpened)
            {
                mOpened = false;
                animateView(mThumbAnimationDuration, true);
            }
            return;
        } else
        {
            setIsOpened(false);
            return;
        }
    }

    public boolean isChecked()
    {
        return mChecked;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mOpened = isChecked();
        mHiddenView = (ImageView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_hidden);
        mImageView = findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
        setIsOpened(mOpened);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }

    public void open()
    {
        if (IS_HONEYCOMB)
        {
            if (!mOpened)
            {
                mOpened = true;
                animateView(mThumbAnimationDuration, false);
            }
            return;
        } else
        {
            setIsOpened(true);
            return;
        }
    }

    public void setChecked(boolean flag)
    {
        if (mChecked != flag)
        {
            mChecked = flag;
        }
    }

    public void setIsOpened(final boolean value)
    {
        boolean flag;
label0:
        {
            flag = false;
            if (value != mOpened)
            {
                Log.i("EffectThumbLayout", (new StringBuilder()).append("setIsOpened(").append(id).append("): ").append(value).toString());
                if (mHiddenView != null && mImageView != null && getHandler() != null)
                {
                    break label0;
                }
            }
            return;
        }
        mTranslationHeight = mHiddenView.getHeight() + mHiddenView.getPaddingBottom() + mHiddenView.getPaddingTop() + 4;
        if (mTranslationHeight <= 0)
        {
            post(new Runnable() {

                final EffectThumbLayout this$0;
                final boolean val$value;

                public void run()
                {
                    setIsOpened(value);
                }

            
            {
                this$0 = EffectThumbLayout.this;
                value = flag;
                super();
            }
            });
            return;
        }
        mOpened = value;
        Object obj = mHiddenView;
        int i;
        if (mOpened)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        ((ImageView) (obj)).setVisibility(i);
        if (IS_HONEYCOMB)
        {
            cancelAnimation();
            obj = mImageView;
            float f;
            if (value)
            {
                f = -mTranslationHeight;
            } else
            {
                f = 0.0F;
            }
            ((View) (obj)).setTranslationY(f);
            return;
        }
        obj = (android.widget.RelativeLayout.LayoutParams)mImageView.getLayoutParams();
        i = ((flag) ? 1 : 0);
        if (value)
        {
            i = mTranslationHeight;
        }
        obj.bottomMargin = i;
        mImageView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
    }

    public void toggle()
    {
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT > 10)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IS_HONEYCOMB = flag;
    }

}
