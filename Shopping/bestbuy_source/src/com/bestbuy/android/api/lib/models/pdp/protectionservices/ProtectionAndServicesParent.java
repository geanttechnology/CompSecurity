// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.protectionservices;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.protectionservices:
//            ProtectionServicesResponse

public class ProtectionAndServicesParent
    implements gu, Serializable
{

    private ProtectionServicesResponse si;

    public ProtectionAndServicesParent()
    {
    }

    public ProtectionServicesResponse getSi()
    {
        return si;
    }

    public void setSi(ProtectionServicesResponse protectionservicesresponse)
    {
        si = protectionservicesresponse;
    }
}
