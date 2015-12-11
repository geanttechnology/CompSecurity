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
    public final String id;
    public final String name;

    (JSONObject jsonobject)
        throws JSONException
    {
        name = JsonModel.getString(jsonobject, "name");
        id = JsonModel.getString(jsonobject, "id");
        balance = JsonModel.getCurrencyAmount(jsonobject, "balance");
    }
}
