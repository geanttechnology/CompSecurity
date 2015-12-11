// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;


// Referenced classes of package com.ebay.nautilus.domain.data.cos.base:
//            AddressTypeEnum, LanguageScriptEnum, WorldRegionEnum

public class Address
{

    public String addressLine1;
    public String addressLine2;
    public AddressTypeEnum addressType;
    public String city;
    public String country;
    public String county;
    public Boolean isTransliterated;
    public LanguageScriptEnum isTransliteratedFromScript;
    public String nationalRegion;
    public String postalCode;
    public LanguageScriptEnum script;
    public String stateOrProvince;
    public WorldRegionEnum worldRegion;

    public Address()
    {
    }
}
