// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.trend:
//            TopicListingViewModel

public class TopicListingViewHolder extends ViewHolder
{

    private final RemoteImageView trendItemImage;
    private final TextView trendItemPrice;
    private final TextView trendItemTitle;

    public TopicListingViewHolder(View view)
    {
        super(view);
        trendItemImage = (RemoteImageView)view.findViewById(0x7f10082f);
        trendItemTitle = (TextView)view.findViewById(0x7f100829);
        trendItemPrice = (TextView)view.findViewById(0x7f10082a);
        view.setOnClickListener(this);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        if (!(viewmodel instanceof TopicListingViewModel) || flag && flag1)
        {
            return false;
        } else
        {
            return isNotEmpty(new CharSequence[] {
                ((TopicListingViewModel)viewmodel).trendItemTitle
            });
        }
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof TopicListingViewModel)
        {
            viewmodel = (TopicListingViewModel)viewmodel;
            trendItemImage.setRemoteImageUrl(((TopicListingViewModel) (viewmodel)).trendItemImage);
            trendItemTitle.setText(((TopicListingViewModel) (viewmodel)).trendItemTitle);
            trendItemPrice.setText(((TopicListingViewModel) (viewmodel)).trendItemPrice);
        }
    }
}
