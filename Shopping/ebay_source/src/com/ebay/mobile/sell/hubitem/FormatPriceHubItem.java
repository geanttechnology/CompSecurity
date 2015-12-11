// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.hubitem;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.sell.HubDisplayState;

// Referenced classes of package com.ebay.mobile.sell.hubitem:
//            CustomHubItem

public class FormatPriceHubItem extends CustomHubItem
{

    private String guaranteedSalePrice;

    public FormatPriceHubItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public String getDynamicBubbleText()
    {
        if (guaranteedSalePrice == null)
        {
            return null;
        } else
        {
            return getResources().getString(0x7f0707b4, new Object[] {
                guaranteedSalePrice
            });
        }
    }

    public int getLabelResource()
    {
        return 0x7f0709d8;
    }

    public void setDisplayFromState(HubDisplayState hubdisplaystate, boolean flag)
    {
        setStatusIndicator(flag);
        if (!flag)
        {
            setCellValue(null);
        } else
        {
            guaranteedSalePrice = hubdisplaystate.guaranteeSalePrice;
            if ("ChineseAuction".equals(hubdisplaystate.formatValue))
            {
                String s2 = getResources().getString(0x7f0701a3);
                Double double1 = EbayCurrencyUtil.parseApiValue(hubdisplaystate.startPriceValue);
                String s = s2;
                if (double1 != null)
                {
                    s = s2;
                    if (hubdisplaystate.currencyValue != null)
                    {
                        s = (new StringBuilder()).append(s2).append(", ").append(EbayCurrencyUtil.formatDisplay(hubdisplaystate.currencyValue, double1.doubleValue(), 0)).toString();
                    }
                }
                setCellValue(s, "", hubdisplaystate.isGuaranteeSelected);
                return;
            }
            if ("FixedPrice".equals(hubdisplaystate.formatValue) || "StoresFixedPrice".equals(hubdisplaystate.formatValue))
            {
                String s3 = getResources().getString(0x7f0701a5);
                Double double2 = EbayCurrencyUtil.parseApiValue(hubdisplaystate.priceValue);
                String s1 = s3;
                if (double2 != null)
                {
                    s1 = s3;
                    if (hubdisplaystate.currencyValue != null)
                    {
                        s1 = (new StringBuilder()).append(s3).append(", ").append(EbayCurrencyUtil.formatDisplay(hubdisplaystate.currencyValue, double2.doubleValue(), 0)).toString();
                    }
                }
                setCellValue(s1);
                return;
            }
        }
    }
}
