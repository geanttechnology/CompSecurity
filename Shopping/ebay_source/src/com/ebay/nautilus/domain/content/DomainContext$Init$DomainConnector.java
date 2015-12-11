// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DomainContext

private final class this._cls0 extends com.ebay.nautilus.kernel.net.tor
{

    final ebayContext this$0;

    public Response sendRequest(Request request)
        throws InterruptedException
    {
        request = super.tor(request);
        ResultStatus resultstatus = request.getResultStatus();
        if (resultstatus.hasMessage())
        {
            _fld0.eErrors(ebayContext, resultstatus);
        }
        return request;
    }

    public I(EbayContext ebaycontext)
    {
        this$0 = this._cls0.this;
        super(ebaycontext);
    }
}
