// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.request.signing.SignedHTTPRequestProvider;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.model.user.AuthKeys;
import com.fasterxml.jackson.databind.ObjectMapper;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoAuthorization, VideoContinueResponseHandler, VideoSession

public class VideoContinueClient
{

    private final HttpService httpService;
    private final ObjectMapper objectMapper;
    private final RequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;

    public VideoContinueClient(HttpService httpservice, ObjectMapper objectmapper, RequestProviderFactory requestproviderfactory, RequestSignerFactory requestsignerfactory)
    {
        httpService = httpservice;
        objectMapper = objectmapper;
        requestProviderFactory = requestproviderfactory;
        requestSignerFactory = requestsignerfactory;
    }

    public VideoSession sendHeartbeat(AuthKeys authkeys, VideoAuthorization videoauthorization)
    {
        authkeys = new SignedHTTPRequestProvider(requestProviderFactory.create("proxy/ams/video/continue", "POST"), requestSignerFactory.create(authkeys.getConsumerKey(), authkeys.getConsumerSecret()));
        authkeys.addHttpEntityParameter("appName", "AndroidPlayNow");
        authkeys.addHttpEntityParameter("deviceAuthorizationToken", videoauthorization.getDeviceAuthorizationToken());
        authkeys.addHttpEntityParameter("previousSessionId", videoauthorization.getSessionToken());
        authkeys.setSocketTimeout(15000L);
        return ((VideoContinueResponseHandler)httpService.executeRequest(authkeys, new Provider() {

            final VideoContinueClient this$0;

            public VideoContinueResponseHandler get()
            {
                return new VideoContinueResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = VideoContinueClient.this;
                super();
            }
        })).getVideoContinue();
    }

}
