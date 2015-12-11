// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.view_holders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.poshmark.data_model.models.FeedItem;
import com.poshmark.data_model.models.FeedItemImageLayout;
import com.poshmark.data_model.models.inner_models.FeedItemFooterLayout;
import com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout;
import com.poshmark.data_model.models.inner_models.FeedItemLayoutInfo;
import com.poshmark.ui.customviews.ListingStatusView;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMClickableImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.SearchFilterTextView;

public class FeedItemViewHolder
{

    public PMTextView allCommentsView;
    public TextView attributionView;
    public PMAvataarImageView avataarView;
    public SearchFilterTextView brandView;
    public ImageView categoryView;
    public PMTextView comment1;
    public PMTextView comment2;
    public Button commentButton;
    public LinearLayout commentLayout1;
    public LinearLayout commentLayout2;
    public PMAvataarImageView commenterAvataar1;
    public PMAvataarImageView commenterAvataar2;
    public TextView commentsCount;
    public PMClickableImageView coverShotViewBig;
    public PMClickableImageView coverShotViewSmall1;
    public PMClickableImageView coverShotViewSmall2;
    public PMClickableImageView coverShotViewSmall3;
    public TextView descriptionView;
    public View footerLayout;
    public PMTextView footerTextView;
    public ImageView headerIconView;
    public PMTextView headerTitleView;
    public Button likeButton;
    public TextView likesCount;
    public LinearLayout likesLayout;
    public PMTextView likesView;
    public View motherContainer;
    public SearchFilterTextView nwtTextView;
    public TextView originalPriceView;
    public PMTextView poshPostTextView;
    public TextView priceView;
    public Button shareButton;
    public SearchFilterTextView sizeView;
    public ListingStatusView statusView;
    public TextView titleView;
    public View topBorder;
    public PMTextView usernameTextView;

    public FeedItemViewHolder()
    {
    }

    public void populateViewHolderWithFooterViews(FeedItem feeditem, View view)
    {
        footerLayout = view;
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[];
            static final int $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[];

            static 
            {
                $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout = new int[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.SIMPLE_LAUNCH_FOOTER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.SOCIAL_ACTIONS_FOOTER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout[com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout.LEGACY_FOOTER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout = new int[com.poshmark.data_model.models.FeedItemImageLayout.Layout.values().length];
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_SUMMARY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_SOCIAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.MIFU_4_GRID.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.MIFU_3_FLUID_LARGE_LEFT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout[com.poshmark.data_model.models.FeedItemImageLayout.Layout.SIFU_LEFT_IMAGE_RIGHT_TEXT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.data_model.models.inner_models.FeedItemFooterLayout.Layout[feeditem.layoutInfo.footerLayout.currentLayout.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            footerTextView = (PMTextView)view.findViewById(0x7f0c011d);
            return;

        case 2: // '\002'
            titleView = (TextView)view.findViewById(0x7f0c0130);
            nwtTextView = (SearchFilterTextView)view.findViewById(0x7f0c007d);
            priceView = (TextView)view.findViewById(0x7f0c007f);
            originalPriceView = (TextView)view.findViewById(0x7f0c0080);
            originalPriceView.setPaintFlags(originalPriceView.getPaintFlags() | 0x10);
            categoryView = (ImageView)view.findViewById(0x7f0c0132);
            sizeView = (SearchFilterTextView)view.findViewById(0x7f0c0081);
            brandView = (SearchFilterTextView)view.findViewById(0x7f0c0134);
            likesLayout = (LinearLayout)view.findViewById(0x7f0c0112);
            likesCount = (TextView)likesLayout.findViewById(0x7f0c0137);
            commentsCount = (TextView)likesLayout.findViewById(0x7f0c0138);
            feeditem = (LinearLayout)view.findViewById(0x7f0c0116);
            likeButton = (Button)feeditem.findViewById(0x7f0c0045);
            commentButton = (Button)feeditem.findViewById(0x7f0c0168);
            shareButton = (Button)feeditem.findViewById(0x7f0c0046);
            commentLayout1 = (LinearLayout)view.findViewById(0x7f0c0113);
            commentLayout2 = (LinearLayout)view.findViewById(0x7f0c0114);
            commenterAvataar1 = (PMAvataarImageView)commentLayout1.findViewById(0x7f0c016f);
            commenterAvataar2 = (PMAvataarImageView)commentLayout2.findViewById(0x7f0c016f);
            comment1 = (PMTextView)commentLayout1.findViewById(0x7f0c0171);
            comment2 = (PMTextView)commentLayout2.findViewById(0x7f0c0171);
            allCommentsView = (PMTextView)view.findViewById(0x7f0c0115);
            nwtTextView.setTextSize(2, 10F);
            sizeView.setTextSize(2, 13F);
            brandView.setTextSize(2, 13F);
            return;

        case 3: // '\003'
            titleView = (TextView)view.findViewById(0x7f0c0130);
            break;
        }
        nwtTextView = (SearchFilterTextView)view.findViewById(0x7f0c007d);
        priceView = (TextView)view.findViewById(0x7f0c007f);
        originalPriceView = (TextView)view.findViewById(0x7f0c0080);
        originalPriceView.setPaintFlags(originalPriceView.getPaintFlags() | 0x10);
        categoryView = (ImageView)view.findViewById(0x7f0c0132);
        sizeView = (SearchFilterTextView)view.findViewById(0x7f0c0081);
        brandView = (SearchFilterTextView)view.findViewById(0x7f0c0134);
        descriptionView = (TextView)view.findViewById(0x7f0c0135);
        descriptionView.setMaxLines(2);
        descriptionView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        likesLayout = (LinearLayout)view.findViewById(0x7f0c0112);
        likesView = (PMTextView)likesLayout.findViewById(0x7f0c01d2);
        feeditem = (LinearLayout)view.findViewById(0x7f0c0116);
        likeButton = (Button)feeditem.findViewById(0x7f0c0045);
        commentButton = (Button)feeditem.findViewById(0x7f0c0168);
        shareButton = (Button)feeditem.findViewById(0x7f0c0046);
        commentLayout1 = (LinearLayout)view.findViewById(0x7f0c0113);
        commentLayout2 = (LinearLayout)view.findViewById(0x7f0c0114);
        commenterAvataar1 = (PMAvataarImageView)commentLayout1.findViewById(0x7f0c016f);
        commenterAvataar2 = (PMAvataarImageView)commentLayout2.findViewById(0x7f0c016f);
        comment1 = (PMTextView)commentLayout1.findViewById(0x7f0c0171);
        comment2 = (PMTextView)commentLayout2.findViewById(0x7f0c0171);
        allCommentsView = (PMTextView)view.findViewById(0x7f0c0115);
        nwtTextView.setTextSize(2, 10F);
        sizeView.setTextSize(2, 13F);
        brandView.setTextSize(2, 13F);
    }

    public void populateViewHolderWithHeaderViews(FeedItem feeditem, View view)
    {
        view = (LinearLayout)view;
        avataarView = (PMAvataarImageView)view.findViewById(0x7f0c011b);
        headerTitleView = (PMTextView)view.findViewById(0x7f0c011a);
        attributionView = (TextView)view.findViewById(0x7f0c011c);
        if (feeditem.layoutInfo.headerLayout.currentLayout == com.poshmark.data_model.models.inner_models.FeedItemHeaderLayout.Layout.DOUBLE_LEVEL_HEADER)
        {
            headerIconView = (ImageView)view.findViewById(0x7f0c0119);
            usernameTextView = (PMTextView)view.findViewById(0x7f0c0058);
        }
    }

    public void populateViewHolderWithImageViews(FeedItem feeditem, View view)
    {
        _cls1..SwitchMap.com.poshmark.data_model.models.FeedItemImageLayout.Layout[feeditem.layoutInfo.imageLayout.getCurrentLayout().ordinal()];
        JVM INSTR tableswitch 1 5: default 52
    //                   1 58
    //                   2 58
    //                   3 88
    //                   4 146
    //                   5 190;
           goto _L1 _L2 _L2 _L3 _L4 _L5
_L1:
        motherContainer = view;
        return;
_L2:
        coverShotViewBig = (PMClickableImageView)view.findViewById(0x7f0c0121);
        statusView = (ListingStatusView)view.findViewById(0x7f0c0127);
        continue; /* Loop/switch isn't completed */
_L3:
        coverShotViewBig = (PMClickableImageView)view.findViewById(0x7f0c0121);
        coverShotViewSmall1 = (PMClickableImageView)view.findViewById(0x7f0c0122);
        coverShotViewSmall2 = (PMClickableImageView)view.findViewById(0x7f0c0123);
        coverShotViewSmall3 = (PMClickableImageView)view.findViewById(0x7f0c0125);
        continue; /* Loop/switch isn't completed */
_L4:
        coverShotViewBig = (PMClickableImageView)view.findViewById(0x7f0c0121);
        coverShotViewSmall1 = (PMClickableImageView)view.findViewById(0x7f0c0122);
        coverShotViewSmall2 = (PMClickableImageView)view.findViewById(0x7f0c0123);
        continue; /* Loop/switch isn't completed */
_L5:
        coverShotViewBig = (PMClickableImageView)view.findViewById(0x7f0c0121);
        poshPostTextView = (PMTextView)view.findViewById(0x7f0c0129);
        if (true) goto _L1; else goto _L6
_L6:
    }
}
