// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ListingViewModel;

public class ListingViewHolder extends ViewHolder
{

    private String STRING_DEAL_PRICE_WITH_DISCOUNT;
    public final TextView description;
    public final TextView discount;
    public final TextView eekRating;
    public final RemoteImageView image;
    final Boolean isTablet;
    public final TextView price;
    public final TextView supply;
    public final TextView title;

    public ListingViewHolder(View view)
    {
        super(view);
        title = (TextView)view.findViewById(0x7f100108);
        image = (RemoteImageView)view.findViewById(0x7f1000fc);
        price = (TextView)view.findViewById(0x7f100109);
        discount = (TextView)view.findViewById(0x7f10010a);
        description = (TextView)view.findViewById(0x7f100243);
        supply = (TextView)view.findViewById(0x7f100106);
        eekRating = (TextView)view.findViewById(0x7f100107);
        STRING_DEAL_PRICE_WITH_DISCOUNT = view.getContext().getString(0x7f0701d5);
        isTablet = Boolean.valueOf(view.getContext().getResources().getBoolean(0x7f0b0006));
    }

    public void bind(ViewModel viewmodel)
    {
        boolean flag = false;
        super.bind(viewmodel);
        ListingViewModel listingviewmodel = (ListingViewModel)viewmodel;
        title.setText(listingviewmodel.title);
        image.setRemoteImageUrl(listingviewmodel.imageUrl);
        int i;
        if (price != null)
        {
            if (listingviewmodel.discountPriceType == com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.MINIMUM_ADVERTISED_PRICE)
            {
                SpannableString spannablestring;
                if (!TextUtils.isEmpty(listingviewmodel.strikeThroughPrice))
                {
                    viewmodel = listingviewmodel.strikeThroughPrice;
                } else
                {
                    viewmodel = listingviewmodel.suggestedRetailPrice;
                }
                spannablestring = new SpannableString(viewmodel);
                spannablestring.setSpan(new StrikethroughSpan(), 0, viewmodel.length(), 33);
                price.setText(spannablestring);
                price.setVisibility(0);
            } else
            {
                price.setText(listingviewmodel.price);
                viewmodel = price;
                if (TextUtils.isEmpty(listingviewmodel.price))
                {
                    i = 8;
                } else
                {
                    i = 0;
                }
                viewmodel.setVisibility(i);
            }
        }
        if (discount != null && listingviewmodel.suggestedRetailPrice != null)
        {
            if (listingviewmodel.discountPriceType == com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum.MINIMUM_ADVERTISED_PRICE)
            {
                discount.setText(0x7f0703dc);
            } else
            {
                viewmodel = new SpannableString(Html.fromHtml(String.format(STRING_DEAL_PRICE_WITH_DISCOUNT, new Object[] {
                    listingviewmodel.suggestedRetailPrice, listingviewmodel.percentOff
                })));
                viewmodel.setSpan(new StrikethroughSpan(), 0, listingviewmodel.suggestedRetailPrice.length(), 33);
                discount.setText(viewmodel);
            }
        } else
        if (description != null)
        {
            if (isTablet.booleanValue())
            {
                description.setText(listingviewmodel.title);
            } else
            {
                description.setVisibility(8);
            }
        }
        if (eekRating != null)
        {
            if (!TextUtils.isEmpty(listingviewmodel.eekDisplayText))
            {
                eekRating.setText(listingviewmodel.eekDisplayText);
                eekRating.setVisibility(0);
            } else
            {
                eekRating.setVisibility(8);
            }
        }
        if (supply != null)
        {
            viewmodel = supply;
            if (listingviewmodel.isAlmostGone)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            viewmodel.setVisibility(i);
        }
        if (discount != null)
        {
            viewmodel = discount;
            if (listingviewmodel.suggestedRetailPrice != null)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 8;
            }
            viewmodel.setVisibility(i);
        }
        itemView.setOnClickListener(this);
    }
}
