// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            PayPalCheckoutDetails, JsonModel

public static final class balance
    implements Serializable
{

    public final CurrencyAmount balance;
    public final String code;
    public final String status;
    public final String type;

    public boolean isGiftCard()
    {
        return type.equalsIgnoreCase("GiftCard");
    }

    public boolean isGiftCertificate()
    {
        return type.equalsIgnoreCase("GiftCertificate");
    }

    (JSONObject jsonobject)
        throws JSONException
    {
        code = JsonModel.getString(jsonobject, "redemptionCode");
        type = JsonModel.getString(jsonobject, "incentiveType");
        status = JsonModel.getString(jsonobject, "status");
        balance = JsonModel.getCurrencyAmount(jsonobject, "balance");
    }
}
