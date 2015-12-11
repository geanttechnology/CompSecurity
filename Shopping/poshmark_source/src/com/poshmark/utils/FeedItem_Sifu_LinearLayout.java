// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.poshmark.ui.customviews.ListingStatusView;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.SearchFilterTextView;
import com.poshmark.utils.view_holders.ListingViewHolder;

// Referenced classes of package com.poshmark.utils:
//            FeedItemLinearLayout

public class FeedItem_Sifu_LinearLayout extends FeedItemLinearLayout
{

    public FeedItem_Sifu_LinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public FeedItem_Sifu_LinearLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void populateViewHolder(ListingViewHolder listingviewholder)
    {
        super.populateViewHolder(listingviewholder);
        listingviewholder.statusView = (ListingStatusView)((LinearLayout)findViewById(0x7f0c0111)).findViewById(0x7f0c0127);
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f0c012c);
        listingviewholder.titleView = (TextView)linearlayout.findViewById(0x7f0c0130);
        listingviewholder.nwtTextView = (SearchFilterTextView)linearlayout.findViewById(0x7f0c007d);
        listingviewholder.priceView = (TextView)linearlayout.findViewById(0x7f0c007f);
        listingviewholder.originalPriceView = (TextView)linearlayout.findViewById(0x7f0c0080);
        listingviewholder.originalPriceView.setPaintFlags(listingviewholder.originalPriceView.getPaintFlags() | 0x10);
        listingviewholder.categoryView = (ImageView)linearlayout.findViewById(0x7f0c0132);
        listingviewholder.sizeView = (SearchFilterTextView)linearlayout.findViewById(0x7f0c0081);
        listingviewholder.brandView = (SearchFilterTextView)linearlayout.findViewById(0x7f0c0134);
        listingviewholder.likesLayout = (LinearLayout)findViewById(0x7f0c0112);
        if (listingviewholder.resourceId == 0x7f03004c)
        {
            listingviewholder.likesCount = (TextView)listingviewholder.likesLayout.findViewById(0x7f0c0137);
            listingviewholder.commentsCount = (TextView)listingviewholder.likesLayout.findViewById(0x7f0c0138);
        }
        linearlayout = (LinearLayout)findViewById(0x7f0c0116);
        listingviewholder.likeButton = (Button)linearlayout.findViewById(0x7f0c0045);
        listingviewholder.commentButton = (Button)linearlayout.findViewById(0x7f0c0168);
        listingviewholder.shareButton = (Button)linearlayout.findViewById(0x7f0c0046);
        listingviewholder.commentLayout1 = (LinearLayout)findViewById(0x7f0c0113);
        listingviewholder.commentLayout2 = (LinearLayout)findViewById(0x7f0c0114);
        listingviewholder.commenterAvataar1 = (PMAvataarImageView)listingviewholder.commentLayout1.findViewById(0x7f0c016f);
        listingviewholder.commenterAvataar2 = (PMAvataarImageView)listingviewholder.commentLayout2.findViewById(0x7f0c016f);
        listingviewholder.comment1 = (PMTextView)listingviewholder.commentLayout1.findViewById(0x7f0c0171);
        listingviewholder.comment2 = (PMTextView)listingviewholder.commentLayout2.findViewById(0x7f0c0171);
        listingviewholder.allCommentsView = (PMTextView)findViewById(0x7f0c0115);
        listingviewholder.nwtTextView.setTextSize(2, 10F);
        listingviewholder.sizeView.setTextSize(2, 13F);
        listingviewholder.brandView.setTextSize(2, 13F);
        listingviewholder.commentButton.setOnClickListener(commentButtonListener);
        listingviewholder.likeButton.setOnClickListener(likeButtonListener);
        listingviewholder.shareButton.setOnClickListener(shareButtonListener);
    }
}
