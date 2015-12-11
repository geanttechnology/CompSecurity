// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseViewHolder

public class ActiveListViewHolder extends SellListBaseViewHolder
{

    private static final long MINUTE = 60000L;
    private final int colorBlack;
    private final int colorGray;
    private final int colorRed;
    private final String statusNoReserve;
    private final String statusReserve;
    private final String strDayHour;
    private final String strHourMin;
    private final String strMinutes;
    private final String strSeconds;
    private float textSizeMedium;
    private float textSizeSmall;

    public ActiveListViewHolder(View view, SellListBaseViewHolder.OnViewHolderClickListener onviewholderclicklistener)
    {
        super(view, onviewholderclicklistener);
        view = view.getContext().getResources();
        statusReserve = view.getString(0x7f070b32);
        statusNoReserve = view.getString(0x7f070b2f);
        strDayHour = view.getString(0x7f07004a);
        strHourMin = view.getString(0x7f07004d);
        strMinutes = view.getString(0x7f070051);
        strSeconds = view.getString(0x7f0705dc);
        textSizeMedium = view.getDimension(0x7f0900ae);
        textSizeSmall = view.getDimension(0x7f0900af);
        colorBlack = view.getColor(0x7f0d00dd);
        colorRed = view.getColor(0x7f0d00f0);
        colorGray = view.getColor(0x7f0d00e7);
        subtext1.setTextColor(colorBlack);
    }

    private void setTimeLeft(Date date, TextView textview)
    {
        int i;
        int j;
        int k;
        int l;
        long l1;
        if (date != null)
        {
            l1 = date.getTime() - EbayResponse.currentHostTime();
        } else
        {
            l1 = 0L;
        }
        if (l1 > 0L && l1 < 0x5265c00L)
        {
            i = colorRed;
        } else
        {
            i = colorGray;
        }
        j = (int)(l1 / 60000L);
        k = j / 60;
        l = k / 24;
        if (l > 0)
        {
            textview.setText(String.format(strDayHour, new Object[] {
                Integer.valueOf(l), Integer.valueOf(k % 24)
            }));
        } else
        if (k > 0)
        {
            textview.setText(String.format(strHourMin, new Object[] {
                Integer.valueOf(k), Integer.valueOf(j % 60)
            }));
        } else
        if (j > 0)
        {
            textview.setText(String.format(strMinutes, new Object[] {
                Integer.valueOf(j), Integer.valueOf(j)
            }));
        } else
        {
            textview.setText(strSeconds);
        }
        textview.setTextColor(i);
    }

    public void onBindView(int i, Object obj)
    {
        if (!(obj instanceof MyEbayListItem))
        {
            return;
        }
        MyEbayListItem myebaylistitem = (MyEbayListItem)obj;
        Resources resources = subtext1.getContext().getResources();
        i = colorBlack;
        obj = null;
        if (myebaylistitem.bidCount > 0 && myebaylistitem.reservePrice != null && myebaylistitem.reservePrice.value != null && !myebaylistitem.reservePrice.value.equals("0.0"))
        {
            if (myebaylistitem.reserveMet)
            {
                obj = statusReserve;
            } else
            {
                obj = statusNoReserve;
            }
        } else
        if (myebaylistitem.bidCount > 0)
        {
            obj = resources.getQuantityString(0x7f08002d, myebaylistitem.bidCount);
        } else
        if (myebaylistitem.bestOfferPendingCount > 0)
        {
            obj = resources.getQuantityString(0x7f08002e, myebaylistitem.bestOfferPendingCount, new Object[] {
                Integer.valueOf(myebaylistitem.bestOfferPendingCount)
            });
            i = colorRed;
        }
        if (obj != null)
        {
            textView.setTextAppearance(textView.getContext(), 0x7f0a0152);
            textView.setText(((CharSequence) (obj)));
            textView.setLines(1);
            textView2.setText(myebaylistitem.title);
            textView2.setVisibility(0);
            obj = Locale.getDefault().getLanguage();
            if (Locale.ITALIAN.getLanguage().equalsIgnoreCase(((String) (obj))))
            {
                textView.setTextSize(0, textSizeSmall);
            } else
            {
                textView.setTextSize(0, textSizeMedium);
            }
        } else
        {
            textView.setTextAppearance(textView.getContext(), 0x7f0a013d);
            textView.setText(myebaylistitem.title);
            textView.setLines(2);
            textView2.setVisibility(8);
            textView.setTextSize(0, textSizeMedium);
        }
        textView.setTextColor(i);
        image.setRemoteImageUrl(myebaylistitem.imageUrl);
        price.setText(EbayCurrencyUtil.formatDisplay(myebaylistitem.currentPrice, 2));
        if (2 == myebaylistitem.listingType || 3 == myebaylistitem.listingType)
        {
            subtext1.setText(resources.getQuantityString(0x7f080013, myebaylistitem.bidCount, new Object[] {
                Integer.valueOf(myebaylistitem.bidCount)
            }));
            subtext2.setText(resources.getQuantityString(0x7f08003b, myebaylistitem.watchCount, new Object[] {
                Integer.valueOf(myebaylistitem.watchCount)
            }));
            subtext2.setTextColor(colorBlack);
            setTimeLeft(myebaylistitem.endDate, subtext3);
            subtext3.setVisibility(0);
            return;
        } else
        {
            subtext1.setText(resources.getQuantityString(0x7f08003b, myebaylistitem.watchCount, new Object[] {
                Integer.valueOf(myebaylistitem.watchCount)
            }));
            setTimeLeft(myebaylistitem.endDate, subtext2);
            subtext3.setVisibility(4);
            return;
        }
    }
}
