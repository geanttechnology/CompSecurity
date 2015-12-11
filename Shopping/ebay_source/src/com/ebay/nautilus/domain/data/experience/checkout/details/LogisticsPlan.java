// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.details;

import com.ebay.nautilus.domain.data.experience.checkout.address.Address;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplayValue;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.details:
//            DeliveryEstimate

public class LogisticsPlan
{

    public Map actions;
    public Address address;
    public TextualDisplayValue amount;
    public DeliveryEstimate deliveryEstimate;
    public String logisticsId;
    public boolean selected;
    public String text;

    public LogisticsPlan()
    {
    }
}
