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
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.net.URLDecoder;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoAuthTokenResponseHandler, VideoAuthToken

public class VideoAuthTokenClient
{

    private final HttpService authorizationService;
    private final XipRequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;

    public VideoAuthTokenClient(HttpService httpservice, XipRequestProviderFactory xiprequestproviderfactory, RequestSignerFactory requestsignerfactory)
    {
        authorizationService = httpservice;
        requestProviderFactory = xiprequestproviderfactory;
        requestSignerFactory = requestsignerfactory;
    }

    public VideoAuthToken authorize(AuthKeys authkeys, VideoEntitlement videoentitlement, String s, String s1)
    {
        authkeys = new SignedHTTPRequestProvider(requestProviderFactory.create("proxy/tve/token/", "POST"), requestSignerFactory.create(authkeys.getConsumerKey(), authkeys.getConsumerSecret()));
        authkeys.addHeader("Content-Type", "application/x-www-form-urlencoded");
        authkeys.addHttpEntityParameter("xedata", URLDecoder.decode(videoentitlement.getXedata()));
        authkeys.addHttpEntityParameter("channel", s);
        authkeys.addHttpEntityParameter("scm", s1);
        authkeys.setSocketTimeout(15000L);
        return ((VideoAuthTokenResponseHandler)authorizationService.executeRequest(authkeys, new Provider() {

            final VideoAuthTokenClient this$0;

            public VideoAuthTokenResponseHandler get()
            {
                return new VideoAuthTokenResponseHandler();
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = VideoAuthTokenClient.this;
                super();
            }
        })).getVideoAuthToken();
    }
}
