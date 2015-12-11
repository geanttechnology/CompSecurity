// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.address;

import com.ebay.nautilus.domain.data.experience.type.base.Module;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.address:
//            Recommendation

public class ShippingAddressesModule extends Module
{

    public Map actions;
    public List addresses;
    public List errors;
    public String legendText;
    public String moduleTitle;
    public Recommendation recommendation;

    public ShippingAddressesModule()
    {
    }
}
