// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.res.Resources;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.groupon.models.deal.SharedDealInfo;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function0;
import com.groupon.util.ImageUrl;
import com.groupon.util.LayoutUtil;
import com.groupon.util.transitions.TransitionListenerAdapter;
import com.groupon.view.DealDetailsTemporaryImage;
import java.util.List;
import java.util.Map;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity.transition:
//            AbstractDetailsTransitionController

public class HotelDetailsTransitionController extends AbstractDetailsTransitionController
{

    public HotelDetailsTransitionController()
    {
    }

    protected SharedElementCallback getSharedElementCallback()
    {
        return new SharedElementCallback() {

            final HotelDetailsTransitionController this$0;

            public void onMapSharedElements(List list, Map map)
            {
                if (isReturning)
                {
                    View view;
                    if (layoutUtil.isLandscape())
                    {
                        view = getViewByViewId(0x7f100222);
                    } else
                    {
                        view = getViewByViewId(0x7f100384);
                    }
                    map.remove("deal_image_transition");
                    map.put("deal_image_transition", view);
                }
                super.onMapSharedElements(list, map);
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
                this$0 = HotelDetailsTransitionController.this;
                super();
            }
        };
    }

    public void handleEnterTransition(final Function0 onTransitionEnded)
    {
        if (shouldStartSceneTransition())
        {
            activity.postponeEnterTransition();
            activity.setEnterSharedElementCallback(getSharedElementCallback());
            final View toolbar = getViewByViewId(0x7f100180);
            final View contentView = getViewByViewId(0x7f100132);
            Object obj = getViewByViewId(0x7f1000da);
            View view = getViewByViewId(0x7f100222);
            DealDetailsTemporaryImage dealdetailstemporaryimage = (DealDetailsTemporaryImage)getViewByViewId(0x7f100385);
            if (layoutUtil.isLandscape())
            {
                obj = view;
            }
            setDealImageTransitionName(((View) (obj)));
            float f;
            if (layoutUtil.isLandscape())
            {
                f = 1.0F;
            } else
            {
                f = 0.0F;
            }
            toolbar.setAlpha(f);
            dealdetailstemporaryimage.setImageHeight(dealImageHeight);
            obj = sharedDealInfo.largeImageUrl;
            if (obj != null && Strings.notEmpty(((ImageUrl) (obj)).getUrl()))
            {
                dealdetailstemporaryimage.loadImageFromUrl(sharedDealInfo.largeImageUrl, new Function0() {

                    final HotelDetailsTransitionController this$0;

                    public void execute()
                        throws RuntimeException
                    {
                        activity.startPostponedEnterTransition();
                    }

            
            {
                this$0 = HotelDetailsTransitionController.this;
                super();
            }
                });
            } else
            {
                dealdetailstemporaryimage.setImageResource(0x7f0201a3);
                activity.startPostponedEnterTransition();
            }
            obj = activity.getWindow().getSharedElementEnterTransition();
            ((Transition) (obj)).setDuration(400L);
            ((Transition) (obj)).setInterpolator(new DecelerateInterpolator());
            ((Transition) (obj)).addListener(new TransitionListenerAdapter() {

                final HotelDetailsTransitionController this$0;
                final View val$contentView;
                final Function0 val$onTransitionEnded;
                final View val$toolbar;

                public void onTransitionEnd(Transition transition)
                {
                    if (!isReturning)
                    {
                        contentView.setBackgroundColor(activity.getResources().getColor(0x7f0e0013));
                        if (!layoutUtil.isLandscape())
                        {
                            toolbar.animate().alpha(1.0F).setDuration(400L).setStartDelay(600L);
                        }
                        if (onTransitionEnded != null)
                        {
                            onTransitionEnded.execute();
                        }
                    }
                }

            
            {
                this$0 = HotelDetailsTransitionController.this;
                contentView = view;
                toolbar = view1;
                onTransitionEnded = function0;
                super();
            }
            });
        }
    }

    public void handleReturnTransition()
    {
        Transition transition = TransitionInflater.from(activity.getApplicationContext()).inflateTransition(0x7f050001);
        transition.addListener(new TransitionListenerAdapter() {

            final HotelDetailsTransitionController this$0;

            public void onTransitionStart(Transition transition1)
            {
                getViewByViewId(0x7f100394).animate().alpha(0.0F).setDuration(200L);
            }

            
            {
                this$0 = HotelDetailsTransitionController.this;
                super();
            }
        });
        View view = getViewByViewId(0x7f100132);
        View view1 = getViewByViewId(0x7f1004bf);
        DealDetailsTemporaryImage dealdetailstemporaryimage = (DealDetailsTemporaryImage)getViewByViewId(0x7f100385);
        activity.getWindow().setReturnTransition(transition);
        transition = activity.getWindow().getSharedElementReturnTransition();
        transition.setDuration(400L);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setBackground(null);
        if (view1 != null)
        {
            view1.setVisibility(8);
        }
        dealdetailstemporaryimage.setImageSize(deviceInfoUtil.convertPixelsToDp(sharedDealInfo.dealImageWidth), deviceInfoUtil.convertPixelsToDp(sharedDealInfo.dealImageHeight));
        dealdetailstemporaryimage.setAlpha(1.0F);
    }
}
