// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayCosRequest, CosVersionType

public abstract class EbayCosExpRequest extends EbayCosRequest
{

    protected EbayCosExpRequest(String s, String s1, Authentication authentication)
    {
        super(s, s1, CosVersionType.V3);
        responseBodyContentType = "application/json";
        requestBodyContentType = "application/json";
        useServiceVersion = false;
        if (authentication != null)
        {
            iafToken = authentication.iafToken;
        }
    }

    protected void initialize(ResultStatusOwner resultstatusowner)
        throws InterruptedException
    {
        super.initialize(resultstatusowner);
        endUserContext = buildEndUserContext(null, null, null, null, true);
    }
}
