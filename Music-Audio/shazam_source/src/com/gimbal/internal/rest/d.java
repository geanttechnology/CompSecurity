// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.springframework.http.ContentCodingType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

// Referenced classes of package com.gimbal.internal.rest:
//            BeaconUserAgentBuilder

public final class d
    implements ClientHttpRequestInterceptor
{

    private final BeaconUserAgentBuilder a;

    public d(BeaconUserAgentBuilder beaconuseragentbuilder)
    {
        a = beaconuseragentbuilder;
    }

    public final ClientHttpResponse intercept(HttpRequest httprequest, byte abyte0[], ClientHttpRequestExecution clienthttprequestexecution)
    {
        HttpHeaders httpheaders = httprequest.getHeaders();
        httpheaders.add("User-Agent", a.getUserAgent());
        httpheaders.add("X-Client-Platform", "android");
        httpheaders.add("X-Client-Timezone", TimeZone.getDefault().getID());
        ArrayList arraylist = new ArrayList(httprequest.getHeaders().getAcceptEncoding());
        if (!arraylist.contains(ContentCodingType.GZIP))
        {
            arraylist.add(ContentCodingType.GZIP);
            httpheaders.setAcceptEncoding(arraylist);
        }
        return clienthttprequestexecution.execute(httprequest, abyte0);
    }
}
