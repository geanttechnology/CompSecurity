// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;

// Referenced classes of package com.medialets.advertising:
//            DataSource, a

protected abstract class 
    implements ResponseHandler
{

    abstract void createAdvertisements(HttpEntity httpentity, List list)
        throws HttpResponseException, IOException;

    public volatile Object handleResponse(HttpResponse httpresponse)
        throws ClientProtocolException, IOException
    {
        return handleResponse(httpresponse);
    }

    public List handleResponse(HttpResponse httpresponse)
        throws HttpResponseException, IOException
    {
        Object obj = httpresponse.getStatusLine();
        if (((StatusLine) (obj)).getStatusCode() >= 300)
        {
            throw new HttpResponseException(((StatusLine) (obj)).getStatusCode(), ((StatusLine) (obj)).getReasonPhrase());
        }
        obj = new ArrayList();
        httpresponse = httpresponse.getEntity();
        if (httpresponse != null)
        {
            createAdvertisements(httpresponse, ((List) (obj)));
            return ((List) (obj));
        } else
        {
            a.d("Empty response returned from the Medialets server");
            return ((List) (obj));
        }
    }

    protected (DataSource datasource)
    {
    }
}
