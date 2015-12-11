// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;

// Referenced classes of package cz.msebera.android.httpclient.message:
//            BasicHttpRequest

public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest
    implements HttpEntityEnclosingRequest
{

    private HttpEntity entity;

    public BasicHttpEntityEnclosingRequest(RequestLine requestline)
    {
        super(requestline);
    }

    public BasicHttpEntityEnclosingRequest(String s, String s1)
    {
        super(s, s1);
    }

    public BasicHttpEntityEnclosingRequest(String s, String s1, ProtocolVersion protocolversion)
    {
        super(s, s1, protocolversion);
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
