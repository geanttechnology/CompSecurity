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
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            RecentlyViewedItemsModel

public class RecentlyViewedItemsHolder extends ViewHolder
{
    public static class RecentlyViewedItemsItemHolder extends ViewHolder
    {

        public final TextView eekRating;
        public final RemoteImageView image;
        public final View placeholder;
        public final TextView price;
        public final TextView title;

        public RecentlyViewedItemsItemHolder(View view)
        {
            super(view);
            image = (RemoteImageView)view.findViewById(0x7f100296);
            title = (TextView)view.findViewById(0x7f100298);
            price = (TextView)view.findViewById(0x7f100299);
            eekRating = (TextView)view.findViewById(0x7f100297);
            placeholder = view.findViewById(0x7f10029a);
        }
    }


    public static final int idList[] = {
        0x7f100290, 0x7f100291, 0x7f100292, 0x7f100293, 0x7f100295
    };
    public final Button edit;
    public final List items = new ArrayList();
    private final Resources resources;
    public final Button seeAll;

    public RecentlyViewedItemsHolder(View view)
    {
        super(view);
        int ai[] = idList;
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            View view1 = view.findViewById(ai[i]);
            if (view1 != null)
            {
                items.add(new RecentlyViewedItemsItemHolder(view1));
                view1.setOnClickListener(this);
            }
        }

        seeAll = (Button)view.findViewById(0x7f100294);
        edit = (Button)view.findViewById(0x7f10028e);
        edit.setVisibility(8);
        resources = view.getResources();
        seeAll.setOnClickListener(this);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof RecentlyViewedItemsModel))
        {
            throw new IllegalArgumentException("Model is not instance of RecentlyViewedItemsModel");
        }
        viewmodel = (RecentlyViewedItemsModel)viewmodel;
        Context context = itemView.getContext();
        boolean flag1 = context.getResources().getBoolean(0x7f0b0006);
        boolean flag;
        if (!DeviceInfoUtil.isPortrait(context))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((RecentlyViewedItemsModel) (viewmodel)).contentRecords != null)
        {
            byte byte0;
            int i;
            if (flag1 && !flag)
            {
                byte0 = 4;
            } else
            {
                byte0 = 5;
            }
            i = 0;
            while (i < items.size()) 
            {
                RecentlyViewedItemsItemHolder recentlyvieweditemsitemholder = (RecentlyViewedItemsItemHolder)items.get(i);
                if (i < ((RecentlyViewedItemsModel) (viewmodel)).contentRecords.size() && i < byte0)
                {
                    if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((RecentlyViewedItemsModel) (viewmodel)).contentRecords.get(i)).listings == null)
                    {
                        recentlyvieweditemsitemholder.itemView.setEnabled(false);
                        recentlyvieweditemsitemholder.image.setVisibility(4);
                        if (recentlyvieweditemsitemholder.placeholder != null)
                        {
                            recentlyvieweditemsitemholder.placeholder.setVisibility(0);
                        }
                    } else
                    if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((RecentlyViewedItemsModel) (viewmodel)).contentRecords.get(i)).listings.size() == 0)
                    {
                        recentlyvieweditemsitemholder.itemView.setEnabled(false);
                        recentlyvieweditemsitemholder.image.setVisibility(4);
                        if (recentlyvieweditemsitemholder.placeholder != null)
                        {
                            recentlyvieweditemsitemholder.placeholder.setVisibility(0);
                        }
                    } else
                    {
                        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((RecentlyViewedItemsModel) (viewmodel)).contentRecords.get(i)).listings.get(0);
                        recentlyvieweditemsitemholder.itemView.setEnabled(true);
                        recentlyvieweditemsitemholder.itemView.setVisibility(0);
                        recentlyvieweditemsitemholder.image.setVisibility(0);
                        if (recentlyvieweditemsitemholder.placeholder != null)
                        {
                            recentlyvieweditemsitemholder.placeholder.setVisibility(4);
                        }
                        if (listing.imageUrl != null)
                        {
                            recentlyvieweditemsitemholder.image.setRemoteImageUrl(listing.imageUrl);
                        }
                        if (listing.title != null)
                        {
                            recentlyvieweditemsitemholder.title.setText(listing.title.content);
                        }
                        recentlyvieweditemsitemholder.eekRating.setVisibility(8);
                        recentlyvieweditemsitemholder.title.setMaxLines(2);
                        if (listing.aspectValuesList != null)
                        {
                            Iterator iterator = listing.aspectValuesList.iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                Object obj = (com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair)iterator.next();
                                if ("EnergyEfficiencyRating".equals(((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (obj)).globalIdentifier) && ((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (obj)).values.size() > 0 && ((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (obj)).name != null)
                                {
                                    String s = ((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (obj)).name.content;
                                    obj = ((com.ebay.nautilus.domain.data.BaseCommonType.Text)((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (obj)).values.get(0)).content;
                                    recentlyvieweditemsitemholder.eekRating.setVisibility(0);
                                    recentlyvieweditemsitemholder.eekRating.setText(String.format(resources.getString(0x7f07046a), new Object[] {
                                        s, obj
                                    }));
                                    recentlyvieweditemsitemholder.title.setMaxLines(1);
                                }
                            } while (true);
                        }
                        if (listing.currentBidPrice != null && com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION.equals(listing.format))
                        {
                            recentlyvieweditemsitemholder.price.setText(EbayCurrencyUtil.formatDisplay(listing.currentBidPrice.currency, listing.currentBidPrice.value, 2));
                        } else
                        if (listing.lowestFixedPrice != null && com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.FIXED_PRICE.equals(listing.format))
                        {
                            recentlyvieweditemsitemholder.price.setText(EbayCurrencyUtil.formatDisplay(listing.lowestFixedPrice.currency, listing.lowestFixedPrice.value, 2));
                        }
                    }
                } else
                if (flag1)
                {
                    recentlyvieweditemsitemholder.itemView.setEnabled(false);
                    recentlyvieweditemsitemholder.image.setVisibility(4);
                    recentlyvieweditemsitemholder.placeholder.setVisibility(0);
                    recentlyvieweditemsitemholder.price.setText("");
                    recentlyvieweditemsitemholder.title.setText("");
                } else
                {
                    recentlyvieweditemsitemholder.itemView.setVisibility(8);
                }
                i++;
            }
        }
    }

}
