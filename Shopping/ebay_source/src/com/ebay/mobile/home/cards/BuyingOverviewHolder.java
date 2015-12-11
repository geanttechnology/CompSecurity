// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.util.ThemeUtil;

// Referenced classes of package com.ebay.mobile.home.cards:
//            BuyingOverviewModel

public class BuyingOverviewHolder extends ViewHolder
{
    public static class BuyingOverviewHolderItem extends ViewHolder
    {

        private TextView bottomText;
        private TextView centerText;
        private TextView topText;




        public BuyingOverviewHolderItem(View view)
        {
            super(view);
            topText = (TextView)view.findViewById(0x7f10022d);
            centerText = (TextView)view.findViewById(0x7f10022e);
            bottomText = (TextView)view.findViewById(0x7f10022f);
        }
    }


    public final BuyingOverviewHolderItem bids;
    public final BuyingOverviewHolderItem offers;
    public final BuyingOverviewHolderItem purchases;
    public final Button seeAll;

    public BuyingOverviewHolder(View view)
    {
        super(view);
        bids = new BuyingOverviewHolderItem(view.findViewById(0x7f100226));
        offers = new BuyingOverviewHolderItem(view.findViewById(0x7f100227));
        purchases = new BuyingOverviewHolderItem(view.findViewById(0x7f100228));
        seeAll = (Button)view.findViewById(0x7f100229);
        bids.itemView.setOnClickListener(this);
        offers.itemView.setOnClickListener(this);
        purchases.itemView.setOnClickListener(this);
        seeAll.setOnClickListener(this);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof BuyingOverviewModel))
        {
            throw new IllegalArgumentException("Model is not instance of BuyingOverviewModel");
        }
        Resources resources = itemView.getContext().getResources();
        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.BuyingOverview buyingoverview = ((BuyingOverviewModel)viewmodel).record.buyingOverview;
        Object obj;
        String s;
        Object obj1;
        int i;
        if (buyingoverview.purchaseSummary == null)
        {
            viewmodel = String.valueOf(0);
        } else
        {
            viewmodel = String.valueOf(buyingoverview.purchaseSummary.totalCount);
        }
        if (buyingoverview.bidSummary == null)
        {
            obj = String.valueOf(0);
        } else
        {
            obj = String.valueOf(buyingoverview.bidSummary.totalCount);
        }
        if (buyingoverview.bestOfferSummary == null)
        {
            s = String.valueOf(0);
        } else
        {
            s = String.valueOf(buyingoverview.bestOfferSummary.totalCount);
        }
        obj1 = viewmodel;
        if (buyingoverview.purchaseSummary != null)
        {
            obj1 = viewmodel;
            if (buyingoverview.purchaseSummary.hasMorePurchase)
            {
                obj1 = (new StringBuilder()).append(viewmodel).append("+").toString();
            }
        }
        purchases.topText.setText(((CharSequence) (obj1)));
        viewmodel = purchases.centerText;
        if (buyingoverview.purchaseSummary == null)
        {
            i = 0;
        } else
        {
            i = buyingoverview.purchaseSummary.totalCount;
        }
        viewmodel.setText(resources.getQuantityString(0x7f08000c, i));
        if (buyingoverview.purchaseSummary != null && buyingoverview.purchaseSummary.waitingForPaymentCount > 0)
        {
            purchases.bottomText.setText(String.format(resources.getQuantityString(0x7f08000b, buyingoverview.purchaseSummary.waitingForPaymentCount), new Object[] {
                Integer.valueOf(buyingoverview.purchaseSummary.waitingForPaymentCount)
            }));
        }
        viewmodel = purchases.bottomText;
        if (buyingoverview.purchaseSummary != null && buyingoverview.purchaseSummary.waitingForPaymentCount > 0)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        viewmodel.setVisibility(i);
        offers.topText.setText(s);
        viewmodel = offers.centerText;
        if (buyingoverview.bestOfferSummary == null)
        {
            i = 0;
        } else
        {
            i = buyingoverview.bestOfferSummary.totalCount;
        }
        viewmodel.setText(resources.getQuantityString(0x7f080009, i));
        if (buyingoverview.bestOfferSummary != null && buyingoverview.bestOfferSummary.counterOfferCount > 0)
        {
            offers.bottomText.setText(String.format(resources.getQuantityString(0x7f080008, buyingoverview.bestOfferSummary.counterOfferCount), new Object[] {
                Integer.valueOf(buyingoverview.bestOfferSummary.counterOfferCount)
            }));
        }
        viewmodel = offers.bottomText;
        if (buyingoverview.bestOfferSummary != null && buyingoverview.bestOfferSummary.counterOfferCount > 0)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        viewmodel.setVisibility(i);
        bids.topText.setText(((CharSequence) (obj)));
        viewmodel = bids.centerText;
        if (buyingoverview.bidSummary == null)
        {
            i = 0;
        } else
        {
            i = buyingoverview.bidSummary.totalCount;
        }
        viewmodel.setText(resources.getQuantityString(0x7f080007, i));
        if (buyingoverview.bidSummary != null && buyingoverview.bidSummary.outbidCount > 0)
        {
            bids.bottomText.setText(String.format(resources.getQuantityString(0x7f08000a, buyingoverview.bidSummary.outbidCount), new Object[] {
                Integer.valueOf(buyingoverview.bidSummary.outbidCount)
            }));
        }
        viewmodel = bids.bottomText;
        if (buyingoverview.bidSummary != null && buyingoverview.bidSummary.outbidCount > 0)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        viewmodel.setVisibility(i);
        viewmodel = ThemeUtil.resolveThemeColorStateList(resources, itemView.getContext().getTheme(), 0x1010036);
        obj = ThemeUtil.resolveThemeColorStateList(resources, itemView.getContext().getTheme(), 0x1010038);
        if (buyingoverview.bidSummary != null && buyingoverview.bidSummary.totalCount > 0)
        {
            bids.centerText.setTextColor(viewmodel);
            bids.topText.setTextColor(viewmodel);
        } else
        {
            bids.itemView.setEnabled(false);
            bids.centerText.setTextColor(((android.content.res.ColorStateList) (obj)));
            bids.topText.setTextColor(((android.content.res.ColorStateList) (obj)));
        }
        if (buyingoverview.bestOfferSummary != null && buyingoverview.bestOfferSummary.totalCount > 0)
        {
            offers.centerText.setTextColor(viewmodel);
            offers.topText.setTextColor(viewmodel);
        } else
        {
            offers.itemView.setEnabled(false);
            offers.centerText.setTextColor(((android.content.res.ColorStateList) (obj)));
            offers.topText.setTextColor(((android.content.res.ColorStateList) (obj)));
        }
        if (buyingoverview.purchaseSummary != null && buyingoverview.purchaseSummary.totalCount > 0)
        {
            purchases.centerText.setTextColor(viewmodel);
            purchases.topText.setTextColor(viewmodel);
            return;
        } else
        {
            purchases.itemView.setEnabled(false);
            purchases.centerText.setTextColor(((android.content.res.ColorStateList) (obj)));
            purchases.topText.setTextColor(((android.content.res.ColorStateList) (obj)));
            return;
        }
    }
}
