// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            DataResponse

public final class DataRequest extends Request
{

    public static final String DATA_REQUEST = "DataRequest";
    private final URL url;

    public DataRequest(URI uri)
        throws MalformedURLException
    {
        this(uri.toURL());
    }

    public DataRequest(URI uri, String s)
        throws MalformedURLException
    {
        this(uri.toURL(), s);
    }

    public DataRequest(URL url1)
    {
        this(url1, "DataRequest");
    }

    public DataRequest(URL url1, String s)
    {
        url = url1;
        setOperationName(s);
    }

    public URL getRequestUrl()
    {
        return url;
    }

    public DataResponse getResponse()
    {
        return new DataResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public String getUserAgent()
    {
        return EbayAppCredentials.get(getEbayContext()).userAgent;
    }
}
