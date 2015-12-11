// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.protectionservices;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.protectionservices:
//            ProtectionService

public class ProtectionAndServicesChildResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ProtectionService protectionAndServices;
    private String skuId;

    public ProtectionAndServicesChildResponse()
    {
    }

    public ProtectionService getProtectionAndServices()
    {
        return protectionAndServices;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setProtectionAndServices(ProtectionService protectionservice)
    {
        protectionAndServices = protectionservice;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }
}
