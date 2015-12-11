// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.success;

import com.ebay.nautilus.domain.data.experience.checkout.protection.BuyerProtection;
import com.ebay.nautilus.domain.data.experience.type.base.Module;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.success:
//            SuccessDetails

public class SuccessModule extends Module
{

    public BuyerProtection buyerProtection;
    public String moduleTitle;
    public SuccessDetails successDetails;
    public String title;

    public SuccessModule()
    {
    }
}
