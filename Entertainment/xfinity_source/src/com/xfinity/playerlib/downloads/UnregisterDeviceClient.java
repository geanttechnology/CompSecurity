// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.request.signing.SignedHTTPRequestProvider;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import com.comcast.cim.model.user.AuthKeys;
import com.fasterxml.jackson.databind.ObjectMapper;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            UnregisterDeviceResponseHandler

public class UnregisterDeviceClient
{

    private final ObjectMapper objectMapper;
    private final XipRequestProviderFactory requestProviderFactory;
    private final RequestSignerFactory requestSignerFactory;
    private final HttpService unregisterDeviceService;

    public UnregisterDeviceClient(HttpService httpservice, ObjectMapper objectmapper, XipRequestProviderFactory xiprequestproviderfactory, RequestSignerFactory requestsignerfactory)
    {
        unregisterDeviceService = httpservice;
        objectMapper = objectmapper;
        requestProviderFactory = xiprequestproviderfactory;
        requestSignerFactory = requestsignerfactory;
    }

    public void unregisterDevice(AuthKeys authkeys, String s)
    {
        authkeys = new SignedHTTPRequestProvider(requestProviderFactory.create((new StringBuilder()).append("proxy/ams/xip/device/download/devices/").append(s).toString(), "DELETE"), requestSignerFactory.create(authkeys.getConsumerKey(), authkeys.getConsumerSecret()));
        unregisterDeviceService.executeRequest(authkeys, new Provider() {

            final UnregisterDeviceClient this$0;

            public UnregisterDeviceResponseHandler get()
            {
                return new UnregisterDeviceResponseHandler(objectMapper);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = UnregisterDeviceClient.this;
                super();
            }
        });
    }

}
