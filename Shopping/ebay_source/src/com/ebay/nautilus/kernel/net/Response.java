// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            IResponseDataHandler, IResponseHeaderHandler

public class Response extends ResultStatusOwner
{

    public long requestTime;
    public int responseCode;
    public String responseMessage;

    public Response()
    {
        requestTime = 0L;
        responseCode = -1;
        responseMessage = null;
    }

    public IResponseDataHandler getDataHandler()
    {
        return null;
    }

    public IResponseHeaderHandler getHeaderHandler()
    {
        return null;
    }

    public boolean hasFailureValidation()
    {
        return false;
    }

    public boolean hasReportableResultStatusError()
    {
        return getResultStatus().hasError();
    }

    public boolean hasSuccessResponseCode()
    {
        return responseCode == 200;
    }

    public void setRequestTime(long l)
    {
        requestTime = l;
    }

    public void setResponseCode(int i, String s)
    {
        responseCode = i;
        responseMessage = s;
    }
}
