// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.mybby:
//            AddressType

class Address
{

    private AddressType addressType;
    private String addressValue;
    private String country;
    private boolean isPrimary;
    private String municipality;
    private String stateCode;
    private String typeCode;
    private String zip;

    Address()
    {
    }

    public static Address loadData(JSONObject jsonobject)
    {
        Address address = new Address();
        address.addressType = AddressType.rzPostal;
        address.addressValue = jsonobject.optString("addressLine1");
        address.country = jsonobject.optString("country");
        address.municipality = jsonobject.optString("municipality");
        address.zip = jsonobject.optString("postalCode");
        address.typeCode = jsonobject.optString("typeCode");
        address.stateCode = jsonobject.optString("region");
        address.isPrimary = jsonobject.optBoolean("primary");
        return address;
    }

    public AddressType getAddressType()
    {
        return addressType;
    }

    public String getAddressValue()
    {
        return addressValue;
    }

    public String getCountry()
    {
        return country;
    }

    public String getMunicipality()
    {
        return municipality;
    }

    public String getStateCode()
    {
        return stateCode;
    }

    public String getTypeCode()
    {
        return typeCode;
    }

    public String getZip()
    {
        return zip;
    }

    public boolean isPrimary()
    {
        return isPrimary;
    }
}
