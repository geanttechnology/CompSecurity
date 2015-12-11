// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.usage;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.net.IRequestLogger;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.usage:
//            Usage

class val.request
    implements IRequestLogger
{

    final val.request this$1;
    final Request val$request;

    public void logHostError(int i)
    {
    }

    public void setCompleteResponse(Response response)
    {
    }

    public void setRequestTime(long l)
    {
        Object obj = val$request.getOperationName();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            invoke(((String) (obj)));
            return;
        }
        obj = val$request.getRequestUrl();
        if (((URL) (obj)).getHost().contains("rover"))
        {
            invoke("rover");
            return;
        } else
        {
            invoke(((URL) (obj)));
            return;
        }
    }

    public void setResponseTime(long l)
    {
    }

    ()
    {
        this$1 = final_;
        val$request = Request.this;
        super();
    }
}
