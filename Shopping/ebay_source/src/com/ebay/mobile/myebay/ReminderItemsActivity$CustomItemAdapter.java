// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.view.DefaultItemAdapter;
import com.ebay.common.view.ViewCache;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.myebay:
//            ReminderItemsActivity

protected static class reminderType extends DefaultItemAdapter
{

    private final int reminderType;

    public volatile void setItem(ViewCache viewcache, EbaySearchListItem ebaysearchlistitem, int i)
    {
        setItem(viewcache, (MyEbayListItem)ebaysearchlistitem, i);
    }

    public void setItem(ViewCache viewcache, MyEbayListItem myebaylistitem, int i)
    {
        viewcache.image.setRemoteImageUrl(myebaylistitem.imageUrl);
        String s = myebaylistitem.title;
        viewcache.text.setText(s);
        setTimeLeft(viewcache.rightColumnText4, myebaylistitem.endDate, EbayResponse.currentHostTime());
        myebaylistitem.sellingState;
        JVM INSTR tableswitch 4 5: default 68
    //                   4 430
    //                   5 444;
           goto _L1 _L2 _L3
_L1:
        reminderType;
        JVM INSTR tableswitch 10 12: default 100
    //                   10 458
    //                   11 458
    //                   12 458;
           goto _L4 _L5 _L5 _L5
_L4:
        viewcache.rightColumnText3.setMaxLines(2);
        viewcache.rightColumnText3.setSingleLine(false);
_L16:
        double d;
        Object obj;
        ItemCurrency itemcurrency;
        int j;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        j = 0;
        i = 0;
        flag2 = false;
        flag3 = false;
        obj = null;
        if (myebaylistitem.transaction != null && myebaylistitem.transaction.ionPrice != null)
        {
            itemcurrency = myebaylistitem.transaction.ionPrice;
        } else
        {
            itemcurrency = myebaylistitem.currentPrice;
            obj = myebaylistitem.convertedCurrentPrice;
        }
        myebaylistitem.listingType;
        JVM INSTR tableswitch 2 6: default 196
    //                   2 555
    //                   3 492
    //                   4 196
    //                   5 609
    //                   6 609;
           goto _L6 _L7 _L8 _L6 _L9 _L9
_L6:
        if (myebaylistitem.transaction != null && myebaylistitem.transaction.ionPrice != null)
        {
            itemcurrency = myebaylistitem.transaction.ionPrice;
        } else
        if (myebaylistitem.transaction != null && myebaylistitem.currentPrice != null)
        {
            itemcurrency = myebaylistitem.currentPrice;
            (new CurrencyAmount(itemcurrency)).multiplyBy(myebaylistitem.transaction.ased);
            obj = myebaylistitem.convertedCurrentPrice;
        } else
        {
            itemcurrency = myebaylistitem.currentPrice;
            obj = myebaylistitem.convertedCurrentPrice;
        }
        flag2 = setCurrency(viewcache.rightColumnText1, itemcurrency, ((ItemCurrency) (obj)));
        viewcache.rightColumnText3.setText("");
        j = i;
        if (myebaylistitem.bestOfferAmount != null)
        {
            setCurrency(viewcache.rightColumnText1, myebaylistitem.bestOfferAmount, null);
        }
        if (flag2)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag3)
        {
            viewcache.rightColumnText1.setText(0x7f0705ab);
        }
        if (j != 0)
        {
            setCurrency(viewcache.rightColumnText5, myebaylistitem.originalRetailPrice, null);
            viewcache.rightColumnText5.setVisibility(0);
        } else
        {
            viewcache.rightColumnText5.setVisibility(8);
        }
        if (!showShipping || myebaylistitem.shippingCost == null || myebaylistitem.shippingCost.code == null || myebaylistitem.shippingCost.value == null) goto _L11; else goto _L10
_L10:
        j = colorSecondary;
        flag1 = false;
        flag = false;
        d = Double.parseDouble(myebaylistitem.shippingCost.value);
        if (d >= 0.01D) goto _L13; else goto _L12
_L12:
        if (!showFreeShipping) goto _L15; else goto _L14
_L14:
        j = colorShippingFree;
        viewcache.rightColumnText2.setText(0x7f070422);
        i = ((flag) ? 1 : 0);
        break MISSING_BLOCK_LABEL_409;
_L2:
        viewcache.rightColumnText1.setTextColor(colorPriceSold);
        continue; /* Loop/switch isn't completed */
_L3:
        viewcache.rightColumnText1.setTextColor(colorPriceUnsold);
        continue; /* Loop/switch isn't completed */
_L5:
        viewcache.rightColumnText3.setMaxLines(1);
        viewcache.rightColumnText3.setSingleLine(true);
          goto _L16
_L8:
        if (myebaylistitem.buyItNowAvailable && (myebaylistitem.buyItNowPrice != null || myebaylistitem.convertedBuyItNowPrice != null) && (buyingFormat & 1) == 0)
        {
            flag2 = setCurrency(viewcache.rightColumnText1, myebaylistitem.buyItNowPrice, myebaylistitem.convertedBuyItNowPrice);
            viewcache.rightColumnText3.setText(0x7f070529);
            j = i;
            break MISSING_BLOCK_LABEL_248;
        }
_L7:
        flag2 = setCurrency(viewcache.rightColumnText1, itemcurrency, ((ItemCurrency) (obj)));
        viewcache.rightColumnText3.setText(resources.getQuantityString(0x7f080013, myebaylistitem.bidCount, new Object[] {
            Integer.valueOf(myebaylistitem.bidCount)
        }));
        j = i;
        break MISSING_BLOCK_LABEL_248;
_L9:
        flag3 = flag2;
        i = j;
        if (myebaylistitem.originalRetailPrice != null)
        {
            flag3 = flag2;
            i = j;
            if (myebaylistitem.originalRetailPrice.code != null)
            {
                flag3 = flag2;
                i = j;
                if (myebaylistitem.originalRetailPrice.value != null)
                {
                    flag3 = "MAP".equals(myebaylistitem.pricingTreatment);
                    if (flag3 || "STP".equals(myebaylistitem.pricingTreatment))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                }
            }
        }
        flag2 = setCurrency(viewcache.rightColumnText1, itemcurrency, ((ItemCurrency) (obj)));
        viewcache.rightColumnText3.setText(0x7f070529);
        j = i;
        break MISSING_BLOCK_LABEL_248;
_L15:
        viewcache.rightColumnText2.setText("");
        i = ((flag) ? 1 : 0);
_L19:
        try
        {
            viewcache.rightColumnText2.setTypeface(Typeface.DEFAULT, i);
            viewcache.rightColumnText2.setTextColor(j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MyEbayListItem myebaylistitem)
        {
            viewcache.rightColumnText2.setText("");
        }
        return;
_L13:
        obj = formatCurrency(d, myebaylistitem.shippingCost.code, i | 2);
        i = ((flag1) ? 1 : 0);
        myebaylistitem = ((MyEbayListItem) (obj));
        if (!flag2) goto _L18; else goto _L17
_L17:
        i = 2;
        myebaylistitem = (new StringBuilder()).append(((String) (obj))).append(" ").toString();
_L18:
        viewcache.rightColumnText2.setText(myebaylistitem);
        if (true) goto _L19; else goto _L11
_L11:
        viewcache.rightColumnText2.setText("");
        return;
        if (true) goto _L1; else goto _L20
_L20:
    }

    public volatile void setItem(ViewCache viewcache, Object obj, int i)
    {
        setItem(viewcache, (MyEbayListItem)obj, i);
    }

    protected void setTimeLeft(TextView textview, Date date, long l)
    {
        int i;
        if (date != null)
        {
            l = date.getTime() - l;
        } else
        {
            l = 0L;
        }
        if (l > 0L && l < 0x5265c00L)
        {
            i = colorTimeWarning;
        } else
        {
            i = colorSecondary;
        }
        textview.setTextColor(i);
        if (l >= 0x757b12c00L)
        {
            textview.setText(null);
            return;
        }
        if (l > 0L)
        {
            l /= 1000L;
            int j = (int)(l % 60L);
            l /= 60L;
            int k = (int)(l % 60L);
            l /= 60L;
            int i1 = (int)(l % 24L);
            int j1 = (int)(l / 24L);
            date = new StringBuilder();
            if (j1 > 0)
            {
                date.append(j1).append(strDays).append(' ').append(i1).append(strHours);
            } else
            if (i1 > 0)
            {
                date.append(i1).append(strHours).append(' ').append(k).append(strMinutes);
            } else
            if (k > 0)
            {
                date.append(k).append(strMinutes).append(' ').append(j).append(strSeconds);
            } else
            {
                date.append(j).append(strSeconds);
            }
            textview.setText(date.toString());
            return;
        } else
        {
            textview.setText(0x7f0703c3);
            return;
        }
    }

    public (Activity activity, boolean flag, boolean flag1, int i)
    {
        super(activity, flag, flag1, false, 7, false);
        reminderType = i;
    }
}
