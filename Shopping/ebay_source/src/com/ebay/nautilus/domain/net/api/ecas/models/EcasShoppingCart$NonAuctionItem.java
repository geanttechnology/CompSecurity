// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCart

public static class  extends 
{

    public Date addedAt;
    public List adjustments;
    public List availablePaymentMethods;
    public List availablePickupMethods;
    public List availableShippingServices;
    public Date endedAt;
    public List fees;
    public ItemCurrency fullPrice;
    public List incentives;
    public boolean isImmediatePay;
    public Long lineItemId;
    public Date orderCreatedAt;
    public String orderId;
    public List orderTransactions;
    public hConversion price;
    public List problems;
    public hConversion selectedPickupMethod;
    public  selectedShippingService;
    public  tax;
    public Date transactionCreatedAt;
    public String transactionId;

    public boolean isBopisSelected()
    {
         ;
        if (selectedPickupMethod != null)
        {
            if (( = getAttribute(selectedPickupMethod.tributes, "storeId")) != null && !TextUtils.isEmpty(.value))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isEnded()
    {
label0:
        {
            boolean flag = false;
            if (endedAt != null)
            {
                if (!isItemEnded)
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        return EbayResponse.currentHostTime() > endedAt.getTime();
    }

    public ()
    {
    }
}
