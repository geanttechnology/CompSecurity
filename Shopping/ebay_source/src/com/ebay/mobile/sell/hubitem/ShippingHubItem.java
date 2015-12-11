// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.hubitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.ebay.mobile.sell.HubDisplayState;

// Referenced classes of package com.ebay.mobile.sell.hubitem:
//            CustomHubItem

public class ShippingHubItem extends CustomHubItem
{

    public ShippingHubItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public int getBubbleTextResource()
    {
        return 0x7f070b49;
    }

    public int getLabelResource()
    {
        return 0x7f0709d9;
    }

    public void setDisplayFromState(HubDisplayState hubdisplaystate, boolean flag, boolean flag1)
    {
        String s = null;
        setStatusIndicator(flag);
        if ("NOT_SPECIFIED".equals(hubdisplaystate.shippingType))
        {
            setCellValue(getResources().getString(0x7f0700b7));
            return;
        }
        if (!TextUtils.isEmpty(hubdisplaystate.shippingValue))
        {
            String s1 = getResources().getString(0x7f0709a1);
            String s2 = hubdisplaystate.shippingValue;
            String s3 = hubdisplaystate.shippingCostValue;
            String s4 = hubdisplaystate.whoPaysForShipping;
            if (hubdisplaystate.additionalShippingMethods)
            {
                s = s1;
            }
            setCellValue(s2, s3, flag1, s4, s);
            return;
        } else
        {
            setCellValue(null);
            return;
        }
    }
}
