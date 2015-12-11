// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.NamedParameter;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartAddress extends BaseDataMapped
{

    private static final String EXTERNAL_IDENTIFIER_PREFIX = "eBay:";
    public String addressType;
    private transient Map attributeMap;
    public List attributes;
    public String city;
    public String country;
    public String county;
    public String externalIdentifier;
    public String name;
    public String phone;
    public String postalCode;
    public String stateOrProvince;
    public String street1;
    public String street2;

    public CartAddress()
    {
    }

    private static final String externalIdentifierToAddressId(String s)
    {
        String s1 = s;
        if (!TextUtils.isEmpty(s))
        {
            s1 = s;
            if (s.length() > "eBay:".length())
            {
                s1 = s.substring("eBay:".length());
            }
        }
        return s1;
    }

    public Address asAddress()
    {
        Address address = new Address(externalIdentifierToAddressId(externalIdentifier), addressType, asAddressFields());
        address.getAttributeMap().putAll(getAttributeMap());
        return address;
    }

    public com.ebay.nautilus.domain.data.Address.AddressFields asAddressFields()
    {
        return new com.ebay.nautilus.domain.data.Address.AddressFields(name, street1, street2, city, stateOrProvince, postalCode, country, county, phone);
    }

    public Map getAttributeMap()
    {
        if (attributeMap == null)
        {
            attributeMap = new HashMap();
            if (attributes != null)
            {
                NamedParameter.addParameterListToMap(attributes, attributeMap);
            }
        }
        return attributeMap;
    }
}
