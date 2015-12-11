// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package android.support.design.widget:
//            FloatingActionButtonEclairMr1, AnimationUtils, ShadowViewDelegate

class FloatingActionButtonHoneycombMr1 extends FloatingActionButtonEclairMr1
{

    private boolean mIsHiding;

    FloatingActionButtonHoneycombMr1(View view, ShadowViewDelegate shadowviewdelegate)
    {
        super(view, shadowviewdelegate);
    }

    void hide()
    {
        if (mIsHiding || mView.getVisibility() != 0)
        {
            return;
        }
        if (!ViewCompat.isLaidOut(mView) || mView.isInEditMode())
        {
            mView.setVisibility(8);
            return;
        } else
        {
            mView.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter() {

                final FloatingActionButtonHoneycombMr1 this$0;

                public void onAnimationCancel(Animator animator)
                {
                    mIsHiding = false;
                }

                public void onAnimationEnd(Animator animator)
                {
                    mIsHiding = false;
                    mView.setVisibility(8);
                }

                public void onAnimationStart(Animator animator)
                {
                    mIsHiding = true;
                    mView.setVisibility(0);
                }

            
            {
                this$0 = FloatingActionButtonHoneycombMr1.this;
                super();
            }
            });
            return;
        }
    }

    void show()
    {
label0:
        {
            if (mView.getVisibility() != 0)
            {
                if (!ViewCompat.isLaidOut(mView) || mView.isInEditMode())
                {
                    break label0;
                }
                mView.setAlpha(0.0F);
                mView.setScaleY(0.0F);
                mView.setScaleX(0.0F);
                mView.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter() {

                    final FloatingActionButtonHoneycombMr1 this$0;

                    public void onAnimationStart(Animator animator)
                    {
                        mView.setVisibility(0);
                    }

            
            {
                this$0 = FloatingActionButtonHoneycombMr1.this;
                super();
            }
                });
            }
            return;
        }
        mView.setVisibility(0);
        mView.setAlpha(1.0F);
        mView.setScaleY(1.0F);
        mView.setScaleX(1.0F);
    }


/*
    static boolean access$002(FloatingActionButtonHoneycombMr1 floatingactionbuttonhoneycombmr1, boolean flag)
    {
        floatingactionbuttonhoneycombmr1.mIsHiding = flag;
        return flag;
    }

*/
}
