// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.client.utils.CloneUtils;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            HttpRequestBase

public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase
    implements HttpEntityEnclosingRequest
{

    private HttpEntity entity;

    public HttpEntityEnclosingRequestBase()
    {
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        HttpEntityEnclosingRequestBase httpentityenclosingrequestbase = (HttpEntityEnclosingRequestBase)super.clone();
        if (entity != null)
        {
            httpentityenclosingrequestbase.entity = (HttpEntity)CloneUtils.cloneObject(entity);
        }
        return httpentityenclosingrequestbase;
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
