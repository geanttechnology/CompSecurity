// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import com.groupon.models.deal.SharedDealInfo;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.LayoutUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractDetailsTransitionController
{

    public static final float ALPHA_OPAQUE = 1F;
    public static final float ALPHA_TRANSPARENT = 0F;
    public static final int ANIMATION_DURATION_MEDIUM = 400;
    public static final int ANIMATION_DURATION_SHORT = 200;
    public static final int ANIMATION_START_DELAY_LONG = 600;
    public static final int ANIMATION_START_DELAY_MEDIUM = 400;
    Activity activity;
    protected boolean bottomBarAnimationShown;
    protected float dealImageHeight;
    DeviceInfoUtil deviceInfoUtil;
    protected boolean isReturning;
    LayoutUtil layoutUtil;
    protected SharedDealInfo sharedDealInfo;
    protected boolean transitionFinished;
    protected Map viewsToAnimate;

    public AbstractDetailsTransitionController()
    {
    }

    public void addAllAnimatedViews(Map map)
    {
        if (viewsToAnimate == null)
        {
            viewsToAnimate = new HashMap();
        }
        viewsToAnimate.putAll(map);
    }

    protected SharedElementCallback getSharedElementCallback()
    {
        return new SharedElementCallback() {

            final AbstractDetailsTransitionController this$0;

            public void onMapSharedElements(List list, Map map)
            {
                if (isReturning)
                {
                    map.put("bottom_bar_transition", getViewByViewId(0x7f1000a0));
                }
                super.onMapSharedElements(list, map);
            }

            public void onSharedElementEnd(List list, List list1, List list2)
            {
                super.onSharedElementEnd(list, list1, list2);
            }

            public void onSharedElementStart(List list, List list1, List list2)
            {
                if (!isReturning)
                {
                    list = TransitionInflater.from(activity.getApplicationContext()).inflateTransition(0x7f050000);
                    activity.getWindow().setEnterTransition(list);
                }
            }

            
            {
                this$0 = AbstractDetailsTransitionController.this;
                super();
            }
        };
    }

    protected View getViewByViewId(int i)
    {
        if (viewsToAnimate != null)
        {
            return (View)viewsToAnimate.get(Integer.valueOf(i));
        } else
        {
            return null;
        }
    }

    public void initializeController(SharedDealInfo shareddealinfo, float f, Map map)
    {
        sharedDealInfo = shareddealinfo;
        dealImageHeight = f;
        addAllAnimatedViews(map);
    }

    public boolean isInitialized()
    {
        return sharedDealInfo != null && viewsToAnimate != null;
    }

    public boolean isReturning()
    {
        return isReturning;
    }

    public boolean isTransitionFinished()
    {
        return transitionFinished;
    }

    protected void setDealImageTransitionName(View view)
    {
        view.setTransitionName("deal_image_transition");
    }

    public void setReturning(boolean flag)
    {
        isReturning = flag;
    }

    public void setTransitionFinished(boolean flag)
    {
        transitionFinished = flag;
    }

    public boolean shouldStartSceneTransition()
    {
        return sharedDealInfo != null;
    }

    public void slideInBottomBar(View view, int i)
    {
        slideInBottomBar(view, i, null);
    }

    public void slideInBottomBar(final View bottomBarView, final int newBottomBarVisibility, final AnimatorListenerAdapter animatorListener)
    {
        if (bottomBarAnimationShown)
        {
            bottomBarView.setVisibility(newBottomBarVisibility);
            return;
        } else
        {
            bottomBarView.setVisibility(4);
            bottomBarView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final AbstractDetailsTransitionController this$0;
                final AnimatorListenerAdapter val$animatorListener;
                final View val$bottomBarView;
                final int val$newBottomBarVisibility;

                public void onGlobalLayout()
                {
                    float f = bottomBarView.getY();
                    bottomBarView.setY(bottomBarView.getBottom());
                    bottomBarView.setVisibility(newBottomBarVisibility);
                    bottomBarView.animate().setListener(animatorListener).y(f).setDuration(200L).setInterpolator(new DecelerateInterpolator());
                    bottomBarAnimationShown = true;
                    bottomBarView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

            
            {
                this$0 = AbstractDetailsTransitionController.this;
                bottomBarView = view;
                newBottomBarVisibility = i;
                animatorListener = animatorlisteneradapter;
                super();
            }
            });
            return;
        }
    }
}
