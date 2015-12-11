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

public class ScheduledListViewHolder extends SellListBaseViewHolder
{

    private final java.text.DateFormat dateFormat;
    private final java.text.DateFormat timeFormat;

    public ScheduledListViewHolder(View view, SellListBaseViewHolder.OnViewHolderClickListener onviewholderclicklistener)
    {
        super(view, onviewholderclicklistener);
        view = view.getContext();
        if (view.getResources().getBoolean(0x7f0b0006))
        {
            textView.setTextAppearance(view, 0x7f0a013f);
        } else
        {
            textView.setTextAppearance(view, 0x7f0a013e);
        }
        textView.setLines(2);
        textView2.setVisibility(8);
        dateFormat = DateFormat.getMediumDateFormat(view);
        timeFormat = DateFormat.getTimeFormat(view);
    }

    public void onBindView(int i, Object obj)
    {
        if (!(obj instanceof MyEbayListItem))
        {
            return;
        }
        obj = (MyEbayListItem)obj;
        textView.setText(((MyEbayListItem) (obj)).title);
        image.setRemoteImageUrl(((MyEbayListItem) (obj)).imageUrl);
        if (((MyEbayListItem) (obj)).startPrice == null)
        {
            price.setText(EbayCurrencyUtil.formatDisplay(((MyEbayListItem) (obj)).buyItNowPrice, 2));
        } else
        {
            price.setText(EbayCurrencyUtil.formatDisplay(((MyEbayListItem) (obj)).startPrice, 2));
        }
        setShippingCost(((MyEbayListItem) (obj)), subtext1);
        subtext2.setText(dateFormat.format(((MyEbayListItem) (obj)).startDate));
        subtext3.setText(timeFormat.format(((MyEbayListItem) (obj)).startDate));
    }
}
