// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            DealsItem, DealsActivity

class Cache
{

    public final ImageView image;
    public final TextView textDeal;
    public final TextView textDealCanada;
    public final TextView textEnergyRating;
    public final TextView textMsrp;
    public final TextView textPrice;
    public final TextView textShipping;
    public final TextView textTitle;

    public Cache(View view)
    {
        textTitle = (TextView)view.findViewById(0x1020014);
        textDeal = (TextView)view.findViewById(0x7f100168);
        textDealCanada = (TextView)view.findViewById(0x7f100166);
        textPrice = (TextView)view.findViewById(0x7f100135);
        textMsrp = (TextView)view.findViewById(0x7f100139);
        textShipping = (TextView)view.findViewById(0x7f100137);
        image = (ImageView)view.findViewById(0x7f10005b);
        textEnergyRating = (TextView)view.findViewById(0x7f100167);
        textMsrp.setPaintFlags(textMsrp.getPaintFlags() | 0x10);
    }

    public final void set(DealsItem dealsitem, ImageCache imagecache, boolean flag)
    {
        imagecache.setImage(image, dealsitem.imageUrl);
        textTitle.setText(dealsitem.title);
        if (dealsitem.deal != null)
        {
            imagecache = textDeal;
            int i = MyApp.getPrefs().getCurrentCountry().getSiteId();
            if (i == 2 || i == 210)
            {
                if (Locale.getDefault().getLanguage().equalsIgnoreCase("FR"))
                {
                    imagecache = textDealCanada;
                    textDeal.setVisibility(8);
                } else
                {
                    textDealCanada.setVisibility(8);
                }
                imagecache.setText(String.format(DealsActivity.upToString, new Object[] {
                    dealsitem.deal
                }));
                imagecache.setTextSize(12F);
            } else
            {
                textDeal.setText(dealsitem.deal);
                textDealCanada.setVisibility(8);
            }
            imagecache.setVisibility(0);
        } else
        {
            textDeal.setVisibility(8);
            textDealCanada.setVisibility(8);
        }
        textPrice.setText(dealsitem.price);
        textMsrp.setText(dealsitem.orps);
        textShipping.setText(dealsitem.shipping);
        textShipping.setTextColor(dealsitem.shippingColor);
        if (dealsitem.energyRating != null && flag)
        {
            imagecache = textEnergyRating.getContext();
            textEnergyRating.setText((new StringBuilder()).append(imagecache.getString(0x7f070087)).append(" ").append(dealsitem.energyRating).toString());
            textEnergyRating.setVisibility(0);
            return;
        } else
        {
            textEnergyRating.setText("");
            textEnergyRating.setVisibility(8);
            return;
        }
    }
}
