// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.data.MyEbayListItem;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseViewHolder

public class UnsoldListViewHolder extends SellListBaseViewHolder
{

    private final java.text.DateFormat dateFormat;
    private final String relisted;
    private float textSizeMedium;

    public UnsoldListViewHolder(View view, SellListBaseViewHolder.OnViewHolderClickListener onviewholderclicklistener)
    {
        super(view, onviewholderclicklistener);
        view = view.getContext();
        onviewholderclicklistener = view.getResources();
        relisted = onviewholderclicklistener.getString(0x7f070b31);
        dateFormat = DateFormat.getMediumDateFormat(view);
        textSizeMedium = onviewholderclicklistener.getDimension(0x7f0900ae);
    }

    protected void onBindView(int i, Object obj)
    {
        if (!(obj instanceof MyEbayListItem))
        {
            return;
        }
        obj = (MyEbayListItem)obj;
        Resources resources;
        if (((MyEbayListItem) (obj)).isRelisted)
        {
            textView.setTextAppearance(textView.getContext(), 0x7f0a0152);
            textView.setText(relisted);
            textView.setLines(1);
            textView2.setText(((MyEbayListItem) (obj)).title);
            textView2.setVisibility(0);
        } else
        {
            textView.setTextAppearance(textView.getContext(), 0x7f0a013d);
            textView.setText(((MyEbayListItem) (obj)).title);
            textView.setLines(2);
            textView2.setVisibility(8);
        }
        textView.setTextSize(0, textSizeMedium);
        image.setRemoteImageUrl(((MyEbayListItem) (obj)).imageUrl);
        price.setText(EbayCurrencyUtil.formatDisplay(((MyEbayListItem) (obj)).currentPrice, 2));
        setShippingCost(((MyEbayListItem) (obj)), subtext1);
        resources = subtext2.getContext().getResources();
        subtext2.setText(resources.getQuantityString(0x7f08003b, ((MyEbayListItem) (obj)).watchCount, new Object[] {
            Integer.valueOf(((MyEbayListItem) (obj)).watchCount)
        }));
        subtext3.setText(dateFormat.format(((MyEbayListItem) (obj)).endDate));
    }
}
