// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            Cart, JsonModel

public static final class oolean
    implements Serializable
{

    public final CurrencyAmount amount;
    public final Double percent;
    public final Boolean shippingIncluded;
    public final String stateOrProvince;

    unt(JSONObject jsonobject)
        throws JSONException
    {
        amount = JsonModel.getCurrencyAmount(jsonobject, "salesTaxAmount");
        percent = JsonModel.getDouble(jsonobject, "salesTaxPercent");
        stateOrProvince = JsonModel.getString(jsonobject, "salesTaxState");
        shippingIncluded = JsonModel.getBoolean(jsonobject, "shippingIncludedInTax");
    }
}
