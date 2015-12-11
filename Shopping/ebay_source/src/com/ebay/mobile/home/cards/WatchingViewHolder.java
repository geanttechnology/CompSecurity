// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            WatchingViewModel

public class WatchingViewHolder extends ViewHolder
{
    public static class WatchingViewHolderItem extends ViewHolder
    {

        public final RemoteImageView image;
        public final View placeholder;
        public final TextView price;
        public final TextView signal;
        public final TextView title;

        public WatchingViewHolderItem(View view)
        {
            super(view);
            title = (TextView)view.findViewById(0x7f1002de);
            image = (RemoteImageView)view.findViewById(0x7f1002dc);
            price = (TextView)view.findViewById(0x7f1002dd);
            signal = (TextView)view.findViewById(0x7f1002df);
            placeholder = view.findViewById(0x7f1002e0);
        }
    }


    public static final int idList[] = {
        0x7f1002d7, 0x7f1002d8, 0x7f1002d9, 0x7f1002da, 0x7f1002db
    };
    public final List items = new ArrayList();
    public final Button seeAll;

    public WatchingViewHolder(View view)
    {
        super(view);
        int ai[] = idList;
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            View view1 = view.findViewById(ai[i]);
            if (view1 != null)
            {
                items.add(new WatchingViewHolderItem(view1));
                view1.setOnClickListener(this);
            }
        }

        seeAll = (Button)view.findViewById(0x7f100229);
        seeAll.setOnClickListener(this);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof WatchingViewModel))
        {
            throw new IllegalArgumentException("Model is not instance of WatchingViewModel");
        }
        viewmodel = (WatchingViewModel)viewmodel;
        Context context = itemView.getContext();
        Resources resources = context.getResources();
        boolean flag = resources.getBoolean(0x7f0b0006);
        byte byte0;
        int i;
        if (!DeviceInfoUtil.isPortrait(context))
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        if (flag && byte0 == 0)
        {
            byte0 = 4;
        } else
        {
            byte0 = 5;
        }
        i = 0;
        while (i < items.size()) 
        {
            WatchingViewHolderItem watchingviewholderitem = (WatchingViewHolderItem)items.get(i);
            if (i < ((WatchingViewModel) (viewmodel)).contentRecords.size() && i < byte0)
            {
                com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((WatchingViewModel) (viewmodel)).contentRecords.get(i)).listings.get(0);
                if (listing != null)
                {
                    if (listing.images != null && listing.images.size() != 0)
                    {
                        watchingviewholderitem.image.setRemoteImageUrl(((com.ebay.nautilus.domain.data.CompactListing.ImageSummary)listing.images.get(0)).imageURL);
                        watchingviewholderitem.image.setVisibility(0);
                        if (watchingviewholderitem.placeholder != null)
                        {
                            watchingviewholderitem.placeholder.setVisibility(8);
                        }
                    }
                    watchingviewholderitem.itemView.setVisibility(0);
                    watchingviewholderitem.itemView.setEnabled(true);
                    if (listing.currentBidPrice != null)
                    {
                        watchingviewholderitem.price.setText(EbayCurrencyUtil.formatDisplay(listing.currentBidPrice.getAmount(), 2));
                    } else
                    if (listing.lowestFixedPrice != null)
                    {
                        watchingviewholderitem.price.setText(EbayCurrencyUtil.formatDisplay(listing.lowestFixedPrice.getAmount(), 2));
                    }
                    if (listing.title != null)
                    {
                        watchingviewholderitem.title.setText(listing.title.content);
                    }
                    if (listing.timeRemaining != null)
                    {
                        long l = listing.timeRemaining.value;
                        if (listing.timeRemaining.value / 1000L > 0L)
                        {
                            watchingviewholderitem.signal.setText(String.format(resources.getString(0x7f0701f4), new Object[] {
                                Util.formatDayHour(context, l)
                            }));
                            if (l > 0x5265c00L)
                            {
                                watchingviewholderitem.signal.setTextColor(resources.getColor(0x7f0d00e7));
                                watchingviewholderitem.signal.setTypeface(null, 0);
                            } else
                            {
                                watchingviewholderitem.signal.setTextColor(resources.getColor(0x7f0d00f0));
                                watchingviewholderitem.signal.setTypeface(null, 1);
                            }
                        }
                    }
                }
            } else
            if (watchingviewholderitem != null)
            {
                if (flag)
                {
                    watchingviewholderitem.image.setVisibility(8);
                    watchingviewholderitem.placeholder.setVisibility(0);
                    watchingviewholderitem.price.setText("");
                    watchingviewholderitem.signal.setText("");
                    watchingviewholderitem.title.setText("");
                } else
                {
                    watchingviewholderitem.itemView.setVisibility(8);
                }
                watchingviewholderitem.itemView.setEnabled(false);
            }
            i++;
        }
    }

}
