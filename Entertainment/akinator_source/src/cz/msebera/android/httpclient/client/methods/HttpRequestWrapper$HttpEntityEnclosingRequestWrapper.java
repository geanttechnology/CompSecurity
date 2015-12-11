// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            HttpRequestWrapper

static class entity extends HttpRequestWrapper
    implements HttpEntityEnclosingRequest
{

    private HttpEntity entity;

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

    public (HttpEntityEnclosingRequest httpentityenclosingrequest)
    {
        super(httpentityenclosingrequest, null);
        entity = httpentityenclosingrequest.getEntity();
    }
}
