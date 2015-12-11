// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingOption

public static class sigConOptionsSupported
{
    public static class ShippingConfirmationOptions
    {

        public String optionDisplayValue;
        public String optionToken;

        public ShippingConfirmationOptions()
        {
        }
    }


    public st carrierInsuranceLimit;
    public boolean carrierInsuranceSupported;
    public boolean carrierInsuranceSuppported;
    public boolean dimensionSupported;
    public String insMessage;
    public st maxWeightAllowed;
    public String packageName;
    public int serviceDisplayOrder;
    public String serviceInfo;
    public String serviceLongName;
    public String serviceName;
    public String sigConMessage;
    public ArrayList sigConOptionsSupported;
    public boolean signatureConfirmationRequired;
    public boolean signatureConfirmationSupported;
    public boolean weightSupported;

    public ShippingConfirmationOptions()
    {
        sigConOptionsSupported = new ArrayList();
    }
}
