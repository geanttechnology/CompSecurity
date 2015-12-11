// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            IncentiveType, Cart, JsonModel

public static final class message extends IncentiveType
    implements Serializable
{

    public final String code;
    public final String message;
    public CurrencyAmount redeemedAmount;

    (JSONObject jsonobject)
        throws JSONException
    {
        super(jsonobject.getString("incentiveType"));
        code = jsonobject.getString("incentiveCode");
        redeemedAmount = JsonModel.toCurrencyAmount(jsonobject.getJSONObject("redeemedAmount"));
        message = jsonobject.optString("incentiveMessage");
    }
}
