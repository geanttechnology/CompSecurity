// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

public class ViewItTutorialView2 extends ViewItTutorialContentView
{

    public ViewItTutorialView2(Context context, int i, int j)
    {
        super(context);
        updateContentView();
        reLayoutContentView(i, j);
        hideNextButton();
        adjustDeviceFramePosition();
    }

    private void adjustDeviceFramePosition()
    {
        mDeviceAndHistoryTrayFrame.setVisibility(0);
        mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_jar);
        float f = (float)mProductsFrameWidth * 0.375F;
        TranslateAnimation translateanimation = new TranslateAnimation(0, f, 0, f, 1, 0.0F, 1, 0.0F);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(translateanimation);
        animationset.setInterpolator(new AccelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(50L);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialView2 this$0;

            public void onAnimationEnd(Animation animation)
            {
                animateOutProductsFrame(false);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialView2.this;
                super();
            }
        });
        mDeviceAndHistoryTrayFrame.startAnimation(animationset);
    }
}
