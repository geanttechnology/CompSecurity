// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Connector, Response, IoError, Request

public static final class Message
{

    public static Response sendRequest(EbayContext ebaycontext, Request request)
        throws IOException, InterruptedException
    {
        ebaycontext = ebaycontext.getConnector().sendRequest(request);
        request = ebaycontext.getResultStatus().getMessages();
        if (request != null && !request.isEmpty())
        {
            request = (com.ebay.nautilus.kernel.content.age)request.get(request.size() - 1);
            if (request instanceof IoError)
            {
                throw ((IoError)request).getException();
            }
        }
        return ebaycontext;
    }

    public Message()
    {
    }
}
