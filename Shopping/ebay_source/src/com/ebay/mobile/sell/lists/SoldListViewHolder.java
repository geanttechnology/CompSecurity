// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseViewHolder

public class SoldListViewHolder extends SellListBaseViewHolder
{

    private final String awaitingPayment;
    private final int colorNeutral;
    private final int colorRed;
    private final java.text.DateFormat dateFormat;
    private final String feedbackReceived;
    private final TextView msku;
    private final String paidShipNow;
    private final String shipped;

    public SoldListViewHolder(View view, SellListBaseViewHolder.OnViewHolderClickListener onviewholderclicklistener)
    {
        super(view, onviewholderclicklistener);
        onviewholderclicklistener = view.getContext();
        Resources resources = onviewholderclicklistener.getResources();
        if (EbaySite.DE.equals(MyApp.getPrefs().getCurrentSite()))
        {
            awaitingPayment = resources.getString(0x7f070b33);
        } else
        {
            awaitingPayment = resources.getString(0x7f070b2d);
        }
        paidShipNow = resources.getString(0x7f070b30);
        shipped = resources.getString(0x7f070b34);
        feedbackReceived = resources.getString(0x7f070b2e);
        colorNeutral = resources.getColor(0x7f0d00dd);
        colorRed = resources.getColor(0x7f0d00f0);
        dateFormat = DateFormat.getMediumDateFormat(onviewholderclicklistener);
        msku = (TextView)view.findViewById(0x7f100726);
    }

    protected void onBindView(int i, Object obj)
    {
        MyEbayListItem myebaylistitem;
        if (obj instanceof MyEbayListItem)
        {
            if ((myebaylistitem = (MyEbayListItem)obj).transaction != null)
            {
                textView.setTextColor(colorNeutral);
                String s = null;
                if (!myebaylistitem.transaction.isPaid())
                {
                    obj = awaitingPayment;
                } else
                if (!myebaylistitem.transaction.shipped)
                {
                    obj = paidShipNow;
                    textView.setTextColor(colorRed);
                } else
                {
                    obj = shipped;
                }
                if (myebaylistitem.transaction.feedbackReceived)
                {
                    s = feedbackReceived;
                }
                if (myebaylistitem.nameValueList != null && myebaylistitem.nameValueList.size() > 0)
                {
                    StringBuilder stringbuilder = new StringBuilder();
                    int j = myebaylistitem.nameValueList.size();
                    for (i = 0; i < j; i++)
                    {
                        stringbuilder.append(((NameValue)myebaylistitem.nameValueList.get(i)).getValue());
                        if (i != j - 1)
                        {
                            stringbuilder.append(", ");
                        }
                    }

                    msku.setText(stringbuilder.toString());
                    msku.setVisibility(0);
                } else
                {
                    msku.setVisibility(4);
                }
                textView.setText(((CharSequence) (obj)));
                textView2.setText(myebaylistitem.title);
                if (!TextUtils.isEmpty(s))
                {
                    statusText2.setText(s);
                    statusText2.setVisibility(0);
                } else
                {
                    statusText2.setVisibility(4);
                }
                image.setRemoteImageUrl(myebaylistitem.imageUrl);
                price.setText(EbayCurrencyUtil.formatDisplay(myebaylistitem.transaction.totalTransactionPrice, 2));
                setShippingCost(myebaylistitem, subtext1);
                subtext2.setText(myebaylistitem.buyerUserID);
                subtext3.setText(dateFormat.format(myebaylistitem.transaction.createdDate));
                return;
            }
        }
    }
}
