// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import java.util.Currency;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            PayPalCheckoutDetails, JsonModel

public static final class exchangeRate
    implements Serializable
{

    public final String currencyCodeFrom;
    public final String currencyCodeTo;
    public final Double exchangeRate;

    public String toString()
    {
        Object obj;
        try
        {
            obj = Currency.getInstance(currencyCodeFrom);
            Currency currency = Currency.getInstance(currencyCodeTo);
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append('(');
            stringbuilder.append(((Currency) (obj)).getSymbol());
            stringbuilder.append("1.00");
            stringbuilder.append(" = ");
            stringbuilder.append(currency.getSymbol());
            stringbuilder.append(exchangeRate);
            stringbuilder.append(')');
            obj = stringbuilder.toString();
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return null;
        }
        return ((String) (obj));
    }

    I(JSONObject jsonobject)
        throws JSONException
    {
        currencyCodeFrom = JsonModel.getString(jsonobject, "currencyFrom");
        currencyCodeTo = JsonModel.getString(jsonobject, "currencyTo");
        exchangeRate = JsonModel.getDouble(jsonobject, "exchangeRate");
    }
}
