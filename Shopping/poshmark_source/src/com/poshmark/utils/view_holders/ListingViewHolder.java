// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.view_holders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.poshmark.ui.customviews.ListingStatusView;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMCovershotImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.SearchFilterTextView;

public class ListingViewHolder
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
    public PMCovershotImageView coverShotViewBig;
    public PMCovershotImageView coverShotViewSmall1;
    public PMCovershotImageView coverShotViewSmall2;
    public PMCovershotImageView coverShotViewSmall3;
    public TextView descriptionView;
    public RelativeLayout footerLayout;
    public PMTextView footerTextView;
    public PMTextView headerTitleView;
    public Button likeButton;
    public TextView likesCount;
    public LinearLayout likesLayout;
    public PMTextView likesView;
    public SearchFilterTextView nwtTextView;
    public TextView originalPriceView;
    public TextView priceView;
    public int resourceId;
    public Button shareButton;
    public SearchFilterTextView sizeView;
    public ListingStatusView statusView;
    public TextView titleView;
    public View topBorder;
    public PMTextView userNameView;

    public ListingViewHolder()
    {
    }
}
