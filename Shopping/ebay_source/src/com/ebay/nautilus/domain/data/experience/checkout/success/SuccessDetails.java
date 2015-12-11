// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.success;

import com.ebay.nautilus.domain.data.experience.checkout.Url;
import com.ebay.nautilus.domain.data.experience.checkout.details.DeliveryEstimate;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplay;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.success:
//            ShopCartDetails

public class SuccessDetails
{

    public TextualDisplay amountSavedText;
    public DeliveryEstimate deliveryEstimate;
    public String emailConfirmationText;
    public String moduleTitle;
    public ShopCartDetails shopCartDetails;
    public Url vodLink;

    public SuccessDetails()
    {
    }
}
