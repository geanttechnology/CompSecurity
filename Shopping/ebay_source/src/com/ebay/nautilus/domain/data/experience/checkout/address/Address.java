// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.address;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.address:
//            AddressMeta

public class Address extends com.ebay.nautilus.domain.data.cos.base.Address
{

    public String addressId;
    public List addressLines;
    public String legendText;
    public boolean primary;
    public boolean selected;
    public AddressMeta value;

    public Address()
    {
    }
}
