// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.RequestLine;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.message:
//            BasicHttpRequest

public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest
    implements HttpEntityEnclosingRequest
{

    private HttpEntity entity;

    public BasicHttpEntityEnclosingRequest(RequestLine requestline)
    {
        super(requestline);
    }

    public boolean expectContinue()
    {
        Header header = getFirstHeader("Expect");
        return header != null && "100-continue".equalsIgnoreCase(header.getValue());
    }

    public HttpEntity getEntity()
    {
        return entity;
    }

    public void setEntity(HttpEntity httpentity)
    {
        entity = httpentity;
    }
}
