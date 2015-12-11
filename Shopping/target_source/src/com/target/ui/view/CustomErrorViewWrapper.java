// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.util.al;

public class CustomErrorViewWrapper extends LinearLayout
{
    private class a
    {

        TextView error;
        View inputView;
        final CustomErrorViewWrapper this$0;

        public a(View view)
        {
            this$0 = CustomErrorViewWrapper.this;
            super();
            inputView = view.findViewById(CustomErrorViewWrapper.a(CustomErrorViewWrapper.this));
            error = (TextView)view.findViewById(0x7f10042a);
        }
    }


    private static final int ANIMATION_DURATION_MS = 200;
    private static final float SCALE_FACTOR = 0.9F;
    private static final String TAG = com/target/ui/view/CustomErrorViewWrapper.getSimpleName();
    private final AnimatorListenerAdapter mHideAnimatorListener;
    private boolean mIsShowingError;
    private TextView mPreInflateErrorView;
    private final AnimatorListenerAdapter mShowAnimatorListener;
    private int mViewId;
    private a mViews;

    public CustomErrorViewWrapper(Context context)
    {
        super(context);
        mIsShowingError = false;
        mShowAnimatorListener = new AnimatorListenerAdapter() {

            final CustomErrorViewWrapper this$0;

            public void onAnimationCancel(Animator animator)
            {
                al.d(CustomErrorViewWrapper.b(CustomErrorViewWrapper.this).error);
            }

            public void onAnimationStart(Animator animator)
            {
                al.b(CustomErrorViewWrapper.b(CustomErrorViewWrapper.this).error);
            }

            
            {
                this$0 = CustomErrorViewWrapper.this;
                super();
            }
        };
        mHideAnimatorListener = new AnimatorListenerAdapter() {

            final CustomErrorViewWrapper this$0;

            public void onAnimationCancel(Animator animator)
            {
                al.b(CustomErrorViewWrapper.b(CustomErrorViewWrapper.this).error);
            }

            public void onAnimationEnd(Animator animator)
            {
                al.d(CustomErrorViewWrapper.b(CustomErrorViewWrapper.this).error);
            }

            public void onAnimationStart(Animator animator)
            {
                al.b(CustomErrorViewWrapper.b(CustomErrorViewWrapper.this).error);
            }

            
            {
                this$0 = CustomErrorViewWrapper.this;
                super();
            }
        };
        a(context, null);
    }

    public CustomErrorViewWrapper(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsShowingError = false;
        mShowAnimatorListener = new _cls1();
        mHideAnimatorListener = new _cls2();
        a(context, attributeset);
    }

    public CustomErrorViewWrapper(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsShowingError = false;
        mShowAnimatorListener = new _cls1();
        mHideAnimatorListener = new _cls2();
        a(context, attributeset);
    }

    static int a(CustomErrorViewWrapper customerrorviewwrapper)
    {
        return customerrorviewwrapper.mViewId;
    }

    private void a(Context context, AttributeSet attributeset)
    {
        setOrientation(1);
        attributeset = context.obtainStyledAttributes(attributeset, com.target.ui.a.a.CustomErrorViewWrapper);
        mViewId = attributeset.getResourceId(0, 0);
        attributeset.recycle();
        if (mViewId == 0)
        {
            throw new IllegalStateException("You must specify an viewId");
        } else
        {
            mPreInflateErrorView = (TextView)LayoutInflater.from(context).inflate(0x7f03014e, this, false);
            return;
        }
    }

    private boolean a(View view)
    {
        while (view == null || view.getVisibility() != 0) 
        {
            return false;
        }
        return true;
    }

    static a b(CustomErrorViewWrapper customerrorviewwrapper)
    {
        return customerrorviewwrapper.mViews;
    }

    private void c()
    {
        if (a(mViews.error))
        {
            return;
        } else
        {
            AnimatorSet animatorset = getEnterAnimator();
            animatorset.addListener(mShowAnimatorListener);
            animatorset.start();
            return;
        }
    }

    private void d()
    {
        if (!a(mViews.error))
        {
            return;
        } else
        {
            AnimatorSet animatorset = getExitAnimator();
            animatorset.addListener(mHideAnimatorListener);
            animatorset.start();
            return;
        }
    }

    private AnimatorSet getEnterAnimator()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(mViews.error, View.SCALE_X, new float[] {
            0.9F, 1.0F
        });
        objectanimator.setDuration(200L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(mViews.error, View.SCALE_Y, new float[] {
            0.9F, 1.0F
        });
        objectanimator1.setDuration(200L);
        ObjectAnimator objectanimator2 = getFadeIn();
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, objectanimator1, objectanimator2
        });
        return animatorset;
    }

    private AnimatorSet getExitAnimator()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(mViews.error, View.SCALE_X, new float[] {
            1.0F, 0.9F
        });
        objectanimator.setDuration(200L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(mViews.error, View.SCALE_Y, new float[] {
            1.0F, 0.9F
        });
        objectanimator1.setDuration(200L);
        ObjectAnimator objectanimator2 = getFadeOut();
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, objectanimator1, objectanimator2
        });
        return animatorset;
    }

    private ObjectAnimator getFadeIn()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(mViews.error, View.ALPHA, new float[] {
            0.0F, 1.0F
        });
        objectanimator.setDuration(200L);
        return objectanimator;
    }

    private ObjectAnimator getFadeOut()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(mViews.error, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        objectanimator.setDuration(200L);
        return objectanimator;
    }

    public boolean a()
    {
        return mIsShowingError;
    }

    public void b()
    {
        mIsShowingError = false;
        mViews.inputView.setBackgroundResource(0x7f020235);
        d();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        if (getChildCount() > 1)
        {
            throw new IllegalStateException("You may not wrap more than one view in CustomErrorViewWrapper");
        }
        if (getChildCount() < 1)
        {
            throw new IllegalStateException("CustomErrorViewWrapper needs to have at least 1 child view");
        }
        if (!(getChildAt(0) instanceof View) && !(getChildAt(0) instanceof ViewGroup))
        {
            throw new IllegalStateException("CustomErrorViewWrapper's child view must be a View/ViewGroup");
        }
        addView(mPreInflateErrorView, 1);
        mViews = new a(this);
        if (mViews.inputView instanceof ViewGroup)
        {
            ((ViewGroup)mViews.inputView).setAddStatesFromChildren(true);
        }
        mViews.inputView.setBackgroundResource(0x7f020235);
    }

    public void setErrorState(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("errorText cannot be null.  Call clearErrorState() if you'd like to hide the error");
        } else
        {
            mIsShowingError = true;
            mViews.inputView.setBackgroundResource(0x7f020239);
            mViews.error.setText(s);
            c();
            return;
        }
    }

}
