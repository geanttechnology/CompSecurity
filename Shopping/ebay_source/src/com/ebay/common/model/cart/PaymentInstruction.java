// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import com.ebay.nautilus.domain.data.NamedParameter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentInstruction
    implements Serializable
{

    public static final String TYPE_BANK_TRANSFER = "MANUAL_BANK_TRANSFER";
    private static final long serialVersionUID = 1L;
    private Map attributeMap;
    private List attributes;
    private final String type = "MANUAL_BANK_TRANSFER";

    public PaymentInstruction(JSONObject jsonobject)
        throws JSONException
    {
        attributeMap = new HashMap();
        if (jsonobject.has("attribute"))
        {
            jsonobject = jsonobject.optJSONArray("attribute");
            if (jsonobject != null)
            {
                for (int i = 0; i < jsonobject.length(); i++)
                {
                    Cart.Property property = new Cart.Property(jsonobject.getJSONObject(i));
                    attributeMap.put(property.name, property.value);
                }

            }
        }
    }

    public Map getAttributeMap()
    {
        if (attributeMap == null)
        {
            attributeMap = new HashMap();
            if (attributes != null)
            {
                NamedParameter.addParameterListToMap(attributes, attributeMap);
                attributeMap.put("HasSellerBankAccountDetails", "true");
            }
        }
        return attributeMap;
    }

    public boolean hasSellerBankAccountDetails()
    {
        if (getAttributeMap().containsKey("HasSellerBankAccountDetails"))
        {
            return ((String)getAttributeMap().get("HasSellerBankAccountDetails")).equalsIgnoreCase("true");
        } else
        {
            return false;
        }
    }
}
