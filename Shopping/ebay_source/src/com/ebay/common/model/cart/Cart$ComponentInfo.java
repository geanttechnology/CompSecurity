// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel, Cart

public static final class t> extends JsonModel
    implements Serializable
{

    public final HashMap attrs = new HashMap();
    public final String ebayItemId;
    public final CurrencyAmount fullPrice;
    public final boolean isDeposit;
    public final String itemImageUrl;
    public final String itemTitle;
    public final String itemTranslatedTitle;
    public final String itemUrl;
    public final CurrencyAmount price;
    public final List promotions = new ArrayList();
    public final int quantity;
    public String transactionId;
    public String variationId;

    public int getQuantityAvailable()
    {
        if (attrs.containsKey("QuantityAvailable"))
        {
            int i;
            try
            {
                i = Integer.parseInt((String)attrs.get("QuantityAvailable"));
            }
            catch (NumberFormatException numberformatexception)
            {
                return 0;
            }
            return i;
        } else
        {
            return 0;
        }
    }

    public boolean isPOBoxAddressExcluded()
    {
        return TextUtils.equals("true", (CharSequence)attrs.get("POBoxAddressExcluded"));
    }

    public boolean isPhoneNumberRequired()
    {
        return TextUtils.equals("true", (CharSequence)attrs.get("PhoneNumberRequired"));
    }

    public boolean isTransacted()
    {
        return !TextUtils.isEmpty(transactionId);
    }

    (JSONObject jsonobject)
        throws JSONException
    {
        Object obj = jsonobject.getJSONObject("componentIdentifier");
        if (((JSONObject) (obj)).has("baseIdentifier"))
        {
            Object obj1 = new JSONObject(((JSONObject) (obj)).getString("baseIdentifier"));
            Object obj2;
            int i;
            if (((JSONObject) (obj1)).has("ItemId"))
            {
                ebayItemId = ((JSONObject) (obj1)).getString("ItemId");
            } else
            {
                ebayItemId = null;
            }
        } else
        {
            ebayItemId = null;
        }
        if (((JSONObject) (obj)).has("extendedIdentifier"))
        {
            obj = new JSONObject(((JSONObject) (obj)).getString("extendedIdentifier"));
            if (((JSONObject) (obj)).has("TransactionId"))
            {
                transactionId = ((JSONObject) (obj)).getString("TransactionId");
            } else
            {
                transactionId = null;
            }
            if (((JSONObject) (obj)).has("VariationId"))
            {
                variationId = ((JSONObject) (obj)).getString("VariationId");
            } else
            {
                variationId = null;
            }
        }
        if (jsonobject.has("lineItemTitle"))
        {
            obj = jsonobject.getJSONObject("lineItemTitle");
            if (((JSONObject) (obj)).has("@basis"))
            {
                itemTitle = ((JSONObject) (obj)).getString("@basis");
                itemTranslatedTitle = ((JSONObject) (obj)).getString("__value__");
            } else
            {
                itemTitle = ((JSONObject) (obj)).getString("__value__");
                itemTranslatedTitle = null;
            }
        } else
        {
            itemTitle = null;
            itemTranslatedTitle = null;
        }
        quantity = jsonobject.getInt("quantity");
        if (jsonobject.has("price"))
        {
            obj = toCurrencyAmount(jsonobject.getJSONObject("price"));
        } else
        {
            obj = null;
        }
        price = ((CurrencyAmount) (obj));
        if (price != null)
        {
            obj = jsonobject.getJSONObject("price").optString("@type");
            boolean flag;
            if (!TextUtils.isEmpty(((CharSequence) (obj))) && ((String) (obj)).equalsIgnoreCase("deposit"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isDeposit = flag;
        } else
        {
            isDeposit = false;
        }
        if (jsonobject.has("fullPrice"))
        {
            obj = toCurrencyAmount(jsonobject.getJSONObject("fullPrice"));
        } else
        {
            obj = null;
        }
        fullPrice = ((CurrencyAmount) (obj));
        itemImageUrl = getString(jsonobject, "imageURL");
        itemUrl = getString(jsonobject, "itemURL");
        if (jsonobject.has("attribute"))
        {
            obj = jsonobject.getJSONArray("attribute");
            for (i = 0; i < ((JSONArray) (obj)).length(); i++)
            {
                obj2 = ((JSONArray) (obj)).getJSONObject(i);
                obj1 = getString(((JSONObject) (obj2)), "@name");
                obj2 = getString(((JSONObject) (obj2)), "__value__");
                if (!TextUtils.isEmpty(((CharSequence) (obj1))) && !TextUtils.isEmpty(((CharSequence) (obj2))))
                {
                    attrs.put(obj1, obj2);
                }
            }

        }
        if (jsonobject.has("promotion"))
        {
            jsonobject = jsonobject.getJSONArray("promotion");
            for (int j = 0; j < jsonobject.length(); j++)
            {
                promotions.add(new t>(jsonobject.getJSONObject(j)));
            }

        }
    }
}
