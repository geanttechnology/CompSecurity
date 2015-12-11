// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.http.NameValuePair;
import com.groupon.models.billingrecord.OrderBillingRecord;
import com.groupon.models.country.Country;
import com.groupon.models.order.Order;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.HashMap;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ECommercePurchase

public class PaypalPurchase extends ECommercePurchase
{

    public static final int REQUEST_CODE = 10113;
    private CurrentCountryManager currentCountryManager;

    public PaypalPurchase()
    {
    }

    protected List getNameValuePairs(HashMap hashmap)
    {
        hashmap = super.getNameValuePairs(hashmap);
        if (currentCountryManager.getCurrentCountry().isLATAMCompatible())
        {
            hashmap.add(new NameValuePair("resURL", "dummy://paymentResult"));
        }
        return hashmap;
    }

    protected String getResUrl()
    {
        String s = order.billingRecord.termUrl;
        if (currentCountryManager.getCurrentCountry().isLATAMCompatible() && Strings.notEmpty(s))
        {
            return s;
        } else
        {
            return super.getResUrl();
        }
    }
}
