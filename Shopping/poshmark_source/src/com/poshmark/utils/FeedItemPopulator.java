// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.adapters.HetroFeedListAdapter;
import com.poshmark.data_model.models.FeedItem;
import com.poshmark.data_model.models.FeedItemContentType;
import com.poshmark.data_model.models.FeedItemImageLayout;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.PoshmarkPost;
import com.poshmark.data_model.models.inner_models.FeedItemFooterLayout;
import com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout;
import com.poshmark.data_model.models.inner_models.FeedItemLayoutInfo;
import com.poshmark.data_model.models.inner_models.FeedItemStoryType;
import com.poshmark.ui.MainActivity;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.ListingStatusView;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMClickableImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.SearchFilterTextView;
import com.poshmark.ui.fragments.BrandFragment;
import com.poshmark.ui.fragments.ClosetFragment;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.utils.view_holders.FeedItemViewHolder;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            ListingUtils, ViewUtils

public class FeedItemPopulator
{
    public static final class COVERSHOT_SIZE extends Enum
    {

        private static final COVERSHOT_SIZE $VALUES[];
        public static final COVERSHOT_SIZE LARGE;
        public static final COVERSHOT_SIZE MEDIUM;
        public static final COVERSHOT_SIZE SMALL;

        public static COVERSHOT_SIZE valueOf(String s)
        {
            return (COVERSHOT_SIZE)Enum.valueOf(com/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE, s);
        }

        public static COVERSHOT_SIZE[] values()
        {
            return (COVERSHOT_SIZE[])$VALUES.clone();
        }

        static 
        {
            LARGE = new COVERSHOT_SIZE("LARGE", 0);
            MEDIUM = new COVERSHOT_SIZE("MEDIUM", 1);
            SMALL = new COVERSHOT_SIZE("SMALL", 2);
            $VALUES = (new COVERSHOT_SIZE[] {
                LARGE, MEDIUM, SMALL
            });
        }

        private COVERSHOT_SIZE(String s, int i)
        {
            super(s, i);
        }
    }


    public FeedItemPopulator()
    {
    }

    public static void populateFooter(Context context, HetroFeedListAdapter hetrofeedlistadapter, FeedItem feeditem, FeedItemViewHolder feeditemviewholder)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[];
            static final int $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[];
            static final int $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[];

            static 
            {
                $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout = new int[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.SIMPLE_LAUNCH_FOOTER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.SOCIAL_ACTIONS_FOOTER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.LEGACY_FOOTER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout = new int[com.poshmark.data_model.models.FeedItemImageLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_SOCIAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_SUMMARY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.MIFU_3_FLUID_LARGE_LEFT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.MIFU_4_GRID.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_LEFT_IMAGE_RIGHT_TEXT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout = new int[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.SINGLE_LEVEL_HEADER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.SINGLE_LEVEL_HEADER_POSHPOST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.DOUBLE_LEVEL_HEADER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.LEGACY_HEADER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout[feeditem.layoutInfo.footerLayout.currentLayout.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            feeditemviewholder.footerTextView.setTitleWithHtmlString(null, feeditem.getFooterString());
            feeditemviewholder.footerLayout.setTag(feeditem);
            return;

        case 2: // '\002'
            ListingSocial listingsocial = (ListingSocial)feeditem.contentArray.get(0);
            int i;
            if (listingsocial.isNWT())
            {
                feeditemviewholder.nwtTextView.setVisibility(0);
            } else
            {
                feeditemviewholder.nwtTextView.setVisibility(8);
            }
            feeditemviewholder.titleView.setText(listingsocial.getTitle());
            feeditemviewholder.priceView.setText(listingsocial.getPriceString());
            feeditemviewholder.originalPriceView.setText(listingsocial.getOriginalPriceString());
            i = ListingUtils.getDrawableIconForCategory(listingsocial.getCategoryId());
            feeditem = context.getResources().getDrawable(i);
            feeditemviewholder.categoryView.setImageDrawable(feeditem);
            feeditemviewholder.sizeView.setText((new StringBuilder()).append(context.getString(0x7f060281)).append(" ").append(listingsocial.getSize()).toString());
            feeditemviewholder.brandView.setText(listingsocial.getBrand());
            feeditemviewholder.sizeView.setCategory(listingsocial.getCategoryId());
            feeditemviewholder.sizeView.setSubCategoryList(listingsocial.getSubCategoryList());
            feeditem = listingsocial.getSize();
            if (feeditem == null)
            {
                feeditem = new String("");
            } else
            {
                feeditem = feeditem.toString();
            }
            feeditemviewholder.sizeView.setSize(feeditem);
            feeditemviewholder.sizeView.setParentScreenNameForAnalytics("listings_feed_screen");
            feeditemviewholder.brandView.setBrand(listingsocial.getBrand());
            feeditemviewholder.brandView.setParentScreenNameForAnalytics("listings_feed_screen");
            if (listingsocial.isRetail())
            {
                feeditemviewholder.nwtTextView.setRetailConditionFlag(Boolean.valueOf(true));
                feeditemviewholder.nwtTextView.setCategory(listingsocial.getCategoryId());
                feeditemviewholder.nwtTextView.setSubCategoryList(listingsocial.getSubCategoryList());
                feeditem = context.getString(0x7f06022c);
                feeditemviewholder.nwtTextView.setText(feeditem.toUpperCase());
            } else
            if (listingsocial.isNWT())
            {
                feeditemviewholder.nwtTextView.setNWTConditionFlag(Boolean.valueOf(true));
                feeditemviewholder.nwtTextView.setCategory(listingsocial.getCategoryId());
                feeditemviewholder.nwtTextView.setSubCategoryList(listingsocial.getSubCategoryList());
                feeditemviewholder.nwtTextView.setText(0x7f0601d6);
            }
            feeditemviewholder.likesLayout.setVisibility(0);
            i = listingsocial.getTotalLikes();
            if (i > 0)
            {
                feeditemviewholder.likesLayout.setVisibility(0);
                if (i == 1)
                {
                    feeditemviewholder.likesCount.setText((new StringBuilder()).append(Integer.toString(i)).append(" ").append(context.getString(0x7f060163)).toString());
                } else
                {
                    feeditemviewholder.likesCount.setText((new StringBuilder()).append(Integer.toString(i)).append(" ").append(context.getString(0x7f060165)).toString());
                }
            } else
            {
                feeditemviewholder.likesCount.setText((new StringBuilder()).append(Integer.toString(i)).append(" ").append(context.getString(0x7f060165)).toString());
            }
            feeditemviewholder.likesCount.setTag(listingsocial);
            feeditemviewholder.likesCount.setOnClickListener(hetrofeedlistadapter.viewLikesListener);
            i = listingsocial.getTotalComments();
            if (i > 0)
            {
                feeditemviewholder.likesLayout.setVisibility(0);
                if (i == 1)
                {
                    feeditemviewholder.commentsCount.setText((new StringBuilder()).append(Integer.toString(i)).append(" ").append(context.getString(0x7f06008d)).toString());
                } else
                {
                    feeditemviewholder.commentsCount.setText((new StringBuilder()).append(Integer.toString(i)).append(" ").append(context.getString(0x7f06008e)).toString());
                }
            } else
            {
                feeditemviewholder.commentsCount.setText((new StringBuilder()).append(Integer.toString(i)).append(" ").append(context.getString(0x7f06008e)).toString());
            }
            feeditemviewholder.commentsCount.setTag(listingsocial);
            feeditemviewholder.commentsCount.setOnClickListener(hetrofeedlistadapter.viewDetailsListener);
            hetrofeedlistadapter.setLikeButtonState(feeditemviewholder, listingsocial.getListingLikeStatus());
            feeditemviewholder.commentLayout1.setVisibility(8);
            feeditemviewholder.commentLayout2.setVisibility(8);
            feeditemviewholder.likeButton.setTag(listingsocial);
            feeditemviewholder.shareButton.setTag(listingsocial);
            feeditemviewholder.commentButton.setTag(listingsocial);
            feeditemviewholder.commentButton.setOnClickListener(hetrofeedlistadapter.commentButtonListener);
            feeditemviewholder.likeButton.setOnClickListener(hetrofeedlistadapter.likeButtonListener);
            feeditemviewholder.shareButton.setOnClickListener(hetrofeedlistadapter.shareButtonListener);
            return;

        case 3: // '\003'
            ListingSocial listingsocial1 = (ListingSocial)feeditem.contentArray.get(0);
            int j;
            if (listingsocial1.isNWT())
            {
                feeditemviewholder.nwtTextView.setVisibility(0);
            } else
            {
                feeditemviewholder.nwtTextView.setVisibility(8);
            }
            feeditemviewholder.titleView.setText(listingsocial1.getTitle());
            feeditemviewholder.priceView.setText(listingsocial1.getPriceString());
            feeditemviewholder.originalPriceView.setText(listingsocial1.getOriginalPriceString());
            j = ListingUtils.getDrawableIconForCategory(listingsocial1.getCategoryId());
            feeditem = context.getResources().getDrawable(j);
            feeditemviewholder.categoryView.setImageDrawable(feeditem);
            feeditemviewholder.sizeView.setText((new StringBuilder()).append(context.getString(0x7f060281)).append(" ").append(listingsocial1.getSize()).toString());
            feeditemviewholder.sizeView.setParentScreenNameForAnalytics("listings_feed_screen");
            feeditemviewholder.brandView.setText(listingsocial1.getBrand());
            feeditemviewholder.brandView.setParentScreenNameForAnalytics("listings_feed_screen");
            feeditemviewholder.descriptionView.setVisibility(0);
            feeditemviewholder.descriptionView.setText(listingsocial1.getDescription());
            feeditemviewholder.sizeView.setCategory(listingsocial1.getCategoryId());
            feeditemviewholder.sizeView.setSubCategoryList(listingsocial1.getSubCategoryList());
            feeditem = listingsocial1.getSize();
            if (feeditem == null)
            {
                feeditem = new String("");
            } else
            {
                feeditem = feeditem.toString();
            }
            feeditemviewholder.sizeView.setSize(feeditem);
            feeditemviewholder.brandView.setBrand(listingsocial1.getBrand());
            if (listingsocial1.isNWT())
            {
                feeditemviewholder.nwtTextView.setNWTConditionFlag(Boolean.valueOf(true));
                feeditemviewholder.nwtTextView.setCategory(listingsocial1.getCategoryLabel());
                feeditemviewholder.nwtTextView.setSubCategoryList(listingsocial1.getSubCategoryList());
            }
            feeditem = listingsocial1.getLikes();
            if (feeditem.size() > 0)
            {
                feeditemviewholder.likesLayout.setVisibility(0);
                feeditemviewholder.likesView.setLikesMessage(feeditem, listingsocial1.getIdAsString());
            } else
            {
                feeditemviewholder.likesLayout.setVisibility(8);
            }
            hetrofeedlistadapter.addComments(context, listingsocial1, feeditemviewholder);
            hetrofeedlistadapter.setLikeButtonState(feeditemviewholder, listingsocial1.getListingLikeStatus());
            feeditemviewholder.likeButton.setTag(listingsocial1);
            feeditemviewholder.shareButton.setTag(listingsocial1);
            feeditemviewholder.commentButton.setTag(listingsocial1);
            feeditemviewholder.allCommentsView.setTag(listingsocial1);
            feeditemviewholder.commentButton.setOnClickListener(hetrofeedlistadapter.commentButtonListener);
            feeditemviewholder.likeButton.setOnClickListener(hetrofeedlistadapter.likeButtonListener);
            feeditemviewholder.shareButton.setOnClickListener(hetrofeedlistadapter.shareButtonListener);
            return;
        }
    }

    public static void populateHeader(Context context, HetroFeedListAdapter hetrofeedlistadapter, FeedItem feeditem, FeedItemViewHolder feeditemviewholder)
    {
        if (feeditemviewholder.headerTitleView != null)
        {
            feeditemviewholder.headerTitleView.setTitleWithHtmlString(null, feeditem.header);
        }
        if (feeditemviewholder.attributionView != null && feeditem.contentType.type != com.poshmark.data_model.models.FeedItemContentType.ContentType.PoshmarkPost)
        {
            feeditemviewholder.attributionView.setText(feeditem.getAttributionText());
        }
        hetrofeedlistadapter = feeditem.getActorImageUrl();
        _cls3..SwitchMap.com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout[feeditem.layoutInfo.headerLayout.currentLayout.ordinal()];
        JVM INSTR tableswitch 1 4: default 104
    //                   1 105
    //                   2 105
    //                   3 133
    //                   4 200;
           goto _L1 _L2 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (feeditemviewholder.avataarView != null)
        {
            feeditem.renderHeaderAvataar(context, feeditemviewholder.avataarView);
            feeditemviewholder.avataarView.setUser(feeditem.getActorId());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (feeditemviewholder.usernameTextView != null)
        {
            feeditemviewholder.usernameTextView.setUserName(feeditem.getContentOwnerName());
        }
        if (feeditem.storyType.getStoryType() == com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType.LISTING_SHARE_SIFU)
        {
            context = feeditem.getContentOwnerImageUrl();
            if (feeditemviewholder.avataarView != null && context != null)
            {
                feeditemviewholder.avataarView.loadImage(context);
                feeditemviewholder.avataarView.setUser(feeditem.getContentOwnerName());
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (feeditemviewholder.avataarView != null && hetrofeedlistadapter != null)
        {
            feeditemviewholder.avataarView.loadImage(hetrofeedlistadapter);
            feeditemviewholder.avataarView.setUser(feeditem.getActorId());
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static void populateImages(Context context, HetroFeedListAdapter hetrofeedlistadapter, FeedItem feeditem, FeedItemViewHolder feeditemviewholder)
    {
        _cls3..SwitchMap.com.poshmark.data_model.models.FeedItemImageLayout.Layout[feeditem.layoutInfo.imageLayout.getCurrentLayout().ordinal()];
        JVM INSTR tableswitch 1 5: default 52
    //                   1 53
    //                   2 53
    //                   3 141
    //                   4 178
    //                   5 227;
           goto _L1 _L2 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewBig, feeditem, 0, COVERSHOT_SIZE.LARGE);
        context = feeditemviewholder.statusView;
        hetrofeedlistadapter = (ListingSocial)feeditem.getContentFromIndex(0, com/poshmark/data_model/models/ListingSocial);
        if (hetrofeedlistadapter == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        hetrofeedlistadapter = hetrofeedlistadapter.getListingStatus();
        if (hetrofeedlistadapter == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD || hetrofeedlistadapter == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.RESERVED)
        {
            context.setVisibility(0);
            context.setListingStatus(hetrofeedlistadapter);
            context.bringToFront();
            return;
        }
        if (context == null) goto _L1; else goto _L6
_L6:
        context.setVisibility(8);
        return;
        if (context == null) goto _L1; else goto _L7
_L7:
        context.setVisibility(8);
        return;
_L3:
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewBig, feeditem, 0, COVERSHOT_SIZE.LARGE);
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewSmall1, feeditem, 1, COVERSHOT_SIZE.SMALL);
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewSmall2, feeditem, 2, COVERSHOT_SIZE.SMALL);
        return;
_L4:
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewBig, feeditem, 0, COVERSHOT_SIZE.SMALL);
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewSmall1, feeditem, 1, COVERSHOT_SIZE.SMALL);
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewSmall2, feeditem, 2, COVERSHOT_SIZE.SMALL);
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewSmall3, feeditem, 3, COVERSHOT_SIZE.SMALL);
        return;
_L5:
        updateCovershotOfFeedItemAtIndex(feeditemviewholder.coverShotViewBig, feeditem, 0, COVERSHOT_SIZE.SMALL);
        context = feeditem.getContentStringFromIndex(0);
        feeditemviewholder.poshPostTextView.setTag(feeditem);
        feeditemviewholder.poshPostTextView.setTitleWithHtmlString(null, context);
        feeditemviewholder.poshPostTextView.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                Object obj = (PoshmarkPost)((FeedItem)view.getTag()).contentArray.get(0);
                if (((PoshmarkPost) (obj)).target != null && ((PoshmarkPost) (obj)).target.url != null)
                {
                    view = (PMActivity)view.getContext();
                    if (view instanceof MainActivity)
                    {
                        obj = Uri.parse(((PoshmarkPost) (obj)).target.url);
                        ((MainActivity)view).handleDeepLinkLaunch(((Uri) (obj)), false);
                    }
                }
            }

        });
        feeditemviewholder.motherContainer.setTag(feeditem);
        feeditemviewholder.motherContainer.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                Object obj = (PoshmarkPost)((FeedItem)view.getTag()).contentArray.get(0);
                if (((PoshmarkPost) (obj)).target != null && ((PoshmarkPost) (obj)).target.url != null)
                {
                    view = (PMActivity)view.getContext();
                    if (view instanceof MainActivity)
                    {
                        obj = Uri.parse(((PoshmarkPost) (obj)).target.url);
                        ((MainActivity)view).handleDeepLinkLaunch(((Uri) (obj)), false);
                    }
                }
            }

        });
        return;
    }

    public static void updateCovershotOfFeedItemAtIndex(PMClickableImageView pmclickableimageview, FeedItem feeditem, int i, COVERSHOT_SIZE covershot_size)
    {
        Bundle bundle = new Bundle();
        Object obj = feeditem.getContentIdFromIndex(i);
        String s;
        if (obj != null)
        {
            bundle.putString("ID", ((String) (obj)));
        } else
        {
            obj = (PoshmarkPost)feeditem.contentArray.get(i);
            if (((PoshmarkPost) (obj)).target != null && ((PoshmarkPost) (obj)).target.url != null)
            {
                bundle.putString("DEEP_LINK", ((PoshmarkPost) (obj)).target.url);
            }
        }
        obj = feeditem.getContentImageUrlFromIndex(i, covershot_size);
        s = feeditem.getContentStringFromIndex(i);
        pmclickableimageview.setBackgroundColor(0);
        pmclickableimageview.setPadding(0, 0, 0, 0);
        if (feeditem.contentType.type == com.poshmark.data_model.models.FeedItemContentType.ContentType.Post)
        {
            pmclickableimageview.setDestinationFragment(com/poshmark/ui/fragments/ListingDetailsFragment);
            if (obj != null && !pmclickableimageview.getImageURL().equals(obj))
            {
                pmclickableimageview.loadImage(feeditem.getContentImageUrlFromIndex(i, covershot_size));
            }
        } else
        if (feeditem.contentType.type == com.poshmark.data_model.models.FeedItemContentType.ContentType.User)
        {
            pmclickableimageview.setDestinationFragment(com/poshmark/ui/fragments/ClosetFragment);
            if (obj != null && !pmclickableimageview.getImageURL().equals(obj))
            {
                pmclickableimageview.loadImage(feeditem.getContentImageUrlFromIndex(i, covershot_size));
            }
            if (s != null)
            {
                pmclickableimageview.loadImageWithString(s, true);
            }
        } else
        if (feeditem.contentType.type == com.poshmark.data_model.models.FeedItemContentType.ContentType.Brand)
        {
            bundle.putString("MODE", com.poshmark.ui.fragments.BrandFragment.MODE.JUST_IN.toString());
            pmclickableimageview.setDestinationFragment(com/poshmark/ui/fragments/BrandFragment);
            if (obj != null)
            {
                if (!pmclickableimageview.getImageURL().equals(obj))
                {
                    pmclickableimageview.loadImage(feeditem.getContentImageUrlFromIndex(i, covershot_size));
                }
                i = (int)ViewUtils.dipToPixels(PMApplication.getContext(), 0.5F);
                pmclickableimageview.setPadding(i, i, i, i);
                pmclickableimageview.setBackgroundColor(PMApplication.getContext().getResources().getColor(0x7f090016));
            } else
            {
                pmclickableimageview.resetImageUrl();
                if (s != null)
                {
                    pmclickableimageview.loadImageWithString(s, false);
                }
            }
        } else
        if (feeditem.contentType.type == com.poshmark.data_model.models.FeedItemContentType.ContentType.PoshmarkPost && obj != null && !pmclickableimageview.getImageURL().equals(obj))
        {
            pmclickableimageview.loadImage(feeditem.getContentImageUrlFromIndex(i, covershot_size));
        }
        pmclickableimageview.setBundle(bundle);
    }
}
