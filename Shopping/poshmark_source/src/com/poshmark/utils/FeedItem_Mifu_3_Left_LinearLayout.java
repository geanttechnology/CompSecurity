// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.poshmark.ui.customviews.PMCovershotImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.view_holders.ListingViewHolder;

// Referenced classes of package com.poshmark.utils:
//            FeedItemLinearLayout

public class FeedItem_Mifu_3_Left_LinearLayout extends FeedItemLinearLayout
{

    public FeedItem_Mifu_3_Left_LinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public FeedItem_Mifu_3_Left_LinearLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void populateViewHolder(ListingViewHolder listingviewholder)
    {
        super.populateViewHolder(listingviewholder);
        Object obj = (LinearLayout)findViewById(0x7f0c0111);
        listingviewholder.coverShotViewSmall1 = (PMCovershotImageView)((LinearLayout) (obj)).findViewById(0x7f0c0122);
        listingviewholder.coverShotViewSmall2 = (PMCovershotImageView)((LinearLayout) (obj)).findViewById(0x7f0c0123);
        obj = (RelativeLayout)findViewById(0x7f0c012c);
        listingviewholder.footerLayout = ((RelativeLayout) (obj));
        listingviewholder.footerTextView = (PMTextView)((RelativeLayout) (obj)).findViewById(0x7f0c011d);
        listingviewholder.footerLayout.setOnClickListener(footerClickListener);
    }
}
