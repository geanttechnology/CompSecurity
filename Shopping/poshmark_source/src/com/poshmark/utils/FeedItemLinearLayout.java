// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsLogger;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.Actor;
import com.poshmark.data_model.models.FeedItem;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.inner_models.FeedItemStoryType;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMCovershotImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.fragments.ClosetFragment;
import com.poshmark.ui.fragments.CommentFragment;
import com.poshmark.ui.fragments.ShareFragment;
import com.poshmark.utils.view_holders.ListingViewHolder;

// Referenced classes of package com.poshmark.utils:
//            MetricsTrackingUtils, FBDPAHelper, ImageUtils

public class FeedItemLinearLayout extends LinearLayout
{

    android.view.View.OnClickListener commentButtonListener = new android.view.View.OnClickListener() {

        final FeedItemLinearLayout this$0;

        public void onClick(View view)
        {
            ListingSocial listingsocial = (ListingSocial)view.getTag();
            view = (PMActivity)view.getContext();
            Bundle bundle = new Bundle();
            bundle.putString("ID", listingsocial.getIdAsString());
            view.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CommentFragment, listingsocial);
        }

            
            {
                this$0 = FeedItemLinearLayout.this;
                super();
            }
    };
    android.view.View.OnClickListener footerClickListener = new android.view.View.OnClickListener() {

        final FeedItemLinearLayout this$0;

        public void onClick(View view)
        {
            FeedItem feeditem = (FeedItem)view.getTag();
            Object obj = feeditem.getStoryType();
            static class _cls5
            {

                static final int $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType[];

                static 
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType = new int[com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.values().length];
                    try
                    {
                        $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType[com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.CLOSET_ADD_MIFU.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType[com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.CLOSET_ADD_SIFU.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType[com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.CLOSET_UPDATE_MIFU.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType[com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.CLOSET_UPDATE_SIFU.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType[com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.LISTING_SHARE_SIFU.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType[com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.SELF_SHARE_MIFU.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemStoryType$StoryType[com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.SELF_SHARE_SIFU.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls5..SwitchMap.com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType[((FeedItemStoryType) (obj)).getStoryType().ordinal()])
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            default:
                view = (PMActivity)view.getContext();
                break;
            }
            obj = new Bundle();
            ((Bundle) (obj)).putString("NAME", feeditem.actor.getId());
            view.launchFragmentInNewActivity(((Bundle) (obj)), com/poshmark/ui/fragments/ClosetFragment, feeditem);
        }

            
            {
                this$0 = FeedItemLinearLayout.this;
                super();
            }
    };
    android.view.View.OnClickListener likeButtonListener = new android.view.View.OnClickListener() {

        final FeedItemLinearLayout this$0;

        public void onClick(View view)
        {
            ListingSocial listingsocial = (ListingSocial)view.getTag();
            boolean flag;
            if (!listingsocial.getListingLikeStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                view = MetricsTrackingUtils.getTrackingJson((Activity)view.getContext(), "lk");
                Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "like", null);
                FBDPAHelper.trackListingLike(listingsocial);
                PMApi.like(listingsocial.getIdAsString(), view, null);
                listingsocial.setListingLikeStatus(true);
                AppEventsLogger.newLogger(PMApplication.getContext()).logEvent("like");
            } else
            {
                Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "unlike", null);
                PMApi.unLike(listingsocial.getIdAsString(), null);
                listingsocial.setListingLikeStatus(false);
            }
            ListingNotificationManager.getListingNotificationManager().fireListingLikedMessage(listingsocial.getIdAsString(), flag);
        }

            
            {
                this$0 = FeedItemLinearLayout.this;
                super();
            }
    };
    android.view.View.OnClickListener shareButtonListener = new android.view.View.OnClickListener() {

        final FeedItemLinearLayout this$0;

        public void onClick(final View v)
        {
            ListingSocial listingsocial = (ListingSocial)v.getTag();
            ImageLoader.getInstance().loadImage(listingsocial.getCovershot(), listingsocial. new ImageLoadingListener() {

                final _cls3 this$1;
                final ListingSocial val$feedItem;
                final View val$v;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    s = ImageUtils.saveBitmapToDisk(bitmap, "ListingCoverShot.jpg");
                    view = new Bundle();
                    view.putString("MODE", ShareManager_Old.SHARE_MODE.SHARE_MODE_LISTING.name());
                    view.putString("IMAGE_URI", s.toString());
                    ((PMActivity)v.getContext()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/ShareFragment, feedItem);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    s = new Bundle();
                    s.putString("MODE", ShareManager_Old.SHARE_MODE.SHARE_MODE_LISTING.name());
                    ((PMActivity)v.getContext()).launchFragmentInNewActivity(s, com/poshmark/ui/fragments/ShareFragment, feedItem);
                }

                public void onLoadingStarted(String s, View view)
                {
                }

            
            {
                this$1 = final__pcls3;
                v = view;
                feedItem = ListingSocial.this;
                super();
            }
            });
        }

            
            {
                this$0 = FeedItemLinearLayout.this;
                super();
            }
    };

    public FeedItemLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public FeedItemLinearLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void populateViewHolder(ListingViewHolder listingviewholder)
    {
        listingviewholder.topBorder = findViewById(0x7f0c010f);
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f0c0110);
        listingviewholder.avataarView = (PMAvataarImageView)linearlayout.findViewById(0x7f0c011b);
        listingviewholder.userNameView = (PMTextView)linearlayout.findViewById(0x7f0c01cd);
        listingviewholder.headerTitleView = (PMTextView)linearlayout.findViewById(0x7f0c011a);
        listingviewholder.attributionView = (TextView)linearlayout.findViewById(0x7f0c011c);
        listingviewholder.coverShotViewBig = (PMCovershotImageView)((LinearLayout)findViewById(0x7f0c0111)).findViewById(0x7f0c0121);
    }
}
