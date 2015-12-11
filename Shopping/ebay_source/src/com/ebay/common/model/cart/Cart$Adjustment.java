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

public static final class rencyAmount
    implements Serializable
{

    public final CurrencyAmount amount;
    public final String description;

    t(JSONObject jsonobject)
        throws JSONException
    {
        description = JsonModel.getString(jsonobject, "adjustmentDescription");
        amount = JsonModel.getCurrencyAmount(jsonobject, "adjustmentAmount");
    }
}
