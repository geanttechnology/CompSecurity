// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.app.Activity;
import android.content.res.Resources;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.groupon.callbacks.OnActivityTransitionFinishedListener;
import com.groupon.models.deal.SharedDealInfo;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.LayoutUtil;
import com.groupon.util.transitions.TransitionListenerAdapter;
import com.groupon.view.DealDetailsTemporaryImage;

// Referenced classes of package com.groupon.activity.transition:
//            AbstractDetailsTransitionController

public class DealDetailsRecyclerTransitionController extends AbstractDetailsTransitionController
{

    public DealDetailsRecyclerTransitionController()
    {
    }

    public void handleEnterTransition(final OnActivityTransitionFinishedListener transitionFinishedListener)
    {
        float f1 = 1.0F;
        if (shouldStartSceneTransition())
        {
            activity.setEnterSharedElementCallback(getSharedElementCallback());
            final View toolbar = getViewByViewId(0x7f100180);
            final View rootView = getViewByViewId(0x7f100254);
            View view = getViewByViewId(0x7f1000da);
            final View imageGradientOverlay = getViewByViewId(0x7f1004bf);
            View view1 = getViewByViewId(0x7f100222);
            final View titleValuePriceSection = getViewByViewId(0x7f1004c0);
            DealDetailsTemporaryImage dealdetailstemporaryimage = (DealDetailsTemporaryImage)getViewByViewId(0x7f100385);
            if (layoutUtil.isLandscape())
            {
                view = view1;
            }
            setDealImageTransitionName(view);
            float f;
            if (layoutUtil.isLandscape())
            {
                f = 1.0F;
            } else
            {
                f = 0.0F;
            }
            toolbar.setAlpha(f);
            titleValuePriceSection.setAlpha(0.0F);
            dealdetailstemporaryimage.setImageHeight(dealImageHeight);
            if (imageGradientOverlay != null)
            {
                Transition transition;
                if (layoutUtil.isLandscape())
                {
                    f = f1;
                } else
                {
                    f = 0.0F;
                }
                imageGradientOverlay.setAlpha(f);
            }
            transition = activity.getWindow().getSharedElementEnterTransition();
            transition.setDuration(400L);
            transition.setInterpolator(new DecelerateInterpolator());
            transition.addListener(new TransitionListenerAdapter() {

                final DealDetailsRecyclerTransitionController this$0;
                final View val$imageGradientOverlay;
                final View val$rootView;
                final View val$titleValuePriceSection;
                final View val$toolbar;
                final OnActivityTransitionFinishedListener val$transitionFinishedListener;

                public void onTransitionEnd(Transition transition1)
                {
                    transitionFinished = true;
                    if (!isReturning)
                    {
                        rootView.setBackgroundColor(activity.getResources().getColor(0x7f0e0013));
                        if (!layoutUtil.isLandscape())
                        {
                            toolbar.animate().alpha(1.0F).setDuration(400L).setStartDelay(600L);
                            if (imageGradientOverlay != null)
                            {
                                imageGradientOverlay.animate().alpha(1.0F).setDuration(400L).setStartDelay(600L);
                            }
                        }
                        titleValuePriceSection.animate().alpha(1.0F).setDuration(400L);
                        if (transitionFinishedListener != null)
                        {
                            transitionFinishedListener.onTransitionFinished();
                        }
                    }
                }

            
            {
                this$0 = DealDetailsRecyclerTransitionController.this;
                rootView = view;
                toolbar = view1;
                imageGradientOverlay = view2;
                titleValuePriceSection = view3;
                transitionFinishedListener = onactivitytransitionfinishedlistener;
                super();
            }
            });
            activity.startPostponedEnterTransition();
        }
    }

    public void handleReturnTransition()
    {
        Object obj = TransitionInflater.from(activity.getApplicationContext()).inflateTransition(0x7f050001);
        activity.getWindow().setReturnTransition(((Transition) (obj)));
        obj = activity.getWindow().getSharedElementReturnTransition();
        ((Transition) (obj)).setDuration(400L);
        ((Transition) (obj)).setInterpolator(new AccelerateDecelerateInterpolator());
        obj = getViewByViewId(0x7f100180);
        View view = getViewByViewId(0x7f100254);
        View view1 = getViewByViewId(0x7f100222);
        View view2 = getViewByViewId(0x7f1004bf);
        View view3 = getViewByViewId(0x7f1004c0);
        DealDetailsTemporaryImage dealdetailstemporaryimage = (DealDetailsTemporaryImage)getViewByViewId(0x7f100385);
        view.setBackground(null);
        if (view2 != null)
        {
            ((View) (obj)).setVisibility(8);
            view2.setVisibility(8);
        }
        float f = deviceInfoUtil.convertPixelsToDp(sharedDealInfo.dealImageWidth);
        float f1 = deviceInfoUtil.convertPixelsToDp(sharedDealInfo.dealImageHeight);
        dealdetailstemporaryimage.animate().cancel();
        dealdetailstemporaryimage.setImageSize(f, f1);
        dealdetailstemporaryimage.setAlpha(1.0F);
        view1.setPadding(0, 0, 0, 0);
        view3.setVisibility(8);
    }
}
