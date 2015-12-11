// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import com.ebay.nautilus.domain.data.Address;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowTimeSlotRequest

public static class country
{

    public final String city;
    public final String country;
    public final String line1;
    public final String line2;
    public final String notes = null;
    public final String postalCode;
    public final String state;

    public I(Address address)
    {
        line1 = address.addressFields.line1();
        line2 = address.addressFields.line2();
        city = address.addressFields.city();
        state = address.addressFields.ce();
        postalCode = address.addressFields.postalCode();
        country = address.addressFields.country();
    }
}
