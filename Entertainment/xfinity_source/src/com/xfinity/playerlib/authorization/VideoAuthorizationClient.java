// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.request.signing.SignedHTTPRequestProvider;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import com.comcast.cim.model.user.AuthKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.net.URLDecoder;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoAuthorizationResponseHandler, VideoAuthorization

public class VideoAuthorizationClient
{

    private final HttpService authorizationService;
    private ObjectMapper objectMapper;
    private final XipRequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;

    public VideoAuthorizationClient(HttpService httpservice, ObjectMapper objectmapper, XipRequestProviderFactory xiprequestproviderfactory, RequestSignerFactory requestsignerfactory)
    {
        authorizationService = httpservice;
        requestProviderFactory = xiprequestproviderfactory;
        requestSignerFactory = requestsignerfactory;
        objectMapper = objectmapper;
    }

    public VideoAuthorization authorize(AuthKeys authkeys, VideoEntitlement videoentitlement, String s, String s1, String s2, String s3, boolean flag)
    {
        XipRequestProviderFactory xiprequestproviderfactory = requestProviderFactory;
        Object obj;
        if (flag)
        {
            obj = "proxy/ams/video/xa-linear-access";
        } else
        {
            obj = "proxy/ams/video/access";
        }
        obj = new SignedHTTPRequestProvider(xiprequestproviderfactory.create(((String) (obj)), "POST"), requestSignerFactory.create(authkeys.getConsumerKey(), authkeys.getConsumerSecret()));
        if (flag)
        {
            authkeys = "scm";
        } else
        {
            authkeys = "svm";
        }
        videoentitlement = URLDecoder.decode(videoentitlement.getXedata());
        if (!flag)
        {
            s = URLDecoder.decode(s);
        }
        ((SignedHTTPRequestProvider) (obj)).addHttpEntityParameter("appName", "AndroidPlayNow");
        ((SignedHTTPRequestProvider) (obj)).addHttpEntityParameter("xedata", videoentitlement);
        ((SignedHTTPRequestProvider) (obj)).addHttpEntityParameter("pin", s3);
        ((SignedHTTPRequestProvider) (obj)).addHttpEntityParameter(authkeys, s);
        ((SignedHTTPRequestProvider) (obj)).addHttpEntityParameter("deviceAuthorizationToken", s1);
        ((SignedHTTPRequestProvider) (obj)).addHttpEntityParameter("previousSessionId", s2);
        ((SignedHTTPRequestProvider) (obj)).addHttpEntityParameter("drmType", "AdobeAccess");
        ((SignedHTTPRequestProvider) (obj)).setSocketTimeout(15000L);
        return ((VideoAuthorizationResponseHandler)authorizationService.executeRequest(((com.comcast.cim.cmasl.http.request.RequestProvider) (obj)), new Provider() {

            final VideoAuthorizationClient this$0;

            public VideoAuthorizationResponseHandler get()
            {
                return new VideoAuthorizationResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = VideoAuthorizationClient.this;
                super();
            }
        })).getVideoAuthorization();
    }

}
