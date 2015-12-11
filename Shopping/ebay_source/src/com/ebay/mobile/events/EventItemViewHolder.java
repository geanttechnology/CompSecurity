// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import java.util.List;

public class EventItemViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder
{

    private final TextView bidsTextView;
    private final TextView discountTextView;
    private final LinearLayout eventItemContainer;
    private final TextView moreOptionsTextView;
    private final TextView priceInCartTextView;
    private final TextView priceTextView;
    private final RemoteImageView remoteImageView;
    private final TextView shippingCostTextView;
    private final TextView titleTextView;

    public EventItemViewHolder(View view, android.view.View.OnClickListener onclicklistener)
    {
        super(view, null);
        titleTextView = (TextView)view.findViewById(0x7f10019b);
        priceTextView = (TextView)view.findViewById(0x7f10019c);
        priceInCartTextView = (TextView)view.findViewById(0x7f1001a0);
        moreOptionsTextView = (TextView)view.findViewById(0x7f10019d);
        discountTextView = (TextView)view.findViewById(0x7f10019f);
        bidsTextView = (TextView)view.findViewById(0x7f10019e);
        remoteImageView = (RemoteImageView)view.findViewById(0x7f10019a);
        shippingCostTextView = (TextView)view.findViewById(0x7f1001a1);
        eventItemContainer = (LinearLayout)view.findViewById(0x7f100199);
        if (eventItemContainer != null)
        {
            eventItemContainer.setOnClickListener(onclicklistener);
        }
    }

    protected void onBindView(int i, com.ebay.nautilus.domain.data.Event.SearchRecord searchrecord)
    {
_L2:
        return;
        if (searchrecord == null || searchrecord.item == null) goto _L2; else goto _L1
_L1:
        Resources resources;
        Object obj;
        Object obj2;
        boolean flag;
        resources = itemView.getResources();
        titleTextView.setText(searchrecord.item.title);
        com.ebay.nautilus.domain.data.Event.Amount amount = searchrecord.item.sellingStatus.currentPrice;
        Object obj1;
        if (amount != null)
        {
            priceTextView.setVisibility(0);
            priceTextView.setText(EbayCurrencyUtil.formatDisplay(searchrecord.item.sellingStatus.currentPrice.currencyId, searchrecord.item.sellingStatus.currentPrice.value.doubleValue(), 2));
        } else
        {
            priceTextView.setVisibility(8);
        }
        flag = false;
        obj1 = searchrecord.item.discountPriceInfo;
        priceInCartTextView.setVisibility(8);
        discountTextView.setVisibility(8);
        i = ((flag) ? 1 : 0);
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        i = ((flag) ? 1 : 0);
        if (((com.ebay.nautilus.domain.data.Event.DiscountPriceInfo) (obj1)).originalRetailPrice == null) goto _L4; else goto _L5
_L5:
        obj2 = EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.Event.DiscountPriceInfo) (obj1)).originalRetailPrice.currencyId, ((com.ebay.nautilus.domain.data.Event.DiscountPriceInfo) (obj1)).originalRetailPrice.value.doubleValue(), 2);
        obj = new SpannableString(Html.fromHtml(((String) (obj2))));
        ((Spannable) (obj)).setSpan(new StrikethroughSpan(), 0, ((String) (obj2)).length(), 33);
        obj2 = ((com.ebay.nautilus.domain.data.Event.DiscountPriceInfo) (obj1)).pricingTreatment;
        obj1 = ((com.ebay.nautilus.domain.data.Event.DiscountPriceInfo) (obj1)).minimumAdvertisedPriceExposure;
        i = ((flag) ? 1 : 0);
        if (obj2 == null) goto _L4; else goto _L6
_L6:
        i = ((flag) ? 1 : 0);
        if (obj1 == null) goto _L4; else goto _L7
_L7:
        i = ((flag) ? 1 : 0);
        if (obj2 == com.ebay.nautilus.domain.data.Event.PricingTreatment.None) goto _L4; else goto _L8
_L8:
        flag = true;
        if (obj2 != com.ebay.nautilus.domain.data.Event.PricingTreatment.STP) goto _L10; else goto _L9
_L9:
        discountTextView.setText(((CharSequence) (obj)));
        discountTextView.setVisibility(0);
        i = ((flag) ? 1 : 0);
_L4:
        obj = searchrecord.item.shippingInfo;
        if ((amount != null || i == 1) && obj != null && searchrecord.item.shippingInfo.shippingCost != null)
        {
            com.ebay.nautilus.domain.data.Event.Amount amount1 = searchrecord.item.shippingInfo.shippingCost;
            shippingCostTextView.setVisibility(0);
            if (((com.ebay.nautilus.domain.data.Event.ShippingInfo) (obj)).shippingType == com.ebay.nautilus.domain.data.Event.ShippingType.Free)
            {
                shippingCostTextView.setText(resources.getText(0x7f070421));
            } else
            {
                shippingCostTextView.setText(String.format(resources.getString(0x7f070a8d), new Object[] {
                    EbayCurrencyUtil.formatDisplay(amount1.currencyId, amount1.value.doubleValue(), 2)
                }));
            }
        } else
        {
            shippingCostTextView.setVisibility(8);
        }
        if (searchrecord.item.itemImageInfo != null && searchrecord.item.itemImageInfo.size() > 0)
        {
            remoteImageView.setRemoteImageUrl(((com.ebay.nautilus.domain.data.Event.ItemImageInfo)searchrecord.item.itemImageInfo.get(0)).imageURL);
        } else
        {
            remoteImageView.setRemoteImageUrl(null);
        }
        eventItemContainer.setTag(Long.valueOf(searchrecord.item.itemId));
        if (searchrecord.item.multiVariationListing)
        {
            moreOptionsTextView.setVisibility(0);
        } else
        {
            moreOptionsTextView.setVisibility(8);
        }
        bidsTextView.setVisibility(8);
        if (searchrecord.item.listingInfo != null && searchrecord.item.sellingStatus != null && (searchrecord.item.listingInfo.listingType == com.ebay.nautilus.domain.data.Event.ListingType.CHINESE_AUCTION || searchrecord.item.listingInfo.listingType == com.ebay.nautilus.domain.data.Event.ListingType.DUTCH_AUCTION || searchrecord.item.listingInfo.listingType == com.ebay.nautilus.domain.data.Event.ListingType.LIVE_AUCTION))
        {
            bidsTextView.setVisibility(0);
            bidsTextView.setText(resources.getQuantityString(0x7f080013, searchrecord.item.sellingStatus.bidCount, new Object[] {
                Integer.valueOf(searchrecord.item.sellingStatus.bidCount)
            }));
            return;
        }
        if (true) goto _L2; else goto _L10
_L10:
        i = ((flag) ? 1 : 0);
        if (obj2 == com.ebay.nautilus.domain.data.Event.PricingTreatment.MAP)
        {
            priceTextView.setText(((CharSequence) (obj)));
            priceTextView.setVisibility(0);
            priceInCartTextView.setVisibility(0);
            i = ((flag) ? 1 : 0);
        }
          goto _L4
    }

    protected volatile void onBindView(int i, Object obj)
    {
        onBindView(i, (com.ebay.nautilus.domain.data.Event.SearchRecord)obj);
    }
}
